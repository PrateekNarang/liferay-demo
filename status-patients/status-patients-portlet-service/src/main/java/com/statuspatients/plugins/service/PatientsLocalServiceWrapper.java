package com.statuspatients.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PatientsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PatientsLocalService
 * @generated
 */
public class PatientsLocalServiceWrapper implements PatientsLocalService,
    ServiceWrapper<PatientsLocalService> {
    private PatientsLocalService _patientsLocalService;

    public PatientsLocalServiceWrapper(
        PatientsLocalService patientsLocalService) {
        _patientsLocalService = patientsLocalService;
    }

    /**
    * Adds the patients to the database. Also notifies the appropriate model listeners.
    *
    * @param patients the patients
    * @return the patients that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.statuspatients.plugins.model.Patients addPatients(
        com.statuspatients.plugins.model.Patients patients)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _patientsLocalService.addPatients(patients);
    }

    /**
    * Creates a new patients with the primary key. Does not add the patients to the database.
    *
    * @param fooId the primary key for the new patients
    * @return the new patients
    */
    @Override
    public com.statuspatients.plugins.model.Patients createPatients(long fooId) {
        return _patientsLocalService.createPatients(fooId);
    }

    /**
    * Deletes the patients with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param fooId the primary key of the patients
    * @return the patients that was removed
    * @throws PortalException if a patients with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.statuspatients.plugins.model.Patients deletePatients(long fooId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _patientsLocalService.deletePatients(fooId);
    }

    /**
    * Deletes the patients from the database. Also notifies the appropriate model listeners.
    *
    * @param patients the patients
    * @return the patients that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.statuspatients.plugins.model.Patients deletePatients(
        com.statuspatients.plugins.model.Patients patients)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _patientsLocalService.deletePatients(patients);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _patientsLocalService.dynamicQuery();
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
        return _patientsLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.statuspatients.plugins.model.impl.PatientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _patientsLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.statuspatients.plugins.model.impl.PatientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _patientsLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _patientsLocalService.dynamicQueryCount(dynamicQuery);
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
        return _patientsLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.statuspatients.plugins.model.Patients fetchPatients(long fooId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _patientsLocalService.fetchPatients(fooId);
    }

    /**
    * Returns the patients with the matching UUID and company.
    *
    * @param uuid the patients's UUID
    * @param companyId the primary key of the company
    * @return the matching patients, or <code>null</code> if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.statuspatients.plugins.model.Patients fetchPatientsByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _patientsLocalService.fetchPatientsByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the patients matching the UUID and group.
    *
    * @param uuid the patients's UUID
    * @param groupId the primary key of the group
    * @return the matching patients, or <code>null</code> if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.statuspatients.plugins.model.Patients fetchPatientsByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _patientsLocalService.fetchPatientsByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns the patients with the primary key.
    *
    * @param fooId the primary key of the patients
    * @return the patients
    * @throws PortalException if a patients with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.statuspatients.plugins.model.Patients getPatients(long fooId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _patientsLocalService.getPatients(fooId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _patientsLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the patients with the matching UUID and company.
    *
    * @param uuid the patients's UUID
    * @param companyId the primary key of the company
    * @return the matching patients
    * @throws PortalException if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.statuspatients.plugins.model.Patients getPatientsByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _patientsLocalService.getPatientsByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the patients matching the UUID and group.
    *
    * @param uuid the patients's UUID
    * @param groupId the primary key of the group
    * @return the matching patients
    * @throws PortalException if a matching patients could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.statuspatients.plugins.model.Patients getPatientsByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _patientsLocalService.getPatientsByUuidAndGroupId(uuid, groupId);
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
    public java.util.List<com.statuspatients.plugins.model.Patients> getPatientses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _patientsLocalService.getPatientses(start, end);
    }

    /**
    * Returns the number of patientses.
    *
    * @return the number of patientses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getPatientsesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _patientsLocalService.getPatientsesCount();
    }

    /**
    * Updates the patients in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param patients the patients
    * @return the patients that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.statuspatients.plugins.model.Patients updatePatients(
        com.statuspatients.plugins.model.Patients patients)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _patientsLocalService.updatePatients(patients);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _patientsLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _patientsLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _patientsLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PatientsLocalService getWrappedPatientsLocalService() {
        return _patientsLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPatientsLocalService(
        PatientsLocalService patientsLocalService) {
        _patientsLocalService = patientsLocalService;
    }

    @Override
    public PatientsLocalService getWrappedService() {
        return _patientsLocalService;
    }

    @Override
    public void setWrappedService(PatientsLocalService patientsLocalService) {
        _patientsLocalService = patientsLocalService;
    }
}
