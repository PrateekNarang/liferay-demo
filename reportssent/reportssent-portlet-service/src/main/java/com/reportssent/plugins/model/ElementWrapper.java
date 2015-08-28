package com.reportssent.plugins.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Element}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Element
 * @generated
 */
public class ElementWrapper implements Element, ModelWrapper<Element> {
    private Element _element;

    public ElementWrapper(Element element) {
        _element = element;
    }

    @Override
    public Class<?> getModelClass() {
        return Element.class;
    }

    @Override
    public String getModelClassName() {
        return Element.class.getName();
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
    * Returns the primary key of this element.
    *
    * @return the primary key of this element
    */
    @Override
    public long getPrimaryKey() {
        return _element.getPrimaryKey();
    }

    /**
    * Sets the primary key of this element.
    *
    * @param primaryKey the primary key of this element
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _element.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this element.
    *
    * @return the uuid of this element
    */
    @Override
    public java.lang.String getUuid() {
        return _element.getUuid();
    }

    /**
    * Sets the uuid of this element.
    *
    * @param uuid the uuid of this element
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _element.setUuid(uuid);
    }

    /**
    * Returns the status ID of this element.
    *
    * @return the status ID of this element
    */
    @Override
    public long getStatusId() {
        return _element.getStatusId();
    }

    /**
    * Sets the status ID of this element.
    *
    * @param statusId the status ID of this element
    */
    @Override
    public void setStatusId(long statusId) {
        _element.setStatusId(statusId);
    }

    /**
    * Returns the group ID of this element.
    *
    * @return the group ID of this element
    */
    @Override
    public long getGroupId() {
        return _element.getGroupId();
    }

    /**
    * Sets the group ID of this element.
    *
    * @param groupId the group ID of this element
    */
    @Override
    public void setGroupId(long groupId) {
        _element.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this element.
    *
    * @return the company ID of this element
    */
    @Override
    public long getCompanyId() {
        return _element.getCompanyId();
    }

    /**
    * Sets the company ID of this element.
    *
    * @param companyId the company ID of this element
    */
    @Override
    public void setCompanyId(long companyId) {
        _element.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this element.
    *
    * @return the user ID of this element
    */
    @Override
    public long getUserId() {
        return _element.getUserId();
    }

    /**
    * Sets the user ID of this element.
    *
    * @param userId the user ID of this element
    */
    @Override
    public void setUserId(long userId) {
        _element.setUserId(userId);
    }

    /**
    * Returns the user uuid of this element.
    *
    * @return the user uuid of this element
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _element.getUserUuid();
    }

    /**
    * Sets the user uuid of this element.
    *
    * @param userUuid the user uuid of this element
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _element.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this element.
    *
    * @return the user name of this element
    */
    @Override
    public java.lang.String getUserName() {
        return _element.getUserName();
    }

    /**
    * Sets the user name of this element.
    *
    * @param userName the user name of this element
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _element.setUserName(userName);
    }

    /**
    * Returns the create date of this element.
    *
    * @return the create date of this element
    */
    @Override
    public java.util.Date getCreateDate() {
        return _element.getCreateDate();
    }

    /**
    * Sets the create date of this element.
    *
    * @param createDate the create date of this element
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _element.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this element.
    *
    * @return the modified date of this element
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _element.getModifiedDate();
    }

    /**
    * Sets the modified date of this element.
    *
    * @param modifiedDate the modified date of this element
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _element.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the status name of this element.
    *
    * @return the status name of this element
    */
    @Override
    public java.lang.String getStatusName() {
        return _element.getStatusName();
    }

    /**
    * Sets the status name of this element.
    *
    * @param statusName the status name of this element
    */
    @Override
    public void setStatusName(java.lang.String statusName) {
        _element.setStatusName(statusName);
    }

    /**
    * Returns the status value of this element.
    *
    * @return the status value of this element
    */
    @Override
    public java.lang.String getStatusValue() {
        return _element.getStatusValue();
    }

    /**
    * Sets the status value of this element.
    *
    * @param statusValue the status value of this element
    */
    @Override
    public void setStatusValue(java.lang.String statusValue) {
        _element.setStatusValue(statusValue);
    }

    @Override
    public boolean isNew() {
        return _element.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _element.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _element.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _element.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _element.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _element.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _element.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _element.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _element.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _element.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _element.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ElementWrapper((Element) _element.clone());
    }

    @Override
    public int compareTo(com.reportssent.plugins.model.Element element) {
        return _element.compareTo(element);
    }

    @Override
    public int hashCode() {
        return _element.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.reportssent.plugins.model.Element> toCacheModel() {
        return _element.toCacheModel();
    }

    @Override
    public com.reportssent.plugins.model.Element toEscapedModel() {
        return new ElementWrapper(_element.toEscapedModel());
    }

    @Override
    public com.reportssent.plugins.model.Element toUnescapedModel() {
        return new ElementWrapper(_element.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _element.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _element.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _element.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ElementWrapper)) {
            return false;
        }

        ElementWrapper elementWrapper = (ElementWrapper) obj;

        if (Validator.equals(_element, elementWrapper._element)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _element.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Element getWrappedElement() {
        return _element;
    }

    @Override
    public Element getWrappedModel() {
        return _element;
    }

    @Override
    public void resetOriginalValues() {
        _element.resetOriginalValues();
    }
}
