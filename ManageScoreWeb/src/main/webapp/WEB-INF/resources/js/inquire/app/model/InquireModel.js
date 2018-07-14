Ext.define('inquire.model.InquireModel', {
	extend : 'Ext.data.Model',
	alias : 'widget.inquireModel',
	fields : [ {
        name : 'id',
        type : 'int',
        sortable : true
    },  {
		name : 'indexFir',
		type : 'string',
		sortable : true
	}, {
		name : 'indexSec',
		type : 'string',
		sortable : true
	} ]
});
