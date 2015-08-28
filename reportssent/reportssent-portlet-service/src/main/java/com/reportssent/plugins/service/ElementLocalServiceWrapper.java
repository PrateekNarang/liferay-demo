package com.reportssent.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ElementLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ElementLocalService
 * @generated
 */
public class ElementLocalServiceWrapper implements ElementLocalService,
    ServiceWrapper<ElementLocalService> {
    private ElementLocalService _elementLocalService;

    public ElementLocalServiceWrapper(ElementLocalService elementLocalService) {
        _elementLocalService = elementLocalService;
    }

    /**
    * Adds the element to the database. Also notifies the appropriate model listeners.
    *
    * @param element the element
    * @return the element that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.reportssent.plugins.model.Element addElement(
        com.reportssent.plugins.model.Element element)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _elementLocalService.addElement(element);
    }

    /**
    * Creates a new element with the primary key. Does not add the element to the database.
    *
    * @param statusId the primary key for the new element
    * @return the new element
    */
    @Override
    public com.reportssent.plugins.model.Element createElement(long statusId) {
        return _elementLocalService.createElement(statusId);
    }

    /**
    * Deletes the element with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param statusId the primary key of the element
    * @return the element that was removed
    * @throws PortalException if a element with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.reportssent.plugins.model.Element deleteElement(long statusId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _elementLocalService.deleteElement(statusId);
    }

    /**
    * Deletes the element from the database. Also notifies the appropriate model listeners.
    *
    * @param element the element
    * @return the element that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.reportssent.plugins.model.Element deleteElement(
        com.reportssent.plugins.model.Element element)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _elementLocalService.deleteElement(element);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _elementLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _elementLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.reportssent.plugins.model.impl.ElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _elementLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.reportssent.plugins.model.impl.ElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _elementLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _elementLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _elementLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.reportssent.plugins.model.Element fetchElement(long statusId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _elementLocalService.fetchElement(statusId);
    }

    /**
    * Returns the element with the matching UUID and company.
    *
    * @param uuid the element's UUID
    * @param companyId the primary key of the company
    * @return the matching element, or <code>null</code> if a matching element could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.reportssent.plugins.model.Element fetchElementByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _elementLocalService.fetchElementByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the element matching the UUID and group.
    *
    * @param uuid the element's UUID
    * @param groupId the primary key of the group
    * @return the matching element, or <code>null</code> if a matching element could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.reportssent.plugins.model.Element fetchElementByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _elementLocalService.fetchElementByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns the element with the primary key.
    *
    * @param statusId the primary key of the element
    * @return the element
    * @throws PortalException if a element with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.reportssent.plugins.model.Element getElement(long statusId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _elementLocalService.getElement(statusId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _elementLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the element with the matching UUID and company.
    *
    * @param uuid the element's UUID
    * @param companyId the primary key of the company
    * @return the matching element
    * @throws PortalException if a matching element could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.reportssent.plugins.model.Element getElementByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _elementLocalService.getElementByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the element matching the UUID and group.
    *
    * @param uuid the element's UUID
    * @param groupId the primary key of the group
    * @return the matching element
    * @throws PortalException if a matching element could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.reportssent.plugins.model.Element getElementByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _elementLocalService.getElementByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns a range of all the elements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.reportssent.plugins.model.impl.ElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of elements
    * @param end the upper bound of the range of elements (not inclusive)
    * @return the range of elements
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.reportssent.plugins.model.Element> getElements(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _elementLocalService.getElements(start, end);
    }

    /**
    * Returns the number of elements.
    *
    * @return the number of elements
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getElementsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _elementLocalService.getElementsCount();
    }

    /**
    * Updates the element in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param element the element
    * @return the element that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.reportssent.plugins.model.Element updateElement(
        com.reportssent.plugins.model.Element element)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _elementLocalService.updateElement(element);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _elementLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _elementLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _elementLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ElementLocalService getWrappedElementLocalService() {
        return _elementLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedElementLocalService(
        ElementLocalService elementLocalService) {
        _elementLocalService = elementLocalService;
    }

    @Override
    public ElementLocalService getWrappedService() {
        return _elementLocalService;
    }

    @Override
    public void setWrappedService(ElementLocalService elementLocalService) {
        _elementLocalService = elementLocalService;
    }
}
