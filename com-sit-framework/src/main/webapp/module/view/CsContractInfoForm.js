 
Ext.define('Fes.view.CsContractInfoForm', {
	extend: 'Ext.form.Panel',
	xtype: 'cscontractinfoform',
	alias: 'widget.cscontractinfoform',
	
    frame: true,
    bodyPadding: 10,
    border: 0,
    id: 'cscontractinfoform-id',
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
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '区域',name: 'area'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '客户名称',name: 'customerName'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '客户类型',name: 'customerType'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '合同/销单/签证编号',name: 'contractNumber'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '合同名称',name: 'contractName'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '合同类型',name: 'contractType'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '项目编号',name: 'projectNumber'},
	      	 
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: '签订时间',name: 'signDate'},
//date
	      	  {xtype: 'datefield',allowBlank: false,columnWidth:1/4,fieldLabel: '到期时间',name: 'endDate'},
//number
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '合同额',name: 'contractMoney'},
//number
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '结算凭证金额',name: 'settlementMoney'},
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '是否立项',name: 'projectInfo'},
	      	 
//number
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '首付款金额',name: 'firstPaymoney'},
//date
	      	  {xtype: 'datefield',allowBlank: false,columnWidth:1/4,fieldLabel: '首付款回款时间',name: 'firstPaymoneyDate'},
//number
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '第二笔金额',name: 'secondPaymoney'},
//date
	      	  {xtype: 'datefield',allowBlank: false,columnWidth:1/4,fieldLabel: '第二笔回款时间',name: 'secondPaymoneyDate'},
//number
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '尾款金额',name: 'endPaymoney'},
//date
	      	  {xtype: 'datefield',allowBlank: false,columnWidth:1/4,fieldLabel: '尾款回款时间',name: 'endPaymoneyDate'},
//number
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '其他回款金额',name: 'otherPaymoney'},
//date
	      	  {xtype: 'datefield',allowBlank: false,columnWidth:1/4,fieldLabel: '其他回款时间',name: 'otherPaymoneyDate'},
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '备用字段1',name: 'remark1'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '备用字段2',name: 'remark2'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '备用字段3',name: 'remark3'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '备用字段4',name: 'remark4'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '备用字段5',name: 'remark5'},
	      	 
					
					{xtype:'hidden',name:'id',value:null}
						        	
						          
						            
             ]

}); 