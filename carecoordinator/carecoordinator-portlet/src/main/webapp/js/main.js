google.load("visualization", "1", {
	packages : [ "corechart" ]
});

google.setOnLoadCallback(drawChart);

var options = {
	legend : {
		position : 'top',
		textStyle : {
			color : '#fff'
		},
		alignment : 'start',
		maxLines : 6
	},
	colors : [ 'green', 'red' ],
	isStacked : true,
	areaOpacity : 1,
	tooltip : {
		trigger : "focus"
	},
	backgroundColor : 'transparent',
	vAxis : {
		textStyle : {
			color : 'white'
		}
	},
	hAxis : {
		textStyle : {
			color : 'white'
		}
	},

};

function drawChart() {

	drawChartPending();
	drawChartScheduled();
	drawChartPost();
	drawChartCompleted();

}

function drawChartPending() {

	var data = google.visualization.arrayToDataTable([
			[ 'Type', 'Overdue', 'In Process' ], [ '', 20, 4 ] ]);
	var chart_pending = new google.visualization.SteppedAreaChart(document
			.getElementById('chart_pending'));
	chart_pending.draw(data, options);
}

function drawChartScheduled() {

	var data = google.visualization.arrayToDataTable([
			[ 'Type', 'In Process', 'Overdue' ], [ '', 24, 16 ] ]);

	var chart_scheduled = new google.visualization.SteppedAreaChart(document
			.getElementById('chart_scheduled'));
	chart_scheduled.draw(data, options);
}

function drawChartPost() {

	var data = google.visualization.arrayToDataTable([
			[ 'Type', 'In Process', 'Overdue' ], [ '', 50, 9 ] ]);

	var chart_post = new google.visualization.SteppedAreaChart(document
			.getElementById('chart_post'));
	chart_post.draw(data, options);
}

function drawChartCompleted() {

	var data = google.visualization.arrayToDataTable([ [ 'Type', 'Overdue' ],
			[ '', 20 ] ]);

	var chart_completed = new google.visualization.SteppedAreaChart(document
			.getElementById('chart_completed'));
	chart_completed.draw(data, options);
}
