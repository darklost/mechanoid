/**
 */
package com.robotoworks.mechanoid.ops.opServiceModel.impl;

import com.robotoworks.mechanoid.ops.opServiceModel.OpServiceModelPackage;
import com.robotoworks.mechanoid.ops.opServiceModel.Operation;
import com.robotoworks.mechanoid.ops.opServiceModel.OperationArg;
import com.robotoworks.mechanoid.ops.opServiceModel.WithUniqueBlock;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.robotoworks.mechanoid.ops.opServiceModel.impl.OperationImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.robotoworks.mechanoid.ops.opServiceModel.impl.OperationImpl#getArgs <em>Args</em>}</li>
 *   <li>{@link com.robotoworks.mechanoid.ops.opServiceModel.impl.OperationImpl#getUnique <em>Unique</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationImpl extends MinimalEObjectImpl.Container implements Operation
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgs()
   * @generated
   * @ordered
   */
  protected EList<OperationArg> args;

  /**
   * The cached value of the '{@link #getUnique() <em>Unique</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnique()
   * @generated
   * @ordered
   */
  protected WithUniqueBlock unique;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperationImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return OpServiceModelPackage.Literals.OPERATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OpServiceModelPackage.OPERATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<OperationArg> getArgs()
  {
    if (args == null)
    {
      args = new EObjectContainmentEList<OperationArg>(OperationArg.class, this, OpServiceModelPackage.OPERATION__ARGS);
    }
    return args;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WithUniqueBlock getUnique()
  {
    return unique;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUnique(WithUniqueBlock newUnique, NotificationChain msgs)
  {
    WithUniqueBlock oldUnique = unique;
    unique = newUnique;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OpServiceModelPackage.OPERATION__UNIQUE, oldUnique, newUnique);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnique(WithUniqueBlock newUnique)
  {
    if (newUnique != unique)
    {
      NotificationChain msgs = null;
      if (unique != null)
        msgs = ((InternalEObject)unique).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OpServiceModelPackage.OPERATION__UNIQUE, null, msgs);
      if (newUnique != null)
        msgs = ((InternalEObject)newUnique).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OpServiceModelPackage.OPERATION__UNIQUE, null, msgs);
      msgs = basicSetUnique(newUnique, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OpServiceModelPackage.OPERATION__UNIQUE, newUnique, newUnique));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case OpServiceModelPackage.OPERATION__ARGS:
        return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
      case OpServiceModelPackage.OPERATION__UNIQUE:
        return basicSetUnique(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case OpServiceModelPackage.OPERATION__NAME:
        return getName();
      case OpServiceModelPackage.OPERATION__ARGS:
        return getArgs();
      case OpServiceModelPackage.OPERATION__UNIQUE:
        return getUnique();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case OpServiceModelPackage.OPERATION__NAME:
        setName((String)newValue);
        return;
      case OpServiceModelPackage.OPERATION__ARGS:
        getArgs().clear();
        getArgs().addAll((Collection<? extends OperationArg>)newValue);
        return;
      case OpServiceModelPackage.OPERATION__UNIQUE:
        setUnique((WithUniqueBlock)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case OpServiceModelPackage.OPERATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case OpServiceModelPackage.OPERATION__ARGS:
        getArgs().clear();
        return;
      case OpServiceModelPackage.OPERATION__UNIQUE:
        setUnique((WithUniqueBlock)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case OpServiceModelPackage.OPERATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case OpServiceModelPackage.OPERATION__ARGS:
        return args != null && !args.isEmpty();
      case OpServiceModelPackage.OPERATION__UNIQUE:
        return unique != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //OperationImpl
