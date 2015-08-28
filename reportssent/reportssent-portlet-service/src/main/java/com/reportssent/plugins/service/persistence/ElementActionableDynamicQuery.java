package com.reportssent.plugins.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.reportssent.plugins.model.Element;
import com.reportssent.plugins.service.ElementLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ElementActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ElementActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ElementLocalServiceUtil.getService());
        setClass(Element.class);

        setClassLoader(com.reportssent.plugins.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("statusId");
    }
}
