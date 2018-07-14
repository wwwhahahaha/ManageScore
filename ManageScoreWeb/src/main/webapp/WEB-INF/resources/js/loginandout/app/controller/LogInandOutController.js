Ext.define('loginandout.controller.LogInandOutController', {
    extend : 'Ext.app.Controller',
    alias : 'widget.loginandoutController',
    stores : [ 'LogInandOutStore' ],
    models : [ 'LogInandOutModel' ],
    views : [ 'LogInandOutGrid', 'LogInandOutEdit' ],
    init : function() {
        this.control({
            'loginandoutGrid' : {
                itemdblclick : this.editLogInandOut
            },
            'loginandoutEdit button[action=save]' : {
                click : this.updateLogInandOut
            }
        });
    },
    editLogInandOut : function(grid, record) {
        var view = Ext.widget('loginandoutEdit');
        view.down('form').loadRecord(record);
    },
    updateLogInandOut : function(button) {
        var win = button.up('window');
        form = win.down('form');
        record = form.getRecord();
        values = form.getValues();
        record.set(values);
        win.close();
    }
});
