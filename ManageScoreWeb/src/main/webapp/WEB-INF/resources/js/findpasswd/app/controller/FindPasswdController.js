Ext.define('findpasswd.controller.FindPasswdController', {
    extend : 'Ext.app.Controller',
    alias : 'widget.findpasswdController',
    stores : [ 'FindPasswdStore' ],
    models : [ 'FindPasswdModel' ],
    views : [ 'FindPasswdGrid', 'FindPasswdEdit' ],
    init : function() {
        this.control({
            'findpasswdGrid' : {
                itemdblclick : this.editFindPasswd
            },
            'findpasswdEdit button[action=save]' : {
                click : this.updateFindPasswd
            }
        });
    },
    editFindPasswd : function(grid, record) {
        var view = Ext.widget('findpasswdEdit');
        view.down('form').loadRecord(record);
    },
    updateFindPasswd : function(button) {
        var win = button.up('window');
        form = win.down('form');
        record = form.getRecord();
        values = form.getValues();
        record.set(values);
        win.close();
    }
});
