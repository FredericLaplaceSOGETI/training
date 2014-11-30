/**
 * OPCoach @ 2009
 *
 * $Id$
 */
package com.opcoach.training.rental;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Customer</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.opcoach.training.rental.Customer#getFirstName <em>First Name</em>}</li>
 *   <li>{@link com.opcoach.training.rental.Customer#getName <em>Name</em>}</li>
 *   <li>{@link com.opcoach.training.rental.Customer#getAddress <em>Address</em>}</li>
 *   <li>{@link com.opcoach.training.rental.Customer#getLicenses <em>Licenses</em>}</li>
 *   <li>{@link com.opcoach.training.rental.Customer#getParentAgency <em>Parent Agency</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.opcoach.training.rental.RentalPackage#getCustomer()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='consistentName'"
 *        annotation="gmf.node label='firstName,lastName'"
 *        annotation="gmf.node label.pattern='{0}:{1}'"
 *        annotation="gmf.node figure='com.opcoach.training.rental.gef.figures'"
 * @generated
 */
public interface Customer extends EObject
{
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "OPCoach @ 2012";

	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Name</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see com.opcoach.training.rental.RentalPackage#getCustomer_FirstName()
	 * @model
	 * @generated
	 */
	String getFirstName();

	/**
	 * Sets the value of the '{@link com.opcoach.training.rental.Customer#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value);

	

	

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.opcoach.training.rental.RentalPackage#getCustomer_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.opcoach.training.rental.Customer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' containment reference.
	 * @see #setAddress(Address)
	 * @see com.opcoach.training.rental.RentalPackage#getCustomer_Address()
	 * @model containment="true" required="true"
	 *        annotation="gmf.compartment foo='bar'"
	 * @generated
	 */
	Address getAddress();

	/**
	 * Sets the value of the '{@link com.opcoach.training.rental.Customer#getAddress <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' containment reference.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(Address value);

	/**
	 * Returns the value of the '<em><b>Licenses</b></em>' containment reference list.
	 * The list contents are of type {@link com.opcoach.training.rental.License}.
	 * It is bidirectional and its opposite is '{@link com.opcoach.training.rental.License#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Licenses</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Licenses</em>' containment reference list.
	 * @see com.opcoach.training.rental.RentalPackage#getCustomer_Licenses()
	 * @see com.opcoach.training.rental.License#getOwner
	 * @model opposite="owner" containment="true"
	 *        annotation="gmf.compartment foo='bar'"
	 * @generated
	 */
	EList<License> getLicenses();

	/**
	 * Returns the value of the '<em><b>Parent Agency</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.opcoach.training.rental.RentalAgency#getCustomers <em>Customers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Agency</em>' container reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Agency</em>' container reference.
	 * @see #setParentAgency(RentalAgency)
	 * @see com.opcoach.training.rental.RentalPackage#getCustomer_ParentAgency()
	 * @see com.opcoach.training.rental.RentalAgency#getCustomers
	 * @model opposite="customers" required="true" transient="false"
	 * @generated
	 */
	RentalAgency getParentAgency();

	/**
	 * Sets the value of the '{@link com.opcoach.training.rental.Customer#getParentAgency <em>Parent Agency</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Agency</em>' container reference.
	 * @see #getParentAgency()
	 * @generated
	 */
	void setParentAgency(RentalAgency value);

	
} // Customer
