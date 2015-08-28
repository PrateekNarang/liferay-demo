package com.statuspatients.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PatientsService}.
 *
 * @author Brian Wing Shun Chan
 * @see PatientsService
 * @generated
 */
public class PatientsServiceWrapper implements PatientsService,
    ServiceWrapper<PatientsService> {
    private PatientsService _patientsService;

    public PatientsServiceWrapper(PatientsService patientsService) {
        _patientsService = patientsService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _patientsService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _patientsService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _patientsService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PatientsService getWrappedPatientsService() {
        return _patientsService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPatientsService(PatientsService patientsService) {
        _patientsService = patientsService;
    }

    @Override
    public PatientsService getWrappedService() {
        return _patientsService;
    }

    @Override
    public void setWrappedService(PatientsService patientsService) {
        _patientsService = patientsService;
    }
}
