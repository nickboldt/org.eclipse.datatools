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

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import org.eclipse.datatools.connectivity.oda.IParameterMetaData;
import org.eclipse.datatools.connectivity.oda.IQuery;
import org.eclipse.datatools.connectivity.oda.IResultSet;
import org.eclipse.datatools.connectivity.oda.IResultSetMetaData;
import org.eclipse.datatools.connectivity.oda.OdaException;
import org.eclipse.datatools.connectivity.oda.SortSpec;
import org.eclipse.datatools.connectivity.oda.consumer.nls.Messages;

/**
 * OdaQuery is the ODA wrapper for query statements.
 */
public class OdaQuery extends OdaDriverObject implements IQuery
{
	// isPreparedSuccessfully can only be set to true if 
	// the underlying ODA provider prepare() call succeeds
	private boolean				m_isPreparedSuccessfully;
	private boolean 			m_isExecuted;
	private String 				m_dataSetType;
	private Object 				m_appContext;
		
	protected OdaQuery( IQuery statement, OdaConnection connection,
							String dataSetType, boolean switchContextClassloader,
							ClassLoader driverClassLoader )
	{
		super( statement, connection, switchContextClassloader,
			   driverClassLoader );
		
		final String context = "OdaQuery.OdaQuery( " + statement +
						 ", " + connection + ", " + dataSetType + " )\t";
		logMethodCalled( context );
		
		m_isPreparedSuccessfully = false;
		m_isExecuted = false;
		m_dataSetType = dataSetType;
				
		logMethodExitWithReturn( context, this );
	}
	
	protected IQuery getQuery()
	{
		return (IQuery) getObject();
	}
	
	protected OdaDataSetMetaData getDSMetaData() throws OdaException
	{
		return getOdaConnection().doGetMetaData( m_dataSetType );
	}
	
	protected boolean isPreparedSuccessfully()
	{
		return m_isPreparedSuccessfully;
	}
	
	protected boolean isExecuted()
	{
		return m_isExecuted;
	}
	
	protected void setIsExecuted( boolean flag )
	{
		m_isExecuted = flag;
	}
	
	private void resetStatementStates()
	{
		// need to decrement the open statement count when we reset the 
		// statement states for prepare() and close()
		getOdaConnection().removeOpenStatement( this );
		
		// reset the statement states
		m_isPreparedSuccessfully = false;
		resetExecuteStates();
	}

	protected void resetExecuteStates() 
	{
		m_isExecuted = false;
	}
	
	//------------------------------------------------------------------
	//	IQuery public interface methods
	//------------------------------------------------------------------
	
	/* 
	 * @see org.eclipse.datatools.connectivity.oda.IQuery#setAppContext(java.lang.Object)
	 */
	public void setAppContext( Object context ) throws OdaException
	{
		final String methodName = "OdaQuery.setAppContext()\t";
		final String contextObjInfo = ( context == null ) ? "null" : context.toString();
		logMethodCalled( methodName );

		if( m_appContext == context )	// already set
		{
		    log( methodName, "Same pass-thru application context object: " + contextObjInfo );
			logMethodExit( methodName );
		    return;		// nothing to do
		}

		try
		{
			setContextClassloader();
			
		    log( methodName, "Passing thru application context to underlying ODA query: " + contextObjInfo );
			getQuery().setAppContext( context );
		}
		catch( UnsupportedOperationException uoException )
		{
			// log, and ignore exception
			logUnsupportedOp( uoException, "IQuery.setAppContext" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
		
		// if no exception with passing thru to the underlying connection,
		// hold on to context to verify whether a new one is being passed thru
		m_appContext = context;
		
		logMethodExit( methodName );
	}

	public void prepare( String queryText ) throws OdaException
	{
	    final String context = "OdaQuery.prepare( " + queryText + " )\t";
		logMethodCalled( context );
		
		final String unsupportedOpContext = "IQuery.prepare( String queryText )";
		
		// pass-thru connection context to the underlying query
		// before calling prepare()
		setAppContext( getOdaConnection().getAppContext() );
		
		try
		{	
			setContextClassloader();	
			doPrepare( queryText, context );
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException, unsupportedOpContext );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
		
		// prepare didn't throw an exception, so the statement has been prepared.
		m_isPreparedSuccessfully = true;
		getOdaConnection().addOpenStatement( this );	
		
		logMethodExit( context );
	}
	
	private void doPrepare( String queryText, String logContext ) throws OdaException
	{
		// will need to reset statement states if we're re-preparing a 
		// statement
		resetStatementStates();
		
		// check whether the queryText is valid according to the ODA interfaces spec,
		// i.e. not null; if null, convert it to an empty string
 		if( queryText == null )
 		{
		    log( logContext, "Converted the null queryText argument to an empty String value to comply with the ODA interfaces specification." );
 			queryText = "";
 		}
		
		if( ! getOdaConnection().canSupportMoreOpenedStatements() )
			throw newOdaException( Messages.helper_maxConcurrentStatementsReached );
		
		getQuery().prepare( queryText );
	}

	public void setProperty( String propertyName, String propertyValue )
		throws OdaException
	{
	    final String context = "OdaQuery.setProperty( " + propertyName +
						 ", " + propertyValue + " )\t";
		logMethodCalled( context );
		
		try
		{	
			setContextClassloader();
			
			getQuery().setProperty( propertyName, propertyValue );
			
			logMethodExit( context );
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException,
								 "IQuery.setProperty( String propertyName, " + 
								 "String propertyValue )" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
	}

	public void close() throws OdaException
	{
	    final String context = "OdaQuery.close()\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();
			
			getQuery().close();
			
			resetStatementStates();
			m_dataSetType = null;
			
			logMethodExit( context );
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException,
								 "IQuery.close()" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
	}

	public void setMaxRows( int max ) throws OdaException
	{
	    final String context = "OdaQuery.setMaxRows( " + max + " )\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();
			
			getQuery().setMaxRows( max );
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException, "IQuery.setMaxRows()" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
		
		logMethodExit( context );
	}

	public int getMaxRows() throws OdaException
	{
	    final String context = "OdaQuery.getMaxRows()\t";
		logMethodCalled( context );
		int ret = 0;
		
		try
		{
			setContextClassloader();
			
			ret = getQuery().getMaxRows();
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException, "IQuery.getMaxRows()" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}

		logMethodExitWithReturn( context, ret );
		return ret;
	}

	public IResultSetMetaData getMetaData() throws OdaException
	{
	    final String context = "OdaQuery.getMetaData()\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();

			OdaResultSetMetaData ret = doGetMetaData();
			
			logMethodExitWithReturn( context, ret );
			return ret;
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException,
								 "IQuery.getMetaData()" );
			return null;
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
			return null;
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
			return null;
		}
		finally
		{
			resetContextClassloader();
		}
	}
	
	private OdaResultSetMetaData doGetMetaData() throws OdaException
	{
		if( ! isPreparedSuccessfully() )
			throw newOdaException( Messages.helper_cannotGetResultSetMdBeforePrepare );	
		
		IResultSetMetaData resultSetMetaData = getQuery().getMetaData();
		
		OdaResultSetMetaData ret =
			( resultSetMetaData == null ) ? null :
			new OdaResultSetMetaData( resultSetMetaData, getOdaConnection(),
			                          switchContextClassloader(),
									  getDriverClassLoader() );
		
		return ret;
	}

	public IResultSet executeQuery() throws OdaException
	{
	    final String context = "OdaQuery.executeQuery()\t";
		logMethodCalled( context );
		
		try
		{	
			setContextClassloader();

			OdaResultSet ret = doExecuteQuery();
			logMethodExitWithReturn( context, ret );
			return ret;
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException,
								 "IQuery.executeQuery()" );
			return null;
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
			return null;
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
			return null;
		}
		finally
		{
			resetContextClassloader();
		}
	}
	
	private OdaResultSet doExecuteQuery() throws OdaException
	{
		// possibly re-executing, so need to reset the execute states
		// from a previous execute.
		resetExecuteStates();
		
		if( ! isPreparedSuccessfully() )
			throw newOdaException( Messages.helper_cannotExecuteBeforePrepare );
		
		IResultSet resultSet = getQuery().executeQuery();
		m_isExecuted = true;
		
		if( resultSet == null )
			return null;

		OdaResultSet ret = newResultSetHelper( resultSet );
							 
		return ret;
	}
	
	protected OdaResultSet newResultSetHelper( IResultSet resultSet )
	{
		return new OdaResultSet( resultSet, getOdaConnection(),
			                     switchContextClassloader(),
								 getDriverClassLoader() );
	}

	public void setInt( String parameterName, int value ) throws OdaException
	{
	    final String context = "OdaQuery.setInt( " + parameterName + ", " +
						 value + " )\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();
			
			if( ! isPreparedSuccessfully() )
				throw newOdaException( Messages.helper_cannotSetParamBeforePrepare );
			
			getQuery().setInt( parameterName, value );
			
			logMethodExit( context );
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException,
								 "IQuery.setInt( String parameterName, int value )" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
	}

	public void setInt( int parameterId, int value ) throws OdaException
	{
	    final String context = "OdaQuery.setInt( " + parameterId + ", " +
						 value + " )\t";
		logMethodCalled( context );
		
		try
		{	
			setContextClassloader();
			
			if( ! isPreparedSuccessfully() )
				throw newOdaException( Messages.helper_cannotSetParamBeforePrepare );
			
			getQuery().setInt( parameterId, value );
			
			logMethodExit( context );
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException, 
								 "IQuery.setInt( int parameterId, int value )" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
	}

	public void setDouble( String parameterName, double value )
		throws OdaException
	{
	    final String context = "OdaQuery.setDouble( " + parameterName + ", " +
						 value + " )\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();
			
			if( ! isPreparedSuccessfully() )
				throw newOdaException( Messages.helper_cannotSetParamBeforePrepare );
			
			getQuery().setDouble( parameterName, value );
			
			logMethodExit( context );
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException,
								 "IQuery.setDouble( String parameterName, double value )" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
	}

	public void setDouble( int parameterId, double value ) throws OdaException
	{
	    final String context = "OdaQuery.setDouble( " + parameterId + ", " +
						 value + " )\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();
			
			if( ! isPreparedSuccessfully() )
				throw newOdaException( Messages.helper_cannotSetParamBeforePrepare );
			
			getQuery().setDouble( parameterId, value );
			
			logMethodExit( context );
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException,
								 "IQuery.setDouble( int parameterId, double value )" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
	}

	public void setBigDecimal( String parameterName, BigDecimal value )
		throws OdaException
	{
	    final String context = "OdaQuery.setBigDecimal( " + parameterName + ", " +
						 value + " )\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();
			
			if( ! isPreparedSuccessfully() )
				throw newOdaException( Messages.helper_cannotSetParamBeforePrepare );
			
			getQuery().setBigDecimal( parameterName, value );
			logMethodExit( context );
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException,
								 "IQuery.setBigDecimal( String parameterName, BigDecimal value )" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
	}
	
	public void setBigDecimal( int parameterId, BigDecimal value ) throws OdaException
	{
	    final String context = "OdaQuery.setBigDecimal( " + parameterId + ", " +
						 value + " )\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();
			
			if( ! isPreparedSuccessfully() )
				throw newOdaException( Messages.helper_cannotSetParamBeforePrepare );
			
			getQuery().setBigDecimal( parameterId, value );
			logMethodExit( context );
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException,
								 "IQuery.setBigDecimal( int parameterId, BigDecimal value )" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
	}
	
	public void setString( String parameterName, String value )
		throws OdaException
	{
	    final String context = "OdaQuery.setString( " + parameterName + ", " +
						 value + " )\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();
			
			if( ! isPreparedSuccessfully() )
				throw newOdaException( Messages.helper_cannotSetParamBeforePrepare );
			
			getQuery().setString( parameterName, value );
			
			logMethodExit( context );
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException,
								 "IQuery.setString( String parameterName, String value )" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
	}

	public void setString( int parameterId, String value ) throws OdaException
	{
	    final String context = "OdaQuery.setString( " + parameterId + ", " +
						 value + " )\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();
			
			if( ! isPreparedSuccessfully() )
				throw newOdaException( Messages.helper_cannotSetParamBeforePrepare );
			
			getQuery().setString( parameterId, value );
			
			logMethodExit( context );
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException,
								 "IQuery.setString( int parameterId, String value )" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
	}

	public void setDate( String parameterName, Date value ) throws OdaException
	{
	    final String context = "OdaQuery.setDate( " + parameterName + ", " +
						 value + " )\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();
			
			if( ! isPreparedSuccessfully() )
				throw newOdaException( Messages.helper_cannotSetParamBeforePrepare );
			
			getQuery().setDate( parameterName, value );
			
			logMethodExit( context );
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException,
								 "IQuery.setDate( String parameterName, Date value )" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
	}

	public void setDate( int parameterId, Date value ) throws OdaException
	{
	    final String context = "OdaQuery.setDate( " + parameterId + ", " +
						 value + " )\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();
			
			if( ! isPreparedSuccessfully() )
				throw newOdaException( Messages.helper_cannotSetParamBeforePrepare );
			
			getQuery().setDate( parameterId, value );
			
			logMethodExit( context );
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException, 
								 "IQuery.setDate( int parameterId, Date value )" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
	}

	public void setTime( String parameterName, Time value ) throws OdaException
	{
	    final String context = "OdaQuery.setTime( " + parameterName + ", " +
					 	 value + " )\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();
			
			if( ! isPreparedSuccessfully() )
				throw newOdaException( Messages.helper_cannotSetParamBeforePrepare );
			
			getQuery().setTime( parameterName, value );
			
			logMethodExit( context );
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException, 
								 "IQuery.setTime( String parameterName, Time value )" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
	}

	public void setTime( int parameterId, Time value ) throws OdaException
	{
	    final String context = "OdaQuery.setTime( " + parameterId + ", " +
						 value + " )\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();
			
			if( ! isPreparedSuccessfully() )
				throw newOdaException( Messages.helper_cannotSetParamBeforePrepare );
			
			getQuery().setTime( parameterId, value );
			
			logMethodExit( context );
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException,
								 "IQuery.setTime( int parameterId, Time value )" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
	}

	public void setTimestamp( String parameterName, Timestamp value )
		throws OdaException
	{
	    final String context = "OdaQuery.setTimestamp( " + parameterName + ", " +
						 value + " )\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();
			
			if( ! isPreparedSuccessfully() )
				throw newOdaException( Messages.helper_cannotSetParamBeforePrepare );
			
			getQuery().setTimestamp( parameterName, value );
			
			logMethodExit( context );
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException,
								 "IQuery.setTimestamp( String parameterName, Timestamp value )" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
	}

	public void setTimestamp( int parameterId, Timestamp value )
		throws OdaException
	{
	    final String context = "OdaQuery.setTimestamp( " + parameterId + ", " +
						 value + " )\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();
			
			if( ! isPreparedSuccessfully() )
				throw newOdaException( Messages.helper_cannotSetParamBeforePrepare );
			
			getQuery().setTimestamp( parameterId, value );
			
			logMethodExit( context );
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException, 
								 "IQuery.setTimestamp( int parameterId, Timestamp value )" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
	}

	public void clearInParameters() throws OdaException
	{
	    final String context = "OdaQuery.clearInParameters()\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();
			
			getQuery().clearInParameters();
			
			logMethodExit( context );
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException, 
			                     "IQuery.clearInParameters()" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
	}
	
	public int findInParameter( String parameterName ) throws OdaException
	{
	    final String context = "OdaQuery.findInParameter( " + parameterName +
						 " )\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();
			
			if( ! isPreparedSuccessfully() )
				throw newOdaException( Messages.helper_cannotGetParamMdBeforePrepare );
			
			int ret = getQuery().findInParameter( parameterName );
			
			logMethodExitWithReturn( context, ret );
			return ret;
		}
		catch( UnsupportedOperationException uoException )
		{
			return handleUnsupportedOpAndRetZero( uoException,
												  "IQuery.findInParameter( String parameterName )" );
		}
		catch( RuntimeException rtException )
		{
			return handleErrorAndReturnZero( rtException );
		}
		catch( OdaException odaException )
		{
			return handleErrorAndReturnZero( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
	}

	public IParameterMetaData getParameterMetaData() throws OdaException
	{
	    final String context = "OdaQuery.getParameterMetaData()\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();
			
			if( ! isPreparedSuccessfully() )
				throw newOdaException( Messages.helper_cannotGetParamMdBeforePrepare );
			
			IParameterMetaData parameterMetaData = getQuery().getParameterMetaData();
			
			// null value means no parameters are defined on query
			OdaParameterMetaData ret =
				( parameterMetaData == null ) ? null :
				new OdaParameterMetaData( parameterMetaData, getOdaConnection(),
				                            switchContextClassloader(),
											getDriverClassLoader() );
			
			logMethodExitWithReturn( context, ret );
			return ret;
		}
		// there may be two ways that the underlying driver may indicate that 
		// the driver doesn't support the IParameterMetaData interface: 
		// 1. returns a null for getParameterMetaData()
		// 2. throws an UnsupportedOperationException or OdaException (ODA MySQL JDBC) 
		//	  for getParameterMetaData()
		catch( UnsupportedOperationException uoException )
		{
			// TODO handle backward compatibility of optional interface
			handleUnsupportedOp( uoException,
								 "IQuery.getParameterMetaData()" );
			return null;
		}
		catch( OdaException odaException )
		{
			// TODO handle backward compatibility of optional interface
			handleError( odaException );
			return null;
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
			return null;
		}
		finally
		{
			resetContextClassloader();
		}
	}

	public void setSortSpec( SortSpec sortBy ) throws OdaException
	{
	    final String context = "OdaQuery.setSortSpec( " + sortBy + " )\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();
			
			if( ! isPreparedSuccessfully() )
				throw newOdaException( 
						Messages.helper_cannotSetSortSpecBeforePrepare );
			
			getQuery().setSortSpec( sortBy );
			
			logMethodExit( context );
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException, 
					 			 "IQuery.setSortSpec( SortSpec sortBy )" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
	}

	public SortSpec getSortSpec() throws OdaException
	{
	    final String context = "OdaQuery.getSortSpec()\t";
		logMethodCalled( context );
		
		try
		{
			setContextClassloader();
			
			SortSpec sortSpec = getQuery().getSortSpec();
			
			logMethodExitWithReturn( context, sortSpec );
			return sortSpec;
		}
		catch( UnsupportedOperationException uoException )
		{
			handleUnsupportedOp( uoException, "IQuery.getSortSpec()" );
		}
		catch( RuntimeException rtException )
		{
			handleError( rtException );
		}
		catch( OdaException odaException )
		{
			handleError( odaException );
		}
		finally
		{
			resetContextClassloader();
		}
		
		// will never get here
		return null;
	}
	
	public String getInterfaceName()
	{
		return IQuery.class.getName();
	}
}
