var pageSize = 20;

Ext.define('statistics.store.StatisticsStore', {
	extend : 'Ext.data.Store',
	alias : 'widget.statisticsStore',
	autoLoad : true,
	autoSync : true,// 需要同步
	model : 'statistics.model.StatisticsModel',
	proxy : {
		url : server_context + '/statistics/.json',
		type : 'ajax',
		api : {
			read : server_context + '/statistics/.json',
			update : server_context + '/statistics/.json'
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
