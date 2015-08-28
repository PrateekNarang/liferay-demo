package com.reportssent.plugins.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.reportssent.plugins.NoSuchElementException;
import com.reportssent.plugins.model.Element;
import com.reportssent.plugins.model.impl.ElementImpl;
import com.reportssent.plugins.model.impl.ElementModelImpl;
import com.reportssent.plugins.service.persistence.ElementPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the element service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElementPersistence
 * @see ElementUtil
 * @generated
 */
public class ElementPersistenceImpl extends BasePersistenceImpl<Element>
    implements ElementPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ElementUtil} to access the element persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ElementImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ElementModelImpl.ENTITY_CACHE_ENABLED,
            ElementModelImpl.FINDER_CACHE_ENABLED, ElementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ElementModelImpl.ENTITY_CACHE_ENABLED,
            ElementModelImpl.FINDER_CACHE_ENABLED, ElementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ElementModelImpl.ENTITY_CACHE_ENABLED,
            ElementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ElementModelImpl.ENTITY_CACHE_ENABLED,
            ElementModelImpl.FINDER_CACHE_ENABLED, ElementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ElementModelImpl.ENTITY_CACHE_ENABLED,
            ElementModelImpl.FINDER_CACHE_ENABLED, ElementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            ElementModelImpl.UUID_COLUMN_BITMASK |
            ElementModelImpl.STATUSNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ElementModelImpl.ENTITY_CACHE_ENABLED,
            ElementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "element.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "element.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(element.uuid IS NULL OR element.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ElementModelImpl.ENTITY_CACHE_ENABLED,
            ElementModelImpl.FINDER_CACHE_ENABLED, ElementImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            ElementModelImpl.UUID_COLUMN_BITMASK |
            ElementModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ElementModelImpl.ENTITY_CACHE_ENABLED,
            ElementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "element.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "element.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(element.uuid IS NULL OR element.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "element.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ElementModelImpl.ENTITY_CACHE_ENABLED,
            ElementModelImpl.FINDER_CACHE_ENABLED, ElementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(ElementModelImpl.ENTITY_CACHE_ENABLED,
            ElementModelImpl.FINDER_CACHE_ENABLED, ElementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            ElementModelImpl.UUID_COLUMN_BITMASK |
            ElementModelImpl.COMPANYID_COLUMN_BITMASK |
            ElementModelImpl.STATUSNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ElementModelImpl.ENTITY_CACHE_ENABLED,
            ElementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "element.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "element.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(element.uuid IS NULL OR element.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "element.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSNAME =
        new FinderPath(ElementModelImpl.ENTITY_CACHE_ENABLED,
            ElementModelImpl.FINDER_CACHE_ENABLED, ElementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusName",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSNAME =
        new FinderPath(ElementModelImpl.ENTITY_CACHE_ENABLED,
            ElementModelImpl.FINDER_CACHE_ENABLED, ElementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatusName",
            new String[] { String.class.getName() },
            ElementModelImpl.STATUSNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_STATUSNAME = new FinderPath(ElementModelImpl.ENTITY_CACHE_ENABLED,
            ElementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatusName",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_STATUSNAME_STATUSNAME_1 = "element.statusName IS NULL";
    private static final String _FINDER_COLUMN_STATUSNAME_STATUSNAME_2 = "element.statusName = ?";
    private static final String _FINDER_COLUMN_STATUSNAME_STATUSNAME_3 = "(element.statusName IS NULL OR element.statusName = '')";
    private static final String _SQL_SELECT_ELEMENT = "SELECT element FROM Element element";
    private static final String _SQL_SELECT_ELEMENT_WHERE = "SELECT element FROM Element element WHERE ";
    private static final String _SQL_COUNT_ELEMENT = "SELECT COUNT(element) FROM Element element";
    private static final String _SQL_COUNT_ELEMENT_WHERE = "SELECT COUNT(element) FROM Element element WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "element.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Element exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Element exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ElementPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static Element _nullElement = new ElementImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Element> toCacheModel() {
                return _nullElementCacheModel;
            }
        };

    private static CacheModel<Element> _nullElementCacheModel = new CacheModel<Element>() {
            @Override
            public Element toEntityModel() {
                return _nullElement;
            }
        };

    public ElementPersistenceImpl() {
        setModelClass(Element.class);
    }

    /**
     * Returns all the elements where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching elements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Element> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Element> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

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
    @Override
    public List<Element> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<Element> list = (List<Element>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Element element : list) {
                if (!Validator.equals(uuid, element.getUuid())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_ELEMENT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ElementModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                if (!pagination) {
                    list = (List<Element>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Element>(list);
                } else {
                    list = (List<Element>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first element in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching element
     * @throws com.reportssent.plugins.NoSuchElementException if a matching element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchElementException, SystemException {
        Element element = fetchByUuid_First(uuid, orderByComparator);

        if (element != null) {
            return element;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchElementException(msg.toString());
    }

    /**
     * Returns the first element in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching element, or <code>null</code> if a matching element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Element> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last element in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching element
     * @throws com.reportssent.plugins.NoSuchElementException if a matching element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchElementException, SystemException {
        Element element = fetchByUuid_Last(uuid, orderByComparator);

        if (element != null) {
            return element;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchElementException(msg.toString());
    }

    /**
     * Returns the last element in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching element, or <code>null</code> if a matching element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Element> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Element[] findByUuid_PrevAndNext(long statusId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchElementException, SystemException {
        Element element = findByPrimaryKey(statusId);

        Session session = null;

        try {
            session = openSession();

            Element[] array = new ElementImpl[3];

            array[0] = getByUuid_PrevAndNext(session, element, uuid,
                    orderByComparator, true);

            array[1] = element;

            array[2] = getByUuid_PrevAndNext(session, element, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Element getByUuid_PrevAndNext(Session session, Element element,
        String uuid, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ELEMENT_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_UUID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(ElementModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(element);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Element> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the elements where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Element element : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(element);
        }
    }

    /**
     * Returns the number of elements where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching elements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid(String uuid) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_ELEMENT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the element where uuid = &#63; and groupId = &#63; or throws a {@link com.reportssent.plugins.NoSuchElementException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching element
     * @throws com.reportssent.plugins.NoSuchElementException if a matching element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element findByUUID_G(String uuid, long groupId)
        throws NoSuchElementException, SystemException {
        Element element = fetchByUUID_G(uuid, groupId);

        if (element == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchElementException(msg.toString());
        }

        return element;
    }

    /**
     * Returns the element where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching element, or <code>null</code> if a matching element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the element where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching element, or <code>null</code> if a matching element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Element) {
            Element element = (Element) result;

            if (!Validator.equals(uuid, element.getUuid()) ||
                    (groupId != element.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_ELEMENT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                List<Element> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Element element = list.get(0);

                    result = element;

                    cacheResult(element);

                    if ((element.getUuid() == null) ||
                            !element.getUuid().equals(uuid) ||
                            (element.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, element);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Element) result;
        }
    }

    /**
     * Removes the element where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the element that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element removeByUUID_G(String uuid, long groupId)
        throws NoSuchElementException, SystemException {
        Element element = findByUUID_G(uuid, groupId);

        return remove(element);
    }

    /**
     * Returns the number of elements where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching elements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUUID_G(String uuid, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

        Object[] finderArgs = new Object[] { uuid, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_ELEMENT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the elements where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching elements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Element> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Element> findByUuid_C(String uuid, long companyId, int start,
        int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

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
    @Override
    public List<Element> findByUuid_C(String uuid, long companyId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] { uuid, companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] {
                    uuid, companyId,
                    
                    start, end, orderByComparator
                };
        }

        List<Element> list = (List<Element>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Element element : list) {
                if (!Validator.equals(uuid, element.getUuid()) ||
                        (companyId != element.getCompanyId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_ELEMENT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ElementModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<Element>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Element>(list);
                } else {
                    list = (List<Element>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

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
    @Override
    public Element findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchElementException, SystemException {
        Element element = fetchByUuid_C_First(uuid, companyId, orderByComparator);

        if (element != null) {
            return element;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchElementException(msg.toString());
    }

    /**
     * Returns the first element in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching element, or <code>null</code> if a matching element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Element> list = findByUuid_C(uuid, companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Element findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchElementException, SystemException {
        Element element = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

        if (element != null) {
            return element;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchElementException(msg.toString());
    }

    /**
     * Returns the last element in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching element, or <code>null</code> if a matching element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Element> list = findByUuid_C(uuid, companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Element[] findByUuid_C_PrevAndNext(long statusId, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchElementException, SystemException {
        Element element = findByPrimaryKey(statusId);

        Session session = null;

        try {
            session = openSession();

            Element[] array = new ElementImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, element, uuid,
                    companyId, orderByComparator, true);

            array[1] = element;

            array[2] = getByUuid_C_PrevAndNext(session, element, uuid,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Element getByUuid_C_PrevAndNext(Session session, Element element,
        String uuid, long companyId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ELEMENT_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_C_UUID_2);
        }

        query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(ElementModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(element);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Element> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the elements where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Element element : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(element);
        }
    }

    /**
     * Returns the number of elements where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching elements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid_C(String uuid, long companyId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

        Object[] finderArgs = new Object[] { uuid, companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_ELEMENT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the elements where statusName = &#63;.
     *
     * @param statusName the status name
     * @return the matching elements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Element> findByStatusName(String statusName)
        throws SystemException {
        return findByStatusName(statusName, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Element> findByStatusName(String statusName, int start, int end)
        throws SystemException {
        return findByStatusName(statusName, start, end, null);
    }

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
    @Override
    public List<Element> findByStatusName(String statusName, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSNAME;
            finderArgs = new Object[] { statusName };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSNAME;
            finderArgs = new Object[] { statusName, start, end, orderByComparator };
        }

        List<Element> list = (List<Element>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Element element : list) {
                if (!Validator.equals(statusName, element.getStatusName())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_ELEMENT_WHERE);

            boolean bindStatusName = false;

            if (statusName == null) {
                query.append(_FINDER_COLUMN_STATUSNAME_STATUSNAME_1);
            } else if (statusName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_STATUSNAME_STATUSNAME_3);
            } else {
                bindStatusName = true;

                query.append(_FINDER_COLUMN_STATUSNAME_STATUSNAME_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ElementModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindStatusName) {
                    qPos.add(statusName);
                }

                if (!pagination) {
                    list = (List<Element>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Element>(list);
                } else {
                    list = (List<Element>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first element in the ordered set where statusName = &#63;.
     *
     * @param statusName the status name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching element
     * @throws com.reportssent.plugins.NoSuchElementException if a matching element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element findByStatusName_First(String statusName,
        OrderByComparator orderByComparator)
        throws NoSuchElementException, SystemException {
        Element element = fetchByStatusName_First(statusName, orderByComparator);

        if (element != null) {
            return element;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("statusName=");
        msg.append(statusName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchElementException(msg.toString());
    }

    /**
     * Returns the first element in the ordered set where statusName = &#63;.
     *
     * @param statusName the status name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching element, or <code>null</code> if a matching element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element fetchByStatusName_First(String statusName,
        OrderByComparator orderByComparator) throws SystemException {
        List<Element> list = findByStatusName(statusName, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last element in the ordered set where statusName = &#63;.
     *
     * @param statusName the status name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching element
     * @throws com.reportssent.plugins.NoSuchElementException if a matching element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element findByStatusName_Last(String statusName,
        OrderByComparator orderByComparator)
        throws NoSuchElementException, SystemException {
        Element element = fetchByStatusName_Last(statusName, orderByComparator);

        if (element != null) {
            return element;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("statusName=");
        msg.append(statusName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchElementException(msg.toString());
    }

    /**
     * Returns the last element in the ordered set where statusName = &#63;.
     *
     * @param statusName the status name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching element, or <code>null</code> if a matching element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element fetchByStatusName_Last(String statusName,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByStatusName(statusName);

        if (count == 0) {
            return null;
        }

        List<Element> list = findByStatusName(statusName, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Element[] findByStatusName_PrevAndNext(long statusId,
        String statusName, OrderByComparator orderByComparator)
        throws NoSuchElementException, SystemException {
        Element element = findByPrimaryKey(statusId);

        Session session = null;

        try {
            session = openSession();

            Element[] array = new ElementImpl[3];

            array[0] = getByStatusName_PrevAndNext(session, element,
                    statusName, orderByComparator, true);

            array[1] = element;

            array[2] = getByStatusName_PrevAndNext(session, element,
                    statusName, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Element getByStatusName_PrevAndNext(Session session,
        Element element, String statusName,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ELEMENT_WHERE);

        boolean bindStatusName = false;

        if (statusName == null) {
            query.append(_FINDER_COLUMN_STATUSNAME_STATUSNAME_1);
        } else if (statusName.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_STATUSNAME_STATUSNAME_3);
        } else {
            bindStatusName = true;

            query.append(_FINDER_COLUMN_STATUSNAME_STATUSNAME_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(ElementModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindStatusName) {
            qPos.add(statusName);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(element);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Element> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the elements where statusName = &#63; from the database.
     *
     * @param statusName the status name
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByStatusName(String statusName) throws SystemException {
        for (Element element : findByStatusName(statusName, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(element);
        }
    }

    /**
     * Returns the number of elements where statusName = &#63;.
     *
     * @param statusName the status name
     * @return the number of matching elements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByStatusName(String statusName) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUSNAME;

        Object[] finderArgs = new Object[] { statusName };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_ELEMENT_WHERE);

            boolean bindStatusName = false;

            if (statusName == null) {
                query.append(_FINDER_COLUMN_STATUSNAME_STATUSNAME_1);
            } else if (statusName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_STATUSNAME_STATUSNAME_3);
            } else {
                bindStatusName = true;

                query.append(_FINDER_COLUMN_STATUSNAME_STATUSNAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindStatusName) {
                    qPos.add(statusName);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the element in the entity cache if it is enabled.
     *
     * @param element the element
     */
    @Override
    public void cacheResult(Element element) {
        EntityCacheUtil.putResult(ElementModelImpl.ENTITY_CACHE_ENABLED,
            ElementImpl.class, element.getPrimaryKey(), element);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { element.getUuid(), element.getGroupId() }, element);

        element.resetOriginalValues();
    }

    /**
     * Caches the elements in the entity cache if it is enabled.
     *
     * @param elements the elements
     */
    @Override
    public void cacheResult(List<Element> elements) {
        for (Element element : elements) {
            if (EntityCacheUtil.getResult(
                        ElementModelImpl.ENTITY_CACHE_ENABLED,
                        ElementImpl.class, element.getPrimaryKey()) == null) {
                cacheResult(element);
            } else {
                element.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all elements.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ElementImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ElementImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the element.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Element element) {
        EntityCacheUtil.removeResult(ElementModelImpl.ENTITY_CACHE_ENABLED,
            ElementImpl.class, element.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(element);
    }

    @Override
    public void clearCache(List<Element> elements) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Element element : elements) {
            EntityCacheUtil.removeResult(ElementModelImpl.ENTITY_CACHE_ENABLED,
                ElementImpl.class, element.getPrimaryKey());

            clearUniqueFindersCache(element);
        }
    }

    protected void cacheUniqueFindersCache(Element element) {
        if (element.isNew()) {
            Object[] args = new Object[] { element.getUuid(), element.getGroupId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, element);
        } else {
            ElementModelImpl elementModelImpl = (ElementModelImpl) element;

            if ((elementModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        element.getUuid(), element.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    element);
            }
        }
    }

    protected void clearUniqueFindersCache(Element element) {
        ElementModelImpl elementModelImpl = (ElementModelImpl) element;

        Object[] args = new Object[] { element.getUuid(), element.getGroupId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((elementModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    elementModelImpl.getOriginalUuid(),
                    elementModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new element with the primary key. Does not add the element to the database.
     *
     * @param statusId the primary key for the new element
     * @return the new element
     */
    @Override
    public Element create(long statusId) {
        Element element = new ElementImpl();

        element.setNew(true);
        element.setPrimaryKey(statusId);

        String uuid = PortalUUIDUtil.generate();

        element.setUuid(uuid);

        return element;
    }

    /**
     * Removes the element with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param statusId the primary key of the element
     * @return the element that was removed
     * @throws com.reportssent.plugins.NoSuchElementException if a element with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element remove(long statusId)
        throws NoSuchElementException, SystemException {
        return remove((Serializable) statusId);
    }

    /**
     * Removes the element with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the element
     * @return the element that was removed
     * @throws com.reportssent.plugins.NoSuchElementException if a element with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element remove(Serializable primaryKey)
        throws NoSuchElementException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Element element = (Element) session.get(ElementImpl.class,
                    primaryKey);

            if (element == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchElementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(element);
        } catch (NoSuchElementException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Element removeImpl(Element element) throws SystemException {
        element = toUnwrappedModel(element);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(element)) {
                element = (Element) session.get(ElementImpl.class,
                        element.getPrimaryKeyObj());
            }

            if (element != null) {
                session.delete(element);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (element != null) {
            clearCache(element);
        }

        return element;
    }

    @Override
    public Element updateImpl(com.reportssent.plugins.model.Element element)
        throws SystemException {
        element = toUnwrappedModel(element);

        boolean isNew = element.isNew();

        ElementModelImpl elementModelImpl = (ElementModelImpl) element;

        if (Validator.isNull(element.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            element.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (element.isNew()) {
                session.save(element);

                element.setNew(false);
            } else {
                session.merge(element);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ElementModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((elementModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { elementModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { elementModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((elementModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        elementModelImpl.getOriginalUuid(),
                        elementModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        elementModelImpl.getUuid(),
                        elementModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((elementModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSNAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        elementModelImpl.getOriginalStatusName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSNAME,
                    args);

                args = new Object[] { elementModelImpl.getStatusName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSNAME,
                    args);
            }
        }

        EntityCacheUtil.putResult(ElementModelImpl.ENTITY_CACHE_ENABLED,
            ElementImpl.class, element.getPrimaryKey(), element);

        clearUniqueFindersCache(element);
        cacheUniqueFindersCache(element);

        return element;
    }

    protected Element toUnwrappedModel(Element element) {
        if (element instanceof ElementImpl) {
            return element;
        }

        ElementImpl elementImpl = new ElementImpl();

        elementImpl.setNew(element.isNew());
        elementImpl.setPrimaryKey(element.getPrimaryKey());

        elementImpl.setUuid(element.getUuid());
        elementImpl.setStatusId(element.getStatusId());
        elementImpl.setGroupId(element.getGroupId());
        elementImpl.setCompanyId(element.getCompanyId());
        elementImpl.setUserId(element.getUserId());
        elementImpl.setUserName(element.getUserName());
        elementImpl.setCreateDate(element.getCreateDate());
        elementImpl.setModifiedDate(element.getModifiedDate());
        elementImpl.setStatusName(element.getStatusName());
        elementImpl.setStatusValue(element.getStatusValue());

        return elementImpl;
    }

    /**
     * Returns the element with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the element
     * @return the element
     * @throws com.reportssent.plugins.NoSuchElementException if a element with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element findByPrimaryKey(Serializable primaryKey)
        throws NoSuchElementException, SystemException {
        Element element = fetchByPrimaryKey(primaryKey);

        if (element == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchElementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return element;
    }

    /**
     * Returns the element with the primary key or throws a {@link com.reportssent.plugins.NoSuchElementException} if it could not be found.
     *
     * @param statusId the primary key of the element
     * @return the element
     * @throws com.reportssent.plugins.NoSuchElementException if a element with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element findByPrimaryKey(long statusId)
        throws NoSuchElementException, SystemException {
        return findByPrimaryKey((Serializable) statusId);
    }

    /**
     * Returns the element with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the element
     * @return the element, or <code>null</code> if a element with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Element element = (Element) EntityCacheUtil.getResult(ElementModelImpl.ENTITY_CACHE_ENABLED,
                ElementImpl.class, primaryKey);

        if (element == _nullElement) {
            return null;
        }

        if (element == null) {
            Session session = null;

            try {
                session = openSession();

                element = (Element) session.get(ElementImpl.class, primaryKey);

                if (element != null) {
                    cacheResult(element);
                } else {
                    EntityCacheUtil.putResult(ElementModelImpl.ENTITY_CACHE_ENABLED,
                        ElementImpl.class, primaryKey, _nullElement);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ElementModelImpl.ENTITY_CACHE_ENABLED,
                    ElementImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return element;
    }

    /**
     * Returns the element with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param statusId the primary key of the element
     * @return the element, or <code>null</code> if a element with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element fetchByPrimaryKey(long statusId) throws SystemException {
        return fetchByPrimaryKey((Serializable) statusId);
    }

    /**
     * Returns all the elements.
     *
     * @return the elements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Element> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Element> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<Element> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Element> list = (List<Element>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_ELEMENT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_ELEMENT;

                if (pagination) {
                    sql = sql.concat(ElementModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Element>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Element>(list);
                } else {
                    list = (List<Element>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the elements from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Element element : findAll()) {
            remove(element);
        }
    }

    /**
     * Returns the number of elements.
     *
     * @return the number of elements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_ELEMENT);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the element persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.reportssent.plugins.model.Element")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Element>> listenersList = new ArrayList<ModelListener<Element>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Element>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ElementImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
