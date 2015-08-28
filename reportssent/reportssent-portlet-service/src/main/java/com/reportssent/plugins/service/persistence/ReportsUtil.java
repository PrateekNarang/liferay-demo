package com.reportssent.plugins.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.reportssent.plugins.model.Reports;

import java.util.List;

/**
 * The persistence utility for the reports service. This utility wraps {@link ReportsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReportsPersistence
 * @see ReportsPersistenceImpl
 * @generated
 */
public class ReportsUtil {
    private static ReportsPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Reports reports) {
        getPersistence().clearCache(reports);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Reports> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Reports> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Reports> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Reports update(Reports reports) throws SystemException {
        return getPersistence().update(reports);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Reports update(Reports reports, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(reports, serviceContext);
    }

    /**
    * Returns all the reportses where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching reportses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.reportssent.plugins.model.Reports> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the reportses where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.reportssent.plugins.model.impl.ReportsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of reportses
    * @param end the upper bound of the range of reportses (not inclusive)
    * @return the range of matching reportses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.reportssent.plugins.model.Reports> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the reportses where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.reportssent.plugins.model.impl.ReportsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of reportses
    * @param end the upper bound of the range of reportses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching reportses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.reportssent.plugins.model.Reports> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first reports in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching reports
    * @throws com.reportssent.plugins.NoSuchReportsException if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchReportsException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first reports in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching reports, or <code>null</code> if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last reports in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching reports
    * @throws com.reportssent.plugins.NoSuchReportsException if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchReportsException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last reports in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching reports, or <code>null</code> if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the reportses before and after the current reports in the ordered set where uuid = &#63;.
    *
    * @param statusId the primary key of the current reports
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next reports
    * @throws com.reportssent.plugins.NoSuchReportsException if a reports with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports[] findByUuid_PrevAndNext(
        long statusId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchReportsException {
        return getPersistence()
                   .findByUuid_PrevAndNext(statusId, uuid, orderByComparator);
    }

    /**
    * Removes all the reportses where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of reportses where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching reportses
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the reports where uuid = &#63; and groupId = &#63; or throws a {@link com.reportssent.plugins.NoSuchReportsException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching reports
    * @throws com.reportssent.plugins.NoSuchReportsException if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchReportsException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the reports where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching reports, or <code>null</code> if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    /**
    * Returns the reports where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching reports, or <code>null</code> if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the reports where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the reports that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchReportsException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of reportses where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching reportses
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the reportses where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching reportses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.reportssent.plugins.model.Reports> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
    }

    /**
    * Returns a range of all the reportses where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.reportssent.plugins.model.impl.ReportsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of reportses
    * @param end the upper bound of the range of reportses (not inclusive)
    * @return the range of matching reportses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.reportssent.plugins.model.Reports> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
    }

    /**
    * Returns an ordered range of all the reportses where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.reportssent.plugins.model.impl.ReportsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of reportses
    * @param end the upper bound of the range of reportses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching reportses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.reportssent.plugins.model.Reports> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first reports in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching reports
    * @throws com.reportssent.plugins.NoSuchReportsException if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchReportsException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the first reports in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching reports, or <code>null</code> if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last reports in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching reports
    * @throws com.reportssent.plugins.NoSuchReportsException if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchReportsException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last reports in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching reports, or <code>null</code> if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the reportses before and after the current reports in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param statusId the primary key of the current reports
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next reports
    * @throws com.reportssent.plugins.NoSuchReportsException if a reports with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports[] findByUuid_C_PrevAndNext(
        long statusId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchReportsException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(statusId, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the reportses where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid_C(uuid, companyId);
    }

    /**
    * Returns the number of reportses where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching reportses
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

    /**
    * Returns all the reportses where statusName = &#63;.
    *
    * @param statusName the status name
    * @return the matching reportses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.reportssent.plugins.model.Reports> findByStatusName(
        java.lang.String statusName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByStatusName(statusName);
    }

    /**
    * Returns a range of all the reportses where statusName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.reportssent.plugins.model.impl.ReportsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param statusName the status name
    * @param start the lower bound of the range of reportses
    * @param end the upper bound of the range of reportses (not inclusive)
    * @return the range of matching reportses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.reportssent.plugins.model.Reports> findByStatusName(
        java.lang.String statusName, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByStatusName(statusName, start, end);
    }

    /**
    * Returns an ordered range of all the reportses where statusName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.reportssent.plugins.model.impl.ReportsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param statusName the status name
    * @param start the lower bound of the range of reportses
    * @param end the upper bound of the range of reportses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching reportses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.reportssent.plugins.model.Reports> findByStatusName(
        java.lang.String statusName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByStatusName(statusName, start, end, orderByComparator);
    }

    /**
    * Returns the first reports in the ordered set where statusName = &#63;.
    *
    * @param statusName the status name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching reports
    * @throws com.reportssent.plugins.NoSuchReportsException if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports findByStatusName_First(
        java.lang.String statusName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchReportsException {
        return getPersistence()
                   .findByStatusName_First(statusName, orderByComparator);
    }

    /**
    * Returns the first reports in the ordered set where statusName = &#63;.
    *
    * @param statusName the status name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching reports, or <code>null</code> if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports fetchByStatusName_First(
        java.lang.String statusName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByStatusName_First(statusName, orderByComparator);
    }

    /**
    * Returns the last reports in the ordered set where statusName = &#63;.
    *
    * @param statusName the status name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching reports
    * @throws com.reportssent.plugins.NoSuchReportsException if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports findByStatusName_Last(
        java.lang.String statusName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchReportsException {
        return getPersistence()
                   .findByStatusName_Last(statusName, orderByComparator);
    }

    /**
    * Returns the last reports in the ordered set where statusName = &#63;.
    *
    * @param statusName the status name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching reports, or <code>null</code> if a matching reports could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports fetchByStatusName_Last(
        java.lang.String statusName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByStatusName_Last(statusName, orderByComparator);
    }

    /**
    * Returns the reportses before and after the current reports in the ordered set where statusName = &#63;.
    *
    * @param statusId the primary key of the current reports
    * @param statusName the status name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next reports
    * @throws com.reportssent.plugins.NoSuchReportsException if a reports with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports[] findByStatusName_PrevAndNext(
        long statusId, java.lang.String statusName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchReportsException {
        return getPersistence()
                   .findByStatusName_PrevAndNext(statusId, statusName,
            orderByComparator);
    }

    /**
    * Removes all the reportses where statusName = &#63; from the database.
    *
    * @param statusName the status name
    * @throws SystemException if a system exception occurred
    */
    public static void removeByStatusName(java.lang.String statusName)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByStatusName(statusName);
    }

    /**
    * Returns the number of reportses where statusName = &#63;.
    *
    * @param statusName the status name
    * @return the number of matching reportses
    * @throws SystemException if a system exception occurred
    */
    public static int countByStatusName(java.lang.String statusName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByStatusName(statusName);
    }

    /**
    * Caches the reports in the entity cache if it is enabled.
    *
    * @param reports the reports
    */
    public static void cacheResult(
        com.reportssent.plugins.model.Reports reports) {
        getPersistence().cacheResult(reports);
    }

    /**
    * Caches the reportses in the entity cache if it is enabled.
    *
    * @param reportses the reportses
    */
    public static void cacheResult(
        java.util.List<com.reportssent.plugins.model.Reports> reportses) {
        getPersistence().cacheResult(reportses);
    }

    /**
    * Creates a new reports with the primary key. Does not add the reports to the database.
    *
    * @param statusId the primary key for the new reports
    * @return the new reports
    */
    public static com.reportssent.plugins.model.Reports create(long statusId) {
        return getPersistence().create(statusId);
    }

    /**
    * Removes the reports with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param statusId the primary key of the reports
    * @return the reports that was removed
    * @throws com.reportssent.plugins.NoSuchReportsException if a reports with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports remove(long statusId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchReportsException {
        return getPersistence().remove(statusId);
    }

    public static com.reportssent.plugins.model.Reports updateImpl(
        com.reportssent.plugins.model.Reports reports)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(reports);
    }

    /**
    * Returns the reports with the primary key or throws a {@link com.reportssent.plugins.NoSuchReportsException} if it could not be found.
    *
    * @param statusId the primary key of the reports
    * @return the reports
    * @throws com.reportssent.plugins.NoSuchReportsException if a reports with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports findByPrimaryKey(
        long statusId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchReportsException {
        return getPersistence().findByPrimaryKey(statusId);
    }

    /**
    * Returns the reports with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param statusId the primary key of the reports
    * @return the reports, or <code>null</code> if a reports with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.reportssent.plugins.model.Reports fetchByPrimaryKey(
        long statusId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(statusId);
    }

    /**
    * Returns all the reportses.
    *
    * @return the reportses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.reportssent.plugins.model.Reports> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.reportssent.plugins.model.Reports> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the reportses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.reportssent.plugins.model.impl.ReportsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of reportses
    * @param end the upper bound of the range of reportses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of reportses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.reportssent.plugins.model.Reports> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the reportses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of reportses.
    *
    * @return the number of reportses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ReportsPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ReportsPersistence) PortletBeanLocatorUtil.locate(com.reportssent.plugins.service.ClpSerializer.getServletContextName(),
                    ReportsPersistence.class.getName());

            ReferenceRegistry.registerReference(ReportsUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ReportsPersistence persistence) {
    }
}
