var pageSize = 20;

Ext.define('userback.store.UserBackStore', {
	extend : 'Ext.data.Store',
	alias : 'widget.userbackStore',
	autoLoad : true,
	autoSync : true,// 需要同步
	model : 'userback.model.UserBackModel',
	proxy : {
		url : server_context + '/userback/.json',
		type : 'ajax',
		api : {
			read : server_context + '/userback/.json',
			update : server_context + '/userback/.json'
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
