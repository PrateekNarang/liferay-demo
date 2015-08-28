package com.reportssent.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ReportsService}.
 *
 * @author Brian Wing Shun Chan
 * @see ReportsService
 * @generated
 */
public class ReportsServiceWrapper implements ReportsService,
    ServiceWrapper<ReportsService> {
    private ReportsService _reportsService;

    public ReportsServiceWrapper(ReportsService reportsService) {
        _reportsService = reportsService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _reportsService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _reportsService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _reportsService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ReportsService getWrappedReportsService() {
        return _reportsService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedReportsService(ReportsService reportsService) {
        _reportsService = reportsService;
    }

    @Override
    public ReportsService getWrappedService() {
        return _reportsService;
    }

    @Override
    public void setWrappedService(ReportsService reportsService) {
        _reportsService = reportsService;
    }
}
