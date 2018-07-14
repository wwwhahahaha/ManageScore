var pageSize = 20;

Ext.define('area.store.AreaStore', {
	extend : 'Ext.data.Store',
	alias : 'widget.areaStore',
	autoLoad : true,
	autoSync : true,// 需要同步
	model : 'area.model.AreaModel',
	proxy : {
		url : server_context + '/area/.json',
		type : 'ajax',
		api : {
			read : server_context + '/area/.json',
			update : server_context + '/area/.json'
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