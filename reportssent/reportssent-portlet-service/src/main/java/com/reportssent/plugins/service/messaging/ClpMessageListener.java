package com.reportssent.plugins.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.reportssent.plugins.service.ClpSerializer;
import com.reportssent.plugins.service.ReportsLocalServiceUtil;
import com.reportssent.plugins.service.ReportsServiceUtil;


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
            ReportsLocalServiceUtil.clearService();

            ReportsServiceUtil.clearService();
        }
    }
}
