/*******************************************************************************
 * Copyright (c) 2004, 2005 Sybase, Inc. and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sybase, Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.sqltools.sql.parser.ast;

/**
 * Interface for the parameter definition list section of a stored procedure
 * 
 * @author Hui Cao
 *
 */
public interface IASTSQLParamDefList
{
    IASTSQLParam getParameter(int index);

    int getParameterCount();
}
