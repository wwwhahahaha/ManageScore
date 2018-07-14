Ext.define('loginandout.view.LogInandOutEdit', {
	extend : 'Ext.window.Window',
	alias : 'widget.loginandoutEdit',
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
				name : 'username',
				fieldLabel : '用户名'
			}, {
				xtype : 'textfield',
				name : 'userPasswd',
				fieldLabel : '密码'
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
