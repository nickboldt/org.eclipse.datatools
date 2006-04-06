/*
 *************************************************************************
 * Copyright (c) 2004, 2005 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *  
 *************************************************************************
 */

package org.eclipse.datatools.connectivity.oda.consumer.helper;

import org.eclipse.datatools.connectivity.oda.OdaException;

/**
 * OdaDriverObject is the base class for all Oda wrapper objects that 
 * needs a reference to its corresponding Oda connection wrapper object. 
 * This also extends some of the OdaObject error handling capabilities.
 */
class OdaDriverObject extends OdaObject
{
	private OdaConnection m_connection;
	
	OdaDriverObject( Object obj, OdaConnection connection, 
	                 boolean switchContextClassloader,
					 ClassLoader driverClassLoader )
	{
		super( obj, switchContextClassloader, driverClassLoader );
		m_connection = connection;
	}
	
	protected OdaConnection getOdaConnection()
	{
		return m_connection;
	}
	
	protected void handleError( OdaException exception ) throws OdaException
	{
		m_connection.handleError( exception );
	}

}
