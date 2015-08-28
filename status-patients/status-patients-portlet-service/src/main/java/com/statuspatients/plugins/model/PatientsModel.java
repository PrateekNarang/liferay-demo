package com.statuspatients.plugins.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedGroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Patients service. Represents a row in the &quot;OH_Patients&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.statuspatients.plugins.model.impl.PatientsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.statuspatients.plugins.model.impl.PatientsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Patients
 * @see com.statuspatients.plugins.model.impl.PatientsImpl
 * @see com.statuspatients.plugins.model.impl.PatientsModelImpl
 * @generated
 */
public interface PatientsModel extends BaseModel<Patients>, StagedGroupedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a patients model instance should use the {@link Patients} interface instead.
     */

    /**
     * Returns the primary key of this patients.
     *
     * @return the primary key of this patients
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this patients.
     *
     * @param primaryKey the primary key of this patients
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the uuid of this patients.
     *
     * @return the uuid of this patients
     */
    @AutoEscape
    @Override
    public String getUuid();

    /**
     * Sets the uuid of this patients.
     *
     * @param uuid the uuid of this patients
     */
    @Override
    public void setUuid(String uuid);

    /**
     * Returns the foo ID of this patients.
     *
     * @return the foo ID of this patients
     */
    public long getFooId();

    /**
     * Sets the foo ID of this patients.
     *
     * @param fooId the foo ID of this patients
     */
    public void setFooId(long fooId);

    /**
     * Returns the group ID of this patients.
     *
     * @return the group ID of this patients
     */
    @Override
    public long getGroupId();

    /**
     * Sets the group ID of this patients.
     *
     * @param groupId the group ID of this patients
     */
    @Override
    public void setGroupId(long groupId);

    /**
     * Returns the company ID of this patients.
     *
     * @return the company ID of this patients
     */
    @Override
    public long getCompanyId();

    /**
     * Sets the company ID of this patients.
     *
     * @param companyId the company ID of this patients
     */
    @Override
    public void setCompanyId(long companyId);

    /**
     * Returns the user ID of this patients.
     *
     * @return the user ID of this patients
     */
    @Override
    public long getUserId();

    /**
     * Sets the user ID of this patients.
     *
     * @param userId the user ID of this patients
     */
    @Override
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this patients.
     *
     * @return the user uuid of this patients
     * @throws SystemException if a system exception occurred
     */
    @Override
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this patients.
     *
     * @param userUuid the user uuid of this patients
     */
    @Override
    public void setUserUuid(String userUuid);

    /**
     * Returns the user name of this patients.
     *
     * @return the user name of this patients
     */
    @AutoEscape
    @Override
    public String getUserName();

    /**
     * Sets the user name of this patients.
     *
     * @param userName the user name of this patients
     */
    @Override
    public void setUserName(String userName);

    /**
     * Returns the create date of this patients.
     *
     * @return the create date of this patients
     */
    @Override
    public Date getCreateDate();

    /**
     * Sets the create date of this patients.
     *
     * @param createDate the create date of this patients
     */
    @Override
    public void setCreateDate(Date createDate);

    /**
     * Returns the modified date of this patients.
     *
     * @return the modified date of this patients
     */
    @Override
    public Date getModifiedDate();

    /**
     * Sets the modified date of this patients.
     *
     * @param modifiedDate the modified date of this patients
     */
    @Override
    public void setModifiedDate(Date modifiedDate);

    /**
     * Returns the field1 of this patients.
     *
     * @return the field1 of this patients
     */
    @AutoEscape
    public String getField1();

    /**
     * Sets the field1 of this patients.
     *
     * @param field1 the field1 of this patients
     */
    public void setField1(String field1);

    /**
     * Returns the field2 of this patients.
     *
     * @return the field2 of this patients
     */
    public boolean getField2();

    /**
     * Returns <code>true</code> if this patients is field2.
     *
     * @return <code>true</code> if this patients is field2; <code>false</code> otherwise
     */
    public boolean isField2();

    /**
     * Sets whether this patients is field2.
     *
     * @param field2 the field2 of this patients
     */
    public void setField2(boolean field2);

    /**
     * Returns the field3 of this patients.
     *
     * @return the field3 of this patients
     */
    public int getField3();

    /**
     * Sets the field3 of this patients.
     *
     * @param field3 the field3 of this patients
     */
    public void setField3(int field3);

    /**
     * Returns the field4 of this patients.
     *
     * @return the field4 of this patients
     */
    public Date getField4();

    /**
     * Sets the field4 of this patients.
     *
     * @param field4 the field4 of this patients
     */
    public void setField4(Date field4);

    /**
     * Returns the field5 of this patients.
     *
     * @return the field5 of this patients
     */
    @AutoEscape
    public String getField5();

    /**
     * Sets the field5 of this patients.
     *
     * @param field5 the field5 of this patients
     */
    public void setField5(String field5);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(com.statuspatients.plugins.model.Patients patients);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.statuspatients.plugins.model.Patients> toCacheModel();

    @Override
    public com.statuspatients.plugins.model.Patients toEscapedModel();

    @Override
    public com.statuspatients.plugins.model.Patients toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}