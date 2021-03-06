package com.reportssent.plugins.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.reportssent.plugins.model.Element;
import com.reportssent.plugins.service.ElementLocalService;
import com.reportssent.plugins.service.persistence.ElementPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the element local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.reportssent.plugins.service.impl.ElementLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.reportssent.plugins.service.impl.ElementLocalServiceImpl
 * @see com.reportssent.plugins.service.ElementLocalServiceUtil
 * @generated
 */
public abstract class ElementLocalServiceBaseImpl extends BaseLocalServiceImpl
    implements ElementLocalService, IdentifiableBean {
    @BeanReference(type = com.reportssent.plugins.service.ElementLocalService.class)
    protected com.reportssent.plugins.service.ElementLocalService elementLocalService;
    @BeanReference(type = com.reportssent.plugins.service.ElementService.class)
    protected com.reportssent.plugins.service.ElementService elementService;
    @BeanReference(type = ElementPersistence.class)
    protected ElementPersistence elementPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private ElementLocalServiceClpInvoker _clpInvoker = new ElementLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.reportssent.plugins.service.ElementLocalServiceUtil} to access the element local service.
     */

    /**
     * Adds the element to the database. Also notifies the appropriate model listeners.
     *
     * @param element the element
     * @return the element that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Element addElement(Element element) throws SystemException {
        element.setNew(true);

        return elementPersistence.update(element);
    }

    /**
     * Creates a new element with the primary key. Does not add the element to the database.
     *
     * @param statusId the primary key for the new element
     * @return the new element
     */
    @Override
    public Element createElement(long statusId) {
        return elementPersistence.create(statusId);
    }

    /**
     * Deletes the element with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param statusId the primary key of the element
     * @return the element that was removed
     * @throws PortalException if a element with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Element deleteElement(long statusId)
        throws PortalException, SystemException {
        return elementPersistence.remove(statusId);
    }

    /**
     * Deletes the element from the database. Also notifies the appropriate model listeners.
     *
     * @param element the element
     * @return the element that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Element deleteElement(Element element) throws SystemException {
        return elementPersistence.remove(element);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(Element.class,
            clazz.getClassLoader());
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
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return elementPersistence.findWithDynamicQuery(dynamicQuery);
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return elementPersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return elementPersistence.findWithDynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return elementPersistence.countWithDynamicQuery(dynamicQuery);
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
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return elementPersistence.countWithDynamicQuery(dynamicQuery, projection);
    }

    @Override
    public Element fetchElement(long statusId) throws SystemException {
        return elementPersistence.fetchByPrimaryKey(statusId);
    }

    /**
     * Returns the element with the matching UUID and company.
     *
     * @param uuid the element's UUID
     * @param  companyId the primary key of the company
     * @return the matching element, or <code>null</code> if a matching element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element fetchElementByUuidAndCompanyId(String uuid, long companyId)
        throws SystemException {
        return elementPersistence.fetchByUuid_C_First(uuid, companyId, null);
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
    public Element fetchElementByUuidAndGroupId(String uuid, long groupId)
        throws SystemException {
        return elementPersistence.fetchByUUID_G(uuid, groupId);
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
    public Element getElement(long statusId)
        throws PortalException, SystemException {
        return elementPersistence.findByPrimaryKey(statusId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return elementPersistence.findByPrimaryKey(primaryKeyObj);
    }

    /**
     * Returns the element with the matching UUID and company.
     *
     * @param uuid the element's UUID
     * @param  companyId the primary key of the company
     * @return the matching element
     * @throws PortalException if a matching element could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Element getElementByUuidAndCompanyId(String uuid, long companyId)
        throws PortalException, SystemException {
        return elementPersistence.findByUuid_C_First(uuid, companyId, null);
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
    public Element getElementByUuidAndGroupId(String uuid, long groupId)
        throws PortalException, SystemException {
        return elementPersistence.findByUUID_G(uuid, groupId);
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
    public List<Element> getElements(int start, int end)
        throws SystemException {
        return elementPersistence.findAll(start, end);
    }

    /**
     * Returns the number of elements.
     *
     * @return the number of elements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getElementsCount() throws SystemException {
        return elementPersistence.countAll();
    }

    /**
     * Updates the element in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param element the element
     * @return the element that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Element updateElement(Element element) throws SystemException {
        return elementPersistence.update(element);
    }

    /**
     * Returns the element local service.
     *
     * @return the element local service
     */
    public com.reportssent.plugins.service.ElementLocalService getElementLocalService() {
        return elementLocalService;
    }

    /**
     * Sets the element local service.
     *
     * @param elementLocalService the element local service
     */
    public void setElementLocalService(
        com.reportssent.plugins.service.ElementLocalService elementLocalService) {
        this.elementLocalService = elementLocalService;
    }

    /**
     * Returns the element remote service.
     *
     * @return the element remote service
     */
    public com.reportssent.plugins.service.ElementService getElementService() {
        return elementService;
    }

    /**
     * Sets the element remote service.
     *
     * @param elementService the element remote service
     */
    public void setElementService(
        com.reportssent.plugins.service.ElementService elementService) {
        this.elementService = elementService;
    }

    /**
     * Returns the element persistence.
     *
     * @return the element persistence
     */
    public ElementPersistence getElementPersistence() {
        return elementPersistence;
    }

    /**
     * Sets the element persistence.
     *
     * @param elementPersistence the element persistence
     */
    public void setElementPersistence(ElementPersistence elementPersistence) {
        this.elementPersistence = elementPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("com.reportssent.plugins.model.Element",
            elementLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "com.reportssent.plugins.model.Element");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return Element.class;
    }

    protected String getModelClassName() {
        return Element.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = elementPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
