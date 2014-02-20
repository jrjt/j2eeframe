var _csDeviceArrivalInfoWindow=false;
Ext.define('Fes.view.CsDeviceArrivalInfoList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.csDeviceArrivalInfolist',
	title : '[设备到货信息]列表',
	requires : [ "Fes.util.ParameterComboTree",
					'Ext.toolbar.Paging' ],// add here
 
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	multiSelect : true,
	simpleSelect : true,
	viewConfig : {
		loadingText : '正在加载[设备到货信息]列表'
	},
createRoleCombox:function(){
 
},
	columns : [	
	{xtype : 'rownumberer'}, 
						{text : '设备到货证明ID',
		                 	width : 120,
		                 	sortable : true,
		                 	dataIndex : 'deviceInfoId',
		                 	field : {
		                 		emptyText: '设备到货证明ID',
		                 		xtype : 'textfield',
		                 		required : true}
							},
		 	 		
						{text :
							'客户名称',
							width : 120,
							sortable : true,
							dataIndex : 'customerName',
							field : {
								emptyText: '客户名称',
								xtype : 'textfield',
								required : true}
							},
		 	 		
						{text : '合同编号/销单编号/签证编号',
							width : 120,
							sortable : true,
							dataIndex : 'contractNumber',
							field : {
								emptyText: '合同编号/销单编号/签证编号',
								xtype : 'textfield',
								required : true}
							},
		 	 		
					{text : '设备到货时间',
							width : 120,
							sortable : true,
							renderer:function(v){
								if(!v||v==''){
									return;
									}
								var d= new Date();
								d.setTime(v);
								return Ext.util.Format.date(d,'Y-m-d');
								},
								dataIndex : 'deviceDate',
								field : {
									emptyText: '设备到货时间',
									xtype : 'datefield',
									format:'Y-m-d'}
								},
		 	 		
		 	 		
						{text : '设备名称',
							width : 120,
							sortable : true,
							dataIndex : 'deviceName',
							field : {
								emptyText: '设备名称',
								xtype : 'textfield',
								required : true
									}
								},
		 	 		
						{text : '设备型号',
							width : 120,
		                    renderer : function(v, c, r) {
		     					return r.data.deviceModelName;
		     					},
		     				sortable : true,
		     				dataIndex : 'deviceModel',
		     				field : {
		     					xtype : 'parameterComboTree',
		     					rootText : '功能',
		     					rootId : '1',
		     					emptyText : '设备型号',
		     					storeUrl : 'sysParameter/getTreeNodeChildren',
		     					id : 'csDeviceArrivalInfolist' + 'deviceModel',
		     					selectMode : 'all',
		     					treeHeight : 300,
		     					rootVisible : false
									}
								},
		 	 		
						{text : '设备编码',
								width : 120,
								sortable : true,
								dataIndex : 'deviceCode',
								field : {
									emptyText: '设备编码',
									xtype : 'textfield',
									required : true
									}
								},
		 	 		
						{text : '设备实际数量',
								width : 120,
								sortable : true,
								dataIndex : 'deviceCount',
								field : {
									emptyText: '设备实际数量',
									xtype : 'textfield',
									required : true
									}
								},
		 	 		
						{text : '设备预计数量',
								width : 120,
								sortable : true,
								dataIndex : 'deviceExpectCount',
								field : {
									emptyText: '设备预计数量',
									xtype : 'textfield',
									required : true
									}
								},
		 	 		
					{text : '更新时间',
								width : 120,
								sortable : true,
								renderer:function(v){
									if(!v||v==''){
										return;
										}
									var d= new Date();
									d.setTime(v);
									return Ext.util.Format.date(d,'Y-m-d')
									;},
									dataIndex : 'updateDate',
									field : {
										emptyText: '更新时间',
										xtype : 'datefield',
										format:'Y-m-d'
											}
									},
		 	 		
		 	 		
						{text : '设备更新人',
							width : 120,
							sortable : true,
							dataIndex : 'updateUser',
							field : {
								emptyText: '设备更新人',
								xtype : 'textfield',
								required : true
								}
							},
		 	 		
						{text : '设备负责人',
							width : 120,
							sortable : true,
							dataIndex : 'deviceHead',
							field : {
								emptyText: '设备负责人',
								xtype : 'textfield',
								required : true
								}
							},
		 	 		
						// {text : 'remark1',width : 120,sortable :
						// true,dataIndex : 'remark1',field : {xtype :
						// 'textfield',required : true}},
		 	 		
						// {text : 'remark2',width : 120,sortable :
						// true,dataIndex : 'remark2',field : {xtype :
						// 'textfield',required : true}},
		 	 		
						// {text : 'remark3',width : 120,sortable :
						// true,dataIndex : 'remark3',field : {xtype :
						// 'textfield',required : true}},
		 	 		
						// {text : 'remark4',width : 120,sortable :
						// true,dataIndex : 'remark4',field : {xtype :
						// 'textfield',required : true}},
		 	 		
						// {text : 'remark5',width : 120,sortable :
						// true,dataIndex : 'remark5',field : {xtype :
						// 'textfield',required : true}},
		 	 		
						// {text : 'remark6',width : 120,sortable :
						// true,dataIndex : 'remark6',field : {xtype :
						// 'textfield',required : true}},
		 	 		
						// {text : 'remark7',width : 120,sortable :
						// true,dataIndex : 'remark7',field : {xtype :
						// 'textfield',required : true}},
		 	 		
						// {text : 'remark8',width : 120,sortable :
						// true,dataIndex : 'remark8',field : {xtype :
						// 'textfield',required : true}},
		 	 		
						// {text : 'remark9',width : 120,sortable :
						// true,dataIndex : 'remark9',field : {xtype :
						// 'textfield',required : true}},
		 	 		
						// {text : 'remark10',width : 120,sortable :
						// true,dataIndex : 'remark10',field : {xtype :
						// 'textfield',required : true}},
		 	 		
						// {text : 'remark11',width : 120,sortable :
						// true,dataIndex : 'remark11',field : {xtype :
						// 'textfield',required : true}},
		 	 		
						// {text : 'remark12',width : 120,sortable :
						// true,dataIndex : 'remark12',field : {xtype :
						// 'textfield',required : true}},
		 	 		
						// {text : 'remark13',width : 120,sortable :
						// true,dataIndex : 'remark13',field : {xtype :
						// 'textfield',required : true}},
		 	 		
						// {text : 'remark14',width : 120,sortable :
						// true,dataIndex : 'remark14',field : {xtype :
						// 'textfield',required : true}},
		 	 		
						// {text : 'remark15',width : 120,sortable :
						// true,dataIndex : 'remark15',field : {xtype :
						// 'textfield',required : true}},
		 	 		
						// {text : 'remark16',width : 120,sortable :
						// true,dataIndex : 'remark16',field : {xtype :
						// 'textfield',required : true}},
		 	 		
						// {text : 'remark17',width : 120,sortable :
						// true,dataIndex : 'remark17',field : {xtype :
						// 'textfield',required : true}},
		 	 		
						// {text : 'remark18',width : 120,sortable :
						// true,dataIndex : 'remark18',field : {xtype :
						// 'textfield',required : true}},
		 	 		
					// {text : 'remark19',width : 120,sortable :
					// true,renderer:function(v){if(!v||v==''){return;}var d=
					// new Date();d.setTime(v); return
					// Ext.util.Format.date(d,'Y-m-d');},dataIndex :
					// 'remark19',field : {xtype : 'datefield',
					// format:'Y-m-d'}},
		 	 		
		 	 		
					// {text : 'remark20',width : 120,sortable :
					// true,renderer:function(v){if(!v||v==''){return;}var d=
					// new Date();d.setTime(v); return
					// Ext.util.Format.date(d,'Y-m-d');},dataIndex :
					// 'remark20',field : {xtype : 'datefield',
					// format:'Y-m-d'}},
		 	 		
		 	 		
	 	 		
	 	 		{text : 'id',width : 120,sortable : true,dataIndex : 'id',hidden:true}
	 	 		
	],
	initComponent : function() {
	 
		this.createStore();
		 
		this.rowEditor = Ext.create('Ext.grid.plugin.RowEditing', {
				id:'csDeviceArrivalInfoListRowEditor',
				listeners : {
					beforeedit:function( editor,  e,  eOpts ){
			//add			      
				      Ext.getCmp('csDeviceArrivalInfolist' + 'deviceModel')
				      .setLocalValue(e.record.data.deviceModel, e.record.data.deviceModelName);
				      
				      console.log(e.record.data.deviceModel);
					  console.log(e.record.data.deviceModelName);
					  
					var d= new Date();if(e.record.data.deviceDate>0){ d.setTime(e.record.data.deviceDate); e.record.data.deviceDate=d;}
					  
					var d= new Date();if(e.record.data.updateDate>0){ d.setTime(e.record.data.updateDate); e.record.data.updateDate=d;}
					  
					var d= new Date();if(e.record.data.remark19>0){ d.setTime(e.record.data.remark19); e.record.data.remark19=d;}
					  
					var d= new Date();if(e.record.data.remark20>0){ d.setTime(e.record.data.remark20); e.record.data.remark20=d;}
					},
					startEdit:function(record, columnHeader ){
						//add
						 Ext.getCmp('csDeviceArrivalInfolist' + 'deviceModel')
					      .setLocalValue(e.record.data.deviceModel, e.record.data.deviceModelName);
						 
						this.editRecord=record;
					},
					edit : function(editor, e) {
						//add
						e.record.data.deviceModel = Ext.getCmp('csDeviceArrivalInfolist' + 'deviceModel').getValue();
						e.record.data.deviceModelName = Ext.getCmp('csDeviceArrivalInfolist' + 'deviceModel').getTextValue();
						
						e.record.save({
									success : function(csDeviceArrivalInfo, options) {
										var data = Ext.decode(options.response.responseText);
										if (data.extra) {
											csDeviceArrivalInfo.set('id', data.extra);
										}
										//add
										csDeviceArrivalInfo.data.deviceModelName = Ext.getCmp('csDeviceInfoList' + 'deviceModel').getTextValue();
										csDeviceArrivalInfo.commit();
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
	
						editRecord : function() {
						var records = this.getSelectionModel().getSelection();
						if (records && records.length > 0) {
							var record = new Fes.model.CsDeviceArrivalInfoModel(
									records[records.length - 1].data);

							this.showWindow(record);
						} else {
							Ext.Msg.alert('提示：', '请先选择需要编辑的记录！');
						}

					},
	
saveRecode:function(obj){
		var record = new Fes.model.CsDeviceArrivalInfoModel(obj);
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
		me.store = Ext.create('Fes.store.CsDeviceArrivalInfoStore');
		me.store.on('beforeload', function (store, options) {
            var params = {
            	paramsCustomerName: Ext.getCmp('csDeviceArrivalInfoCustomerName').getValue(),
            	paramsContractNumber: Ext.getCmp('csDeviceArrivalInfoContractNumber').getValue(),
            	paramsDeviceModel: Ext.getCmp('csDeviceArrivalInfolist' + 'deviceModelQ').getValue()
                };                                                                        
            Ext.apply(me.store.proxy.extraParams, params);                     
	  });     
	},

	addRecord : function() {
		var records = this.getSelectionModel().getSelection();
		var record = new Fes.model.CsDeviceArrivalInfoModel({
			
		});

		if (records.length > 0){
			// record = records[records.length-1];
			record= new Fes.model.CsDeviceArrivalInfoModel({
			
						deviceInfoId:records[records.length-1].data.deviceInfoId,
				 	
						customerName:records[records.length-1].data.customerName,
				 	
						contractNumber:records[records.length-1].data.contractNumber,
				 	
						deviceDate:records[records.length-1].data.deviceDate,
				 	
						deviceName:records[records.length-1].data.deviceName,
				 	
						deviceModel:records[records.length-1].data.deviceModel,
				 	
						deviceCode:records[records.length-1].data.deviceCode,
				 	
						deviceCount:records[records.length-1].data.deviceCount,
				 	
						deviceExpectCount:records[records.length-1].data.deviceExpectCount,
				 	
						updateDate:records[records.length-1].data.updateDate,
				 	
						updateUser:records[records.length-1].data.updateUser,
				 	
						deviceHead:records[records.length-1].data.deviceHead,
				 	
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
				 	
						remark20:records[records.length-1].data.remark20
								});
		}
		
	
		this.getStore().add(record);
		this.rowEditor.startEdit(record, 1);
	},

	deleteRecord : function() {
		var me = this;
		var records = this.getSelectionModel().getSelection();
		if (records.length > 0) {
			Fes.MsgBox.confirm('确定删除这' + records.length + '个设备到货信息?',
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
		if(!_csDeviceArrivalInfoWindow){
			_csDeviceArrivalInfoWindow= Ext.create('Fes.view.CsDeviceArrivalInfoWindow', { 
			    closeAction:'hide',
				buttons : [
				            {
				                text: 'Save5',
				                handler: function(){
				                	  
				            		  
				            			// alert(_csDeviceArrivalInfoWindow.down('form').getValues());
				            			me.saveRecode(_csDeviceArrivalInfoWindow.down('form').getValues());
				            		 
				                }
				            },
				            {
				                text: 'Cancel',
				                scope: this,
				                handler: function(){
				                	_csDeviceArrivalInfoWindow.hide();
				                }
				            }
				        ]
			})
			}
			 						if (rec&&rec.data) {
							if (rec.data.signDate > 0) {
								var d = new Date();
								d.setTime(rec.data.signDate);
								rec.data.signDate = d;
							}
							_csDeviceArrivalInfoWindow.down('form').loadRecord(rec);
		}
		_csDeviceArrivalInfoWindow.show();
	},
	createToolbar : function() {
		var me = this;
		return Ext.create('Ext.toolbar.Toolbar', {
					items : [{
								xtype : 'textfield',
								labelWidth : 20,
							    flex : .0,
							    emptyText:'客户名称',
							    id : 'csDeviceArrivalInfoCustomerName'
							},
							{
								xtype : 'textfield',
								labelWidth : 20,
							    flex : .0,
							    emptyText:'合同编号/销单编号/签证编号',
							    id : 'csDeviceArrivalInfoContractNumber'
							},
							{
								
								xtype : 'parameterComboTree',
								rootText : '功能',
								labelWidth : 20,
								rootId : '1',
								emptyText:'设备型号',
								storeUrl : 'sysParameter/getTreeNodeChildren',
								id : 'csDeviceArrivalInfolist' + 'deviceModelQ',
								selectMode : 'all',
								treeHeight : 300,
								rootVisible : false						
							
							  },
							{
								xtype : 'button',
								text : '查询',
								iconCls : 'icon-search',
								handler : function() {
									me.getStore().load({
										//这个里面的东西要清空
									});
								}
							}, 
							{
								xtype : 'button',
								text : ' 清空',
								iconCls : 'icon-no',
								handler : function() {// 清空搜索条件文本框
									Ext.getCmp('csDeviceArrivalInfoCustomerName').reset();
									Ext.getCmp('csDeviceArrivalInfoContractNumber').reset();
									Ext.getCmp('csDeviceArrivalInfolist' + 'deviceModelQ').setLocalValue(null, null);
								}
								
								
							},
							'-', Ext.create('Ext.Button', {
								text : '弹窗添加',
								iconCls : 'icon-add',
								handler : me.showWindow,
								scope : me
							}),Ext.create('Ext.Button', {
										text : '页面添加',
										iconCls : 'icon-add',
										handler : me.addRecord,
										scope : me
									}),'-',Ext.create('Ext.Button', {
										text : '编辑',
										iconCls : 'icon-edit',
										handler : me.editRecord,
										scope : me
									}),'-', {
								xtype : 'button',
								text : '删除',
								iconCls : 'icon-del',
								handler : me.deleteRecord,
								scope : me
							}]
				});
	}
});