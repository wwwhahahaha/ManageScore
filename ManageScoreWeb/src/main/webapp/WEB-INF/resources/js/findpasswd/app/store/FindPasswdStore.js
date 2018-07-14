var pageSize = 20;

Ext.define('findpasswd.store.FindPasswdStore', {
	extend : 'Ext.data.Store',
	alias : 'widget.findpasswdStore',
	autoLoad : true,
	autoSync : true,// 需要同步
	model : 'findpasswd.model.FindPasswdModel',
	proxy : {
		url : server_context + '/findpasswd/.json',
		type : 'ajax',
		api : {
			read : server_context + '/findpasswd/.json',
			update : server_context + '/findpassswd/.json'
		},
		reader : {
			type : 'json',
			root : 'content',
			totalProperty : 'totalElements'
		},
		writer : {
			type : 'json'
		}
	},
	// 每页显示的记录行数
	pageSize : pageSize
});
