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
package org.eclipse.datatools.sqltools.editor.core.result;

import org.eclipse.osgi.util.NLS;

public final class Messages extends NLS {

	private static final String BUNDLE_NAME = Messages.class.getPackage().getName() + ".messages";//$NON-NLS-1$

	private Messages() {
		// Do not instantiate
	}

//    public static String GroupSQLResultRunnable_group_exec;
	public static String ResultSupportRunnable_name;
	public static String ResultSupportRunnable_task_connection;
	public static String ResultSupportRunnable_task_statement;
	public static String ResultSupportRunnable_task_run;
	public static String ResultSupportRunnable_task_iterate;
	public static String ResultSupportRunnable_exception_terminated;
	public static String ResultSupportRunnable_handseccess_name;
	public static String ResultSupportRunnable_handseccess_task;
	public static String sqlEditorName;
//	public static String GroupSQLResultRunnable_name;
//	public static String GroupSQLResultRunnable_groups;
//	public static String GroupSQLResultRunnable_group;
//	public static String GroupSQLResultRunnable_error_interrupted;
//	public static String GroupSQLResultRunnable_title;
//	public static String GroupSQLResultRunnable_message;
//    public static String GroupSQLResultRunnable_not_complete;
//    public static String GroupSQLResultRunnable_fail_to_create_conn;
//    public static String GroupSQLResultRunnable_fail_to_create_conn_to;

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
