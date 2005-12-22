/**
 * </copyright>
 *
 * $Id: XMLNamespaceDeclarationPrefixImpl.java,v 1.3 2005/12/19 20:57:49 bpayton Exp $
 */
package org.eclipse.datatools.modelbase.sql.xml.query.impl;


import java.util.Collection;

import org.eclipse.datatools.modelbase.sql.xml.query.SQLXMLQueryModelPackage;
import org.eclipse.datatools.modelbase.sql.xml.query.XMLNamespaceDeclarationPrefix;
import org.eclipse.datatools.modelbase.sql.xml.query.XMLNamespacesDeclaration;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XML Namespace Declaration Prefix</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.datatools.modelbase.sql.xml.query.impl.XMLNamespaceDeclarationPrefixImpl#getPrefix <em>Prefix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XMLNamespaceDeclarationPrefixImpl extends XMLNamespaceDeclarationItemImpl implements XMLNamespaceDeclarationPrefix {
	/**
	 * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getPrefix()
	 * @generated
	 * @ordered
	 */
    protected static final String PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getPrefix()
	 * @generated
	 * @ordered
	 */
    protected String prefix = PREFIX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected XMLNamespaceDeclarationPrefixImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return SQLXMLQueryModelPackage.eINSTANCE.getXMLNamespaceDeclarationPrefix();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getPrefix() {
		return prefix;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setPrefix(String newPrefix) {
		String oldPrefix = prefix;
		prefix = newPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__PREFIX, oldPrefix, prefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__NAMESPACES_DECL:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__NAMESPACES_DECL, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__DEPENDENCIES:
					return ((InternalEList)getDependencies()).basicRemove(otherEnd, msgs);
				case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__NAMESPACES_DECL:
					return eBasicSetContainer(null, SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__NAMESPACES_DECL, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__NAMESPACES_DECL:
					return eContainer.eInverseRemove(this, SQLXMLQueryModelPackage.XML_NAMESPACES_DECLARATION__NAMESPACE_DECLTEM_LIST, XMLNamespacesDeclaration.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__EANNOTATIONS:
				return getEAnnotations();
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__NAME:
				return getName();
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__DEPENDENCIES:
				return getDependencies();
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__DESCRIPTION:
				return getDescription();
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__LABEL:
				return getLabel();
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__URI:
				return getUri();
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__NAMESPACES_DECL:
				return getNamespacesDecl();
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__PREFIX:
				return getPrefix();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__NAME:
				setName((String)newValue);
				return;
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection)newValue);
				return;
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__LABEL:
				setLabel((String)newValue);
				return;
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__URI:
				setUri((String)newValue);
				return;
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__NAMESPACES_DECL:
				setNamespacesDecl((XMLNamespacesDeclaration)newValue);
				return;
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__PREFIX:
				setPrefix((String)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__DEPENDENCIES:
				getDependencies().clear();
				return;
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__URI:
				setUri(URI_EDEFAULT);
				return;
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__NAMESPACES_DECL:
				setNamespacesDecl((XMLNamespacesDeclaration)null);
				return;
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__PREFIX:
				setPrefix(PREFIX_EDEFAULT);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__NAMESPACES_DECL:
				return getNamespacesDecl() != null;
			case SQLXMLQueryModelPackage.XML_NAMESPACE_DECLARATION_PREFIX__PREFIX:
				return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals(prefix);
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (prefix: ");
		result.append(prefix);
		result.append(')');
		return result.toString();
	}

} //XMLNamespaceDeclarationPrefixImpl
