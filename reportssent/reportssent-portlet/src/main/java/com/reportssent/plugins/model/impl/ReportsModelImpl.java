package com.reportssent.plugins.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.reportssent.plugins.model.Reports;
import com.reportssent.plugins.model.ReportsModel;
import com.reportssent.plugins.model.ReportsSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Reports service. Represents a row in the &quot;OH_Reports&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.reportssent.plugins.model.ReportsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ReportsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReportsImpl
 * @see com.reportssent.plugins.model.Reports
 * @see com.reportssent.plugins.model.ReportsModel
 * @generated
 */
@JSON(strict = true)
public class ReportsModelImpl extends BaseModelImpl<Reports>
    implements ReportsModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a reports model instance should use the {@link com.reportssent.plugins.model.Reports} interface instead.
     */
    public static final String TABLE_NAME = "OH_Reports";
    public static final Object[][] TABLE_COLUMNS = {
            { "uuid_", Types.VARCHAR },
            { "statusId", Types.BIGINT },
            { "groupId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "userName", Types.VARCHAR },
            { "createDate", Types.TIMESTAMP },
            { "modifiedDate", Types.TIMESTAMP },
            { "statusName", Types.VARCHAR },
            { "statusValue", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table OH_Reports (uuid_ VARCHAR(75) null,statusId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,statusName VARCHAR(75) null,statusValue VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table OH_Reports";
    public static final String ORDER_BY_JPQL = " ORDER BY reports.statusName ASC";
    public static final String ORDER_BY_SQL = " ORDER BY OH_Reports.statusName ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.reportssent.plugins.model.Reports"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.reportssent.plugins.model.Reports"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.reportssent.plugins.model.Reports"),
            true);
    public static long COMPANYID_COLUMN_BITMASK = 1L;
    public static long GROUPID_COLUMN_BITMASK = 2L;
    public static long STATUSNAME_COLUMN_BITMASK = 4L;
    public static long UUID_COLUMN_BITMASK = 8L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.reportssent.plugins.model.Reports"));
    private static ClassLoader _classLoader = Reports.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            Reports.class
        };
    private String _uuid;
    private String _originalUuid;
    private long _statusId;
    private long _groupId;
    private long _originalGroupId;
    private boolean _setOriginalGroupId;
    private long _companyId;
    private long _originalCompanyId;
    private boolean _setOriginalCompanyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _statusName;
    private String _originalStatusName;
    private String _statusValue;
    private long _columnBitmask;
    private Reports _escapedModel;

    public ReportsModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static Reports toModel(ReportsSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        Reports model = new ReportsImpl();

        model.setUuid(soapModel.getUuid());
        model.setStatusId(soapModel.getStatusId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());
        model.setStatusName(soapModel.getStatusName());
        model.setStatusValue(soapModel.getStatusValue());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<Reports> toModels(ReportsSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<Reports> models = new ArrayList<Reports>(soapModels.length);

        for (ReportsSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _statusId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setStatusId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _statusId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @JSON
    @Override
    public String getUuid() {
        if (_uuid == null) {
            return StringPool.BLANK;
        } else {
            return _uuid;
        }
    }

    @Override
    public void setUuid(String uuid) {
        if (_originalUuid == null) {
            _originalUuid = _uuid;
        }

        _uuid = uuid;
    }

    public String getOriginalUuid() {
        return GetterUtil.getString(_originalUuid);
    }

    @JSON
    @Override
    public long getStatusId() {
        return _statusId;
    }

    @Override
    public void setStatusId(long statusId) {
        _statusId = statusId;
    }

    @JSON
    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _columnBitmask |= GROUPID_COLUMN_BITMASK;

        if (!_setOriginalGroupId) {
            _setOriginalGroupId = true;

            _originalGroupId = _groupId;
        }

        _groupId = groupId;
    }

    public long getOriginalGroupId() {
        return _originalGroupId;
    }

    @JSON
    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _columnBitmask |= COMPANYID_COLUMN_BITMASK;

        if (!_setOriginalCompanyId) {
            _setOriginalCompanyId = true;

            _originalCompanyId = _companyId;
        }

        _companyId = companyId;
    }

    public long getOriginalCompanyId() {
        return _originalCompanyId;
    }

    @JSON
    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @JSON
    @Override
    public String getUserName() {
        if (_userName == null) {
            return StringPool.BLANK;
        } else {
            return _userName;
        }
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;
    }

    @JSON
    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    @JSON
    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    @JSON
    @Override
    public String getStatusName() {
        if (_statusName == null) {
            return StringPool.BLANK;
        } else {
            return _statusName;
        }
    }

    @Override
    public void setStatusName(String statusName) {
        _columnBitmask = -1L;

        if (_originalStatusName == null) {
            _originalStatusName = _statusName;
        }

        _statusName = statusName;
    }

    public String getOriginalStatusName() {
        return GetterUtil.getString(_originalStatusName);
    }

    @JSON
    @Override
    public String getStatusValue() {
        if (_statusValue == null) {
            return StringPool.BLANK;
        } else {
            return _statusValue;
        }
    }

    @Override
    public void setStatusValue(String statusValue) {
        _statusValue = statusValue;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Reports.class.getName()));
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            Reports.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Reports toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Reports) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        ReportsImpl reportsImpl = new ReportsImpl();

        reportsImpl.setUuid(getUuid());
        reportsImpl.setStatusId(getStatusId());
        reportsImpl.setGroupId(getGroupId());
        reportsImpl.setCompanyId(getCompanyId());
        reportsImpl.setUserId(getUserId());
        reportsImpl.setUserName(getUserName());
        reportsImpl.setCreateDate(getCreateDate());
        reportsImpl.setModifiedDate(getModifiedDate());
        reportsImpl.setStatusName(getStatusName());
        reportsImpl.setStatusValue(getStatusValue());

        reportsImpl.resetOriginalValues();

        return reportsImpl;
    }

    @Override
    public int compareTo(Reports reports) {
        int value = 0;

        value = getStatusName().compareTo(reports.getStatusName());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Reports)) {
            return false;
        }

        Reports reports = (Reports) obj;

        long primaryKey = reports.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        ReportsModelImpl reportsModelImpl = this;

        reportsModelImpl._originalUuid = reportsModelImpl._uuid;

        reportsModelImpl._originalGroupId = reportsModelImpl._groupId;

        reportsModelImpl._setOriginalGroupId = false;

        reportsModelImpl._originalCompanyId = reportsModelImpl._companyId;

        reportsModelImpl._setOriginalCompanyId = false;

        reportsModelImpl._originalStatusName = reportsModelImpl._statusName;

        reportsModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Reports> toCacheModel() {
        ReportsCacheModel reportsCacheModel = new ReportsCacheModel();

        reportsCacheModel.uuid = getUuid();

        String uuid = reportsCacheModel.uuid;

        if ((uuid != null) && (uuid.length() == 0)) {
            reportsCacheModel.uuid = null;
        }

        reportsCacheModel.statusId = getStatusId();

        reportsCacheModel.groupId = getGroupId();

        reportsCacheModel.companyId = getCompanyId();

        reportsCacheModel.userId = getUserId();

        reportsCacheModel.userName = getUserName();

        String userName = reportsCacheModel.userName;

        if ((userName != null) && (userName.length() == 0)) {
            reportsCacheModel.userName = null;
        }

        Date createDate = getCreateDate();

        if (createDate != null) {
            reportsCacheModel.createDate = createDate.getTime();
        } else {
            reportsCacheModel.createDate = Long.MIN_VALUE;
        }

        Date modifiedDate = getModifiedDate();

        if (modifiedDate != null) {
            reportsCacheModel.modifiedDate = modifiedDate.getTime();
        } else {
            reportsCacheModel.modifiedDate = Long.MIN_VALUE;
        }

        reportsCacheModel.statusName = getStatusName();

        String statusName = reportsCacheModel.statusName;

        if ((statusName != null) && (statusName.length() == 0)) {
            reportsCacheModel.statusName = null;
        }

        reportsCacheModel.statusValue = getStatusValue();

        String statusValue = reportsCacheModel.statusValue;

        if ((statusValue != null) && (statusValue.length() == 0)) {
            reportsCacheModel.statusValue = null;
        }

        return reportsCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", statusId=");
        sb.append(getStatusId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", statusName=");
        sb.append(getStatusName());
        sb.append(", statusValue=");
        sb.append(getStatusValue());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(34);

        sb.append("<model><model-name>");
        sb.append("com.reportssent.plugins.model.Reports");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statusId</column-name><column-value><![CDATA[");
        sb.append(getStatusId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statusName</column-name><column-value><![CDATA[");
        sb.append(getStatusName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statusValue</column-name><column-value><![CDATA[");
        sb.append(getStatusValue());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
