var pageSize = 20;

var inquireStore = Ext.create('inquire.store.InquireStore');

Ext.define('inquire.view.InquireGrid', {
	extend : 'Ext.grid.GridPanel',
	alias : 'widget.inquireGrid',
	title : 'inquire',
	store : inquireStore,
	columns : [ {
        text : 'id',
        width : 50,
        sortable : true,
        dataIndex : 'id'
    }, {
		text : '首选关键词',
		width : 300,
		sortable : true,
		dataIndex : 'indexFir'
	}, {
		text : "次要关键词",
		width : 300,
		sortable : true,
		dataIndex : 'indexSec'
	} ],
	viewConfig : {
		columnsText : '列',
		sortAscText : '升序',
		sortDescText : '降序'
	},

	bbar : new Ext.PagingToolbar({
		pageSize : pageSize,// 每页显示的记录值
        store : inquireStore,
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
