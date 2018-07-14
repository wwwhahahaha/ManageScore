Ext.define('loginandout.model.LogInandOutModel', {
	extend : 'Ext.data.Model',
	alias : 'widget.loginandoutModel',
	fields : [ {
        name : 'id',
        type : 'int',
        sortable : true
    },  {
		name : 'userName',
		type : 'string',
		sortable : true
	}, {
		name : 'userPasswd',
		type : 'string',
		sortable : true
	} ]
});
