Ext.define('userback.controller.UserBackController', {
    extend : 'Ext.app.Controller',
    alias : 'widget.userbackController',
    stores : [ 'UserBackStore' ],
    models : [ 'UserBackModel' ],
    views : [ 'UserBackGrid', 'UserBackEdit' ],
    init : function() {
        this.control({
            'userbackGrid' : {
                itemdblclick : this.editUserBack
            },
            'userbackEdit button[action=save]' : {
                click : this.updateUserBack
            }
        });
    },
    editUserBack : function(grid, record) {
        var view = Ext.widget('userbackEdit');
        view.down('form').loadRecord(record);
    },
    updateUserBack : function(button) {
        var win = button.up('window');
        form = win.down('form');
        record = form.getRecord();
        values = form.getValues();
        record.set(values);
        win.close();
    }
});
