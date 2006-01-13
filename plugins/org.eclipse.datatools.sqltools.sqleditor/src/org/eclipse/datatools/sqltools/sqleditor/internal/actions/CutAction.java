/**
 * Created on 2004-10-25
 * 
 * Copyright (c) Sybase, Inc. 2004-2006 All rights reserved.
 */
package org.eclipse.datatools.sqltools.sqleditor.internal.actions;

import org.eclipse.datatools.sqltools.sql.parser.ast.Node;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.IAbstractTextEditorHelpContextIds;


/**
 * @author Hui Cao
 *  
 */
public class CutAction extends SelectionDispatchAction
{

    private CopyToClipboardAction _fCopyToClipboardAction;

    /**
     *  
     */
    public CutAction(IWorkbenchSite site, Clipboard clipboard, SelectionDispatchAction pasteAction)
    {
        super(site);

        setText(Messages.getString("CutAction.label")); //$NON-NLS-1$
        setToolTipText(Messages.getString("CutAction.tooltip")); //$NON-NLS-1$

        _fCopyToClipboardAction = new CopyToClipboardAction(site, clipboard, pasteAction);

        ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
        setDisabledImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT_DISABLED));
        setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));

        PlatformUI.getWorkbench().getHelpSystem().setHelp(this, IAbstractTextEditorHelpContextIds.CUT_ACTION);

        update(getSelection());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jdt.ui.actions.SelectionDispatchAction#selectionChanged(org.eclipse.jface.viewers.IStructuredSelection)
     */
    public void selectionChanged(IStructuredSelection selection)
    {
        _fCopyToClipboardAction.selectionChanged(selection);
        setEnabled(_fCopyToClipboardAction.isEnabled());
    }



    public void run(IStructuredSelection selection)
    {
        selectionChanged(selection);
        if (isEnabled())
        {
            _fCopyToClipboardAction.run(selection);
            Object obj = selection.getFirstElement();
            if (obj instanceof Node)
            {
                Node node = (Node) obj;
                DeleteAction.removeNode(node);
            }
        }

    }

}
