package com.statuspatients.plugins.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.statuspatients.plugins.model.Patients;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Patients in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Patients
 * @generated
 */
public class PatientsCacheModel implements CacheModel<Patients>, Externalizable {
    public String uuid;
    public long fooId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String field1;
    public boolean field2;
    public int field3;
    public long field4;
    public String field5;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(27);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", fooId=");
        sb.append(fooId);
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
        sb.append(", field1=");
        sb.append(field1);
        sb.append(", field2=");
        sb.append(field2);
        sb.append(", field3=");
        sb.append(field3);
        sb.append(", field4=");
        sb.append(field4);
        sb.append(", field5=");
        sb.append(field5);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Patients toEntityModel() {
        PatientsImpl patientsImpl = new PatientsImpl();

        if (uuid == null) {
            patientsImpl.setUuid(StringPool.BLANK);
        } else {
            patientsImpl.setUuid(uuid);
        }

        patientsImpl.setFooId(fooId);
        patientsImpl.setGroupId(groupId);
        patientsImpl.setCompanyId(companyId);
        patientsImpl.setUserId(userId);

        if (userName == null) {
            patientsImpl.setUserName(StringPool.BLANK);
        } else {
            patientsImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            patientsImpl.setCreateDate(null);
        } else {
            patientsImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            patientsImpl.setModifiedDate(null);
        } else {
            patientsImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (field1 == null) {
            patientsImpl.setField1(StringPool.BLANK);
        } else {
            patientsImpl.setField1(field1);
        }

        patientsImpl.setField2(field2);
        patientsImpl.setField3(field3);

        if (field4 == Long.MIN_VALUE) {
            patientsImpl.setField4(null);
        } else {
            patientsImpl.setField4(new Date(field4));
        }

        if (field5 == null) {
            patientsImpl.setField5(StringPool.BLANK);
        } else {
            patientsImpl.setField5(field5);
        }

        patientsImpl.resetOriginalValues();

        return patientsImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        fooId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        field1 = objectInput.readUTF();
        field2 = objectInput.readBoolean();
        field3 = objectInput.readInt();
        field4 = objectInput.readLong();
        field5 = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(fooId);
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

        if (field1 == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(field1);
        }

        objectOutput.writeBoolean(field2);
        objectOutput.writeInt(field3);
        objectOutput.writeLong(field4);

        if (field5 == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(field5);
        }
    }
}
