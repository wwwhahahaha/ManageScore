Ext.define('scoreback.model.ScoreBackModel', {
	extend : 'Ext.data.Model',
	alias : 'widget.scorebackModel',
	fields : [ {
        name : 'id',
        type : 'int',
        sortable : true
    },  {
		name : 'message',
		type : 'string',
		sortable : true
	}, {
		name : 'score',
		type : 'string',
		sortable : true
	} ]
});
