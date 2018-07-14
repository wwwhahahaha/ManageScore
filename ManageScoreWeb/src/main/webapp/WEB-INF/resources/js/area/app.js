Ext.Loader.setConfig({
	enabled : true
});
Ext.application({
	name : 'area',
	appFolder : server_context + '/resources/js/area/app',
	controllers : [ 'AreaController' ],
	launch : function() {
		Ext.create('Ext.container.Viewport', {
			layout : 'fit',
			items : [ {
				xtype : 'areaGrid'
			} ]
		});
	}
});
