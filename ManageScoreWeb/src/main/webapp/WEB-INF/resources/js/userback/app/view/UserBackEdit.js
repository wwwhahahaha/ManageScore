Ext.define('userback.view.UserBackEdit', {
	extend : 'Ext.window.Window',
	alias : 'widget.userbackEdit',
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
				name : 'message',
				fieldLabel : '信息'
			}, {
				xtype : 'textfield',
				name : 'phone',
				fieldLabel : '电话'
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
