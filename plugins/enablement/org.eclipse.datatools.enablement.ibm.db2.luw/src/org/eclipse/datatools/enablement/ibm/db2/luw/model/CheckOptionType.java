/**
 * <copyright>
 * </copyright>
 *
 * $Id: CheckOptionType.java,v 1.7 2008/02/05 02:01:24 hskolwal Exp $
 */
package org.eclipse.datatools.enablement.ibm.db2.luw.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Check Option Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.datatools.enablement.ibm.db2.luw.model.LUWPackage#getCheckOptionType()
 * @model
 * @generated
 */
public final class CheckOptionType extends AbstractEnumerator {
	/**
	 * The '<em><b>NONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NONE = 0;

	/**
	 * The '<em><b>CASCADED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CASCADED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CASCADED = 1;

	/**
	 * The '<em><b>LOCAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOCAL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOCAL = 2;

	/**
	 * The '<em><b>NONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NONE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NONE
	 * @generated
	 * @ordered
	 */
	public static final CheckOptionType NONE_LITERAL = new CheckOptionType(NONE, "NONE", "NONE"); //$NON-NLS-1$

	/**
	 * The '<em><b>CASCADED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CASCADED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CASCADED
	 * @generated
	 * @ordered
	 */
	public static final CheckOptionType CASCADED_LITERAL = new CheckOptionType(CASCADED, "CASCADED", "CASCADED"); //$NON-NLS-1$

	/**
	 * The '<em><b>LOCAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOCAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOCAL
	 * @generated
	 * @ordered
	 */
	public static final CheckOptionType LOCAL_LITERAL = new CheckOptionType(LOCAL, "LOCAL", "LOCAL"); //$NON-NLS-1$

	/**
	 * An array of all the '<em><b>Check Option Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CheckOptionType[] VALUES_ARRAY =
		new CheckOptionType[] {
			NONE_LITERAL,
			CASCADED_LITERAL,
			LOCAL_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Check Option Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Check Option Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CheckOptionType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CheckOptionType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Check Option Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CheckOptionType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CheckOptionType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Check Option Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CheckOptionType get(int value) {
		switch (value) {
			case NONE: return NONE_LITERAL;
			case CASCADED: return CASCADED_LITERAL;
			case LOCAL: return LOCAL_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CheckOptionType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //CheckOptionType
