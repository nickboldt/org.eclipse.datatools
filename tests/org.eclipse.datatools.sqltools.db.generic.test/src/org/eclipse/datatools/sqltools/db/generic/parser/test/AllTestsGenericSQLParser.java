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
package org.eclipse.datatools.sqltools.db.generic.parser.test;

import junit.framework.Test;
import junit.framework.TestSuite;


/**
 * @author Hui Cao
 *  
 */
public class AllTestsGenericSQLParser
{

    public static Test suite()
    {
        TestSuite suite = new TestSuite("Tests for org.eclipse.sqltools.db.generic.parser.test");
        //$JUnit-BEGIN$
        suite.addTestSuite(GenericSQLParserTest.class);
        //$JUnit-END$
        return suite;
    }
}
