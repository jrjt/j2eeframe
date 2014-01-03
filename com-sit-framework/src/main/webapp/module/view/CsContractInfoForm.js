 
Ext.define('Fes.view.CsContractInfoForm', {
	extend: 'Ext.form.Panel',
	xtype: 'cscontractinfoform',
	alias: 'widget.cscontractinfoform',
	
    frame: true,
    bodyPadding: 10,
    border: 0,
    id: 'cscontractinfoform-id',
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
	                fieldLabel: '数据项含义',
	                name: 'area'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '区域',
	                name: 'customerName'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '客户名称',
	                name: 'customerType'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '客户类型',
	                name: 'contractNumber'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '合同/销单/签证编号',
	                name: 'contractName'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '合同名称',
	                name: 'contractType'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '合同类型',
	                name: 'projectNumber'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '项目编号',
	                name: 'signDate'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '签订时间',
	                name: 'endDate'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '到期时间',
	                name: 'contractMoney'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '合同额',
	                name: 'settlementMoney'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '结算凭证金额',
	                name: 'projectInfo'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '是否立项',
	                name: 'firstPaymoney'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '首付款金额',
	                name: 'firstPaymoneyDate'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '首付款回款时间',
	                name: 'secondPaymoney'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '第二笔金额',
	                name: 'secondPaymoneyDate'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '第二笔回款时间',
	                name: 'endPaymoney'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '尾款金额',
	                name: 'endPaymoneyDate'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '尾款回款时间',
	                name: 'otherPaymoney'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '其他回款金额',
	                name: 'otherPaymoneyDate'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '备用字段1',
	                name: 'remark1'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '备用字段2',
	                name: 'remark2'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '备用字段3',
	                name: 'remark3'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '备用字段4',
	                name: 'remark4'
	               },
				 
	        	   {
	           	    xtype: 'textfield',
	           	    allowBlank: false,
	           	    columnWidth:1/4,
	                fieldLabel: '备用字段5',
	                name: 'remark5'
	               },
					
					{xtype:'hidden',name:'id'}
						        	
						          
						            
             ]

}); 