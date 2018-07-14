var pageSize = 20;

Ext.define('typein.store.TypeInStore', {
	extend : 'Ext.data.Store',
	alias : 'widget.typeinStore',
	autoLoad : true,
	autoSync : true,// 需要同步
	model : 'typein.model.TypeInModel',
	proxy : {
		url : server_context + '/typein/.json',
		type : 'ajax',
		api : {
			read : server_context + '/typein/.json',
			update : server_context + '/typein/.json'
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
