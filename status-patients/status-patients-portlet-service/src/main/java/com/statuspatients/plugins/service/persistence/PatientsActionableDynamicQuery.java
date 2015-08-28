package com.statuspatients.plugins.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.statuspatients.plugins.model.Patients;
import com.statuspatients.plugins.service.PatientsLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class PatientsActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public PatientsActionableDynamicQuery() throws SystemException {
        setBaseLocalService(PatientsLocalServiceUtil.getService());
        setClass(Patients.class);

        setClassLoader(com.statuspatients.plugins.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("fooId");
    }
}
