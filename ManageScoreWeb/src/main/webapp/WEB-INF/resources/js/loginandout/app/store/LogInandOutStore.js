var pageSize = 20;

Ext.define('loginandout.store.LogInandOutStore', {
	extend : 'Ext.data.Store',
	alias : 'widget.loginandoutStore',
	autoLoad : true,
	autoSync : true,// 需要同步
	model : 'loginandout.model.LogInandOutModel',
	proxy : {
		url : server_context + '/loginandout/.json',
		type : 'ajax',
		api : {
			read : server_context + '/loginandout/.json',
			update : server_context + '/loginandout/.json'
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
