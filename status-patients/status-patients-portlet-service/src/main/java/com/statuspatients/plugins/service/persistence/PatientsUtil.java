package com.statuspatients.plugins.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.statuspatients.plugins.model.Patients;

import java.util.List;

/**
 * The persistence utility for the patients service. This utility wraps {@link PatientsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PatientsPersistence
 * @see PatientsPersistenceImpl
 * @generated
 */
public class PatientsUtil {
    private static PatientsPersistence _persistence;

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
    public static void clearCache(Patients patients) {
        getPersistence().clearCache(patients);
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
    public static List<Patients> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Patients> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Patients> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Patients update(Patients patients) throws SystemException {
        return getPersistence().update(patients);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Patients update(Patients patients,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(patients, serviceContext);
    }

    /**
    * Returns all the patientses where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching patientses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.statuspatients.plugins.model.Patients> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the patientses where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.statuspatients.plugins.model.impl.PatientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of patientses
    * @param end the upper bound of the range of patientses (not inclusive)
    * @return the range of matching patientses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.statuspatients.plugins.model.Patients> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the patientses where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.statuspatients.plugins.model.impl.PatientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of patientses
    * @param end the upper bound of the range of patientses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching patientses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.statuspatients.plugins.model.Patients> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first patients in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching patients
    * @throws com.statuspatients.plugins.NoSuchPatientsException if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first patients in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching patients, or <code>null</code> if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last patients in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching patients
    * @throws com.statuspatients.plugins.NoSuchPatientsException if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last patients in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching patients, or <code>null</code> if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the patientses before and after the current patients in the ordered set where uuid = &#63;.
    *
    * @param fooId the primary key of the current patients
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next patients
    * @throws com.statuspatients.plugins.NoSuchPatientsException if a patients with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients[] findByUuid_PrevAndNext(
        long fooId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException {
        return getPersistence()
                   .findByUuid_PrevAndNext(fooId, uuid, orderByComparator);
    }

    /**
    * Removes all the patientses where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of patientses where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching patientses
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the patients where uuid = &#63; and groupId = &#63; or throws a {@link com.statuspatients.plugins.NoSuchPatientsException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching patients
    * @throws com.statuspatients.plugins.NoSuchPatientsException if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the patients where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching patients, or <code>null</code> if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    /**
    * Returns the patients where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching patients, or <code>null</code> if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the patients where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the patients that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of patientses where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching patientses
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the patientses where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching patientses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.statuspatients.plugins.model.Patients> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
    }

    /**
    * Returns a range of all the patientses where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.statuspatients.plugins.model.impl.PatientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of patientses
    * @param end the upper bound of the range of patientses (not inclusive)
    * @return the range of matching patientses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.statuspatients.plugins.model.Patients> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
    }

    /**
    * Returns an ordered range of all the patientses where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.statuspatients.plugins.model.impl.PatientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of patientses
    * @param end the upper bound of the range of patientses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching patientses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.statuspatients.plugins.model.Patients> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first patients in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching patients
    * @throws com.statuspatients.plugins.NoSuchPatientsException if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the first patients in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching patients, or <code>null</code> if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last patients in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching patients
    * @throws com.statuspatients.plugins.NoSuchPatientsException if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last patients in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching patients, or <code>null</code> if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the patientses before and after the current patients in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param fooId the primary key of the current patients
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next patients
    * @throws com.statuspatients.plugins.NoSuchPatientsException if a patients with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients[] findByUuid_C_PrevAndNext(
        long fooId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(fooId, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the patientses where uuid = &#63; and companyId = &#63; from the database.
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
    * Returns the number of patientses where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching patientses
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

    /**
    * Returns all the patientses where field2 = &#63;.
    *
    * @param field2 the field2
    * @return the matching patientses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.statuspatients.plugins.model.Patients> findByField2(
        boolean field2)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByField2(field2);
    }

    /**
    * Returns a range of all the patientses where field2 = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.statuspatients.plugins.model.impl.PatientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param field2 the field2
    * @param start the lower bound of the range of patientses
    * @param end the upper bound of the range of patientses (not inclusive)
    * @return the range of matching patientses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.statuspatients.plugins.model.Patients> findByField2(
        boolean field2, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByField2(field2, start, end);
    }

    /**
    * Returns an ordered range of all the patientses where field2 = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.statuspatients.plugins.model.impl.PatientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param field2 the field2
    * @param start the lower bound of the range of patientses
    * @param end the upper bound of the range of patientses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching patientses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.statuspatients.plugins.model.Patients> findByField2(
        boolean field2, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByField2(field2, start, end, orderByComparator);
    }

    /**
    * Returns the first patients in the ordered set where field2 = &#63;.
    *
    * @param field2 the field2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching patients
    * @throws com.statuspatients.plugins.NoSuchPatientsException if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients findByField2_First(
        boolean field2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException {
        return getPersistence().findByField2_First(field2, orderByComparator);
    }

    /**
    * Returns the first patients in the ordered set where field2 = &#63;.
    *
    * @param field2 the field2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching patients, or <code>null</code> if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients fetchByField2_First(
        boolean field2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByField2_First(field2, orderByComparator);
    }

    /**
    * Returns the last patients in the ordered set where field2 = &#63;.
    *
    * @param field2 the field2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching patients
    * @throws com.statuspatients.plugins.NoSuchPatientsException if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients findByField2_Last(
        boolean field2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException {
        return getPersistence().findByField2_Last(field2, orderByComparator);
    }

    /**
    * Returns the last patients in the ordered set where field2 = &#63;.
    *
    * @param field2 the field2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching patients, or <code>null</code> if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients fetchByField2_Last(
        boolean field2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByField2_Last(field2, orderByComparator);
    }

    /**
    * Returns the patientses before and after the current patients in the ordered set where field2 = &#63;.
    *
    * @param fooId the primary key of the current patients
    * @param field2 the field2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next patients
    * @throws com.statuspatients.plugins.NoSuchPatientsException if a patients with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients[] findByField2_PrevAndNext(
        long fooId, boolean field2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException {
        return getPersistence()
                   .findByField2_PrevAndNext(fooId, field2, orderByComparator);
    }

    /**
    * Removes all the patientses where field2 = &#63; from the database.
    *
    * @param field2 the field2
    * @throws SystemException if a system exception occurred
    */
    public static void removeByField2(boolean field2)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByField2(field2);
    }

    /**
    * Returns the number of patientses where field2 = &#63;.
    *
    * @param field2 the field2
    * @return the number of matching patientses
    * @throws SystemException if a system exception occurred
    */
    public static int countByField2(boolean field2)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByField2(field2);
    }

    /**
    * Caches the patients in the entity cache if it is enabled.
    *
    * @param patients the patients
    */
    public static void cacheResult(
        com.statuspatients.plugins.model.Patients patients) {
        getPersistence().cacheResult(patients);
    }

    /**
    * Caches the patientses in the entity cache if it is enabled.
    *
    * @param patientses the patientses
    */
    public static void cacheResult(
        java.util.List<com.statuspatients.plugins.model.Patients> patientses) {
        getPersistence().cacheResult(patientses);
    }

    /**
    * Creates a new patients with the primary key. Does not add the patients to the database.
    *
    * @param fooId the primary key for the new patients
    * @return the new patients
    */
    public static com.statuspatients.plugins.model.Patients create(long fooId) {
        return getPersistence().create(fooId);
    }

    /**
    * Removes the patients with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param fooId the primary key of the patients
    * @return the patients that was removed
    * @throws com.statuspatients.plugins.NoSuchPatientsException if a patients with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients remove(long fooId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException {
        return getPersistence().remove(fooId);
    }

    public static com.statuspatients.plugins.model.Patients updateImpl(
        com.statuspatients.plugins.model.Patients patients)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(patients);
    }

    /**
    * Returns the patients with the primary key or throws a {@link com.statuspatients.plugins.NoSuchPatientsException} if it could not be found.
    *
    * @param fooId the primary key of the patients
    * @return the patients
    * @throws com.statuspatients.plugins.NoSuchPatientsException if a patients with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients findByPrimaryKey(
        long fooId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException {
        return getPersistence().findByPrimaryKey(fooId);
    }

    /**
    * Returns the patients with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param fooId the primary key of the patients
    * @return the patients, or <code>null</code> if a patients with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.statuspatients.plugins.model.Patients fetchByPrimaryKey(
        long fooId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(fooId);
    }

    /**
    * Returns all the patientses.
    *
    * @return the patientses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.statuspatients.plugins.model.Patients> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the patientses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.statuspatients.plugins.model.impl.PatientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of patientses
    * @param end the upper bound of the range of patientses (not inclusive)
    * @return the range of patientses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.statuspatients.plugins.model.Patients> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the patientses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.statuspatients.plugins.model.impl.PatientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of patientses
    * @param end the upper bound of the range of patientses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of patientses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.statuspatients.plugins.model.Patients> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the patientses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of patientses.
    *
    * @return the number of patientses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static PatientsPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (PatientsPersistence) PortletBeanLocatorUtil.locate(com.statuspatients.plugins.service.ClpSerializer.getServletContextName(),
                    PatientsPersistence.class.getName());

            ReferenceRegistry.registerReference(PatientsUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(PatientsPersistence persistence) {
    }
}
