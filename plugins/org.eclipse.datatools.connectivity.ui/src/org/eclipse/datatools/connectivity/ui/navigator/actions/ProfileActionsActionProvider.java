/*******************************************************************************
 * Copyright (c) 2005 Sybase, Inc.
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: brianf - initial API and implementation
 ******************************************************************************/
package org.eclipse.datatools.connectivity.ui.navigator.actions;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.datatools.connectivity.ICategory;
import org.eclipse.datatools.connectivity.IConnectionProfile;
import org.eclipse.datatools.connectivity.internal.Category;
import org.eclipse.datatools.connectivity.internal.repository.IConnectionProfileRepository;
import org.eclipse.datatools.connectivity.internal.ui.ConnectivityUIPlugin;
import org.eclipse.datatools.connectivity.internal.ui.LocalRepositoryNode;
import org.eclipse.datatools.connectivity.ui.actions.AddProfileViewAction;
import org.eclipse.datatools.connectivity.ui.actions.DeleteAction;
import org.eclipse.datatools.connectivity.ui.actions.RenameAction;
import org.eclipse.datatools.connectivity.ui.actions.ViewPropertyAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;
import org.eclipse.ui.operations.UndoRedoActionGroup;

/**
 * This class provides default keyboard handling and 
 * some basic actions to the DSE. Note that if you want to 
 * override the Delete, Rename, or View Property actions you
 * will need to do it here (by overriding this action provider)
 * as well as in the popup menu extension. That is to handle
 * the keyboard support.
 * 
 * @author brianf
 *
 */
public class ProfileActionsActionProvider extends CommonActionProvider {

	private StructuredViewer aViewer;
    private IStructuredSelection selection;
    
	private AddProfileViewAction addCPAction;
	private ViewPropertyAction propAction;
    private RenameAction renameAction;
    private DeleteAction deleteAction;

	private UndoRedoActionGroup undoRedoGroup;

	/* (non-Javadoc)
	 * @see org.eclipse.ui.navigator.ICommonActionProvider#dispose()
	 */
	public void dispose() {
	}

	/**
	 * @param selection
	 */
	private void setSelection ( IStructuredSelection selection ) {
        this.selection = selection;
        updateActionBars();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.navigator.ICommonActionProvider#setActionContext(org.eclipse.ui.actions.ActionContext)
	 */
	public void setActionContext(ActionContext aContext) {
        if (aContext.getSelection() instanceof IStructuredSelection)
        {
        	setSelection((IStructuredSelection) aContext.getSelection());
        }
		undoRedoGroup.setContext(aContext);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.navigator.ICommonActionProvider#fillContextMenu(org.eclipse.jface.action.IMenuManager)
	 */
	public void fillContextMenu(IMenuManager manager) {
		boolean hasSelection = false;
		if (selection != null && selection.getFirstElement() != null)
			hasSelection = true;
		Object selObject = null;
		if (hasSelection) {
			selObject = selection.getFirstElement();
			if (selObject instanceof ICategory) {
				if(selObject instanceof Category){
					IConnectionProfile repositoryProfile = ((Category) selObject)
							.getRepositoryProfile();
					if (repositoryProfile != null) {
						//when category is in non-local repository
						addCPAction.setParentProfile(repositoryProfile);
					}else{
						//when category is in local repository
						addCPAction.setParentProfile(null);
					}
				}
				addCPAction.setCategory((ICategory) selObject);// = new AddProfileViewAction((ICategory) selObject);
				manager.insertBefore(IActionCategoryDefs.MARKER_ID_SLOT1,
						addCPAction);
			}else if(selObject instanceof LocalRepositoryNode){
				addCPAction.setParentProfile(null);
				addCPAction.setCategory((ICategory)null);
				manager.insertBefore(IActionCategoryDefs.MARKER_ID_SLOT1,
						addCPAction);
			}
			else if (selObject instanceof IConnectionProfile
					&& ((IConnectionProfile) selObject).getConnectionState() == IConnectionProfile.CONNECTED_STATE
					&& ((IConnectionProfile) selObject).getProvider()
							.getConnectionFactory(
									IConnectionProfileRepository.class
											.getName()) != null) {
				// This profile is a repository
				addCPAction.setCategory((ICategory)null);
				addCPAction.setParentProfile((IConnectionProfile)selObject);
				manager.insertBefore(IActionCategoryDefs.MARKER_ID_SLOT1,
						addCPAction);
			}
		}
		else {
			addCPAction.setCategory((ICategory)null);
			manager.insertBefore(IActionCategoryDefs.MARKER_ID_SLOT1,
					addCPAction);
		}

		if (hasSelection && ViewPropertyAction.hasContributors(selObject)) {
			manager.add(propAction);
		}
		undoRedoGroup.fillContextMenu(manager);
		return;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.navigator.ICommonActionProvider#fillActionBars(org.eclipse.ui.IActionBars)
	 */
	public void fillActionBars(IActionBars bars) {
		undoRedoGroup.fillActionBars(bars);
		bars.setGlobalActionHandler(ActionFactory.PROPERTIES.getId(),
				propAction);
		bars.setGlobalActionHandler(ActionFactory.RENAME.getId(),
				renameAction);
		bars.setGlobalActionHandler(ActionFactory.DELETE.getId(),
				deleteAction);
        updateActionBars();
        return;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.navigator.CommonActionProvider#init(org.eclipse.ui.navigator.ICommonActionExtensionSite)
	 */
	public void init(ICommonActionExtensionSite aConfig) {
        this.aViewer = aConfig.getStructuredViewer();
        makeActions();

		IUndoContext workspaceContext = (IUndoContext) ResourcesPlugin
			.getWorkspace().getAdapter(IUndoContext.class);
		undoRedoGroup = new UndoRedoActionGroup(((ICommonViewerWorkbenchSite) aConfig.getViewSite()).getSite(),
				workspaceContext, true);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.actions.ActionGroup#setContext(org.eclipse.ui.actions.ActionContext)
	 */
	public void setContext(ActionContext context) {
		super.setContext(context);
        if (context.getSelection() instanceof IStructuredSelection)
        {
        	setSelection((IStructuredSelection) context.getSelection());
        }
	}
	
	/**
	 * 
	 */
	private void makeActions() {
		addCPAction = new AddProfileViewAction();
		
		propAction = new ViewPropertyAction(this.aViewer);
		propAction.setActionDefinitionId("org.eclipse.ui.file.properties"); //$NON-NLS-1$

    	renameAction = new RenameAction();
    	renameAction.setActionDefinitionId("org.eclipse.ui.edit.rename"); //$NON-NLS-1$
    	renameAction.setText(ConnectivityUIPlugin.getDefault().getResourceString("DSE.Rename.label")); //$NON-NLS-1$
    	
    	deleteAction = new DeleteAction();
    	deleteAction.setText(ConnectivityUIPlugin.getDefault().getResourceString("DSE.Delete.label")); //$NON-NLS-1$
    	deleteAction.setActionDefinitionId("org.eclipse.ui.edit.delete"); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.actions.ActionGroup#updateActionBars()
	 */
	public void updateActionBars() {
		IStructuredSelection selection = null;
		
		if (getContext().getSelection() != null)
			selection = (IStructuredSelection) getContext()
				.getSelection();

		addCPAction.selectionChanged(addCPAction, selection);
		renameAction.selectionChanged(renameAction, selection);
		deleteAction.selectionChanged(deleteAction, selection);
		
		Object selected = selection.getFirstElement();
		boolean hasProperties = ViewPropertyAction.hasContributors(selected);
		propAction.setEnabled(hasProperties);
		undoRedoGroup.updateActionBars();
	}

}
