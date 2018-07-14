Ext.define('area.view.AreaEdit', {
	extend : 'Ext.window.Window',
	alias : 'widget.areaEdit',
	title : '编辑学生信息',
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
				name : 'code',
				fieldLabel : '区域编码'
			}, {
				xtype : 'textfield',
				name : 'name',
				fieldLabel : '区域名称'
			}, {
				xtype : 'textfield',
				name : 'description',
				fieldLabel : '简介'
			} ]
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
