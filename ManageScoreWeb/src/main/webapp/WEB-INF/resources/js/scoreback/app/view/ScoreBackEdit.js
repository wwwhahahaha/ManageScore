Ext.define('scoreback.view.ScoreBackEdit', {
	extend : 'Ext.window.Window',
	alias : 'widget.scorebackEdit',
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
				name : 'score',
				fieldLabel : '分数'
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
