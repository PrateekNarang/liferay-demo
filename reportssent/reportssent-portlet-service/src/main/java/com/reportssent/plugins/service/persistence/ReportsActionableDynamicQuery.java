package com.reportssent.plugins.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.reportssent.plugins.model.Reports;
import com.reportssent.plugins.service.ReportsLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ReportsActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ReportsActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ReportsLocalServiceUtil.getService());
        setClass(Reports.class);

        setClassLoader(com.reportssent.plugins.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("statusId");
    }
}
