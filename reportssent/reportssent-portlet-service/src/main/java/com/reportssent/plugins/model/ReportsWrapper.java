package com.reportssent.plugins.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Reports}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Reports
 * @generated
 */
public class ReportsWrapper implements Reports, ModelWrapper<Reports> {
    private Reports _reports;

    public ReportsWrapper(Reports reports) {
        _reports = reports;
    }

    @Override
    public Class<?> getModelClass() {
        return Reports.class;
    }

    @Override
    public String getModelClassName() {
        return Reports.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("statusId", getStatusId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("statusName", getStatusName());
        attributes.put("statusValue", getStatusValue());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long statusId = (Long) attributes.get("statusId");

        if (statusId != null) {
            setStatusId(statusId);
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

        String statusName = (String) attributes.get("statusName");

        if (statusName != null) {
            setStatusName(statusName);
        }

        String statusValue = (String) attributes.get("statusValue");

        if (statusValue != null) {
            setStatusValue(statusValue);
        }
    }

    /**
    * Returns the primary key of this reports.
    *
    * @return the primary key of this reports
    */
    @Override
    public long getPrimaryKey() {
        return _reports.getPrimaryKey();
    }

    /**
    * Sets the primary key of this reports.
    *
    * @param primaryKey the primary key of this reports
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _reports.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this reports.
    *
    * @return the uuid of this reports
    */
    @Override
    public java.lang.String getUuid() {
        return _reports.getUuid();
    }

    /**
    * Sets the uuid of this reports.
    *
    * @param uuid the uuid of this reports
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _reports.setUuid(uuid);
    }

    /**
    * Returns the status ID of this reports.
    *
    * @return the status ID of this reports
    */
    @Override
    public long getStatusId() {
        return _reports.getStatusId();
    }

    /**
    * Sets the status ID of this reports.
    *
    * @param statusId the status ID of this reports
    */
    @Override
    public void setStatusId(long statusId) {
        _reports.setStatusId(statusId);
    }

    /**
    * Returns the group ID of this reports.
    *
    * @return the group ID of this reports
    */
    @Override
    public long getGroupId() {
        return _reports.getGroupId();
    }

    /**
    * Sets the group ID of this reports.
    *
    * @param groupId the group ID of this reports
    */
    @Override
    public void setGroupId(long groupId) {
        _reports.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this reports.
    *
    * @return the company ID of this reports
    */
    @Override
    public long getCompanyId() {
        return _reports.getCompanyId();
    }

    /**
    * Sets the company ID of this reports.
    *
    * @param companyId the company ID of this reports
    */
    @Override
    public void setCompanyId(long companyId) {
        _reports.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this reports.
    *
    * @return the user ID of this reports
    */
    @Override
    public long getUserId() {
        return _reports.getUserId();
    }

    /**
    * Sets the user ID of this reports.
    *
    * @param userId the user ID of this reports
    */
    @Override
    public void setUserId(long userId) {
        _reports.setUserId(userId);
    }

    /**
    * Returns the user uuid of this reports.
    *
    * @return the user uuid of this reports
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reports.getUserUuid();
    }

    /**
    * Sets the user uuid of this reports.
    *
    * @param userUuid the user uuid of this reports
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _reports.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this reports.
    *
    * @return the user name of this reports
    */
    @Override
    public java.lang.String getUserName() {
        return _reports.getUserName();
    }

    /**
    * Sets the user name of this reports.
    *
    * @param userName the user name of this reports
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _reports.setUserName(userName);
    }

    /**
    * Returns the create date of this reports.
    *
    * @return the create date of this reports
    */
    @Override
    public java.util.Date getCreateDate() {
        return _reports.getCreateDate();
    }

    /**
    * Sets the create date of this reports.
    *
    * @param createDate the create date of this reports
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _reports.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this reports.
    *
    * @return the modified date of this reports
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _reports.getModifiedDate();
    }

    /**
    * Sets the modified date of this reports.
    *
    * @param modifiedDate the modified date of this reports
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _reports.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the status name of this reports.
    *
    * @return the status name of this reports
    */
    @Override
    public java.lang.String getStatusName() {
        return _reports.getStatusName();
    }

    /**
    * Sets the status name of this reports.
    *
    * @param statusName the status name of this reports
    */
    @Override
    public void setStatusName(java.lang.String statusName) {
        _reports.setStatusName(statusName);
    }

    /**
    * Returns the status value of this reports.
    *
    * @return the status value of this reports
    */
    @Override
    public java.lang.String getStatusValue() {
        return _reports.getStatusValue();
    }

    /**
    * Sets the status value of this reports.
    *
    * @param statusValue the status value of this reports
    */
    @Override
    public void setStatusValue(java.lang.String statusValue) {
        _reports.setStatusValue(statusValue);
    }

    @Override
    public boolean isNew() {
        return _reports.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _reports.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _reports.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _reports.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _reports.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _reports.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _reports.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _reports.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _reports.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _reports.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _reports.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ReportsWrapper((Reports) _reports.clone());
    }

    @Override
    public int compareTo(com.reportssent.plugins.model.Reports reports) {
        return _reports.compareTo(reports);
    }

    @Override
    public int hashCode() {
        return _reports.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.reportssent.plugins.model.Reports> toCacheModel() {
        return _reports.toCacheModel();
    }

    @Override
    public com.reportssent.plugins.model.Reports toEscapedModel() {
        return new ReportsWrapper(_reports.toEscapedModel());
    }

    @Override
    public com.reportssent.plugins.model.Reports toUnescapedModel() {
        return new ReportsWrapper(_reports.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _reports.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _reports.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _reports.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ReportsWrapper)) {
            return false;
        }

        ReportsWrapper reportsWrapper = (ReportsWrapper) obj;

        if (Validator.equals(_reports, reportsWrapper._reports)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _reports.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Reports getWrappedReports() {
        return _reports;
    }

    @Override
    public Reports getWrappedModel() {
        return _reports;
    }

    @Override
    public void resetOriginalValues() {
        _reports.resetOriginalValues();
    }
}
