package com.statuspatients.plugins.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.statuspatients.plugins.model.Patients;

/**
 * The persistence interface for the patients service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PatientsPersistenceImpl
 * @see PatientsUtil
 * @generated
 */
public interface PatientsPersistence extends BasePersistence<Patients> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link PatientsUtil} to access the patients persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the patientses where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching patientses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.statuspatients.plugins.model.Patients> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.statuspatients.plugins.model.Patients> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.statuspatients.plugins.model.Patients> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first patients in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching patients
    * @throws com.statuspatients.plugins.NoSuchPatientsException if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.statuspatients.plugins.model.Patients findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException;

    /**
    * Returns the first patients in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching patients, or <code>null</code> if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.statuspatients.plugins.model.Patients fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last patients in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching patients
    * @throws com.statuspatients.plugins.NoSuchPatientsException if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.statuspatients.plugins.model.Patients findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException;

    /**
    * Returns the last patients in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching patients, or <code>null</code> if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.statuspatients.plugins.model.Patients fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.statuspatients.plugins.model.Patients[] findByUuid_PrevAndNext(
        long fooId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException;

    /**
    * Removes all the patientses where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of patientses where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching patientses
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the patients where uuid = &#63; and groupId = &#63; or throws a {@link com.statuspatients.plugins.NoSuchPatientsException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching patients
    * @throws com.statuspatients.plugins.NoSuchPatientsException if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.statuspatients.plugins.model.Patients findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException;

    /**
    * Returns the patients where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching patients, or <code>null</code> if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.statuspatients.plugins.model.Patients fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the patients where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching patients, or <code>null</code> if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.statuspatients.plugins.model.Patients fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the patients where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the patients that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.statuspatients.plugins.model.Patients removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException;

    /**
    * Returns the number of patientses where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching patientses
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the patientses where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching patientses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.statuspatients.plugins.model.Patients> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.statuspatients.plugins.model.Patients> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.statuspatients.plugins.model.Patients> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.statuspatients.plugins.model.Patients findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException;

    /**
    * Returns the first patients in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching patients, or <code>null</code> if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.statuspatients.plugins.model.Patients fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.statuspatients.plugins.model.Patients findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException;

    /**
    * Returns the last patients in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching patients, or <code>null</code> if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.statuspatients.plugins.model.Patients fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.statuspatients.plugins.model.Patients[] findByUuid_C_PrevAndNext(
        long fooId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException;

    /**
    * Removes all the patientses where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of patientses where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching patientses
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the patientses where field2 = &#63;.
    *
    * @param field2 the field2
    * @return the matching patientses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.statuspatients.plugins.model.Patients> findByField2(
        boolean field2)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.statuspatients.plugins.model.Patients> findByField2(
        boolean field2, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.statuspatients.plugins.model.Patients> findByField2(
        boolean field2, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first patients in the ordered set where field2 = &#63;.
    *
    * @param field2 the field2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching patients
    * @throws com.statuspatients.plugins.NoSuchPatientsException if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.statuspatients.plugins.model.Patients findByField2_First(
        boolean field2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException;

    /**
    * Returns the first patients in the ordered set where field2 = &#63;.
    *
    * @param field2 the field2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching patients, or <code>null</code> if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.statuspatients.plugins.model.Patients fetchByField2_First(
        boolean field2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last patients in the ordered set where field2 = &#63;.
    *
    * @param field2 the field2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching patients
    * @throws com.statuspatients.plugins.NoSuchPatientsException if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.statuspatients.plugins.model.Patients findByField2_Last(
        boolean field2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException;

    /**
    * Returns the last patients in the ordered set where field2 = &#63;.
    *
    * @param field2 the field2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching patients, or <code>null</code> if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.statuspatients.plugins.model.Patients fetchByField2_Last(
        boolean field2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.statuspatients.plugins.model.Patients[] findByField2_PrevAndNext(
        long fooId, boolean field2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException;

    /**
    * Removes all the patientses where field2 = &#63; from the database.
    *
    * @param field2 the field2
    * @throws SystemException if a system exception occurred
    */
    public void removeByField2(boolean field2)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of patientses where field2 = &#63;.
    *
    * @param field2 the field2
    * @return the number of matching patientses
    * @throws SystemException if a system exception occurred
    */
    public int countByField2(boolean field2)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the patients in the entity cache if it is enabled.
    *
    * @param patients the patients
    */
    public void cacheResult(com.statuspatients.plugins.model.Patients patients);

    /**
    * Caches the patientses in the entity cache if it is enabled.
    *
    * @param patientses the patientses
    */
    public void cacheResult(
        java.util.List<com.statuspatients.plugins.model.Patients> patientses);

    /**
    * Creates a new patients with the primary key. Does not add the patients to the database.
    *
    * @param fooId the primary key for the new patients
    * @return the new patients
    */
    public com.statuspatients.plugins.model.Patients create(long fooId);

    /**
    * Removes the patients with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param fooId the primary key of the patients
    * @return the patients that was removed
    * @throws com.statuspatients.plugins.NoSuchPatientsException if a patients with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.statuspatients.plugins.model.Patients remove(long fooId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException;

    public com.statuspatients.plugins.model.Patients updateImpl(
        com.statuspatients.plugins.model.Patients patients)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the patients with the primary key or throws a {@link com.statuspatients.plugins.NoSuchPatientsException} if it could not be found.
    *
    * @param fooId the primary key of the patients
    * @return the patients
    * @throws com.statuspatients.plugins.NoSuchPatientsException if a patients with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.statuspatients.plugins.model.Patients findByPrimaryKey(
        long fooId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.statuspatients.plugins.NoSuchPatientsException;

    /**
    * Returns the patients with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param fooId the primary key of the patients
    * @return the patients, or <code>null</code> if a patients with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.statuspatients.plugins.model.Patients fetchByPrimaryKey(
        long fooId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the patientses.
    *
    * @return the patientses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.statuspatients.plugins.model.Patients> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.statuspatients.plugins.model.Patients> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.statuspatients.plugins.model.Patients> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the patientses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of patientses.
    *
    * @return the number of patientses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
