Ext.define("Fes.model.SysParameterModel",{
	extend:'Ext.data.Model',
	fields:[
			
			{name:'parName',type:'string'}	,	//参数名称
			
			{name:'parCode',type:'string'}	,	//参数代码
			
			{name:'parUpId',type:'string'}	,	//上级参数
		{name:'id',type:'int'}
		 
	],
	
	   proxy:{
    	 
        type : 'rest',
        url:'sysParameter',
        actionMethods:{
        	  create : 'POST',
              read   : 'GET',
              update : 'PUT',
              destroy: 'DELETE' 
        	
        },
        api:{
        	create: 'sysParameter/create',
        	read:   'sysParameter/list',
        	update: 'sysParameter/update',
        	destroy:'sysParameter/delete'   
        	 
        },
        reader:{
            type : 'json',
            root : 'root',
            totalProperty : 'total'// 数据的总数
        },
        writer:{
            type:'json'
            
        }
    }
 
});