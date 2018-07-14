Ext.define('typein.controller.TypeInController', {
    extend : 'Ext.app.Controller',
    alias : 'widget.typeinController',
    stores : [ 'TypeInStore' ],
    models : [ 'TypeInModel' ],
    views : [ 'TypeInGrid', 'TypeInEdit' ],
    init : function() {
        this.control({
            'typeinGrid' : {
                itemdblclick : this.editTypeIn
            },
            'typeinEdit button[action=save]' : {
                click : this.updateTypeIn
            }
        });
    },
    editTypeIn : function(grid, record) {
        var view = Ext.widget('typeinEdit');
        view.down('form').loadRecord(record);
    },
    updateTypeIn : function(button) {
        var win = button.up('window');
        form = win.down('form');
        record = form.getRecord();
        values = form.getValues();
        record.set(values);
        win.close();
    }
});
