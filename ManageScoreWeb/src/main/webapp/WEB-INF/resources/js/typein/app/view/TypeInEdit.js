Ext.define('typein.view.TypeInEdit', {
	extend : 'Ext.window.Window',
	alias : 'widget.typeinEdit',
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
				name : 'struct',
				fieldLabel : '数据'
			}, {
				xtype : 'textfield',
				name : 'struct2',
				fieldLabel : '被替换数据'
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
