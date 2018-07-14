var pageSize = 20;

Ext.define('inquire.store.InquireStore', {
	extend : 'Ext.data.Store',
	alias : 'widget.inquireStore',
	autoLoad : true,
	autoSync : true,// 需要同步
	model : 'inquire.model.InquireModel',
	proxy : {
		url : server_context + '/inquire/.json',
		type : 'ajax',
		api : {
			read : server_context + '/inquire/.json',
			update : server_context + '/inquire/.json'
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
