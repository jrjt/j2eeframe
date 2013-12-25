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
        url:'${entityName?uncap_first}s',
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