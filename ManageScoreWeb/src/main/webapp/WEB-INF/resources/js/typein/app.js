Ext.Loader.setConfig({
	enabled : true
});
Ext.application({
	name : 'typein',
	appFolder : server_context + '/resources/js/typein/app',
	controllers : [ 'TypeInController' ],
	launch : function() {
		Ext.create('Ext.container.Viewport', {
			layout : 'fit',
			items : [ {
				xtype : 'typeinGrid'
			} ]
		});
	}
});
