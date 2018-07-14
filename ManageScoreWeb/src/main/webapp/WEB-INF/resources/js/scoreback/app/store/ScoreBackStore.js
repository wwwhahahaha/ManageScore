var pageSize = 20;

Ext.define('scoreback.store.ScoreBackStore', {
	extend : 'Ext.data.Store',
	alias : 'widget.scorebackStore',
	autoLoad : true,
	autoSync : true,// 需要同步
	model : 'scoreback.model.ScoreBackModel',
	proxy : {
		url : server_context + '/scoreback/.json',
		type : 'ajax',
		api : {
			read : server_context + '/scoreback/.json',
			update : server_context + '/scoreback/.json'
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
