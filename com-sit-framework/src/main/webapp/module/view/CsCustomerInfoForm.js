Ext.define('Fes.view.CsCustomerInfoForm', {
	extend : 'Ext.form.Panel',
	xtype : 'cscustomerinfoform',
	alias : 'widget.cscustomerinfoform',

	frame : true,
	bodyPadding : 10,
	border : 0,
	id : 'cscustomerinfoform-id',
	fieldDefaults : {
		labelAlign : 'right',
		anchor : '99%',
		labelWidth : 110
	},
	defaults : {
		layout : 'anchor',
		defaults : {
			anchor : '100%'
		}
	},
	layout : 'column',
	items : [
	// varchar2
	{
		xtype : 'parameterComboTree',
		rootText : '功能',
		rootId : '1',
		storeUrl : 'sysParameter/getTreeNodeChildren',
		id : 'sysParameterlist' + 'SysParameterComboTree',
		selectMode : 'all',
		treeHeight : 300,
		rootVisible : false,
		
//		xtype : 'textfield',
		allowBlank : false,
		columnWidth : 1 / 4,
		fieldLabel : '区域',
		name : 'area'
	},

	// varchar2
	{
		xtype : 'textfield',
		allowBlank : false,
		columnWidth : 1 / 4,
		fieldLabel : '客户名称',
		name : 'customerName'
	},

	// char
	{
		xtype : 'parameterComboTree',
		rootText : '功能',
		rootId : '1',
		storeUrl : 'sysParameter/getTreeNodeChildren',
		id : 'sysParameterlist' + 'customerName',
		selectMode : 'all',
		treeHeight : 300,
		rootVisible : false,
		
//		xtype : 'textfield',
		allowBlank : false,
		columnWidth : 1 / 4,
		fieldLabel : '客户类型',
		name : 'customerType'
	},

	// number
	{
		xtype : 'numberfield',
		allowBlank : false,
		columnWidth : 1 / 4,
		fieldLabel : '联系电话',
		name : 'customerTel'
	},
	// varchar2
	{
		xtype : 'textfield',
		allowBlank : false,
		columnWidth : 1 / 4,
		fieldLabel : '客户联系人',
		name : 'customerPeople'
	},

	// varchar2
	{
		xtype : 'textfield',
		allowBlank : false,
		columnWidth : 1 / 4,
		fieldLabel : '详细地址',
		name : 'customerAddress'
	},

	// number
	{
		xtype : 'numberfield',
		allowBlank : false,
		columnWidth : 1 / 4,
		fieldLabel : '单位税号',
		name : 'unitNumber'
	},
	// number
	{
		xtype : 'numberfield',
		allowBlank : false,
		columnWidth : 1 / 4,
		fieldLabel : '开户行账号',
		name : 'accountNumber'
	},
	// number
	{
		xtype : 'numberfield',
		allowBlank : false,
		columnWidth : 1 / 4,
		fieldLabel : '邮政编码',
		name : 'postalNumber'
	},
	// varchar2
	// {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel:
	// 'remark1',name: 'remark1'},
	//	      	 
	// //varchar2
	// {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel:
	// 'remark2',name: 'remark2'},
	//	      	 
	// //varchar2
	// {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel:
	// 'remark3',name: 'remark3'},
	//	      	 
	// //varchar2
	// {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel:
	// 'remark4',name: 'remark4'},
	//	      	 
	// //varchar2
	// {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel:
	// 'remark5',name: 'remark5'},
	//	      	 
	// //varchar2
	// {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel:
	// 'remark6',name: 'remark6'},
	//	      	 
	// //varchar2
	// {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel:
	// 'remark7',name: 'remark7'},
	//	      	 
	// //varchar2
	// {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel:
	// 'remark8',name: 'remark8'},
	//	      	 
	// //varchar2
	// {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel:
	// 'remark9',name: 'remark9'},
	//	      	 
	// //varchar2
	// {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel:
	// 'remark10',name: 'remark10'},
	//	      	 
	// //varchar2
	// {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel:
	// 'remark11',name: 'remark11'},
	//	      	 
	// //varchar2
	// {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel:
	// 'remark12',name: 'remark12'},
	//	      	 
	// //number
	// {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel:
	// 'remark13',name: 'remark13'},
	// //number
	// {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel:
	// 'remark14',name: 'remark14'},
	// //number
	// {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel:
	// 'remark15',name: 'remark15'},
	// //number
	// {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel:
	// 'remark16',name: 'remark16'},
	// //varchar2
	// {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel:
	// 'remark17',name: 'remark17'},
	//	      	 
	// //varchar2
	// {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel:
	// 'remark18',name: 'remark18'},
	//	      	 
	// //date
	// {xtype: 'datefield',format:'Y-m-d',allowBlank:
	// false,columnWidth:1/4,fieldLabel: 'remark19',name: 'remark19'},
	// //date
	// {xtype: 'datefield',format:'Y-m-d',allowBlank:
	// false,columnWidth:1/4,fieldLabel: 'remark20',name: 'remark20'},
	//					
	{
		xtype : 'hidden',
		name : 'id'
	}

	]

});