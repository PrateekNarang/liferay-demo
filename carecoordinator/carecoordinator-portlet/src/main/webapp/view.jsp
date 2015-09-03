<%@include file="/init.jsp"%>

<jsp:useBean id="graph_data" class="java.util.ArrayList" scope="request"/>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script>
console.log(<%= graph_data %>);
</script>


<div class="ocuhub_portal_header">Overview</div>

<div class="container-fluid occuhub_remove_padding">

	<div class="row-fluid">

		<div class="span3 ocuhub_overview_tile"
			onclick="document.getElementById('detail-url').click();">

			<p class="ocuhub_tile_header">Pending</p>

			<div id="chart_pending" style="width: 100%;"></div>

		</div>

		<div class="span3 ocuhub_overview_tile">

			<p class="ocuhub_tile_header">Scheduled</p>

			<div id="chart_scheduled" style="width: 100%;"></div>

		</div>

		<div class="span3 ocuhub_overview_tile">

			<p class="ocuhub_tile_header">Post-Appointment</p>

			<div id="chart_post" style="width: 100%;"></div>

		</div>

		<div class="span3 ocuhub_overview_tile">

			<p class="ocuhub_tile_header">Completed</p>

			<div id=chart_completed style="width: 100%;"></div>

		</div>


	</div>

</div>