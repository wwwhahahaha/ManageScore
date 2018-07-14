Ext.Loader.setConfig({
	enabled : true
});
Ext.application({
	name : 'statistics',
	appFolder : server_context + '/resources/js/statistics/app',
	controllers : [ 'StatisticsController' ],
	launch : function() {
		Ext.create('Ext.container.Viewport', {
			layout : 'fit',
			items : [ {
				xtype : 'statisticsGrid'
			} ]
		});
	}
});
