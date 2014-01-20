 
Ext.define('Fes.view.CustomerInfoForm', {
	extend: 'Ext.form.Panel',
	xtype: 'customerinfoform',
	alias: 'widget.customerinfoform',
	
    frame: true,
    bodyPadding: 10,
    border: 0,
    id: 'customerinfoform-id',
    fieldDefaults: {
        labelAlign: 'left',
        anchor: '99%',
        labelWidth: 100
    },
    defaults:{layout:'anchor',
    		  defaults:{anchor:'100%'}
    },
    layout: 'column',
    items: [
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'area',
	                name: 'area'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'customerName',
	                name: 'customerName'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'customerType',
	                name: 'customerType'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'contractNumber',
	                name: 'contractNumber'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'contractName',
	                name: 'contractName'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'contractType',
	                name: 'contractType'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'projectNumber',
	                name: 'projectNumber'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'signDate',
	                name: 'signDate'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'endDate',
	                name: 'endDate'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'contractMoney',
	                name: 'contractMoney'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'settlementMoney',
	                name: 'settlementMoney'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'projectInfo',
	                name: 'projectInfo'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'firstPaymoney',
	                name: 'firstPaymoney'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'firstPaymoneyDate',
	                name: 'firstPaymoneyDate'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'secondPaymoney',
	                name: 'secondPaymoney'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'secondPaymoneyDate',
	                name: 'secondPaymoneyDate'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'endPaymoney',
	                name: 'endPaymoney'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'endPaymoneyDate',
	                name: 'endPaymoneyDate'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'otherPaymoney',
	                name: 'otherPaymoney'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'otherPaymoneyDate',
	                name: 'otherPaymoneyDate'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'remark1',
	                name: 'remark1'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'remark2',
	                name: 'remark2'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'remark3',
	                name: 'remark3'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'remark4',
	                name: 'remark4'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'remark5',
	                name: 'remark5'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'remark6',
	                name: 'remark6'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'remark7',
	                name: 'remark7'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'remark8',
	                name: 'remark8'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'remark9',
	                name: 'remark9'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'remark10',
	                name: 'remark10'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'remark11',
	                name: 'remark11'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'remark12',
	                name: 'remark12'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'remark13',
	                name: 'remark13'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'remark14',
	                name: 'remark14'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'remark15',
	                name: 'remark15'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'remark16',
	                name: 'remark16'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'remark17',
	                name: 'remark17'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'remark18',
	                name: 'remark18'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'remark19',
	                name: 'remark19'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: 'remark20',
	                name: 'remark20'
	               },
					
					{xtype:'hidden',name:'id'}
						        	
						          
						            
             ]

}); 