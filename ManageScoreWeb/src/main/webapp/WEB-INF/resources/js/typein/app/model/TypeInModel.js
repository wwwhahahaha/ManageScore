Ext.define('typein.model.TypeInModel', {
	extend : 'Ext.data.Model',
	alias : 'widget.typeinModel',
	fields : [ {
        name : 'id',
        type : 'int',
        sortable : true
    },  {
		name : 'struct',
		type : 'string',
		sortable : true
	}, {
		name : 'struct2',
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
