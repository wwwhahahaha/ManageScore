Ext.define('area.controller.AreaController', {
	extend : 'Ext.app.Controller',
	alias : 'widget.areaController',
	stores : [ 'AreaStore' ],
	models : [ 'AreaModel' ],
	views : [ 'AreaGrid', 'AreaEdit' ],
	init : function() {
		this.control({
			'areaGrid' : {
				itemdblclick : this.editArea
			},
			'areaEdit button[action=save]' : {
				click : this.updateArea
			}
		});
	},
	editArea : function(grid, record) {
		var view = Ext.widget('areaEdit');
		view.down('form').loadRecord(record);
	},
	updateArea : function(button) {
		var win = button.up('window');
		form = win.down('form');
		record = form.getRecord();
		values = form.getValues();
		record.set(values);
		win.close();
	}
});
