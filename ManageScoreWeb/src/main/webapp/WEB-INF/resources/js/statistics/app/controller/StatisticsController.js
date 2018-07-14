Ext.define('statistics.controller.StatisticsController', {
    extend : 'Ext.app.Controller',
    alias : 'widget.statisticsController',
    stores : [ 'StatisticsStore' ],
    models : [ 'StatisticsModel' ],
    views : [ 'StatisticsGrid', 'StatisticsEdit' ],
    init : function() {
        this.control({
            'statisticsGrid' : {
                itemdblclick : this.editStatistics
            },
            'statisticsEdit button[action=save]' : {
                click : this.updateStatistics
            }
        });
    },
    editStatistics : function(grid, record) {
        var view = Ext.widget('statisticsEdit');
        view.down('form').loadRecord(record);
    },
    updateStatistics : function(button) {
        var win = button.up('window');
        form = win.down('form');
        record = form.getRecord();
        values = form.getValues();
        record.set(values);
        win.close();
    }
});
