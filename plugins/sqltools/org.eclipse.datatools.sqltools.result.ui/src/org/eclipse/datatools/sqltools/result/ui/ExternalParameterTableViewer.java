/*******************************************************************************
 * Copyright 2001, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.sqltools.result.ui;

import org.eclipse.datatools.sqltools.result.internal.ui.view.ParameterTableViewer;
import org.eclipse.swt.widgets.Composite;

/**
 * Extends ParameterTableViewer to allow extensions to inherit the default parameter viewer
 */
public class ExternalParameterTableViewer extends ParameterTableViewer {

	public ExternalParameterTableViewer(Composite parent, int style) {
		super(parent, style);
	}

}