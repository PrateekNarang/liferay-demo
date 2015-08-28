package com.statuspatients.plugins.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.statuspatients.plugins.service.ClpSerializer;
import com.statuspatients.plugins.service.PatientsLocalServiceUtil;
import com.statuspatients.plugins.service.PatientsServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            PatientsLocalServiceUtil.clearService();

            PatientsServiceUtil.clearService();
        }
    }
}
