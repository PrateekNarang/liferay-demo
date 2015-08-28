package com.reportssent.plugins.model;

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
 * The base model interface for the Element service. Represents a row in the &quot;OH_Element&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.reportssent.plugins.model.impl.ElementModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.reportssent.plugins.model.impl.ElementImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Element
 * @see com.reportssent.plugins.model.impl.ElementImpl
 * @see com.reportssent.plugins.model.impl.ElementModelImpl
 * @generated
 */
public interface ElementModel extends BaseModel<Element>, StagedGroupedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a element model instance should use the {@link Element} interface instead.
     */

    /**
     * Returns the primary key of this element.
     *
     * @return the primary key of this element
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this element.
     *
     * @param primaryKey the primary key of this element
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the uuid of this element.
     *
     * @return the uuid of this element
     */
    @AutoEscape
    @Override
    public String getUuid();

    /**
     * Sets the uuid of this element.
     *
     * @param uuid the uuid of this element
     */
    @Override
    public void setUuid(String uuid);

    /**
     * Returns the status ID of this element.
     *
     * @return the status ID of this element
     */
    public long getStatusId();

    /**
     * Sets the status ID of this element.
     *
     * @param statusId the status ID of this element
     */
    public void setStatusId(long statusId);

    /**
     * Returns the group ID of this element.
     *
     * @return the group ID of this element
     */
    @Override
    public long getGroupId();

    /**
     * Sets the group ID of this element.
     *
     * @param groupId the group ID of this element
     */
    @Override
    public void setGroupId(long groupId);

    /**
     * Returns the company ID of this element.
     *
     * @return the company ID of this element
     */
    @Override
    public long getCompanyId();

    /**
     * Sets the company ID of this element.
     *
     * @param companyId the company ID of this element
     */
    @Override
    public void setCompanyId(long companyId);

    /**
     * Returns the user ID of this element.
     *
     * @return the user ID of this element
     */
    @Override
    public long getUserId();

    /**
     * Sets the user ID of this element.
     *
     * @param userId the user ID of this element
     */
    @Override
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this element.
     *
     * @return the user uuid of this element
     * @throws SystemException if a system exception occurred
     */
    @Override
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this element.
     *
     * @param userUuid the user uuid of this element
     */
    @Override
    public void setUserUuid(String userUuid);

    /**
     * Returns the user name of this element.
     *
     * @return the user name of this element
     */
    @AutoEscape
    @Override
    public String getUserName();

    /**
     * Sets the user name of this element.
     *
     * @param userName the user name of this element
     */
    @Override
    public void setUserName(String userName);

    /**
     * Returns the create date of this element.
     *
     * @return the create date of this element
     */
    @Override
    public Date getCreateDate();

    /**
     * Sets the create date of this element.
     *
     * @param createDate the create date of this element
     */
    @Override
    public void setCreateDate(Date createDate);

    /**
     * Returns the modified date of this element.
     *
     * @return the modified date of this element
     */
    @Override
    public Date getModifiedDate();

    /**
     * Sets the modified date of this element.
     *
     * @param modifiedDate the modified date of this element
     */
    @Override
    public void setModifiedDate(Date modifiedDate);

    /**
     * Returns the status name of this element.
     *
     * @return the status name of this element
     */
    @AutoEscape
    public String getStatusName();

    /**
     * Sets the status name of this element.
     *
     * @param statusName the status name of this element
     */
    public void setStatusName(String statusName);

    /**
     * Returns the status value of this element.
     *
     * @return the status value of this element
     */
    @AutoEscape
    public String getStatusValue();

    /**
     * Sets the status value of this element.
     *
     * @param statusValue the status value of this element
     */
    public void setStatusValue(String statusValue);

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
    public int compareTo(com.reportssent.plugins.model.Element element);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.reportssent.plugins.model.Element> toCacheModel();

    @Override
    public com.reportssent.plugins.model.Element toEscapedModel();

    @Override
    public com.reportssent.plugins.model.Element toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
