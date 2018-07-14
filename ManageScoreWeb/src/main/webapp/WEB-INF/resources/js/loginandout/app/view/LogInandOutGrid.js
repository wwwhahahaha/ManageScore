var pageSize = 20;

var loginandoutStore = Ext.create('loginandout.store.LogInandOutStore');

Ext.define('loginandout.view.LogInandOutGrid', {
	extend : 'Ext.grid.GridPanel',
	alias : 'widget.loginandoutGrid',
	title : 'loginandout',
	store : loginandoutStore,
	columns : [ {
        text : 'id',
        width : 50,
        sortable : true,
        dataIndex : 'id'
    }, {
		text : '用户名',
		width : 300,
		sortable : true,
		dataIndex : 'userName'
	}, {
		text : "密码",
		width : 300,
		sortable : true,
		dataIndex : 'userPasswd'
	} ],
	viewConfig : {
		columnsText : '列',
		sortAscText : '升序',
		sortDescText : '降序'
	},

	bbar : new Ext.PagingToolbar({
		pageSize : pageSize,// 每页显示的记录值
        store : loginandoutStore,
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
