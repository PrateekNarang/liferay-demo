package com.statuspatients.plugins.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Patients}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Patients
 * @generated
 */
public class PatientsWrapper implements Patients, ModelWrapper<Patients> {
    private Patients _patients;

    public PatientsWrapper(Patients patients) {
        _patients = patients;
    }

    @Override
    public Class<?> getModelClass() {
        return Patients.class;
    }

    @Override
    public String getModelClassName() {
        return Patients.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("fooId", getFooId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("field1", getField1());
        attributes.put("field2", getField2());
        attributes.put("field3", getField3());
        attributes.put("field4", getField4());
        attributes.put("field5", getField5());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long fooId = (Long) attributes.get("fooId");

        if (fooId != null) {
            setFooId(fooId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String field1 = (String) attributes.get("field1");

        if (field1 != null) {
            setField1(field1);
        }

        Boolean field2 = (Boolean) attributes.get("field2");

        if (field2 != null) {
            setField2(field2);
        }

        Integer field3 = (Integer) attributes.get("field3");

        if (field3 != null) {
            setField3(field3);
        }

        Date field4 = (Date) attributes.get("field4");

        if (field4 != null) {
            setField4(field4);
        }

        String field5 = (String) attributes.get("field5");

        if (field5 != null) {
            setField5(field5);
        }
    }

    /**
    * Returns the primary key of this patients.
    *
    * @return the primary key of this patients
    */
    @Override
    public long getPrimaryKey() {
        return _patients.getPrimaryKey();
    }

    /**
    * Sets the primary key of this patients.
    *
    * @param primaryKey the primary key of this patients
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _patients.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this patients.
    *
    * @return the uuid of this patients
    */
    @Override
    public java.lang.String getUuid() {
        return _patients.getUuid();
    }

    /**
    * Sets the uuid of this patients.
    *
    * @param uuid the uuid of this patients
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _patients.setUuid(uuid);
    }

    /**
    * Returns the foo ID of this patients.
    *
    * @return the foo ID of this patients
    */
    @Override
    public long getFooId() {
        return _patients.getFooId();
    }

    /**
    * Sets the foo ID of this patients.
    *
    * @param fooId the foo ID of this patients
    */
    @Override
    public void setFooId(long fooId) {
        _patients.setFooId(fooId);
    }

    /**
    * Returns the group ID of this patients.
    *
    * @return the group ID of this patients
    */
    @Override
    public long getGroupId() {
        return _patients.getGroupId();
    }

    /**
    * Sets the group ID of this patients.
    *
    * @param groupId the group ID of this patients
    */
    @Override
    public void setGroupId(long groupId) {
        _patients.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this patients.
    *
    * @return the company ID of this patients
    */
    @Override
    public long getCompanyId() {
        return _patients.getCompanyId();
    }

    /**
    * Sets the company ID of this patients.
    *
    * @param companyId the company ID of this patients
    */
    @Override
    public void setCompanyId(long companyId) {
        _patients.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this patients.
    *
    * @return the user ID of this patients
    */
    @Override
    public long getUserId() {
        return _patients.getUserId();
    }

    /**
    * Sets the user ID of this patients.
    *
    * @param userId the user ID of this patients
    */
    @Override
    public void setUserId(long userId) {
        _patients.setUserId(userId);
    }

    /**
    * Returns the user uuid of this patients.
    *
    * @return the user uuid of this patients
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _patients.getUserUuid();
    }

    /**
    * Sets the user uuid of this patients.
    *
    * @param userUuid the user uuid of this patients
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _patients.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this patients.
    *
    * @return the user name of this patients
    */
    @Override
    public java.lang.String getUserName() {
        return _patients.getUserName();
    }

    /**
    * Sets the user name of this patients.
    *
    * @param userName the user name of this patients
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _patients.setUserName(userName);
    }

    /**
    * Returns the create date of this patients.
    *
    * @return the create date of this patients
    */
    @Override
    public java.util.Date getCreateDate() {
        return _patients.getCreateDate();
    }

    /**
    * Sets the create date of this patients.
    *
    * @param createDate the create date of this patients
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _patients.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this patients.
    *
    * @return the modified date of this patients
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _patients.getModifiedDate();
    }

    /**
    * Sets the modified date of this patients.
    *
    * @param modifiedDate the modified date of this patients
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _patients.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the field1 of this patients.
    *
    * @return the field1 of this patients
    */
    @Override
    public java.lang.String getField1() {
        return _patients.getField1();
    }

    /**
    * Sets the field1 of this patients.
    *
    * @param field1 the field1 of this patients
    */
    @Override
    public void setField1(java.lang.String field1) {
        _patients.setField1(field1);
    }

    /**
    * Returns the field2 of this patients.
    *
    * @return the field2 of this patients
    */
    @Override
    public boolean getField2() {
        return _patients.getField2();
    }

    /**
    * Returns <code>true</code> if this patients is field2.
    *
    * @return <code>true</code> if this patients is field2; <code>false</code> otherwise
    */
    @Override
    public boolean isField2() {
        return _patients.isField2();
    }

    /**
    * Sets whether this patients is field2.
    *
    * @param field2 the field2 of this patients
    */
    @Override
    public void setField2(boolean field2) {
        _patients.setField2(field2);
    }

    /**
    * Returns the field3 of this patients.
    *
    * @return the field3 of this patients
    */
    @Override
    public int getField3() {
        return _patients.getField3();
    }

    /**
    * Sets the field3 of this patients.
    *
    * @param field3 the field3 of this patients
    */
    @Override
    public void setField3(int field3) {
        _patients.setField3(field3);
    }

    /**
    * Returns the field4 of this patients.
    *
    * @return the field4 of this patients
    */
    @Override
    public java.util.Date getField4() {
        return _patients.getField4();
    }

    /**
    * Sets the field4 of this patients.
    *
    * @param field4 the field4 of this patients
    */
    @Override
    public void setField4(java.util.Date field4) {
        _patients.setField4(field4);
    }

    /**
    * Returns the field5 of this patients.
    *
    * @return the field5 of this patients
    */
    @Override
    public java.lang.String getField5() {
        return _patients.getField5();
    }

    /**
    * Sets the field5 of this patients.
    *
    * @param field5 the field5 of this patients
    */
    @Override
    public void setField5(java.lang.String field5) {
        _patients.setField5(field5);
    }

    @Override
    public boolean isNew() {
        return _patients.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _patients.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _patients.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _patients.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _patients.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _patients.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _patients.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _patients.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _patients.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _patients.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _patients.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new PatientsWrapper((Patients) _patients.clone());
    }

    @Override
    public int compareTo(com.statuspatients.plugins.model.Patients patients) {
        return _patients.compareTo(patients);
    }

    @Override
    public int hashCode() {
        return _patients.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.statuspatients.plugins.model.Patients> toCacheModel() {
        return _patients.toCacheModel();
    }

    @Override
    public com.statuspatients.plugins.model.Patients toEscapedModel() {
        return new PatientsWrapper(_patients.toEscapedModel());
    }

    @Override
    public com.statuspatients.plugins.model.Patients toUnescapedModel() {
        return new PatientsWrapper(_patients.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _patients.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _patients.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _patients.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PatientsWrapper)) {
            return false;
        }

        PatientsWrapper patientsWrapper = (PatientsWrapper) obj;

        if (Validator.equals(_patients, patientsWrapper._patients)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _patients.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Patients getWrappedPatients() {
        return _patients;
    }

    @Override
    public Patients getWrappedModel() {
        return _patients;
    }

    @Override
    public void resetOriginalValues() {
        _patients.resetOriginalValues();
    }
}
