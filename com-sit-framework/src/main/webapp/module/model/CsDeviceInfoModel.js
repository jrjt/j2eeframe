Ext.define("Fes.model.CsDeviceInfoModel",{
	extend:'Ext.data.Model',
	fields:[
				{name:'deviceName',type:'string'}	,	//设备名称
			
			
				{name:'deviceModel',type:'string'}	,	//设备型号
				{name:'deviceModelName',type:'string'}	,//设备型号名
			
				{name:'deviceCode',type:'string'}	,	//设备编码
			
			
				{name:'deviceNumber',type:'string'}	,	//设备数量
			
			
				{name:'updateDate',type:'auto'}	,	//设备更新日期
			
				{name:'updateUser',type:'string'}	,	//设备更新人
			
			
				{name:'operationMode',type:'string'}	,	//设备操作方式
				{name:'operationModeName',type:'string'}	,//设备操方式名
			
				{name:'deviceDestination',type:'string'}	,	//设备去向 
			
			
				{name:'deviceQuestionInfo',type:'string'}	,	//设备问题说明
			
			
				{name:'remark1',type:'string'}	,	//remark1
			
			
				{name:'remark2',type:'string'}	,	//remark2
			
			
				{name:'remark3',type:'string'}	,	//remark3
			
			
				{name:'remark4',type:'string'}	,	//remark4
			
			
				{name:'remark5',type:'string'}	,	//remark5
			
			
				{name:'remark6',type:'string'}	,	//remark6
			
			
				{name:'remark7',type:'string'}	,	//remark7
			
			
				{name:'remark8',type:'string'}	,	//remark8
			
			
				{name:'remark9',type:'string'}	,	//remark9
			
			
				{name:'remark10',type:'string'}	,	//remark10
			
			
				{name:'remark11',type:'string'}	,	//remark11
			
			
				{name:'remark12',type:'string'}	,	//remark12
			
			
				{name:'remark13',type:'string'}	,	//remark13
			
			
				{name:'remark14',type:'string'}	,	//remark14
			
			
				{name:'remark15',type:'string'}	,	//remark15
			
			
				{name:'remark16',type:'string'}	,	//remark16
			
			
				{name:'remark17',type:'string'}	,	//remark17
			
			
				{name:'remark18',type:'string'}	,	//remark18
			
			
				{name:'remark19',type:'auto'}	,	//remark19
			
				{name:'remark20',type:'auto'}	,	//remark20
			
		{name:'id',type:'int'}
		 
	],
	
	   proxy:{
		   appendId:false,
        type : 'rest',
        url:'csDeviceInfo',
        actionMethods:{
        	  create : 'POST',
              read   : 'GET',
              update : 'PUT',
              destroy: 'DELETE' 
        	
        },
        api:{
        	create:'csDeviceInfo/create',
        	read:'csDeviceInfo/list',
        	update:'csDeviceInfo/update',
        	destroy:'csDeviceInfo/delete' 
        	 
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