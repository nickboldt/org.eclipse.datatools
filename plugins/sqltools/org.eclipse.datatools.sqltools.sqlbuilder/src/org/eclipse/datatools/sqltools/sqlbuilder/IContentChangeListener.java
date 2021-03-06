/*******************************************************************************
 * Copyright � 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.sqltools.sqlbuilder;

/**
 * This interface is a listener interface for receiving notifications about changes
 * made to the <code>SQLBuilder</code>'s content. 
 *
 */
public interface IContentChangeListener {

	/**
	 * This should be called when the content changes.
	 */
    public void notifyContentChange();
}

