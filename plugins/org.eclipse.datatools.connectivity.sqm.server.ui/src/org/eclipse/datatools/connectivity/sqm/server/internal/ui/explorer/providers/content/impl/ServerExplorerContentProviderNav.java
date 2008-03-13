/*******************************************************************************
 * Copyright (c) 2001, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.connectivity.sqm.server.internal.ui.explorer.providers.content.impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.datatools.connectivity.IConnectionProfile;
import org.eclipse.datatools.connectivity.ProfileManager;
import org.eclipse.datatools.connectivity.sqm.core.containment.ContainmentService;
import org.eclipse.datatools.connectivity.sqm.core.rte.ICatalogObject;
import org.eclipse.datatools.connectivity.sqm.core.rte.ICatalogObjectListener;
import org.eclipse.datatools.connectivity.sqm.core.rte.RefreshManager;
import org.eclipse.datatools.connectivity.sqm.core.ui.explorer.providers.content.virtual.VirtualNode;
import org.eclipse.datatools.connectivity.sqm.core.ui.explorer.virtual.IVirtualNode;
import org.eclipse.datatools.connectivity.sqm.internal.core.RDBCorePlugin;
import org.eclipse.datatools.connectivity.sqm.internal.core.connection.ConnectionInfo;
import org.eclipse.datatools.connectivity.sqm.server.internal.ui.explorer.loading.ILoadingService;
import org.eclipse.datatools.connectivity.sqm.server.internal.ui.explorer.loading.LoadingNode;
import org.eclipse.datatools.connectivity.sqm.server.internal.ui.explorer.providers.ServerExplorerManager;
import org.eclipse.datatools.connectivity.sqm.server.internal.ui.explorer.providers.content.layout.IServerExplorerLayoutProviderNav;
import org.eclipse.datatools.connectivity.sqm.server.internal.ui.explorer.providers.content.layout.hierar.ServerExplorerHierarchicalLayoutNav;
import org.eclipse.datatools.connectivity.sqm.server.internal.ui.explorer.providers.content.layout.vnode.ServerExplorerVirtualNodeLayoutNav;
import org.eclipse.datatools.connectivity.sqm.server.internal.ui.layout.IServerExplorerLayoutExtensionProvider;
import org.eclipse.datatools.connectivity.sqm.server.internal.ui.layout.IServerExplorerLayoutExtensionProvider.Layout;
import org.eclipse.datatools.connectivity.sqm.server.internal.ui.services.IServerExplorerContentService;
import org.eclipse.datatools.connectivity.sqm.server.internal.ui.services.IServerExplorerLayoutService;
import org.eclipse.datatools.connectivity.sqm.server.internal.ui.services.IServerExplorerNavigationService;
import org.eclipse.datatools.connectivity.sqm.server.internal.ui.util.TransientEObjectUtil;
import org.eclipse.datatools.connectivity.sqm.server.internal.ui.util.TransientEObjectUtil.IGroup;
import org.eclipse.datatools.connectivity.sqm.server.internal.ui.util.resources.ResourceLoader;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.navigator.CommonViewer;


/**
 * @author ljulien
 */
public class ServerExplorerContentProviderNav implements IServerExplorerContentService,
        IServerExplorerLayoutService, IServerExplorerNavigationService, ICatalogObjectListener, ILoadingService
{
    private static final ContainmentService containmentService = RDBCorePlugin.getDefault().getContainmentService();
    private static final ResourceLoader resourceLoader = ResourceLoader.INSTANCE;

    private static final String DESCRIPTION = resourceLoader.queryString("DATATOOLS.SERVER.UI.EXPLORER.DESCRIPTION"); //$NON-NLS-1$

    private IServerExplorerLayoutProviderNav layoutProvider = new ServerExplorerVirtualNodeLayoutNav(this);
    private CommonViewer viewer;
    private List layoutProvidersExtensionList = new LinkedList();
    
    /**
     * Will initialize the Server Explorer
     */
    public ServerExplorerContentProviderNav()
    {
        ServerExplorerManager.INSTANCE.setServerExplorerService(this);
    }
    
    /**
     * @return The viewer used by the Data Server Explorer
     */
    private CommonViewer getViewer ()
    {
        return this.viewer;
    }

    /**
     * @see org.eclipse.ui.views.navigator.INavigatorContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
     */
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
    {
    	if (viewer instanceof CommonViewer && this.viewer == null)
    	{
    		this.viewer = (CommonViewer) viewer;
	        this.enableVirtualNodeLayout();
	        RefreshManager.getInstance().AddListener(null, this);
    	}
    }
    
    public void notifyChanged(final ICatalogObject dmElement, int eventType) {
        if (eventType == ICatalogObjectListener.EventTypeEnumeration.ELEMENT_REFRESH && viewer != null)
        {
            //this may occur in rare cases where dispose() is not called.
            if (viewer.getControl().isDisposed())
            {
                RefreshManager.getInstance().removeListener(null, this);
            }
            else
            {
                viewer.getControl().getDisplay().syncExec(new Runnable() {
                    public void run() {
                        viewer.refresh(dmElement, true);
                    }
                });
            }
        }
	}

	public boolean isServerExplorerViewer ()
    {
    	return this.viewer != null;
    }

	public Object[] getChildren (Object parent)
	{
    	return new Loading ().getChildren(this.viewer, parent, this);
	}
	
	public String getLoadingDescription()
	{
		return DESCRIPTION;
	}

    public Object[] load(Object parentElement)
    {
		if (parentElement instanceof ConnectionInfo)
		{
			return new Object[] { ((ConnectionInfo) parentElement).getSharedDatabase() };
		}
		else if (parentElement instanceof VirtualNode && ((IVirtualNode) parentElement).hasChildren())
		{
			return ((IVirtualNode) parentElement).getChildrenArray();
		}
		else
		{
			return layoutProvider.getChildren(parentElement);
		}
	}

    /**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
    public Object getParent(Object element)
    {
        if (isServerExplorerViewer ())
        {
			Object result = getViewer().testFindItem(element);
			result = result != null ? ((TreeItem)result).getParentItem().getData() : element instanceof IVirtualNode ? ((IVirtualNode) element).getParent() : null;
			result = result != null ? result : element instanceof EObject ? containmentService.getContainer((EObject) element)
					: null;
			return result;
		}
        return null;
    }

    /**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
    public boolean hasChildren(Object element)
    {
    	if (element instanceof IConnectionProfile)
    	{
    		return ((IConnectionProfile) element).getConnectionState() != IConnectionProfile.DISCONNECTED_STATE;
    	}
    	return element instanceof ConnectionInfo && ((ConnectionInfo) element).getSharedDatabase() == null ? false : element instanceof LoadingNode ? false : true;
    }

    /**
     * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
     */
    public Object[] getElements(Object inputElement)
    {
        return getChildren(inputElement);
    }

    /**
     * @see org.eclipse.jface.viewers.IContentProvider#dispose()
     */
    public void dispose()
    {
        RefreshManager.getInstance().removeListener(null, this);
    }

    private void loadChilds (CommonViewer viewer, Object parent)
    {
        viewer.expandToLevel(parent, 1);
    }
    
    private Object getVirtualNode (CommonViewer viewer, Object parent, String groupID)
    {
        if (parent != null)
        {
            if (parent instanceof IConnectionProfile)
            {
                return parent;
            }
            else
            {
                TreeItem [] items = getServerExplorerChildren(parent);
                if (items.length != 0)
                {   
                    for (int i = 0, n = items.length; i < n; i++)
                    {
                        TreeItem child = items[i];
                        Object childNode = child.getData ();
                        if (childNode instanceof IVirtualNode && ((IVirtualNode)childNode).getGroupID().equals(groupID))
                        {
                            return (IVirtualNode) child.getData();
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public TreeItem[] getServerExplorerChildren(Object object)
    {
        TreeItem w = (TreeItem)this.getViewer().testFindItem(object);
        return w == null ? new TreeItem[0] : (TreeItem [])w.getItems();
    }

    private Object getEObjectNode (CommonViewer viewer, Object parent, String name)
    {
        if (parent != null)
        {
            TreeItem [] items = getServerExplorerChildren(parent);
            if (items.length != 0)
            {
                for (int i = 0, n = items.length; i < n; i++)
                {
                    TreeItem child = items[i];
                    Object childNode = child.getData ();
                    if (childNode instanceof ENamedElement && ((ENamedElement)childNode).getName().equals (name))
                    {
                        return childNode;
                    }
                }
            }
        }
        return null;
    }
    
    /**
     * @see org.eclipse.datatools.connectivity.sqm.server.internal.ui.ui.services.IServerExplorerServices#expandNode(java.lang.Object)
     */
    public void expandNode(EObject eObject)
    {
        try
        {
            expandNode (TransientEObjectUtil.getEObjectId(eObject));
        }
        catch (Exception e)
        {
        }
    }

    public void selectAndReveal(ISelection selection)
    {
        if (selection instanceof IStructuredSelection)
        {
            IStructuredSelection structuredSelection = (IStructuredSelection) selection;
            for (Iterator iterator = structuredSelection.iterator(); iterator.hasNext();)
            {
                Object object = iterator.next();
                if (object instanceof EObject)
                {
                    expandNode ((EObject)object);
                }
            }
        }
        getViewer().setSelection(selection, true);
    }
    
    public void expandNode (String pathToNavigate)
    {
        final CommonViewer viewer = getViewer();

        try
        {
            List path = TransientEObjectUtil.getPathFromID (pathToNavigate);
            Iterator pathIterator = path.iterator();
            
            Object parent1 = ProfileManager.getInstance().getProfileByName((String)pathIterator.next());
            Object parent2 = null;
            while (pathIterator.hasNext())
            {
                String pathString = (String) pathIterator.next();
                IGroup group = TransientEObjectUtil.getGroupInfo(pathString);
                String groupID = group.getGroupId();
                String elementName = group.getElementName();
                
                parent2 = getVirtualNode (viewer, parent1, groupID);
                if (parent2 == null)
                {
                    loadChilds (viewer, parent1);
                    parent2 = getVirtualNode (viewer, parent1, groupID);
                    if (parent2 == null && parent1 instanceof IVirtualNode)
                    {
                        Object [] children =  ((IVirtualNode) parent1).getChildrenArray();
                        for (int i = 0, n = children.length; i < n; i++)
                        {
                            Object parent4 = getVirtualNode (viewer, children[i], groupID);
                            if (parent4 != null)
                            {
                                parent2 = parent4;
                                break;
                            }
                        }
                    }
                }
                else
                {
                    loadChilds (viewer, parent2);
                    Object parent3 = getVirtualNode (viewer, parent2, groupID);
                    if (parent3 != null)
                    {
                        parent2 = parent3;
                    }
                }
                parent1 = parent2;
                if (elementName != null)
                {
                    parent2 = getEObjectNode (viewer, parent1, elementName);
                    if (parent2 == null)
                    {
                        loadChilds (viewer, parent1);
                        parent2 = getEObjectNode (viewer, parent1, elementName);
                    }
                }
                parent1 = parent2;
            }
            
            viewer.setSelection(new StructuredSelection(parent1));
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
    }
    
    /**
     * @see org.eclipse.datatools.connectivity.sqm.server.internal.ui.ui.services.IServerExplorerServices#getServerExplorerLayoutServices()
     */
    public IServerExplorerLayoutService getServerExplorerLayoutService()
    {
        return this;
    }

    /**
     * @see org.eclipse.datatools.connectivity.sqm.server.internal.ui.ui.services.IServerExplorerServices#refreshServerExplorer()
     */
    public void refreshServerExplorer()
    {
    }

    /**
     * @see org.eclipse.datatools.connectivity.sqm.server.internal.ui.ui.services.IServerExplorerServices#updateLayout()
     */
    public void updateLayout()
    {
    }

    /**
     * @see org.eclipse.datatools.connectivity.sqm.server.internal.ui.ui.services.IServerExplorerServices#refreshNode(java.lang.Object)
     */
    public void refreshNode(final Object node)
    {
    	Display.getDefault().asyncExec(new Runnable()
    	{
    		public void run ()
    		{
    	    	if (isServerExplorerViewer ())
    	    	{
    	    		viewer.refresh(node, true);
    	    	}
    		}
    	});
    }

    /**
     * @see org.eclipse.datatools.connectivity.sqm.server.internal.ui.ui.services.IServerExplorerLayoutServices#enableVirtualNodeLayout()
     */
    public void enableVirtualNodeLayout()
    {
        this.layoutProvider = new ServerExplorerVirtualNodeLayoutNav(this);
        for (Iterator iterator = layoutProvidersExtensionList.iterator(); iterator.hasNext();)
        {
            ((IServerExplorerLayoutExtensionProvider) iterator.next()).enableLayout(Layout.VNODE);
        }
    }

    /**
     * @see org.eclipse.datatools.connectivity.sqm.server.internal.ui.ui.services.IServerExplorerLayoutServices#enableHierarchicalLayout()
     */
    public void enableHierarchicalLayout()
    {
        this.layoutProvider = new ServerExplorerHierarchicalLayoutNav(this);
        for (Iterator iterator = layoutProvidersExtensionList.iterator(); iterator.hasNext();)
        {
            ((IServerExplorerLayoutExtensionProvider) iterator.next()).enableLayout(Layout.HIERARCHICAL);
        }
    }

    /**
     * @see org.eclipse.datatools.connectivity.sqm.server.internal.ui.ui.services.IServerExplorerLayoutServices#isVirtualNodeLayoutSelected()
     */
    public boolean isVirtualNodeLayoutSelected()
    {
        return this.layoutProvider instanceof ServerExplorerVirtualNodeLayoutNav;
    }

    /**
     * @see org.eclipse.datatools.connectivity.sqm.server.internal.ui.ui.services.IServerExplorerLayoutServices#isHierarchicalLayoutSelected()
     */
    public boolean isHierarchicalLayoutSelected()
    {
        return this.layoutProvider instanceof ServerExplorerHierarchicalLayoutNav;
    }

    public void expandNode(Object node, int depth)
    {
        while (Display.getDefault().readAndDispatch());
        viewer.expandToLevel(node, depth);
    }

    public void updateSelection(ISelection selection)
    {
        viewer.setSelection(selection,true);
    }

	public void init(Object oldInput, Object newInput) 
	{
	}
}
