package com.reportssent.plugins.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.reportssent.plugins.model.Element;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Element in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Element
 * @generated
 */
public class ElementCacheModel implements CacheModel<Element>, Externalizable {
    public String uuid;
    public long statusId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String statusName;
    public String statusValue;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", statusId=");
        sb.append(statusId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", statusName=");
        sb.append(statusName);
        sb.append(", statusValue=");
        sb.append(statusValue);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Element toEntityModel() {
        ElementImpl elementImpl = new ElementImpl();

        if (uuid == null) {
            elementImpl.setUuid(StringPool.BLANK);
        } else {
            elementImpl.setUuid(uuid);
        }

        elementImpl.setStatusId(statusId);
        elementImpl.setGroupId(groupId);
        elementImpl.setCompanyId(companyId);
        elementImpl.setUserId(userId);

        if (userName == null) {
            elementImpl.setUserName(StringPool.BLANK);
        } else {
            elementImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            elementImpl.setCreateDate(null);
        } else {
            elementImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            elementImpl.setModifiedDate(null);
        } else {
            elementImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (statusName == null) {
            elementImpl.setStatusName(StringPool.BLANK);
        } else {
            elementImpl.setStatusName(statusName);
        }

        if (statusValue == null) {
            elementImpl.setStatusValue(StringPool.BLANK);
        } else {
            elementImpl.setStatusValue(statusValue);
        }

        elementImpl.resetOriginalValues();

        return elementImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        statusId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        statusName = objectInput.readUTF();
        statusValue = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(statusId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);

        if (statusName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(statusName);
        }

        if (statusValue == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(statusValue);
        }
    }
}
