/**
 * OPCoach @ 2009
 *
 * $Id$
 */
package com.opcoach.training.rental.impl;

import com.opcoach.training.rental.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.opcoach.training.rental.Address;
import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.License;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalFactory;
import com.opcoach.training.rental.RentalObject;
import com.opcoach.training.rental.RentalPackage;
import com.opcoach.training.rental.StreetType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RentalFactoryImpl extends EFactoryImpl implements RentalFactory
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "OPCoach @ 2012";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RentalFactory init()
	{
		try
		{
			RentalFactory theRentalFactory = (RentalFactory)EPackage.Registry.INSTANCE.getEFactory(RentalPackage.eNS_URI);
			if (theRentalFactory != null)
			{
				return theRentalFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RentalFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RentalFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case RentalPackage.RENTAL_AGENCY: return createRentalAgency();
			case RentalPackage.CUSTOMER: return createCustomer();
			case RentalPackage.ADDRESS: return createAddress();
			case RentalPackage.RENTAL_OBJECT: return createRentalObject();
			case RentalPackage.LICENSE: return createLicense();
			case RentalPackage.RENTAL: return createRental();
			case RentalPackage.CAR: return createCar();
			case RentalPackage.DEVICE: return createDevice();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue)
	{
		switch (eDataType.getClassifierID())
		{
			case RentalPackage.STREET_TYPE:
				return createStreetTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue)
	{
		switch (eDataType.getClassifierID())
		{
			case RentalPackage.STREET_TYPE:
				return convertStreetTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer createCustomer()
	{
		CustomerImpl customer = new CustomerImpl();
		return customer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RentalAgency createRentalAgency()
	{
		RentalAgencyImpl rentalAgency = new RentalAgencyImpl();
		return rentalAgency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Address createAddress()
	{
		AddressImpl address = new AddressImpl();
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RentalObject createRentalObject()
	{
		RentalObjectImpl rentalObject = new RentalObjectImpl();
		return rentalObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public License createLicense()
	{
		LicenseImpl license = new LicenseImpl();
		return license;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rental createRental()
	{
		RentalImpl rental = new RentalImpl();
		return rental;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Car createCar()
	{
		CarImpl car = new CarImpl();
		return car;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Device createDevice()
	{
		DeviceImpl device = new DeviceImpl();
		return device;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StreetType createStreetTypeFromString(EDataType eDataType, String initialValue)
	{
		StreetType result = StreetType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStreetTypeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RentalPackage getRentalPackage()
	{
		return (RentalPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RentalPackage getPackage()
	{
		return RentalPackage.eINSTANCE;
	}

} //RentalFactoryImpl
