var pageSize = 20;

var userbackStore = Ext.create('userback.store.UserBackStore');

Ext.define('userback.view.UserBackGrid', {
	extend : 'Ext.grid.GridPanel',
	alias : 'widget.userbackGrid',
	title : 'userback',
	store : userbackStore,
	columns : [ {
        text : 'id',
        width : 50,
        sortable : true,
        dataIndex : 'id'
    }, {
		text : '信息',
		width : 300,
		sortable : true,
		dataIndex : 'message'
	}, {
		text : "电话",
		width : 300,
		sortable : true,
		dataIndex : 'phone'
	} ],
	viewConfig : {
		columnsText : '列',
		sortAscText : '升序',
		sortDescText : '降序'
	},

	bbar : new Ext.PagingToolbar({
		pageSize : pageSize,// 每页显示的记录值
        store : userbackStore,
		displayInfo : true,
		firstTest : '首页',
		lastText : '尾页',
		nextText : '下页',
		prevText : '前页',
		beforePageText : '第',
		afterPageText : '页，共{0}页',
		displayMsg : '记录数：第{0}条 - 第{1}条，共 {2}条',
		emptyMsg : "没有记录"
	})
});
