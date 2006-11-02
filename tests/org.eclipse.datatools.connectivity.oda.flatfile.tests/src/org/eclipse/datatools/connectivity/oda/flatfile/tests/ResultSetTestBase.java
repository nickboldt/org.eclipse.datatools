/*******************************************************************************
 * Copyright (c) 2004, 2005 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.datatools.connectivity.oda.flatfile.tests;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Properties;

import org.eclipse.datatools.connectivity.oda.IQuery;
import org.eclipse.datatools.connectivity.oda.IResultSet;
import org.eclipse.datatools.connectivity.oda.OdaException;
import org.eclipse.datatools.connectivity.oda.flatfile.CommonConstants;
import org.eclipse.datatools.connectivity.oda.flatfile.Connection;

import junit.framework.TestCase;

/**
 * Base class for testing ResultSet
 */

public abstract class ResultSetTestBase extends TestCase
{

	protected IQuery statement = null;

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp( ) throws Exception
	{
		super.setUp( );
		Connection connection = new Connection( );
		Properties prop = new Properties( );
		prop.setProperty( CommonConstants.CONN_HOME_DIR_PROP, TestUtil.getHomeDir( ) );
		prop.setProperty( CommonConstants.CONN_CHARSET_PROP, TestUtil.DATASET );
		prop.setProperty( CommonConstants.CONN_DELIMITER_TYPE,
				getDelimiterName( ) );
		connection.open( prop );
		statement = connection.newQuery( "FLATFILE" );

	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown( ) throws Exception
	{
		statement.close( );
		super.tearDown( );
	}

	/**
	 * Constructor for ResultSetTest.
	 * 
	 * @throws OdaException
	 */
	public ResultSetTestBase( ) throws OdaException
	{
		TestUtil.createTestFile( getDelimiter( ) );
	}

	/**
	 * 
	 * @throws OdaException
	 */
	public void testSetMaxRows( ) throws OdaException
	{
		statement.prepare( "select INT0_COL,DOUBLE0_COL,DATE_COL from table1"
				+ getSuffix( ) + getExtension( ) );
		IResultSet rs = statement.executeQuery( );
		int counter = -1;
		rs.setMaxRows( 555 );
		while ( rs.next( ) )
		{
			counter++;
		}
		assertEquals( counter, 554 );

	}

	/**
	 * 
	 * @throws OdaException
	 */
	public void testNext( ) throws OdaException
	{
		statement.prepare( "select INT0_COL,DOUBLE0_COL,DATE_COL from table1"
				+ getSuffix( ) + getExtension( ) );
		statement.setMaxRows( 500 );
		IResultSet rs = statement.executeQuery( );
		int counter = 0;

		rs.setMaxRows( 1000 );
		while ( rs.next( ) )
		{
			assertEquals( new Integer( counter++ ).toString( ),
					rs.getString( 1 ) );
		}
		assertEquals( counter, statement.getMaxRows( ) );
	}

	/**
	 * 
	 * @throws OdaException
	 */
	public void testGetRow( ) throws OdaException
	{
		statement.prepare( "select INT0_COL from table1"
				+ getSuffix( ) + getExtension( ) );
		IResultSet rs = statement.executeQuery( );
		int counter = -1;
		while ( rs.next( ) )
			assertEquals( rs.getRow( ), ++counter );
		assertEquals( counter, 1233 );
	}

	/**
	 * Class under test for String getString(int)
	 * 
	 * @throws OdaException
	 */
	public void testGetStringint( ) throws OdaException
	{
		statement.prepare( "select INT0_COL,STRING_COL from table2"
				+ getSuffix( ) + getExtension( ) );
		IResultSet rs = statement.executeQuery( );
		rs.next( );
		assertEquals( rs.getString( 2 ),
				"I'm, really, a lovely ,nice , \"STRING\"" );
		assertFalse( rs.wasNull( ) );

		statement.prepare( "select string_col as string1, string_col from table2"
				+ getSuffix( ) + getExtension( ) );
		rs = statement.executeQuery( );
		rs.next( );
		assertEquals( rs.getString( 1 ), rs.getString( 2 ) );
	}

	/**
	 * Class under test for String getString(String)
	 * 
	 * @throws OdaException
	 */
	public void testGetStringString( ) throws OdaException
	{
		statement.prepare( "select INT0_COL,STRING_COL from table2"
				+ getSuffix( ) + getExtension( ) );
		IResultSet rs = statement.executeQuery( );
		rs.next( );
		assertEquals( rs.getString( "String_col" ),
				"I'm, really, a lovely ,nice , \"STRING\"" );
		assertFalse( rs.wasNull( ) );
	}

	/**
	 * 
	 * @throws OdaException
	 */
	public void testGetStringWithQuote( ) throws OdaException
	{
		statement.prepare( "select * from table5"
				+ getSuffix( ) + getExtension( ) );
		IResultSet rs = statement.executeQuery( );
		rs.next( );
		assertEquals( rs.getString( 1 ), "\"\"\"" );
		assertEquals( rs.getString( 2 ), "\"ABC\"" );
		assertEquals( rs.getString( 3 ), null );
		assertEquals( rs.getString( 4 ), null );
		assertEquals( rs.getString( 5 ), null );

		rs.next( );
		assertEquals( rs.getString( 1 ), "1" );
		assertEquals( rs.getString( 2 ), null );
		assertEquals( rs.getString( 3 ), null );
		assertEquals( rs.getString( 4 ), null );
		assertEquals( rs.getString( 5 ), null );
	}

	/**
	 * Class under test for int getInt(int)
	 * 
	 * @throws OdaException
	 */
	public void testGetIntint( ) throws OdaException
	{
		statement.prepare( "select INT0_COL,INT1_COL from table2"
				+ getSuffix( ) + getExtension( ) );
		IResultSet rs = statement.executeQuery( );
		rs.next( );
		assertEquals( rs.getInt( 1 ), 0 );
		assertFalse( rs.wasNull( ) );
		assertEquals( rs.getInt( 2 ), -123456789 );
		assertFalse( rs.wasNull( ) );
	}

	/**
	 * Class under test for int getInt(String)
	 * 
	 * @throws OdaException
	 */
	public void testGetIntString( ) throws OdaException
	{
		statement.prepare( "select INT0_COL,INT1_COL from table2"
				+ getSuffix( ) + getExtension( ) );
		IResultSet rs = statement.executeQuery( );
		rs.next( );
		assertEquals( rs.getInt( "INT0_COL" ), 0 );
		assertFalse( rs.wasNull( ) );
		assertEquals( rs.getInt( "INT1_COL" ), -123456789 );
		assertFalse( rs.wasNull( ) );

	}

	/**
	 * Class under test for double getDouble(int)
	 * 
	 * @throws OdaException
	 */
	public void testGetDoubleint( ) throws OdaException
	{
		statement.prepare( "select DOUBLE0_COL,DOUBLE1_COL from table2"
				+ getSuffix( ) + getExtension( ) );
		IResultSet rs = statement.executeQuery( );
		rs.next( );
		assertEquals( rs.getDouble( 1 ), 0.123456789, 0 );
		assertFalse( rs.wasNull( ) );
		assertEquals( rs.getDouble( 2 ), 0.987654321, 0 );
		assertFalse( rs.wasNull( ) );
	}

	/**
	 * Class under test for double getDouble(String)
	 * 
	 * @throws OdaException
	 */
	public void testGetDoubleString( ) throws OdaException
	{
		statement.prepare( "select  DOUBLE0_COL  ,  DOUBLE1_COL   from    table2"
				+ getSuffix( ) + getExtension( ) );
		IResultSet rs = statement.executeQuery( );
		rs.next( );
		assertEquals( rs.getDouble( "DOUBLE0_COL" ), 0.123456789, 0 );
		assertFalse( rs.wasNull( ) );
		assertEquals( rs.getDouble( "DOUBLE1_COL" ), 0.987654321, 0 );
		assertFalse( rs.wasNull( ) );
	}

	/**
	 * Class under test for BigDecimal getBigDecimal(int)
	 * 
	 * @throws OdaException
	 */
	public void testGetBigDecimalint( ) throws OdaException
	{
		statement.prepare( "select BIGDECIMAL_COL from table2"
				+ getSuffix( ) + getExtension( ) );
		IResultSet rs = statement.executeQuery( );
		rs.next( );
		assertEquals( rs.getBigDecimal( 1 ),
				new BigDecimal( "1234567891011121314151617.123456789" ) );
		assertFalse( rs.wasNull( ) );

	}

	/**
	 * Class under test for BigDecimal getBigDecimal(String)
	 * 
	 * @throws OdaException
	 */
	public void testGetBigDecimalString( ) throws OdaException
	{
		statement.prepare( "select BIGDECIMAL_COL from table2"
				+ getSuffix( ) + getExtension( ) );
		IResultSet rs = statement.executeQuery( );
		rs.next( );
		assertEquals( rs.getBigDecimal( "bigdecimal_col" ),
				new BigDecimal( "1234567891011121314151617.123456789" ) );
		assertFalse( rs.wasNull( ) );
	}

	/**
	 * Class under test for Date getDate(int)
	 * 
	 * @throws OdaException
	 */
	public void testGetDateint( ) throws OdaException
	{
		statement.prepare( "select DATE_COL from table2"
				+ getSuffix( ) + getExtension( ) );
		IResultSet rs = statement.executeQuery( );
		rs.next( );
		assertEquals( rs.getDate( 1 ), Date.valueOf( "2005-01-30" ) );
		assertFalse( rs.wasNull( ) );
	}

	/**
	 * Class under test for Date getDate(String)
	 * 
	 * @throws OdaException
	 */
	public void testGetDateString( ) throws OdaException
	{
		statement.prepare( "select DATE_COL from table2"
				+ getSuffix( ) + getExtension( ) );
		IResultSet rs = statement.executeQuery( );
		rs.next( );
		assertEquals( rs.getDate( "DATE_COL" ), Date.valueOf( "2005-01-30" ) );
		assertFalse( rs.wasNull( ) );
	}

	/**
	 * Class under test for Time getTime(int)
	 * 
	 * @throws OdaException
	 */
	public void testGetTimeint( ) throws OdaException
	{
		statement.prepare( "select TIME_COL from table2"
				+ getSuffix( ) + getExtension( ) );
		IResultSet rs = statement.executeQuery( );
		rs.next( );
		assertEquals( rs.getTime( 1 ), Time.valueOf( "12:04:59" ) );
		assertFalse( rs.wasNull( ) );
	}

	/**
	 * Class under test for Time getTime(String)
	 * 
	 * @throws OdaException
	 */
	public void testGetTimeString( ) throws OdaException
	{
		statement.prepare( "select TIME_COL from table2"
				+ getSuffix( ) + getExtension( ) );
		IResultSet rs = statement.executeQuery( );
		rs.next( );
		assertEquals( rs.getTime( "TIME_COL" ), Time.valueOf( "12:04:59" ) );
		assertFalse( rs.wasNull( ) );

	}

	/**
	 * Class under test for Timestamp getTimestamp(int)
	 * 
	 * @throws OdaException
	 */
	public void testGetTimestampint( ) throws OdaException
	{
		statement.prepare( "select TIMESTAMP_COL from table2"
				+ getSuffix( ) + getExtension( ) );
		IResultSet rs = statement.executeQuery( );
		rs.next( );
		assertEquals( rs.getTimestamp( 1 ),
				Timestamp.valueOf( "2005-01-31 12:12:12.6" ) );
		assertFalse( rs.wasNull( ) );
	}

	/**
	 * Class under test for Timestamp getTimestamp(String)
	 * 
	 * @throws OdaException
	 */
	public void testGetTimestampString( ) throws OdaException
	{
		statement.prepare( "select TIMESTAMP_COL from table2"
				+ getSuffix( ) + getExtension( ) );
		IResultSet rs = statement.executeQuery( );
		rs.next( );
		assertEquals( rs.getTimestamp( "Timestamp_col" ),
				Timestamp.valueOf( "2005-01-31 12:12:12.6" ) );
		assertFalse( rs.wasNull( ) );
	}

	/**
	 * 
	 * @throws OdaException
	 */
	public void testWasNull( ) throws OdaException
	{
		statement.prepare( "select * from table2"
				+ getSuffix( ) + getExtension( ) );
		IResultSet rs = statement.executeQuery( );
		rs.next( ); // go to the line of null values;
		rs.next( );
		assertNull( rs.getString( "STRING_COL" ) );
		assertTrue( rs.wasNull( ) );

		assertEquals( 0, rs.getInt( "int1_col" ) );
		assertTrue( rs.wasNull( ) );

		assertEquals( 0, rs.getDouble( "double0_col" ), 0 );
		assertTrue( rs.wasNull( ) );
		assertEquals( 0, rs.getDouble( "double1_col" ), 0 );
		assertTrue( rs.wasNull( ) );

		assertNull( rs.getBigDecimal( "bigdecimal_col" ) );
		assertTrue( rs.wasNull( ) );

		assertNull( rs.getDate( "date_col" ) );
		assertTrue( rs.wasNull( ) );

		assertNull( rs.getTime( "time_col" ) );
		assertTrue( rs.wasNull( ) );

		assertNull( rs.getTimestamp( "Timestamp_col" ) );
		assertTrue( rs.wasNull( ) );
	}

	/**
	 * 
	 * @throws OdaException
	 */
	public void testFindColumn( ) throws OdaException
	{
		statement.prepare( "select  INT0_COL , INT1_COL , DOUBLE0_COL ,"
				+ " DOUBLE1_COL , TIME_COL , DATE_COL , BLOB_COL , STRING_COL , BIGDECIMAL_COL   from   table2"
				+ getSuffix( ) + getExtension( ) );
		IResultSet rs = statement.executeQuery( );
		try
		{
			assertEquals( 1, rs.findColumn( "int0_col" ) );
			assertEquals( 2, rs.findColumn( "int1_col" ) );
			assertEquals( 3, rs.findColumn( "DoubLE0_coL" ) );
			assertEquals( 4, rs.findColumn( "double1_col" ) );
			assertEquals( 5, rs.findColumn( "time_col" ) );
			assertEquals( 6, rs.findColumn( "date_col" ) );
			assertEquals( 7, rs.findColumn( "blob_col" ) );
			assertEquals( 8, rs.findColumn( "String_col" ) );
			assertEquals( 9, rs.findColumn( "bigdecimal_col" ) );
		}
		catch ( OdaException e )
		{
			e.printStackTrace( );
			assertTrue( false );
		}

		try
		{
			rs.findColumn( "0" );
			assertTrue( false );
		}
		catch ( OdaException e )
		{
		}
	}
	
	/**
	 * 
	 * @throws OdaException
	 */
	public void testDateConvertFailure( ) throws OdaException
	{
		statement.prepare( "select  INT0_COL , INT1_COL , DOUBLE0_COL ,"
				+ " DOUBLE1_COL , TIME_COL , DATE_COL , BLOB_COL , STRING_COL , BIGDECIMAL_COL   from   table2"
				+ getSuffix( ) + getExtension( ) );
		IResultSet rs = statement.executeQuery( );

		while ( rs.next( ) )
		{
			assertTrue( rs.getTime( "STRING_COL" ) == null );
			assertTrue( rs.getDate( "STRING_COL" ) == null );
			assertTrue( rs.getTimestamp( "STRING_COL" ) == null );
		}
	}

	/**
	 * 
	 * @return
	 */
	protected abstract String getDelimiter( );

	/**
	 * 
	 * @return
	 */
	protected abstract String getDelimiterName( );

	/**
	 * 
	 * @return
	 */
	protected abstract String getSuffix( );

	protected abstract String getExtension( );
}
