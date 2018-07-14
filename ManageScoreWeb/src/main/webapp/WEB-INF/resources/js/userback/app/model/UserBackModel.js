Ext.define('userback.model.UserBackModel', {
	extend : 'Ext.data.Model',
	alias : 'widget.userbackModel',
	fields : [ {
        name : 'id',
        type : 'int',
        sortable : true
    },  {
		name : 'message',
		type : 'string',
		sortable : true
	}, {
		name : 'phone',
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
