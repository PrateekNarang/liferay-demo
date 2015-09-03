package com.liferay.docs.carecoordinator.portlet;

import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class carecoordinator
 */
public class carecoordinator extends MVCPortlet {

	@Override
	public void render (RenderRequest renderRequest, RenderResponse renderResponse) 
	        throws PortletException, IOException {
	
		ArrayList<Object> graph_data = new ArrayList<Object>();
		
		
	    renderRequest.setAttribute("graph_data", graph_data);
	    
	
	    super.render(renderRequest, renderResponse);
	
	}
	

}