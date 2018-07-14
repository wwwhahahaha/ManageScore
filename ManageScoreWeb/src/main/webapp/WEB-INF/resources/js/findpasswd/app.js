Ext.Loader.setConfig({
	enabled : true
});
Ext.application({
	name : 'findpasswd',
	appFolder : server_context + '/resources/js/findpasswd/app',
	controllers : [ 'FindPasswdController' ],
	launch : function() {
		Ext.create('Ext.container.Viewport', {
			layout : 'fit',
			items : [ {
				xtype : 'findpasswdGrid'
			} ]
		});
	}
});
