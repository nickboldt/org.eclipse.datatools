/*******************************************************************************
 * Copyright (c) 2005 Sybase, Inc.
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Sybase, Inc. - initial API and implementation
 ******************************************************************************/
package org.eclipse.datatools.connectivity.sqm.server.internal.ui.explorer.providers;

import org.eclipse.datatools.connectivity.IConnectionProfile;
import org.eclipse.datatools.connectivity.sqm.internal.core.connection.ConnectionInfo;
import org.eclipse.datatools.connectivity.ui.IContentExtension;
import org.eclipse.datatools.connectivity.ui.ManagedContentExtensionBase;
import org.eclipse.swt.graphics.Image;

/**
 * @see IContentExtension
 */
public class SQLModelContentExtension extends ManagedContentExtensionBase {

	public SQLModelContentExtension(IConnectionProfile profile) {
		super(profile, ConnectionInfo.class.getName());
	}

	public Image getImage() {
		return null;
	}

	public String getLabel() {
		return "SQL Model Content";
	}

	public boolean isVisible() {
		return false;
	}
	
}
