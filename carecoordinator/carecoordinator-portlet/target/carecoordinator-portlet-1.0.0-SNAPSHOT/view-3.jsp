<%@include file="/init.jsp"%>

<aui:button-row>
	<portlet:renderURL var="viewdetailURL">
		<portlet:param name="mvcPath" value="/view-2.jsp"></portlet:param>
	</portlet:renderURL>

	<aui:button class="ocuhub_hidden" id="detail-url"
		onClick="<%= viewdetailURL %>"></aui:button>

</aui:button-row>


<div class="ocuhub_portal_header">Pending Appointments</div>

<div class="container-fluid occuhub_remove_padding">

	<div class="row-fluid">

		<div class="span12 ocuhub_detail_tile"
			onclick="document.getElementById('detail-url').click();">


			<div class="container-fluid occuhub_remove_padding">

				<div class="row-fluid">
					<div class="span6">
						<p class="ocuhub_subtile_header ocuhub_center_align">Contact
							Attempts</p>
					</div>

					<div class="span6">
						<p class="ocuhub_subtile_header ocuhub_center_align">Days
							Pending</p>
					</div>
				</div>


			</div>
			
			<div class="container-fluid occuhub_remove_padding">

				<div class="row-fluid ocuhub_appointments_header">

					<div class="span2 ocuhub_row_cell">
						<span class="">Days Pending</span>
					</div>

					<div class="span2 ocuhub_row_cell">
						<span class="">Request Received</span>
					</div>

					<div class="span2 ocuhub_row_cell">
						<span class="">Patient Name</span>
					</div>

					<div class="span2 ocuhub_row_cell">
						<span class="">Patient Phone</span>
					</div>

					<div class="span2 ocuhub_row_cell">
						<span class="">Contact Attempts</span>
					</div>

					<div class="span2 ocuhub_row_cell">
						<span class="">Action</span>
					</div>

				</div>
					
				<div class="row-fluid ocuhub_appointments_row ocuhub_row_1" onclick="document.getElementById('detail-url').click();">

					<div class="span2  ocuhub_row_cell ocuhub_cell_border">
						<span class="">3</span>
					</div>

					<div class="span2  ocuhub_row_cell ocuhub_cell_border">
						<span class="">08/22/15</span>
					</div>

					<div class="span2  ocuhub_row_cell ocuhub_cell_border">
						<span class="">Sam Smith</span>
					</div>

					<div class="span2  ocuhub_row_cell ocuhub_cell_border">
						<span class="">000-000-0000</span>
					</div>

					<div class="span2  ocuhub_row_cell ocuhub_cell_border">
						<span class="">1</span>
					</div>

					<div class="span2  ocuhub_row_cell">
						<select class="ocuhub_select_action ocuhub_remove_margin">
							<option></option>
							<option></option>
						</select>
					</div>

				</div>

			</div>


		</div>

	</div>

</div>



