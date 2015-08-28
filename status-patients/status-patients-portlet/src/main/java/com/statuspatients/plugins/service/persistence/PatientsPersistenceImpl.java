package com.statuspatients.plugins.service.persistence;

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

import com.statuspatients.plugins.NoSuchPatientsException;
import com.statuspatients.plugins.model.Patients;
import com.statuspatients.plugins.model.impl.PatientsImpl;
import com.statuspatients.plugins.model.impl.PatientsModelImpl;
import com.statuspatients.plugins.service.persistence.PatientsPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the patients service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PatientsPersistence
 * @see PatientsUtil
 * @generated
 */
public class PatientsPersistenceImpl extends BasePersistenceImpl<Patients>
    implements PatientsPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link PatientsUtil} to access the patients persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = PatientsImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PatientsModelImpl.ENTITY_CACHE_ENABLED,
            PatientsModelImpl.FINDER_CACHE_ENABLED, PatientsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PatientsModelImpl.ENTITY_CACHE_ENABLED,
            PatientsModelImpl.FINDER_CACHE_ENABLED, PatientsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PatientsModelImpl.ENTITY_CACHE_ENABLED,
            PatientsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PatientsModelImpl.ENTITY_CACHE_ENABLED,
            PatientsModelImpl.FINDER_CACHE_ENABLED, PatientsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PatientsModelImpl.ENTITY_CACHE_ENABLED,
            PatientsModelImpl.FINDER_CACHE_ENABLED, PatientsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            PatientsModelImpl.UUID_COLUMN_BITMASK |
            PatientsModelImpl.FIELD1_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PatientsModelImpl.ENTITY_CACHE_ENABLED,
            PatientsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "patients.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "patients.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(patients.uuid IS NULL OR patients.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(PatientsModelImpl.ENTITY_CACHE_ENABLED,
            PatientsModelImpl.FINDER_CACHE_ENABLED, PatientsImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            PatientsModelImpl.UUID_COLUMN_BITMASK |
            PatientsModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(PatientsModelImpl.ENTITY_CACHE_ENABLED,
            PatientsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "patients.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "patients.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(patients.uuid IS NULL OR patients.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "patients.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(PatientsModelImpl.ENTITY_CACHE_ENABLED,
            PatientsModelImpl.FINDER_CACHE_ENABLED, PatientsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(PatientsModelImpl.ENTITY_CACHE_ENABLED,
            PatientsModelImpl.FINDER_CACHE_ENABLED, PatientsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            PatientsModelImpl.UUID_COLUMN_BITMASK |
            PatientsModelImpl.COMPANYID_COLUMN_BITMASK |
            PatientsModelImpl.FIELD1_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(PatientsModelImpl.ENTITY_CACHE_ENABLED,
            PatientsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "patients.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "patients.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(patients.uuid IS NULL OR patients.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "patients.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FIELD2 = new FinderPath(PatientsModelImpl.ENTITY_CACHE_ENABLED,
            PatientsModelImpl.FINDER_CACHE_ENABLED, PatientsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByField2",
            new String[] {
                Boolean.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2 =
        new FinderPath(PatientsModelImpl.ENTITY_CACHE_ENABLED,
            PatientsModelImpl.FINDER_CACHE_ENABLED, PatientsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByField2",
            new String[] { Boolean.class.getName() },
            PatientsModelImpl.FIELD2_COLUMN_BITMASK |
            PatientsModelImpl.FIELD1_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_FIELD2 = new FinderPath(PatientsModelImpl.ENTITY_CACHE_ENABLED,
            PatientsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByField2",
            new String[] { Boolean.class.getName() });
    private static final String _FINDER_COLUMN_FIELD2_FIELD2_2 = "patients.field2 = ?";
    private static final String _SQL_SELECT_PATIENTS = "SELECT patients FROM Patients patients";
    private static final String _SQL_SELECT_PATIENTS_WHERE = "SELECT patients FROM Patients patients WHERE ";
    private static final String _SQL_COUNT_PATIENTS = "SELECT COUNT(patients) FROM Patients patients";
    private static final String _SQL_COUNT_PATIENTS_WHERE = "SELECT COUNT(patients) FROM Patients patients WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "patients.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Patients exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Patients exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(PatientsPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static Patients _nullPatients = new PatientsImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Patients> toCacheModel() {
                return _nullPatientsCacheModel;
            }
        };

    private static CacheModel<Patients> _nullPatientsCacheModel = new CacheModel<Patients>() {
            @Override
            public Patients toEntityModel() {
                return _nullPatients;
            }
        };

    public PatientsPersistenceImpl() {
        setModelClass(Patients.class);
    }

    /**
     * Returns all the patientses where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching patientses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Patients> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Patients> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
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
    @Override
    public List<Patients> findByUuid(String uuid, int start, int end,
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

        List<Patients> list = (List<Patients>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Patients patients : list) {
                if (!Validator.equals(uuid, patients.getUuid())) {
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

            query.append(_SQL_SELECT_PATIENTS_WHERE);

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
                query.append(PatientsModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Patients>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Patients>(list);
                } else {
                    list = (List<Patients>) QueryUtil.list(q, getDialect(),
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
     * Returns the first patients in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching patients
     * @throws com.statuspatients.plugins.NoSuchPatientsException if a matching patients could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Patients findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchPatientsException, SystemException {
        Patients patients = fetchByUuid_First(uuid, orderByComparator);

        if (patients != null) {
            return patients;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPatientsException(msg.toString());
    }

    /**
     * Returns the first patients in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching patients, or <code>null</code> if a matching patients could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Patients fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Patients> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Patients findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchPatientsException, SystemException {
        Patients patients = fetchByUuid_Last(uuid, orderByComparator);

        if (patients != null) {
            return patients;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPatientsException(msg.toString());
    }

    /**
     * Returns the last patients in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching patients, or <code>null</code> if a matching patients could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Patients fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Patients> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Patients[] findByUuid_PrevAndNext(long fooId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchPatientsException, SystemException {
        Patients patients = findByPrimaryKey(fooId);

        Session session = null;

        try {
            session = openSession();

            Patients[] array = new PatientsImpl[3];

            array[0] = getByUuid_PrevAndNext(session, patients, uuid,
                    orderByComparator, true);

            array[1] = patients;

            array[2] = getByUuid_PrevAndNext(session, patients, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Patients getByUuid_PrevAndNext(Session session,
        Patients patients, String uuid, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PATIENTS_WHERE);

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
            query.append(PatientsModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(patients);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Patients> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the patientses where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Patients patients : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(patients);
        }
    }

    /**
     * Returns the number of patientses where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching patientses
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

            query.append(_SQL_COUNT_PATIENTS_WHERE);

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
     * Returns the patients where uuid = &#63; and groupId = &#63; or throws a {@link com.statuspatients.plugins.NoSuchPatientsException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching patients
     * @throws com.statuspatients.plugins.NoSuchPatientsException if a matching patients could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Patients findByUUID_G(String uuid, long groupId)
        throws NoSuchPatientsException, SystemException {
        Patients patients = fetchByUUID_G(uuid, groupId);

        if (patients == null) {
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

            throw new NoSuchPatientsException(msg.toString());
        }

        return patients;
    }

    /**
     * Returns the patients where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching patients, or <code>null</code> if a matching patients could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Patients fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
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
    @Override
    public Patients fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Patients) {
            Patients patients = (Patients) result;

            if (!Validator.equals(uuid, patients.getUuid()) ||
                    (groupId != patients.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_PATIENTS_WHERE);

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

                List<Patients> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Patients patients = list.get(0);

                    result = patients;

                    cacheResult(patients);

                    if ((patients.getUuid() == null) ||
                            !patients.getUuid().equals(uuid) ||
                            (patients.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, patients);
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
            return (Patients) result;
        }
    }

    /**
     * Removes the patients where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the patients that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Patients removeByUUID_G(String uuid, long groupId)
        throws NoSuchPatientsException, SystemException {
        Patients patients = findByUUID_G(uuid, groupId);

        return remove(patients);
    }

    /**
     * Returns the number of patientses where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching patientses
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

            query.append(_SQL_COUNT_PATIENTS_WHERE);

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
     * Returns all the patientses where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching patientses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Patients> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Patients> findByUuid_C(String uuid, long companyId, int start,
        int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
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
    @Override
    public List<Patients> findByUuid_C(String uuid, long companyId, int start,
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

        List<Patients> list = (List<Patients>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Patients patients : list) {
                if (!Validator.equals(uuid, patients.getUuid()) ||
                        (companyId != patients.getCompanyId())) {
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

            query.append(_SQL_SELECT_PATIENTS_WHERE);

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
                query.append(PatientsModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Patients>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Patients>(list);
                } else {
                    list = (List<Patients>) QueryUtil.list(q, getDialect(),
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
     * Returns the first patients in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching patients
     * @throws com.statuspatients.plugins.NoSuchPatientsException if a matching patients could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Patients findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchPatientsException, SystemException {
        Patients patients = fetchByUuid_C_First(uuid, companyId,
                orderByComparator);

        if (patients != null) {
            return patients;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPatientsException(msg.toString());
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
    @Override
    public Patients fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Patients> list = findByUuid_C(uuid, companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Patients findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchPatientsException, SystemException {
        Patients patients = fetchByUuid_C_Last(uuid, companyId,
                orderByComparator);

        if (patients != null) {
            return patients;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPatientsException(msg.toString());
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
    @Override
    public Patients fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Patients> list = findByUuid_C(uuid, companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Patients[] findByUuid_C_PrevAndNext(long fooId, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchPatientsException, SystemException {
        Patients patients = findByPrimaryKey(fooId);

        Session session = null;

        try {
            session = openSession();

            Patients[] array = new PatientsImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, patients, uuid,
                    companyId, orderByComparator, true);

            array[1] = patients;

            array[2] = getByUuid_C_PrevAndNext(session, patients, uuid,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Patients getByUuid_C_PrevAndNext(Session session,
        Patients patients, String uuid, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PATIENTS_WHERE);

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
            query.append(PatientsModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(patients);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Patients> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the patientses where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Patients patients : findByUuid_C(uuid, companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(patients);
        }
    }

    /**
     * Returns the number of patientses where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching patientses
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

            query.append(_SQL_COUNT_PATIENTS_WHERE);

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
     * Returns all the patientses where field2 = &#63;.
     *
     * @param field2 the field2
     * @return the matching patientses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Patients> findByField2(boolean field2)
        throws SystemException {
        return findByField2(field2, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Patients> findByField2(boolean field2, int start, int end)
        throws SystemException {
        return findByField2(field2, start, end, null);
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
    @Override
    public List<Patients> findByField2(boolean field2, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2;
            finderArgs = new Object[] { field2 };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FIELD2;
            finderArgs = new Object[] { field2, start, end, orderByComparator };
        }

        List<Patients> list = (List<Patients>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Patients patients : list) {
                if ((field2 != patients.getField2())) {
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

            query.append(_SQL_SELECT_PATIENTS_WHERE);

            query.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PatientsModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(field2);

                if (!pagination) {
                    list = (List<Patients>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Patients>(list);
                } else {
                    list = (List<Patients>) QueryUtil.list(q, getDialect(),
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
     * Returns the first patients in the ordered set where field2 = &#63;.
     *
     * @param field2 the field2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching patients
     * @throws com.statuspatients.plugins.NoSuchPatientsException if a matching patients could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Patients findByField2_First(boolean field2,
        OrderByComparator orderByComparator)
        throws NoSuchPatientsException, SystemException {
        Patients patients = fetchByField2_First(field2, orderByComparator);

        if (patients != null) {
            return patients;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("field2=");
        msg.append(field2);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPatientsException(msg.toString());
    }

    /**
     * Returns the first patients in the ordered set where field2 = &#63;.
     *
     * @param field2 the field2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching patients, or <code>null</code> if a matching patients could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Patients fetchByField2_First(boolean field2,
        OrderByComparator orderByComparator) throws SystemException {
        List<Patients> list = findByField2(field2, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Patients findByField2_Last(boolean field2,
        OrderByComparator orderByComparator)
        throws NoSuchPatientsException, SystemException {
        Patients patients = fetchByField2_Last(field2, orderByComparator);

        if (patients != null) {
            return patients;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("field2=");
        msg.append(field2);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPatientsException(msg.toString());
    }

    /**
     * Returns the last patients in the ordered set where field2 = &#63;.
     *
     * @param field2 the field2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching patients, or <code>null</code> if a matching patients could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Patients fetchByField2_Last(boolean field2,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByField2(field2);

        if (count == 0) {
            return null;
        }

        List<Patients> list = findByField2(field2, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Patients[] findByField2_PrevAndNext(long fooId, boolean field2,
        OrderByComparator orderByComparator)
        throws NoSuchPatientsException, SystemException {
        Patients patients = findByPrimaryKey(fooId);

        Session session = null;

        try {
            session = openSession();

            Patients[] array = new PatientsImpl[3];

            array[0] = getByField2_PrevAndNext(session, patients, field2,
                    orderByComparator, true);

            array[1] = patients;

            array[2] = getByField2_PrevAndNext(session, patients, field2,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Patients getByField2_PrevAndNext(Session session,
        Patients patients, boolean field2, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PATIENTS_WHERE);

        query.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

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
            query.append(PatientsModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(field2);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(patients);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Patients> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the patientses where field2 = &#63; from the database.
     *
     * @param field2 the field2
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByField2(boolean field2) throws SystemException {
        for (Patients patients : findByField2(field2, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(patients);
        }
    }

    /**
     * Returns the number of patientses where field2 = &#63;.
     *
     * @param field2 the field2
     * @return the number of matching patientses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByField2(boolean field2) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_FIELD2;

        Object[] finderArgs = new Object[] { field2 };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PATIENTS_WHERE);

            query.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(field2);

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
     * Caches the patients in the entity cache if it is enabled.
     *
     * @param patients the patients
     */
    @Override
    public void cacheResult(Patients patients) {
        EntityCacheUtil.putResult(PatientsModelImpl.ENTITY_CACHE_ENABLED,
            PatientsImpl.class, patients.getPrimaryKey(), patients);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { patients.getUuid(), patients.getGroupId() }, patients);

        patients.resetOriginalValues();
    }

    /**
     * Caches the patientses in the entity cache if it is enabled.
     *
     * @param patientses the patientses
     */
    @Override
    public void cacheResult(List<Patients> patientses) {
        for (Patients patients : patientses) {
            if (EntityCacheUtil.getResult(
                        PatientsModelImpl.ENTITY_CACHE_ENABLED,
                        PatientsImpl.class, patients.getPrimaryKey()) == null) {
                cacheResult(patients);
            } else {
                patients.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all patientses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(PatientsImpl.class.getName());
        }

        EntityCacheUtil.clearCache(PatientsImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the patients.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Patients patients) {
        EntityCacheUtil.removeResult(PatientsModelImpl.ENTITY_CACHE_ENABLED,
            PatientsImpl.class, patients.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(patients);
    }

    @Override
    public void clearCache(List<Patients> patientses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Patients patients : patientses) {
            EntityCacheUtil.removeResult(PatientsModelImpl.ENTITY_CACHE_ENABLED,
                PatientsImpl.class, patients.getPrimaryKey());

            clearUniqueFindersCache(patients);
        }
    }

    protected void cacheUniqueFindersCache(Patients patients) {
        if (patients.isNew()) {
            Object[] args = new Object[] {
                    patients.getUuid(), patients.getGroupId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                patients);
        } else {
            PatientsModelImpl patientsModelImpl = (PatientsModelImpl) patients;

            if ((patientsModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        patients.getUuid(), patients.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    patients);
            }
        }
    }

    protected void clearUniqueFindersCache(Patients patients) {
        PatientsModelImpl patientsModelImpl = (PatientsModelImpl) patients;

        Object[] args = new Object[] { patients.getUuid(), patients.getGroupId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((patientsModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    patientsModelImpl.getOriginalUuid(),
                    patientsModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new patients with the primary key. Does not add the patients to the database.
     *
     * @param fooId the primary key for the new patients
     * @return the new patients
     */
    @Override
    public Patients create(long fooId) {
        Patients patients = new PatientsImpl();

        patients.setNew(true);
        patients.setPrimaryKey(fooId);

        String uuid = PortalUUIDUtil.generate();

        patients.setUuid(uuid);

        return patients;
    }

    /**
     * Removes the patients with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param fooId the primary key of the patients
     * @return the patients that was removed
     * @throws com.statuspatients.plugins.NoSuchPatientsException if a patients with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Patients remove(long fooId)
        throws NoSuchPatientsException, SystemException {
        return remove((Serializable) fooId);
    }

    /**
     * Removes the patients with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the patients
     * @return the patients that was removed
     * @throws com.statuspatients.plugins.NoSuchPatientsException if a patients with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Patients remove(Serializable primaryKey)
        throws NoSuchPatientsException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Patients patients = (Patients) session.get(PatientsImpl.class,
                    primaryKey);

            if (patients == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchPatientsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(patients);
        } catch (NoSuchPatientsException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Patients removeImpl(Patients patients) throws SystemException {
        patients = toUnwrappedModel(patients);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(patients)) {
                patients = (Patients) session.get(PatientsImpl.class,
                        patients.getPrimaryKeyObj());
            }

            if (patients != null) {
                session.delete(patients);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (patients != null) {
            clearCache(patients);
        }

        return patients;
    }

    @Override
    public Patients updateImpl(
        com.statuspatients.plugins.model.Patients patients)
        throws SystemException {
        patients = toUnwrappedModel(patients);

        boolean isNew = patients.isNew();

        PatientsModelImpl patientsModelImpl = (PatientsModelImpl) patients;

        if (Validator.isNull(patients.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            patients.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (patients.isNew()) {
                session.save(patients);

                patients.setNew(false);
            } else {
                session.merge(patients);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !PatientsModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((patientsModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { patientsModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { patientsModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((patientsModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        patientsModelImpl.getOriginalUuid(),
                        patientsModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        patientsModelImpl.getUuid(),
                        patientsModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((patientsModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        patientsModelImpl.getOriginalField2()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIELD2, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2,
                    args);

                args = new Object[] { patientsModelImpl.getField2() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIELD2, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2,
                    args);
            }
        }

        EntityCacheUtil.putResult(PatientsModelImpl.ENTITY_CACHE_ENABLED,
            PatientsImpl.class, patients.getPrimaryKey(), patients);

        clearUniqueFindersCache(patients);
        cacheUniqueFindersCache(patients);

        return patients;
    }

    protected Patients toUnwrappedModel(Patients patients) {
        if (patients instanceof PatientsImpl) {
            return patients;
        }

        PatientsImpl patientsImpl = new PatientsImpl();

        patientsImpl.setNew(patients.isNew());
        patientsImpl.setPrimaryKey(patients.getPrimaryKey());

        patientsImpl.setUuid(patients.getUuid());
        patientsImpl.setFooId(patients.getFooId());
        patientsImpl.setGroupId(patients.getGroupId());
        patientsImpl.setCompanyId(patients.getCompanyId());
        patientsImpl.setUserId(patients.getUserId());
        patientsImpl.setUserName(patients.getUserName());
        patientsImpl.setCreateDate(patients.getCreateDate());
        patientsImpl.setModifiedDate(patients.getModifiedDate());
        patientsImpl.setField1(patients.getField1());
        patientsImpl.setField2(patients.isField2());
        patientsImpl.setField3(patients.getField3());
        patientsImpl.setField4(patients.getField4());
        patientsImpl.setField5(patients.getField5());

        return patientsImpl;
    }

    /**
     * Returns the patients with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the patients
     * @return the patients
     * @throws com.statuspatients.plugins.NoSuchPatientsException if a patients with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Patients findByPrimaryKey(Serializable primaryKey)
        throws NoSuchPatientsException, SystemException {
        Patients patients = fetchByPrimaryKey(primaryKey);

        if (patients == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchPatientsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return patients;
    }

    /**
     * Returns the patients with the primary key or throws a {@link com.statuspatients.plugins.NoSuchPatientsException} if it could not be found.
     *
     * @param fooId the primary key of the patients
     * @return the patients
     * @throws com.statuspatients.plugins.NoSuchPatientsException if a patients with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Patients findByPrimaryKey(long fooId)
        throws NoSuchPatientsException, SystemException {
        return findByPrimaryKey((Serializable) fooId);
    }

    /**
     * Returns the patients with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the patients
     * @return the patients, or <code>null</code> if a patients with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Patients fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Patients patients = (Patients) EntityCacheUtil.getResult(PatientsModelImpl.ENTITY_CACHE_ENABLED,
                PatientsImpl.class, primaryKey);

        if (patients == _nullPatients) {
            return null;
        }

        if (patients == null) {
            Session session = null;

            try {
                session = openSession();

                patients = (Patients) session.get(PatientsImpl.class, primaryKey);

                if (patients != null) {
                    cacheResult(patients);
                } else {
                    EntityCacheUtil.putResult(PatientsModelImpl.ENTITY_CACHE_ENABLED,
                        PatientsImpl.class, primaryKey, _nullPatients);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(PatientsModelImpl.ENTITY_CACHE_ENABLED,
                    PatientsImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return patients;
    }

    /**
     * Returns the patients with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param fooId the primary key of the patients
     * @return the patients, or <code>null</code> if a patients with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Patients fetchByPrimaryKey(long fooId) throws SystemException {
        return fetchByPrimaryKey((Serializable) fooId);
    }

    /**
     * Returns all the patientses.
     *
     * @return the patientses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Patients> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Patients> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Patients> findAll(int start, int end,
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

        List<Patients> list = (List<Patients>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_PATIENTS);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_PATIENTS;

                if (pagination) {
                    sql = sql.concat(PatientsModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Patients>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Patients>(list);
                } else {
                    list = (List<Patients>) QueryUtil.list(q, getDialect(),
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
     * Removes all the patientses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Patients patients : findAll()) {
            remove(patients);
        }
    }

    /**
     * Returns the number of patientses.
     *
     * @return the number of patientses
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

                Query q = session.createQuery(_SQL_COUNT_PATIENTS);

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
     * Initializes the patients persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.statuspatients.plugins.model.Patients")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Patients>> listenersList = new ArrayList<ModelListener<Patients>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Patients>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(PatientsImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
