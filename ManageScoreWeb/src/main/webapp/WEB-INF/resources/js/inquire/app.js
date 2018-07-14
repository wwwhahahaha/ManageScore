Ext.Loader.setConfig({
	enabled : true
});
Ext.application({
	name : 'inquire',
	appFolder : server_context + '/resources/js/inquire/app',
	controllers : [ 'InquireController' ],
	launch : function() {
		Ext.create('Ext.container.Viewport', {
			layout : 'fit',
			items : [ {
				xtype : 'inquireGrid'
			} ]
		});
	}
});
