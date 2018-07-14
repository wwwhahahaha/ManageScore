Ext.define('findpasswd.model.FindPasswdModel', {
	extend : 'Ext.data.Model',
	alias : 'widget.findpasswdModel',
	fields : [ {
        name : 'id',
        type : 'int',
        sortable : true
    },  {
		name : 'email',
		type : 'string',
		sortable : true
	}, {
		name : 'userName',
		type : 'string',
		sortable : true
	} ]
});
