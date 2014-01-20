var _customerInfoWindow=false;
Ext.define('Fes.view.CustomerInfoList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.customerInfolist',
	title : '角色列表',
 
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	multiSelect : true,
	simpleSelect : true,
	viewConfig : {
		loadingText : '正在加载人员列表'
	},
createRoleCombox:function(){
 
},
	columns : [	
	{xtype : 'rownumberer'}, 
					{text : 'area',width : 120,sortable : true,dataIndex : 'area',field : {xtype : 'textfield',required : true}},
					{text : 'customerName',width : 120,sortable : true,dataIndex : 'customerName',field : {xtype : 'textfield',required : true}},
					{text : 'customerType',width : 120,sortable : true,dataIndex : 'customerType',field : {xtype : 'textfield',required : true}},
					{text : 'contractNumber',width : 120,sortable : true,dataIndex : 'contractNumber',field : {xtype : 'textfield',required : true}},
					{text : 'contractName',width : 120,sortable : true,dataIndex : 'contractName',field : {xtype : 'textfield',required : true}},
					{text : 'contractType',width : 120,sortable : true,dataIndex : 'contractType',field : {xtype : 'textfield',required : true}},
					{text : 'projectNumber',width : 120,sortable : true,dataIndex : 'projectNumber',field : {xtype : 'textfield',required : true}},
					{text : 'signDate',width : 120,sortable : true,dataIndex : 'signDate',field : {xtype : 'textfield',required : true}},
					{text : 'endDate',width : 120,sortable : true,dataIndex : 'endDate',field : {xtype : 'textfield',required : true}},
					{text : 'contractMoney',width : 120,sortable : true,dataIndex : 'contractMoney',field : {xtype : 'textfield',required : true}},
					{text : 'settlementMoney',width : 120,sortable : true,dataIndex : 'settlementMoney',field : {xtype : 'textfield',required : true}},
					{text : 'projectInfo',width : 120,sortable : true,dataIndex : 'projectInfo',field : {xtype : 'textfield',required : true}},
					{text : 'firstPaymoney',width : 120,sortable : true,dataIndex : 'firstPaymoney',field : {xtype : 'textfield',required : true}},
					{text : 'firstPaymoneyDate',width : 120,sortable : true,dataIndex : 'firstPaymoneyDate',field : {xtype : 'textfield',required : true}},
					{text : 'secondPaymoney',width : 120,sortable : true,dataIndex : 'secondPaymoney',field : {xtype : 'textfield',required : true}},
					{text : 'secondPaymoneyDate',width : 120,sortable : true,dataIndex : 'secondPaymoneyDate',field : {xtype : 'textfield',required : true}},
					{text : 'endPaymoney',width : 120,sortable : true,dataIndex : 'endPaymoney',field : {xtype : 'textfield',required : true}},
					{text : 'endPaymoneyDate',width : 120,sortable : true,dataIndex : 'endPaymoneyDate',field : {xtype : 'textfield',required : true}},
					{text : 'otherPaymoney',width : 120,sortable : true,dataIndex : 'otherPaymoney',field : {xtype : 'textfield',required : true}},
					{text : 'otherPaymoneyDate',width : 120,sortable : true,dataIndex : 'otherPaymoneyDate',field : {xtype : 'textfield',required : true}},
					{text : 'remark1',width : 120,sortable : true,dataIndex : 'remark1',field : {xtype : 'textfield',required : true}},
					{text : 'remark2',width : 120,sortable : true,dataIndex : 'remark2',field : {xtype : 'textfield',required : true}},
					{text : 'remark3',width : 120,sortable : true,dataIndex : 'remark3',field : {xtype : 'textfield',required : true}},
					{text : 'remark4',width : 120,sortable : true,dataIndex : 'remark4',field : {xtype : 'textfield',required : true}},
					{text : 'remark5',width : 120,sortable : true,dataIndex : 'remark5',field : {xtype : 'textfield',required : true}},
					{text : 'remark6',width : 120,sortable : true,dataIndex : 'remark6',field : {xtype : 'textfield',required : true}},
					{text : 'remark7',width : 120,sortable : true,dataIndex : 'remark7',field : {xtype : 'textfield',required : true}},
					{text : 'remark8',width : 120,sortable : true,dataIndex : 'remark8',field : {xtype : 'textfield',required : true}},
					{text : 'remark9',width : 120,sortable : true,dataIndex : 'remark9',field : {xtype : 'textfield',required : true}},
					{text : 'remark10',width : 120,sortable : true,dataIndex : 'remark10',field : {xtype : 'textfield',required : true}},
					{text : 'remark11',width : 120,sortable : true,dataIndex : 'remark11',field : {xtype : 'textfield',required : true}},
					{text : 'remark12',width : 120,sortable : true,dataIndex : 'remark12',field : {xtype : 'textfield',required : true}},
					{text : 'remark13',width : 120,sortable : true,dataIndex : 'remark13',field : {xtype : 'textfield',required : true}},
					{text : 'remark14',width : 120,sortable : true,dataIndex : 'remark14',field : {xtype : 'textfield',required : true}},
					{text : 'remark15',width : 120,sortable : true,dataIndex : 'remark15',field : {xtype : 'textfield',required : true}},
					{text : 'remark16',width : 120,sortable : true,dataIndex : 'remark16',field : {xtype : 'textfield',required : true}},
					{text : 'remark17',width : 120,sortable : true,dataIndex : 'remark17',field : {xtype : 'textfield',required : true}},
					{text : 'remark18',width : 120,sortable : true,dataIndex : 'remark18',field : {xtype : 'textfield',required : true}},
					{text : 'remark19',width : 120,sortable : true,dataIndex : 'remark19',field : {xtype : 'textfield',required : true}},
					{text : 'remark20',width : 120,sortable : true,dataIndex : 'remark20',field : {xtype : 'textfield',required : true}},
	 	 		
	 	 		{text : 'id',width : 120,sortable : true,dataIndex : 'id',hidden:true}
	 	 		
	],
	initComponent : function() {
	 
		this.createStore();
		 
		this.rowEditor = Ext.create('Ext.grid.plugin.RowEditing', {
				id:'customerInfoListRowEditor',
				listeners : {
					beforeedit:function( editor,  e,  eOpts ){
					},
					startEdit:function(record, columnHeader ){
			
						this.editRecord=record;
					},
					edit : function(editor, e) {
					 
						e.record.save({
									success : function(customerInfo, options) {
										var data = Ext.decode(options.response.responseText);
										if (data.extra) {
											customerInfo.set('id', data.extra);
										}
										customerInfo.commit();
									}
								});
	
					}
				}
			});
		 
		;
		this.plugins = [this.rowEditor], this.tbar = this.createToolbar();
		this.bbar = {
			xtype : 'pagingtoolbar',
			store : this.store,
			displayInfo : true
		};
		this.callParent();
		
	},
saveRecode:function(obj){
		var record = new Fes.model.CustomerInfoModel(obj);
		this.getStore().add(record);
		record.save({
			success : function(vo, options) {
				var data = Ext
						.decode(options.response.responseText);
				if (data.extra) {
					vo.set('id', data.extra);
				}
				vo.commit();
			}
		}); 
	},
	createStore : function() {
		var me = this;
		me.store = Ext.create('Fes.store.CustomerInfoStore');
	},

	addRecord : function() {
		var records = this.getSelectionModel().getSelection();
		var record = new Fes.model.CustomerInfoModel({
			
		});

		if (records.length > 0){
			// record =	records[records.length-1];
			record= new Fes.model.CustomerInfoModel({
			
						area:records[records.length-1].data.area,
				 	
						customerName:records[records.length-1].data.customerName,
				 	
						customerType:records[records.length-1].data.customerType,
				 	
						contractNumber:records[records.length-1].data.contractNumber,
				 	
						contractName:records[records.length-1].data.contractName,
				 	
						contractType:records[records.length-1].data.contractType,
				 	
						projectNumber:records[records.length-1].data.projectNumber,
				 	
						signDate:records[records.length-1].data.signDate,
				 	
						endDate:records[records.length-1].data.endDate,
				 	
						contractMoney:records[records.length-1].data.contractMoney,
				 	
						settlementMoney:records[records.length-1].data.settlementMoney,
				 	
						projectInfo:records[records.length-1].data.projectInfo,
				 	
						firstPaymoney:records[records.length-1].data.firstPaymoney,
				 	
						firstPaymoneyDate:records[records.length-1].data.firstPaymoneyDate,
				 	
						secondPaymoney:records[records.length-1].data.secondPaymoney,
				 	
						secondPaymoneyDate:records[records.length-1].data.secondPaymoneyDate,
				 	
						endPaymoney:records[records.length-1].data.endPaymoney,
				 	
						endPaymoneyDate:records[records.length-1].data.endPaymoneyDate,
				 	
						otherPaymoney:records[records.length-1].data.otherPaymoney,
				 	
						otherPaymoneyDate:records[records.length-1].data.otherPaymoneyDate,
				 	
						remark1:records[records.length-1].data.remark1,
				 	
						remark2:records[records.length-1].data.remark2,
				 	
						remark3:records[records.length-1].data.remark3,
				 	
						remark4:records[records.length-1].data.remark4,
				 	
						remark5:records[records.length-1].data.remark5,
				 	
						remark6:records[records.length-1].data.remark6,
				 	
						remark7:records[records.length-1].data.remark7,
				 	
						remark8:records[records.length-1].data.remark8,
				 	
						remark9:records[records.length-1].data.remark9,
				 	
						remark10:records[records.length-1].data.remark10,
				 	
						remark11:records[records.length-1].data.remark11,
				 	
						remark12:records[records.length-1].data.remark12,
				 	
						remark13:records[records.length-1].data.remark13,
				 	
						remark14:records[records.length-1].data.remark14,
				 	
						remark15:records[records.length-1].data.remark15,
				 	
						remark16:records[records.length-1].data.remark16,
				 	
						remark17:records[records.length-1].data.remark17,
				 	
						remark18:records[records.length-1].data.remark18,
				 	
						remark19:records[records.length-1].data.remark19,
				 	
						remark20:records[records.length-1].data.remark20,
				 	
 
								});
		}
		
	
		this.getStore().add(record);
		this.rowEditor.startEdit(record, 1);
	},

	deleteRecord : function() {
		var me = this;
		var records = this.getSelectionModel().getSelection();
		if (records.length > 0) {
			Fes.MsgBox.confirm('确定删除这' + records.length + '个客户信息?',
					function(btn) {
						Ext.each(records, function(record) {
									if (Ext.Array.contains(me.getStore()
													.getNewRecords(), record)) {
										me.getStore().remove(record);
									} else {
										record.destroy({
													success : function() {
														me.store.remove(record);
													}
												});
									}
								});
					});
		}

	},
	showWindow:function(rec){ 
		var me = this;
		if(!_customerInfoWindow){
			_customerInfoWindow= Ext.create('Fes.view.CustomerInfoWindow', { 
				buttons : [
				            {
				                text: 'Save5',
				                handler: function(){
				                	  
				            		  
				            			//alert(_customerInfoWindow.down('form').getValues());
				            			me.saveRecode(_customerInfoWindow.down('form').getValues());
				            		 
				                }
				            },
				            {
				                text: 'Cancel',
				                scope: this,
				                handler: function(){
				                	_customerInfoWindow.hide();
				                }
				            }
				        ]
			})
			 
		}
		_customerInfoWindow.show();
	},
	createToolbar : function() {
		var me = this;
		return Ext.create('Ext.toolbar.Toolbar', {
					items : [{
								xtype : 'textfield',
								fieldLabel : 'ID',
								labelWidth : 40,
								flex : .6,
								id : 'customerInfoId'
							},{
								xtype : 'button',
								text : '查询',
								iconCls : 'icon-search',
								handler : function() {
									me.getStore().load({
										params : {
											id : Ext.getCmp('customerInfoId').getValue()
										}
									});
								}
							}, '-', Ext.create('Ext.Button', {
								text : '添加1',
								iconCls : 'icon-add',
								handler : me.showWindow,
								scope : me
							}),Ext.create('Ext.Button', {
										text : '添加',
										iconCls : 'icon-add',
										handler : me.addRecord,
										scope : me
									}),  '-', {
								xtype : 'button',
								text : '删除',
								iconCls : 'icon-del',
								handler : me.deleteRecord,
								scope : me
							}]
				});
	}
});