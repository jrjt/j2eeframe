 
Ext.define('Fes.view.CsDeviceArrivalInfoForm', {
	extend: 'Ext.form.Panel',
	xtype: 'csdevicearrivalinfoform',
	alias: 'widget.csdevicearrivalinfoform',
	
    frame: true,
    bodyPadding: 10,
    border: 0,
    id: 'csdevicearrivalinfoform-id',
    fieldDefaults: {
        labelAlign: 'right',
        anchor: '99%',
        labelWidth: 110
    },
    defaults:{layout:'anchor',
    		  defaults:{anchor:'100%'}
    },
    layout: 'column',
    items: [
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '设备到货证明ID',name: 'deviceInfoId'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '客户名称',name: 'customerName'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '合同编号/销单编号/签证编号',name: 'contractNumber'},
	      	 
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: '设备到货时间',name: 'deviceDate'}, 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '设备名称',name: 'deviceName'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '设备型号',name: 'deviceModel'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '设备编码',name: 'deviceCode'},
	      	 
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '设备实际数量',name: 'deviceCount'},
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '设备预计数量',name: 'deviceExpectCount'},
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: '更新时间',name: 'updateDate'}, 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '设备更新人',name: 'updateUser'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '设备负责人',name: 'deviceHead'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'remark1',name: 'remark1'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'remark2',name: 'remark2'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'remark3',name: 'remark3'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'remark4',name: 'remark4'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'remark5',name: 'remark5'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'remark6',name: 'remark6'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'remark7',name: 'remark7'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'remark8',name: 'remark8'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'remark9',name: 'remark9'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'remark10',name: 'remark10'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'remark11',name: 'remark11'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'remark12',name: 'remark12'},
	      	 
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'remark13',name: 'remark13'},
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'remark14',name: 'remark14'},
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'remark15',name: 'remark15'},
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'remark16',name: 'remark16'},
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'remark17',name: 'remark17'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'remark18',name: 'remark18'},
	      	 
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: 'remark19',name: 'remark19'}, 
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: 'remark20',name: 'remark20'}, 
					
					{xtype:'hidden',name:'id'}
						        	
						          
						            
             ]

}); 