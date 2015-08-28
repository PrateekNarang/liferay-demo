package com.reportssent.plugins.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.reportssent.plugins.model.Reports;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Reports in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Reports
 * @generated
 */
public class ReportsCacheModel implements CacheModel<Reports>, Externalizable {
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
    public Reports toEntityModel() {
        ReportsImpl reportsImpl = new ReportsImpl();

        if (uuid == null) {
            reportsImpl.setUuid(StringPool.BLANK);
        } else {
            reportsImpl.setUuid(uuid);
        }

        reportsImpl.setStatusId(statusId);
        reportsImpl.setGroupId(groupId);
        reportsImpl.setCompanyId(companyId);
        reportsImpl.setUserId(userId);

        if (userName == null) {
            reportsImpl.setUserName(StringPool.BLANK);
        } else {
            reportsImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            reportsImpl.setCreateDate(null);
        } else {
            reportsImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            reportsImpl.setModifiedDate(null);
        } else {
            reportsImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (statusName == null) {
            reportsImpl.setStatusName(StringPool.BLANK);
        } else {
            reportsImpl.setStatusName(statusName);
        }

        if (statusValue == null) {
            reportsImpl.setStatusValue(StringPool.BLANK);
        } else {
            reportsImpl.setStatusValue(statusValue);
        }

        reportsImpl.resetOriginalValues();

        return reportsImpl;
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
