Ext.Loader.setConfig({
	enabled : true
});
Ext.application({
	name : 'scoreback',
	appFolder : server_context + '/resources/js/scoreback/app',
	controllers : [ 'ScoreBackController' ],
	launch : function() {
		Ext.create('Ext.container.Viewport', {
			layout : 'fit',
			items : [ {
				xtype : 'scorebackGrid'
			} ]
		});
	}
});
