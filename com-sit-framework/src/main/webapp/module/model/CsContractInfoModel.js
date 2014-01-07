Ext.define("Fes.model.CsContractInfoModel",{
	extend:'Ext.data.Model',
	fields:[
			
			{name:'area',type:'string'}	,	//数据项含义
			
			{name:'customerName',type:'string'}	,	//区域
			
			{name:'customerType',type:'string'}	,	//客户名称
			
			{name:'contractNumber',type:'string'}	,	//客户类型
			
			{name:'contractName',type:'string'}	,	//合同编号/销单编号/签证编号
			
			{name:'contractType',type:'string'}	,	//合同名称
			
			{name:'projectNumber',type:'string'}	,	//合同类型
			
			{name:'signDate',type:'string'}	,	//项目编号
			
			{name:'endDate',type:'string'}	,	//签订时间
			
			{name:'contractMoney',type:'string'}	,	//到期时间
			
			{name:'settlementMoney',type:'string'}	,	//合同额
			
			{name:'projectInfo',type:'string'}	,	//结算凭证金额
			
			{name:'firstPaymoney',type:'string'}	,	//是否立项
			
			{name:'firstPaymoneyDate',type:'string'}	,	//首付款金额
			
			{name:'secondPaymoney',type:'string'}	,	//首付款回款时间
			
			{name:'secondPaymoneyDate',type:'string'}	,	//第二笔金额
			
			{name:'endPaymoney',type:'string'}	,	//第二笔回款时间
			
			{name:'endPaymoneyDate',type:'string'}	,	//尾款金额
			
			{name:'otherPaymoney',type:'string'}	,	//尾款回款时间
			
			{name:'otherPaymoneyDate',type:'string'}	,	//其他回款金额
			
			{name:'remark1',type:'string'}	,	//备用字段1
			
			{name:'remark2',type:'string'}	,	//备用字段2
			
			{name:'remark3',type:'string'}	,	//备用字段3
			
			{name:'remark4',type:'string'}	,	//备用字段4
			
			{name:'remark5',type:'string'}	,	//备用字段5
		{name:'id',type:'int'}
		 
	],
	
	   proxy:{
    	 
        type : 'rest',
        url:'csContractInfos',
        actionMethods:{
        	  create : 'POST',
              read   : 'GET',
              update : 'PUT',
              destroy: 'DELETE' 
        	
        },
        api:{
        	create:'csContractInfo/create',
        	read:'csContractInfo/list',
        	update:'csContractInfo/update',
        	destroy:'csContractInfo/destroy' 
        	 
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