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

import com.reportssent.plugins.NoSuchReportsException;
import com.reportssent.plugins.model.Reports;
import com.reportssent.plugins.model.impl.ReportsImpl;
import com.reportssent.plugins.model.impl.ReportsModelImpl;
import com.reportssent.plugins.service.persistence.ReportsPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the reports service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReportsPersistence
 * @see ReportsUtil
 * @generated
 */
public class ReportsPersistenceImpl extends BasePersistenceImpl<Reports>
    implements ReportsPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ReportsUtil} to access the reports persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ReportsImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ReportsModelImpl.ENTITY_CACHE_ENABLED,
            ReportsModelImpl.FINDER_CACHE_ENABLED, ReportsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ReportsModelImpl.ENTITY_CACHE_ENABLED,
            ReportsModelImpl.FINDER_CACHE_ENABLED, ReportsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ReportsModelImpl.ENTITY_CACHE_ENABLED,
            ReportsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ReportsModelImpl.ENTITY_CACHE_ENABLED,
            ReportsModelImpl.FINDER_CACHE_ENABLED, ReportsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ReportsModelImpl.ENTITY_CACHE_ENABLED,
            ReportsModelImpl.FINDER_CACHE_ENABLED, ReportsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            ReportsModelImpl.UUID_COLUMN_BITMASK |
            ReportsModelImpl.STATUSNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ReportsModelImpl.ENTITY_CACHE_ENABLED,
            ReportsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "reports.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "reports.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(reports.uuid IS NULL OR reports.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ReportsModelImpl.ENTITY_CACHE_ENABLED,
            ReportsModelImpl.FINDER_CACHE_ENABLED, ReportsImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            ReportsModelImpl.UUID_COLUMN_BITMASK |
            ReportsModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ReportsModelImpl.ENTITY_CACHE_ENABLED,
            ReportsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "reports.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "reports.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(reports.uuid IS NULL OR reports.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "reports.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ReportsModelImpl.ENTITY_CACHE_ENABLED,
            ReportsModelImpl.FINDER_CACHE_ENABLED, ReportsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(ReportsModelImpl.ENTITY_CACHE_ENABLED,
            ReportsModelImpl.FINDER_CACHE_ENABLED, ReportsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            ReportsModelImpl.UUID_COLUMN_BITMASK |
            ReportsModelImpl.COMPANYID_COLUMN_BITMASK |
            ReportsModelImpl.STATUSNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ReportsModelImpl.ENTITY_CACHE_ENABLED,
            ReportsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "reports.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "reports.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(reports.uuid IS NULL OR reports.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "reports.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSNAME =
        new FinderPath(ReportsModelImpl.ENTITY_CACHE_ENABLED,
            ReportsModelImpl.FINDER_CACHE_ENABLED, ReportsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusName",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSNAME =
        new FinderPath(ReportsModelImpl.ENTITY_CACHE_ENABLED,
            ReportsModelImpl.FINDER_CACHE_ENABLED, ReportsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatusName",
            new String[] { String.class.getName() },
            ReportsModelImpl.STATUSNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_STATUSNAME = new FinderPath(ReportsModelImpl.ENTITY_CACHE_ENABLED,
            ReportsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatusName",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_STATUSNAME_STATUSNAME_1 = "reports.statusName IS NULL";
    private static final String _FINDER_COLUMN_STATUSNAME_STATUSNAME_2 = "reports.statusName = ?";
    private static final String _FINDER_COLUMN_STATUSNAME_STATUSNAME_3 = "(reports.statusName IS NULL OR reports.statusName = '')";
    private static final String _SQL_SELECT_REPORTS = "SELECT reports FROM Reports reports";
    private static final String _SQL_SELECT_REPORTS_WHERE = "SELECT reports FROM Reports reports WHERE ";
    private static final String _SQL_COUNT_REPORTS = "SELECT COUNT(reports) FROM Reports reports";
    private static final String _SQL_COUNT_REPORTS_WHERE = "SELECT COUNT(reports) FROM Reports reports WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "reports.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Reports exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Reports exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ReportsPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static Reports _nullReports = new ReportsImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Reports> toCacheModel() {
                return _nullReportsCacheModel;
            }
        };

    private static CacheModel<Reports> _nullReportsCacheModel = new CacheModel<Reports>() {
            @Override
            public Reports toEntityModel() {
                return _nullReports;
            }
        };

    public ReportsPersistenceImpl() {
        setModelClass(Reports.class);
    }

    /**
     * Returns all the reportses where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching reportses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Reports> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Reports> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
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
    @Override
    public List<Reports> findByUuid(String uuid, int start, int end,
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

        List<Reports> list = (List<Reports>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Reports reports : list) {
                if (!Validator.equals(uuid, reports.getUuid())) {
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

            query.append(_SQL_SELECT_REPORTS_WHERE);

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
                query.append(ReportsModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Reports>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Reports>(list);
                } else {
                    list = (List<Reports>) QueryUtil.list(q, getDialect(),
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
     * Returns the first reports in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching reports
     * @throws com.reportssent.plugins.NoSuchReportsException if a matching reports could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Reports findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchReportsException, SystemException {
        Reports reports = fetchByUuid_First(uuid, orderByComparator);

        if (reports != null) {
            return reports;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchReportsException(msg.toString());
    }

    /**
     * Returns the first reports in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching reports, or <code>null</code> if a matching reports could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Reports fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Reports> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Reports findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchReportsException, SystemException {
        Reports reports = fetchByUuid_Last(uuid, orderByComparator);

        if (reports != null) {
            return reports;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchReportsException(msg.toString());
    }

    /**
     * Returns the last reports in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching reports, or <code>null</code> if a matching reports could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Reports fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Reports> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Reports[] findByUuid_PrevAndNext(long statusId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchReportsException, SystemException {
        Reports reports = findByPrimaryKey(statusId);

        Session session = null;

        try {
            session = openSession();

            Reports[] array = new ReportsImpl[3];

            array[0] = getByUuid_PrevAndNext(session, reports, uuid,
                    orderByComparator, true);

            array[1] = reports;

            array[2] = getByUuid_PrevAndNext(session, reports, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Reports getByUuid_PrevAndNext(Session session, Reports reports,
        String uuid, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_REPORTS_WHERE);

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
            query.append(ReportsModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(reports);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Reports> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the reportses where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Reports reports : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(reports);
        }
    }

    /**
     * Returns the number of reportses where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching reportses
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

            query.append(_SQL_COUNT_REPORTS_WHERE);

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
     * Returns the reports where uuid = &#63; and groupId = &#63; or throws a {@link com.reportssent.plugins.NoSuchReportsException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching reports
     * @throws com.reportssent.plugins.NoSuchReportsException if a matching reports could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Reports findByUUID_G(String uuid, long groupId)
        throws NoSuchReportsException, SystemException {
        Reports reports = fetchByUUID_G(uuid, groupId);

        if (reports == null) {
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

            throw new NoSuchReportsException(msg.toString());
        }

        return reports;
    }

    /**
     * Returns the reports where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching reports, or <code>null</code> if a matching reports could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Reports fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
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
    @Override
    public Reports fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Reports) {
            Reports reports = (Reports) result;

            if (!Validator.equals(uuid, reports.getUuid()) ||
                    (groupId != reports.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_REPORTS_WHERE);

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

                List<Reports> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Reports reports = list.get(0);

                    result = reports;

                    cacheResult(reports);

                    if ((reports.getUuid() == null) ||
                            !reports.getUuid().equals(uuid) ||
                            (reports.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, reports);
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
            return (Reports) result;
        }
    }

    /**
     * Removes the reports where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the reports that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Reports removeByUUID_G(String uuid, long groupId)
        throws NoSuchReportsException, SystemException {
        Reports reports = findByUUID_G(uuid, groupId);

        return remove(reports);
    }

    /**
     * Returns the number of reportses where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching reportses
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

            query.append(_SQL_COUNT_REPORTS_WHERE);

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
     * Returns all the reportses where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching reportses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Reports> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Reports> findByUuid_C(String uuid, long companyId, int start,
        int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
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
    @Override
    public List<Reports> findByUuid_C(String uuid, long companyId, int start,
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

        List<Reports> list = (List<Reports>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Reports reports : list) {
                if (!Validator.equals(uuid, reports.getUuid()) ||
                        (companyId != reports.getCompanyId())) {
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

            query.append(_SQL_SELECT_REPORTS_WHERE);

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
                query.append(ReportsModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Reports>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Reports>(list);
                } else {
                    list = (List<Reports>) QueryUtil.list(q, getDialect(),
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
     * Returns the first reports in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching reports
     * @throws com.reportssent.plugins.NoSuchReportsException if a matching reports could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Reports findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchReportsException, SystemException {
        Reports reports = fetchByUuid_C_First(uuid, companyId, orderByComparator);

        if (reports != null) {
            return reports;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchReportsException(msg.toString());
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
    @Override
    public Reports fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Reports> list = findByUuid_C(uuid, companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Reports findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchReportsException, SystemException {
        Reports reports = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

        if (reports != null) {
            return reports;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchReportsException(msg.toString());
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
    @Override
    public Reports fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Reports> list = findByUuid_C(uuid, companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Reports[] findByUuid_C_PrevAndNext(long statusId, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchReportsException, SystemException {
        Reports reports = findByPrimaryKey(statusId);

        Session session = null;

        try {
            session = openSession();

            Reports[] array = new ReportsImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, reports, uuid,
                    companyId, orderByComparator, true);

            array[1] = reports;

            array[2] = getByUuid_C_PrevAndNext(session, reports, uuid,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Reports getByUuid_C_PrevAndNext(Session session, Reports reports,
        String uuid, long companyId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_REPORTS_WHERE);

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
            query.append(ReportsModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(reports);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Reports> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the reportses where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Reports reports : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(reports);
        }
    }

    /**
     * Returns the number of reportses where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching reportses
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

            query.append(_SQL_COUNT_REPORTS_WHERE);

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
     * Returns all the reportses where statusName = &#63;.
     *
     * @param statusName the status name
     * @return the matching reportses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Reports> findByStatusName(String statusName)
        throws SystemException {
        return findByStatusName(statusName, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Reports> findByStatusName(String statusName, int start, int end)
        throws SystemException {
        return findByStatusName(statusName, start, end, null);
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
    @Override
    public List<Reports> findByStatusName(String statusName, int start,
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

        List<Reports> list = (List<Reports>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Reports reports : list) {
                if (!Validator.equals(statusName, reports.getStatusName())) {
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

            query.append(_SQL_SELECT_REPORTS_WHERE);

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
                query.append(ReportsModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Reports>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Reports>(list);
                } else {
                    list = (List<Reports>) QueryUtil.list(q, getDialect(),
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
     * Returns the first reports in the ordered set where statusName = &#63;.
     *
     * @param statusName the status name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching reports
     * @throws com.reportssent.plugins.NoSuchReportsException if a matching reports could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Reports findByStatusName_First(String statusName,
        OrderByComparator orderByComparator)
        throws NoSuchReportsException, SystemException {
        Reports reports = fetchByStatusName_First(statusName, orderByComparator);

        if (reports != null) {
            return reports;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("statusName=");
        msg.append(statusName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchReportsException(msg.toString());
    }

    /**
     * Returns the first reports in the ordered set where statusName = &#63;.
     *
     * @param statusName the status name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching reports, or <code>null</code> if a matching reports could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Reports fetchByStatusName_First(String statusName,
        OrderByComparator orderByComparator) throws SystemException {
        List<Reports> list = findByStatusName(statusName, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Reports findByStatusName_Last(String statusName,
        OrderByComparator orderByComparator)
        throws NoSuchReportsException, SystemException {
        Reports reports = fetchByStatusName_Last(statusName, orderByComparator);

        if (reports != null) {
            return reports;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("statusName=");
        msg.append(statusName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchReportsException(msg.toString());
    }

    /**
     * Returns the last reports in the ordered set where statusName = &#63;.
     *
     * @param statusName the status name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching reports, or <code>null</code> if a matching reports could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Reports fetchByStatusName_Last(String statusName,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByStatusName(statusName);

        if (count == 0) {
            return null;
        }

        List<Reports> list = findByStatusName(statusName, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Reports[] findByStatusName_PrevAndNext(long statusId,
        String statusName, OrderByComparator orderByComparator)
        throws NoSuchReportsException, SystemException {
        Reports reports = findByPrimaryKey(statusId);

        Session session = null;

        try {
            session = openSession();

            Reports[] array = new ReportsImpl[3];

            array[0] = getByStatusName_PrevAndNext(session, reports,
                    statusName, orderByComparator, true);

            array[1] = reports;

            array[2] = getByStatusName_PrevAndNext(session, reports,
                    statusName, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Reports getByStatusName_PrevAndNext(Session session,
        Reports reports, String statusName,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_REPORTS_WHERE);

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
            query.append(ReportsModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(reports);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Reports> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the reportses where statusName = &#63; from the database.
     *
     * @param statusName the status name
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByStatusName(String statusName) throws SystemException {
        for (Reports reports : findByStatusName(statusName, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(reports);
        }
    }

    /**
     * Returns the number of reportses where statusName = &#63;.
     *
     * @param statusName the status name
     * @return the number of matching reportses
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

            query.append(_SQL_COUNT_REPORTS_WHERE);

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
     * Caches the reports in the entity cache if it is enabled.
     *
     * @param reports the reports
     */
    @Override
    public void cacheResult(Reports reports) {
        EntityCacheUtil.putResult(ReportsModelImpl.ENTITY_CACHE_ENABLED,
            ReportsImpl.class, reports.getPrimaryKey(), reports);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { reports.getUuid(), reports.getGroupId() }, reports);

        reports.resetOriginalValues();
    }

    /**
     * Caches the reportses in the entity cache if it is enabled.
     *
     * @param reportses the reportses
     */
    @Override
    public void cacheResult(List<Reports> reportses) {
        for (Reports reports : reportses) {
            if (EntityCacheUtil.getResult(
                        ReportsModelImpl.ENTITY_CACHE_ENABLED,
                        ReportsImpl.class, reports.getPrimaryKey()) == null) {
                cacheResult(reports);
            } else {
                reports.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all reportses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ReportsImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ReportsImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the reports.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Reports reports) {
        EntityCacheUtil.removeResult(ReportsModelImpl.ENTITY_CACHE_ENABLED,
            ReportsImpl.class, reports.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(reports);
    }

    @Override
    public void clearCache(List<Reports> reportses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Reports reports : reportses) {
            EntityCacheUtil.removeResult(ReportsModelImpl.ENTITY_CACHE_ENABLED,
                ReportsImpl.class, reports.getPrimaryKey());

            clearUniqueFindersCache(reports);
        }
    }

    protected void cacheUniqueFindersCache(Reports reports) {
        if (reports.isNew()) {
            Object[] args = new Object[] { reports.getUuid(), reports.getGroupId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, reports);
        } else {
            ReportsModelImpl reportsModelImpl = (ReportsModelImpl) reports;

            if ((reportsModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        reports.getUuid(), reports.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    reports);
            }
        }
    }

    protected void clearUniqueFindersCache(Reports reports) {
        ReportsModelImpl reportsModelImpl = (ReportsModelImpl) reports;

        Object[] args = new Object[] { reports.getUuid(), reports.getGroupId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((reportsModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    reportsModelImpl.getOriginalUuid(),
                    reportsModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new reports with the primary key. Does not add the reports to the database.
     *
     * @param statusId the primary key for the new reports
     * @return the new reports
     */
    @Override
    public Reports create(long statusId) {
        Reports reports = new ReportsImpl();

        reports.setNew(true);
        reports.setPrimaryKey(statusId);

        String uuid = PortalUUIDUtil.generate();

        reports.setUuid(uuid);

        return reports;
    }

    /**
     * Removes the reports with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param statusId the primary key of the reports
     * @return the reports that was removed
     * @throws com.reportssent.plugins.NoSuchReportsException if a reports with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Reports remove(long statusId)
        throws NoSuchReportsException, SystemException {
        return remove((Serializable) statusId);
    }

    /**
     * Removes the reports with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the reports
     * @return the reports that was removed
     * @throws com.reportssent.plugins.NoSuchReportsException if a reports with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Reports remove(Serializable primaryKey)
        throws NoSuchReportsException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Reports reports = (Reports) session.get(ReportsImpl.class,
                    primaryKey);

            if (reports == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchReportsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(reports);
        } catch (NoSuchReportsException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Reports removeImpl(Reports reports) throws SystemException {
        reports = toUnwrappedModel(reports);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(reports)) {
                reports = (Reports) session.get(ReportsImpl.class,
                        reports.getPrimaryKeyObj());
            }

            if (reports != null) {
                session.delete(reports);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (reports != null) {
            clearCache(reports);
        }

        return reports;
    }

    @Override
    public Reports updateImpl(com.reportssent.plugins.model.Reports reports)
        throws SystemException {
        reports = toUnwrappedModel(reports);

        boolean isNew = reports.isNew();

        ReportsModelImpl reportsModelImpl = (ReportsModelImpl) reports;

        if (Validator.isNull(reports.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            reports.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (reports.isNew()) {
                session.save(reports);

                reports.setNew(false);
            } else {
                session.merge(reports);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ReportsModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((reportsModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { reportsModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { reportsModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((reportsModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        reportsModelImpl.getOriginalUuid(),
                        reportsModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        reportsModelImpl.getUuid(),
                        reportsModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((reportsModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSNAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        reportsModelImpl.getOriginalStatusName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSNAME,
                    args);

                args = new Object[] { reportsModelImpl.getStatusName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSNAME,
                    args);
            }
        }

        EntityCacheUtil.putResult(ReportsModelImpl.ENTITY_CACHE_ENABLED,
            ReportsImpl.class, reports.getPrimaryKey(), reports);

        clearUniqueFindersCache(reports);
        cacheUniqueFindersCache(reports);

        return reports;
    }

    protected Reports toUnwrappedModel(Reports reports) {
        if (reports instanceof ReportsImpl) {
            return reports;
        }

        ReportsImpl reportsImpl = new ReportsImpl();

        reportsImpl.setNew(reports.isNew());
        reportsImpl.setPrimaryKey(reports.getPrimaryKey());

        reportsImpl.setUuid(reports.getUuid());
        reportsImpl.setStatusId(reports.getStatusId());
        reportsImpl.setGroupId(reports.getGroupId());
        reportsImpl.setCompanyId(reports.getCompanyId());
        reportsImpl.setUserId(reports.getUserId());
        reportsImpl.setUserName(reports.getUserName());
        reportsImpl.setCreateDate(reports.getCreateDate());
        reportsImpl.setModifiedDate(reports.getModifiedDate());
        reportsImpl.setStatusName(reports.getStatusName());
        reportsImpl.setStatusValue(reports.getStatusValue());

        return reportsImpl;
    }

    /**
     * Returns the reports with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the reports
     * @return the reports
     * @throws com.reportssent.plugins.NoSuchReportsException if a reports with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Reports findByPrimaryKey(Serializable primaryKey)
        throws NoSuchReportsException, SystemException {
        Reports reports = fetchByPrimaryKey(primaryKey);

        if (reports == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchReportsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return reports;
    }

    /**
     * Returns the reports with the primary key or throws a {@link com.reportssent.plugins.NoSuchReportsException} if it could not be found.
     *
     * @param statusId the primary key of the reports
     * @return the reports
     * @throws com.reportssent.plugins.NoSuchReportsException if a reports with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Reports findByPrimaryKey(long statusId)
        throws NoSuchReportsException, SystemException {
        return findByPrimaryKey((Serializable) statusId);
    }

    /**
     * Returns the reports with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the reports
     * @return the reports, or <code>null</code> if a reports with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Reports fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Reports reports = (Reports) EntityCacheUtil.getResult(ReportsModelImpl.ENTITY_CACHE_ENABLED,
                ReportsImpl.class, primaryKey);

        if (reports == _nullReports) {
            return null;
        }

        if (reports == null) {
            Session session = null;

            try {
                session = openSession();

                reports = (Reports) session.get(ReportsImpl.class, primaryKey);

                if (reports != null) {
                    cacheResult(reports);
                } else {
                    EntityCacheUtil.putResult(ReportsModelImpl.ENTITY_CACHE_ENABLED,
                        ReportsImpl.class, primaryKey, _nullReports);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ReportsModelImpl.ENTITY_CACHE_ENABLED,
                    ReportsImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return reports;
    }

    /**
     * Returns the reports with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param statusId the primary key of the reports
     * @return the reports, or <code>null</code> if a reports with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Reports fetchByPrimaryKey(long statusId) throws SystemException {
        return fetchByPrimaryKey((Serializable) statusId);
    }

    /**
     * Returns all the reportses.
     *
     * @return the reportses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Reports> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Reports> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Reports> findAll(int start, int end,
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

        List<Reports> list = (List<Reports>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_REPORTS);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_REPORTS;

                if (pagination) {
                    sql = sql.concat(ReportsModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Reports>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Reports>(list);
                } else {
                    list = (List<Reports>) QueryUtil.list(q, getDialect(),
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
     * Removes all the reportses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Reports reports : findAll()) {
            remove(reports);
        }
    }

    /**
     * Returns the number of reportses.
     *
     * @return the number of reportses
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

                Query q = session.createQuery(_SQL_COUNT_REPORTS);

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
     * Initializes the reports persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.reportssent.plugins.model.Reports")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Reports>> listenersList = new ArrayList<ModelListener<Reports>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Reports>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ReportsImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
