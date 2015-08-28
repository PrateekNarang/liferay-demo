<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<div class="portal-header-content" id="status-patients-header">
    
    Status of Patients
    
</div>


<div class="portal-inner-content" id="status-patients-content">
    
    
    <div class="container">
        <div class="row-fluid">
            <div class="span3 primary-column">Exam Completed</div>
            <div class="span1 secondary-column">60</div>
            <div class="span1 secondary-column">48%</div>
        </div>
        <div class="row-fluid">
            <div class="span3 primary-column">Scheduled</div>
            <div class="span1 secondary-column">60</div>
            <div class="span1 secondary-column">32%</div>
        </div>
        <div class="row-fluid">
            <div class="span3 primary-column">No Contact W/ Patient</div>
            <div class="span1 secondary-column">10</div>
            <div class="span1 secondary-column">8%</div>
        </div>
        <div class="row-fluid">
            <div class="span3 primary-column">No Insurance Coverage</div>
            <div class="span1 secondary-column">10</div>
            <div class="span1 secondary-column">8%</div>
        </div>
        <div class="row-fluid">
            <div class="span3 primary-column">Other</div>
            <div class="span1 secondary-column">5</div>
            <div class="span1 secondary-column">4%</div>
        </div>
    </div>
    
    
</div>