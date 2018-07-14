Ext.Loader.setConfig({
	enabled : true
});
Ext.application({
	name : 'loginandout',
	appFolder : server_context + '/resources/js/loginandout/app',
	controllers : [ 'LogInandOutController' ],
	launch : function() {
		Ext.create('Ext.container.Viewport', {
			layout : 'fit',
			items : [ {
				xtype : 'loginandoutGrid'
			} ]
		});
	}
});
