Ext.define('inquire.view.InquireEdit', {
	extend : 'Ext.window.Window',
	alias : 'widget.inquireEdit',
	title : '编辑信息',
	layout : 'fit',
	autoShow : true,
	initComponent : function() {
		this.items = [ {
			xtype : 'form',
			height : 300,
			width : 300,
			border : false,
			items : [ {
				xtype : 'textfield',
				name : 'indexFir',
				fieldLabel : '首先关键词'
			}, {
				xtype : 'textfield',
				name : 'indexSec',
				fieldLabel : '次要关键词'
			}, ]
		} ];
		this.buttons = [ {
			text : '保存',
			action : 'save'
		}, {
			text : '取消',
			scope : this,
			handler : this.close
		} ];
		this.callParent(arguments);
	}
});
