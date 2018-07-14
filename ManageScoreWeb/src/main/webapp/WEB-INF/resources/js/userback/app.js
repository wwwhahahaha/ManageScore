Ext.Loader.setConfig({
	enabled : true
});
Ext.application({
	name : 'userback',
	appFolder : server_context + '/resources/js/userback/app',
	controllers : [ 'UserBackController' ],
	launch : function() {
		Ext.create('Ext.container.Viewport', {
			layout : 'fit',
			items : [ {
				xtype : 'userbackGrid'
			} ]
		});
	}
});
