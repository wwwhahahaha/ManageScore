Ext.define('scoreback.controller.ScoreBackController', {
    extend : 'Ext.app.Controller',
    alias : 'widget.scorebackController',
    stores : [ 'ScoreBackStore' ],
    models : [ 'ScoreBackModel' ],
    views : [ 'ScoreBackGrid', 'ScoreBackEdit' ],
    init : function() {
        this.control({
            'scorebackGrid' : {
                itemdblclick : this.editScoreBack
            },
            'scorebackEdit button[action=save]' : {
                click : this.updateScoreBack
            }
        });
    },
    editScoreBack : function(grid, record) {
        var view = Ext.widget('scorebackEdit');
        view.down('form').loadRecord(record);
    },
    updateScoreBack : function(button) {
        var win = button.up('window');
        form = win.down('form');
        record = form.getRecord();
        values = form.getValues();
        record.set(values);
        win.close();
    }
});
