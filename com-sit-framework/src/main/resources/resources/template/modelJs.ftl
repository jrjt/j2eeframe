Ext.define("Fes.model.${entityName}Model",{
	extend:'Ext.data.Model',
	fields:[
		<#list columns as po>
			
			{name:'${po.fieldName}',type:'string'}	,	//${po.filedComment}
		</#list>
		{name:'id',type:'int'}
		 
	],
	
	   proxy:{
    	 
        type : 'rest',
        url:'csContractInfo',
        actionMethods:{
        	  create : 'POST',
              read   : 'GET',
              update : 'PUT',
              destroy: 'DELETE' 
        	
        },
        api:{
        	create:'${entityName?uncap_first}/create',
        	read:'${entityName?uncap_first}/list',
        	update:'${entityName?uncap_first}/update',
        	destroy:'${entityName?uncap_first}/destroy' 
        	 
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