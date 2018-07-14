Ext.define('statistics.model.StatisticsModel', {
	extend : 'Ext.data.Model',
	alias : 'widget.statisticsModel',
	fields : [ {
        name : 'id',
        type : 'int',
        sortable : true
    },  {
		name : 'data',
		type : 'string',
		sortable : true
	}, {
		name : 'value',
		type : 'string',
		sortable : true
	},{
        name : 'dateCreated',
        type : 'date',
        dateFormat : 'time',
        sortable : true
    }, {
        name : 'dateModified',
        type : 'date',
        dateFormat : 'time',
        sortable : true
    }, ]
});
