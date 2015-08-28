package com.reportssent.plugins.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.reportssent.plugins.service.http.ElementServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.reportssent.plugins.service.http.ElementServiceSoap
 * @generated
 */
public class ElementSoap implements Serializable {
    private String _uuid;
    private long _statusId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _statusName;
    private String _statusValue;

    public ElementSoap() {
    }

    public static ElementSoap toSoapModel(Element model) {
        ElementSoap soapModel = new ElementSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setStatusId(model.getStatusId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setStatusName(model.getStatusName());
        soapModel.setStatusValue(model.getStatusValue());

        return soapModel;
    }

    public static ElementSoap[] toSoapModels(Element[] models) {
        ElementSoap[] soapModels = new ElementSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ElementSoap[][] toSoapModels(Element[][] models) {
        ElementSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ElementSoap[models.length][models[0].length];
        } else {
            soapModels = new ElementSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ElementSoap[] toSoapModels(List<Element> models) {
        List<ElementSoap> soapModels = new ArrayList<ElementSoap>(models.size());

        for (Element model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ElementSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _statusId;
    }

    public void setPrimaryKey(long pk) {
        setStatusId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getStatusId() {
        return _statusId;
    }

    public void setStatusId(long statusId) {
        _statusId = statusId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getStatusName() {
        return _statusName;
    }

    public void setStatusName(String statusName) {
        _statusName = statusName;
    }

    public String getStatusValue() {
        return _statusValue;
    }

    public void setStatusValue(String statusValue) {
        _statusValue = statusValue;
    }
}
