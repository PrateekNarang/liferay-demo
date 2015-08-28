package com.reportssent.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ReportsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ReportsLocalService
 * @generated
 */
public class ReportsLocalServiceWrapper implements ReportsLocalService,
    ServiceWrapper<ReportsLocalService> {
    private ReportsLocalService _reportsLocalService;

    public ReportsLocalServiceWrapper(ReportsLocalService reportsLocalService) {
        _reportsLocalService = reportsLocalService;
    }

    /**
    * Adds the reports to the database. Also notifies the appropriate model listeners.
    *
    * @param reports the reports
    * @return the reports that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.reportssent.plugins.model.Reports addReports(
        com.reportssent.plugins.model.Reports reports)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reportsLocalService.addReports(reports);
    }

    /**
    * Creates a new reports with the primary key. Does not add the reports to the database.
    *
    * @param statusId the primary key for the new reports
    * @return the new reports
    */
    @Override
    public com.reportssent.plugins.model.Reports createReports(long statusId) {
        return _reportsLocalService.createReports(statusId);
    }

    /**
    * Deletes the reports with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param statusId the primary key of the reports
    * @return the reports that was removed
    * @throws PortalException if a reports with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.reportssent.plugins.model.Reports deleteReports(long statusId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _reportsLocalService.deleteReports(statusId);
    }

    /**
    * Deletes the reports from the database. Also notifies the appropriate model listeners.
    *
    * @param reports the reports
    * @return the reports that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.reportssent.plugins.model.Reports deleteReports(
        com.reportssent.plugins.model.Reports reports)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reportsLocalService.deleteReports(reports);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _reportsLocalService.dynamicQuery();
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
        return _reportsLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.reportssent.plugins.model.impl.ReportsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _reportsLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.reportssent.plugins.model.impl.ReportsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _reportsLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _reportsLocalService.dynamicQueryCount(dynamicQuery);
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
        return _reportsLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.reportssent.plugins.model.Reports fetchReports(long statusId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reportsLocalService.fetchReports(statusId);
    }

    /**
    * Returns the reports with the matching UUID and company.
    *
    * @param uuid the reports's UUID
    * @param companyId the primary key of the company
    * @return the matching reports, or <code>null</code> if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.reportssent.plugins.model.Reports fetchReportsByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reportsLocalService.fetchReportsByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the reports matching the UUID and group.
    *
    * @param uuid the reports's UUID
    * @param groupId the primary key of the group
    * @return the matching reports, or <code>null</code> if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.reportssent.plugins.model.Reports fetchReportsByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reportsLocalService.fetchReportsByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns the reports with the primary key.
    *
    * @param statusId the primary key of the reports
    * @return the reports
    * @throws PortalException if a reports with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.reportssent.plugins.model.Reports getReports(long statusId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _reportsLocalService.getReports(statusId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _reportsLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the reports with the matching UUID and company.
    *
    * @param uuid the reports's UUID
    * @param companyId the primary key of the company
    * @return the matching reports
    * @throws PortalException if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.reportssent.plugins.model.Reports getReportsByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _reportsLocalService.getReportsByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the reports matching the UUID and group.
    *
    * @param uuid the reports's UUID
    * @param groupId the primary key of the group
    * @return the matching reports
    * @throws PortalException if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.reportssent.plugins.model.Reports getReportsByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _reportsLocalService.getReportsByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns a range of all the reportses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.reportssent.plugins.model.impl.ReportsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of reportses
    * @param end the upper bound of the range of reportses (not inclusive)
    * @return the range of reportses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.reportssent.plugins.model.Reports> getReportses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reportsLocalService.getReportses(start, end);
    }

    /**
    * Returns the number of reportses.
    *
    * @return the number of reportses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getReportsesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reportsLocalService.getReportsesCount();
    }

    /**
    * Updates the reports in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param reports the reports
    * @return the reports that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.reportssent.plugins.model.Reports updateReports(
        com.reportssent.plugins.model.Reports reports)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reportsLocalService.updateReports(reports);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _reportsLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _reportsLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _reportsLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ReportsLocalService getWrappedReportsLocalService() {
        return _reportsLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedReportsLocalService(
        ReportsLocalService reportsLocalService) {
        _reportsLocalService = reportsLocalService;
    }

    @Override
    public ReportsLocalService getWrappedService() {
        return _reportsLocalService;
    }

    @Override
    public void setWrappedService(ReportsLocalService reportsLocalService) {
        _reportsLocalService = reportsLocalService;
    }
}
