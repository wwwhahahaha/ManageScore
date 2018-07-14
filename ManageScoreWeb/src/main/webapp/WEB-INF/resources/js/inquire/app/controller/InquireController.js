Ext.define('inquire.controller.InquireController', {
    extend : 'Ext.app.Controller',
    alias : 'widget.inquireController',
    stores : [ 'InquireStore' ],
    models : [ 'InquireModel' ],
    views : [ 'InquireGrid', 'InquireEdit' ],
    init : function() {
        this.control({
            'inquireGrid' : {
                itemdblclick : this.editInquire
            },
            'inquireEdit button[action=save]' : {
                click : this.updateInquire
            }
        });
    },
    editInquire : function(grid, record) {
        var view = Ext.widget('inquireEdit');
        view.down('form').loadRecord(record);
    },
    updateInquire : function(button) {
        var win = button.up('window');
        form = win.down('form');
        record = form.getRecord();
        values = form.getValues();
        record.set(values);
        win.close();
    }
});
