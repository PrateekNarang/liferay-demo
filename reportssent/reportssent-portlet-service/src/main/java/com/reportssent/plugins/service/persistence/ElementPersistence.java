package com.reportssent.plugins.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.reportssent.plugins.model.Element;

/**
 * The persistence interface for the element service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElementPersistenceImpl
 * @see ElementUtil
 * @generated
 */
public interface ElementPersistence extends BasePersistence<Element> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ElementUtil} to access the element persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the elements where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching elements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.reportssent.plugins.model.Element> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the elements where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.reportssent.plugins.model.impl.ElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of elements
    * @param end the upper bound of the range of elements (not inclusive)
    * @return the range of matching elements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.reportssent.plugins.model.Element> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the elements where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.reportssent.plugins.model.impl.ElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of elements
    * @param end the upper bound of the range of elements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching elements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.reportssent.plugins.model.Element> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first element in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching element
    * @throws com.reportssent.plugins.NoSuchElementException if a matching element could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchElementException;

    /**
    * Returns the first element in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching element, or <code>null</code> if a matching element could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last element in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching element
    * @throws com.reportssent.plugins.NoSuchElementException if a matching element could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchElementException;

    /**
    * Returns the last element in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching element, or <code>null</code> if a matching element could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the elements before and after the current element in the ordered set where uuid = &#63;.
    *
    * @param statusId the primary key of the current element
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next element
    * @throws com.reportssent.plugins.NoSuchElementException if a element with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element[] findByUuid_PrevAndNext(
        long statusId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchElementException;

    /**
    * Removes all the elements where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of elements where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching elements
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the element where uuid = &#63; and groupId = &#63; or throws a {@link com.reportssent.plugins.NoSuchElementException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching element
    * @throws com.reportssent.plugins.NoSuchElementException if a matching element could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchElementException;

    /**
    * Returns the element where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching element, or <code>null</code> if a matching element could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the element where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching element, or <code>null</code> if a matching element could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the element where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the element that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchElementException;

    /**
    * Returns the number of elements where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching elements
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the elements where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching elements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.reportssent.plugins.model.Element> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the elements where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.reportssent.plugins.model.impl.ElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of elements
    * @param end the upper bound of the range of elements (not inclusive)
    * @return the range of matching elements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.reportssent.plugins.model.Element> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the elements where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.reportssent.plugins.model.impl.ElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of elements
    * @param end the upper bound of the range of elements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching elements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.reportssent.plugins.model.Element> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first element in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching element
    * @throws com.reportssent.plugins.NoSuchElementException if a matching element could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchElementException;

    /**
    * Returns the first element in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching element, or <code>null</code> if a matching element could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last element in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching element
    * @throws com.reportssent.plugins.NoSuchElementException if a matching element could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchElementException;

    /**
    * Returns the last element in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching element, or <code>null</code> if a matching element could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the elements before and after the current element in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param statusId the primary key of the current element
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next element
    * @throws com.reportssent.plugins.NoSuchElementException if a element with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element[] findByUuid_C_PrevAndNext(
        long statusId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchElementException;

    /**
    * Removes all the elements where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of elements where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching elements
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the elements where statusName = &#63;.
    *
    * @param statusName the status name
    * @return the matching elements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.reportssent.plugins.model.Element> findByStatusName(
        java.lang.String statusName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the elements where statusName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.reportssent.plugins.model.impl.ElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param statusName the status name
    * @param start the lower bound of the range of elements
    * @param end the upper bound of the range of elements (not inclusive)
    * @return the range of matching elements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.reportssent.plugins.model.Element> findByStatusName(
        java.lang.String statusName, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the elements where statusName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.reportssent.plugins.model.impl.ElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param statusName the status name
    * @param start the lower bound of the range of elements
    * @param end the upper bound of the range of elements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching elements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.reportssent.plugins.model.Element> findByStatusName(
        java.lang.String statusName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first element in the ordered set where statusName = &#63;.
    *
    * @param statusName the status name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching element
    * @throws com.reportssent.plugins.NoSuchElementException if a matching element could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element findByStatusName_First(
        java.lang.String statusName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchElementException;

    /**
    * Returns the first element in the ordered set where statusName = &#63;.
    *
    * @param statusName the status name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching element, or <code>null</code> if a matching element could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element fetchByStatusName_First(
        java.lang.String statusName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last element in the ordered set where statusName = &#63;.
    *
    * @param statusName the status name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching element
    * @throws com.reportssent.plugins.NoSuchElementException if a matching element could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element findByStatusName_Last(
        java.lang.String statusName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchElementException;

    /**
    * Returns the last element in the ordered set where statusName = &#63;.
    *
    * @param statusName the status name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching element, or <code>null</code> if a matching element could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element fetchByStatusName_Last(
        java.lang.String statusName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the elements before and after the current element in the ordered set where statusName = &#63;.
    *
    * @param statusId the primary key of the current element
    * @param statusName the status name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next element
    * @throws com.reportssent.plugins.NoSuchElementException if a element with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element[] findByStatusName_PrevAndNext(
        long statusId, java.lang.String statusName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchElementException;

    /**
    * Removes all the elements where statusName = &#63; from the database.
    *
    * @param statusName the status name
    * @throws SystemException if a system exception occurred
    */
    public void removeByStatusName(java.lang.String statusName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of elements where statusName = &#63;.
    *
    * @param statusName the status name
    * @return the number of matching elements
    * @throws SystemException if a system exception occurred
    */
    public int countByStatusName(java.lang.String statusName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the element in the entity cache if it is enabled.
    *
    * @param element the element
    */
    public void cacheResult(com.reportssent.plugins.model.Element element);

    /**
    * Caches the elements in the entity cache if it is enabled.
    *
    * @param elements the elements
    */
    public void cacheResult(
        java.util.List<com.reportssent.plugins.model.Element> elements);

    /**
    * Creates a new element with the primary key. Does not add the element to the database.
    *
    * @param statusId the primary key for the new element
    * @return the new element
    */
    public com.reportssent.plugins.model.Element create(long statusId);

    /**
    * Removes the element with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param statusId the primary key of the element
    * @return the element that was removed
    * @throws com.reportssent.plugins.NoSuchElementException if a element with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element remove(long statusId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchElementException;

    public com.reportssent.plugins.model.Element updateImpl(
        com.reportssent.plugins.model.Element element)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the element with the primary key or throws a {@link com.reportssent.plugins.NoSuchElementException} if it could not be found.
    *
    * @param statusId the primary key of the element
    * @return the element
    * @throws com.reportssent.plugins.NoSuchElementException if a element with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element findByPrimaryKey(long statusId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.reportssent.plugins.NoSuchElementException;

    /**
    * Returns the element with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param statusId the primary key of the element
    * @return the element, or <code>null</code> if a element with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.reportssent.plugins.model.Element fetchByPrimaryKey(
        long statusId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the elements.
    *
    * @return the elements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.reportssent.plugins.model.Element> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.reportssent.plugins.model.Element> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the elements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.reportssent.plugins.model.impl.ElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of elements
    * @param end the upper bound of the range of elements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of elements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.reportssent.plugins.model.Element> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the elements from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of elements.
    *
    * @return the number of elements
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
