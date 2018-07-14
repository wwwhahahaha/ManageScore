Ext.define('statistics.view.StatisticsEdit', {
	extend : 'Ext.window.Window',
	alias : 'widget.statisticsEdit',
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
				name : 'data',
				fieldLabel : '日期'
			}, {
				xtype : 'textfield',
				name : 'value',
				fieldLabel : '数据'
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
