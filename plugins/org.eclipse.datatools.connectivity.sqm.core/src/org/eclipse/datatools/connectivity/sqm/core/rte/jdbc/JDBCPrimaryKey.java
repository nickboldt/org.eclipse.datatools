/*******************************************************************************
 * Copyright (c) 2001, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package org.eclipse.datatools.connectivity.sqm.core.rte.jdbc;

import java.sql.Connection;

import org.eclipse.datatools.connectivity.sqm.core.rte.ICatalogObject;
import org.eclipse.datatools.connectivity.sqm.core.rte.RefreshManager;
import org.eclipse.datatools.modelbase.sql.constraints.impl.PrimaryKeyImpl;
import org.eclipse.datatools.modelbase.sql.schema.Database;


public class JDBCPrimaryKey extends PrimaryKeyImpl implements ICatalogObject {

	public void refresh() {
		RefreshManager.getInstance().referesh(this);
	}

	public boolean isSystemObject() {
		return false;
	}

	public Database getCatalogDatabase() {
		return getBaseTable().getSchema().getCatalog().getDatabase();
	}

	public Connection getConnection() {
		Database db = getCatalogDatabase();
		if (db instanceof ICatalogObject) {
			return ((ICatalogObject) db).getConnection();
		}
		return null;
	}

}
