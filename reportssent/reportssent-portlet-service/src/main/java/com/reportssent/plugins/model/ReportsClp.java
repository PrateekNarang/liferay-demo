package com.reportssent.plugins.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.reportssent.plugins.service.ClpSerializer;
import com.reportssent.plugins.service.ReportsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ReportsClp extends BaseModelImpl<Reports> implements Reports {
    private String _uuid;
    private long _statusId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _statusName;
    private String _statusValue;
    private BaseModel<?> _reportsRemoteModel;
    private Class<?> _clpSerializerClass = com.reportssent.plugins.service.ClpSerializer.class;

    public ReportsClp() {
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

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_reportsRemoteModel != null) {
            try {
                Class<?> clazz = _reportsRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_reportsRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getStatusId() {
        return _statusId;
    }

    @Override
    public void setStatusId(long statusId) {
        _statusId = statusId;

        if (_reportsRemoteModel != null) {
            try {
                Class<?> clazz = _reportsRemoteModel.getClass();

                Method method = clazz.getMethod("setStatusId", long.class);

                method.invoke(_reportsRemoteModel, statusId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_reportsRemoteModel != null) {
            try {
                Class<?> clazz = _reportsRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_reportsRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_reportsRemoteModel != null) {
            try {
                Class<?> clazz = _reportsRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_reportsRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_reportsRemoteModel != null) {
            try {
                Class<?> clazz = _reportsRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_reportsRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_reportsRemoteModel != null) {
            try {
                Class<?> clazz = _reportsRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_reportsRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_reportsRemoteModel != null) {
            try {
                Class<?> clazz = _reportsRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_reportsRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_reportsRemoteModel != null) {
            try {
                Class<?> clazz = _reportsRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_reportsRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStatusName() {
        return _statusName;
    }

    @Override
    public void setStatusName(String statusName) {
        _statusName = statusName;

        if (_reportsRemoteModel != null) {
            try {
                Class<?> clazz = _reportsRemoteModel.getClass();

                Method method = clazz.getMethod("setStatusName", String.class);

                method.invoke(_reportsRemoteModel, statusName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStatusValue() {
        return _statusValue;
    }

    @Override
    public void setStatusValue(String statusValue) {
        _statusValue = statusValue;

        if (_reportsRemoteModel != null) {
            try {
                Class<?> clazz = _reportsRemoteModel.getClass();

                Method method = clazz.getMethod("setStatusValue", String.class);

                method.invoke(_reportsRemoteModel, statusValue);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Reports.class.getName()));
    }

    public BaseModel<?> getReportsRemoteModel() {
        return _reportsRemoteModel;
    }

    public void setReportsRemoteModel(BaseModel<?> reportsRemoteModel) {
        _reportsRemoteModel = reportsRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _reportsRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_reportsRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ReportsLocalServiceUtil.addReports(this);
        } else {
            ReportsLocalServiceUtil.updateReports(this);
        }
    }

    @Override
    public Reports toEscapedModel() {
        return (Reports) ProxyUtil.newProxyInstance(Reports.class.getClassLoader(),
            new Class[] { Reports.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ReportsClp clone = new ReportsClp();

        clone.setUuid(getUuid());
        clone.setStatusId(getStatusId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setStatusName(getStatusName());
        clone.setStatusValue(getStatusValue());

        return clone;
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

        if (!(obj instanceof ReportsClp)) {
            return false;
        }

        ReportsClp reports = (ReportsClp) obj;

        long primaryKey = reports.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
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
