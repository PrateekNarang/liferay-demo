package com.reportssent.plugins.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Reports. This utility wraps
 * {@link com.reportssent.plugins.service.impl.ReportsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ReportsLocalService
 * @see com.reportssent.plugins.service.base.ReportsLocalServiceBaseImpl
 * @see com.reportssent.plugins.service.impl.ReportsLocalServiceImpl
 * @generated
 */
public class ReportsLocalServiceUtil {
    private static ReportsLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.reportssent.plugins.service.impl.ReportsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the reports to the database. Also notifies the appropriate model listeners.
    *
    * @param reports the reports
    * @return the reports that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports addReports(
        com.reportssent.plugins.model.Reports reports)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addReports(reports);
    }

    /**
    * Creates a new reports with the primary key. Does not add the reports to the database.
    *
    * @param statusId the primary key for the new reports
    * @return the new reports
    */
    public static com.reportssent.plugins.model.Reports createReports(
        long statusId) {
        return getService().createReports(statusId);
    }

    /**
    * Deletes the reports with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param statusId the primary key of the reports
    * @return the reports that was removed
    * @throws PortalException if a reports with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports deleteReports(
        long statusId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteReports(statusId);
    }

    /**
    * Deletes the reports from the database. Also notifies the appropriate model listeners.
    *
    * @param reports the reports
    * @return the reports that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports deleteReports(
        com.reportssent.plugins.model.Reports reports)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteReports(reports);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.reportssent.plugins.model.Reports fetchReports(
        long statusId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchReports(statusId);
    }

    /**
    * Returns the reports with the matching UUID and company.
    *
    * @param uuid the reports's UUID
    * @param companyId the primary key of the company
    * @return the matching reports, or <code>null</code> if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports fetchReportsByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchReportsByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the reports matching the UUID and group.
    *
    * @param uuid the reports's UUID
    * @param groupId the primary key of the group
    * @return the matching reports, or <code>null</code> if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports fetchReportsByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchReportsByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns the reports with the primary key.
    *
    * @param statusId the primary key of the reports
    * @return the reports
    * @throws PortalException if a reports with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports getReports(
        long statusId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getReports(statusId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static com.reportssent.plugins.model.Reports getReportsByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getReportsByUuidAndCompanyId(uuid, companyId);
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
    public static com.reportssent.plugins.model.Reports getReportsByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getReportsByUuidAndGroupId(uuid, groupId);
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
    public static java.util.List<com.reportssent.plugins.model.Reports> getReportses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getReportses(start, end);
    }

    /**
    * Returns the number of reportses.
    *
    * @return the number of reportses
    * @throws SystemException if a system exception occurred
    */
    public static int getReportsesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getReportsesCount();
    }

    /**
    * Updates the reports in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param reports the reports
    * @return the reports that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports updateReports(
        com.reportssent.plugins.model.Reports reports)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateReports(reports);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static void clearService() {
        _service = null;
    }

    public static ReportsLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ReportsLocalService.class.getName());

            if (invokableLocalService instanceof ReportsLocalService) {
                _service = (ReportsLocalService) invokableLocalService;
            } else {
                _service = new ReportsLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ReportsLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ReportsLocalService service) {
    }
}
