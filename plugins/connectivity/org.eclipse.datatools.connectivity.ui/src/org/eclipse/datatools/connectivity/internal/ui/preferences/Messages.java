/*******************************************************************************
 * Copyright (c) 2008 Sybase, Inc.
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Sybase on 2008-3-14
 ******************************************************************************/
package org.eclipse.datatools.connectivity.internal.ui.preferences;

import org.eclipse.osgi.util.NLS;

/**
 * @author renj
 */
public final class Messages extends NLS 
{

    private static final String BUNDLE_NAME = Messages.class.getPackage().getName()+".messages";	//$NON-NLS-1$

    private Messages() 
    {
        // Do not instantiate
    }

    public static String Connectivity_description;
    
    static 
    {
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }
}
