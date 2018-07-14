var pageSize = 20;

var findpasswdStore = Ext.create('findpasswd.store.FindPasswdStore');

Ext.define('findpasswd.view.FindPasswdGrid', {
	extend : 'Ext.grid.GridPanel',
	alias : 'widget.findpasswdGrid',
	title : 'findpasswd',
	store : findpasswdStore,
	columns : [ {
        text : 'id',
        width : 50,
        sortable : true,
        dataIndex : 'id'
    }, {
		text : '用户',
		width : 300,
		sortable : true,
		dataIndex : 'userName'
	}, {
		text : "邮箱",
		width : 300,
		sortable : true,
		dataIndex : 'email'
	} ],
	viewConfig : {
		columnsText : '列',
		sortAscText : '升序',
		sortDescText : '降序'
	},

	bbar : new Ext.PagingToolbar({
		pageSize : pageSize,// 每页显示的记录值
        store : findpasswdStore,
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
