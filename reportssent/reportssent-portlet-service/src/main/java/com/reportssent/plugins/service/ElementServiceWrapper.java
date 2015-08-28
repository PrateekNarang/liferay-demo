package com.reportssent.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ElementService}.
 *
 * @author Brian Wing Shun Chan
 * @see ElementService
 * @generated
 */
public class ElementServiceWrapper implements ElementService,
    ServiceWrapper<ElementService> {
    private ElementService _elementService;

    public ElementServiceWrapper(ElementService elementService) {
        _elementService = elementService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _elementService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _elementService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _elementService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ElementService getWrappedElementService() {
        return _elementService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedElementService(ElementService elementService) {
        _elementService = elementService;
    }

    @Override
    public ElementService getWrappedService() {
        return _elementService;
    }

    @Override
    public void setWrappedService(ElementService elementService) {
        _elementService = elementService;
    }
}
