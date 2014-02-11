var _csContractDetailInfoWindow = false;
Ext
		.define(
				'Fes.view.CsContractDetailInfoList',
				{
					extend : 'Ext.grid.Panel',
					alias : 'widget.csContractDetailInfolist',
					title : '[合同明细]列表',
					requires : [ "Fes.util.ParameterComboTree",
									'Ext.toolbar.Paging' ],// add here
					iconCls : 'icon-grid-list',
					rowLines : true,
					columnLines : true,
					multiSelect : true,
					simpleSelect : true,
					viewConfig : {
						loadingText : '正在加载[合同明细]列表'
					},
					createRoleCombox : function() {

					},
					columns : [ {
						xtype : 'rownumberer'
					}, {
						text : '合同/销单/签证编号',
						width : 120,
						sortable : true,
						dataIndex : 'contractNumber',
						field : {
							emptyText : '合同/销单/签证编号',
							xtype : 'textfield',
							required : true
						}
					},

					{
						text : '客户名称',
						width : 120,
						sortable : true,
						dataIndex : 'customerName',
						field : {
							emptyText : '客户名称',
							xtype : 'textfield',
							required : true
						}
					},					{
						text : '设备名称',
						width : 120,
						sortable : true,
						dataIndex : 'deviceName',
						field : {
							emptyText : '设备名称',
							xtype : 'textfield',
							required : true
						}
					},

					{
					text : '设备型号',
					width : 120,
					renderer : function(v, c, r) {
						return r.data.deviceModelName;
					},
					sortable : true,
					dataIndex : 'deviceModel',
					field : {
						emptyText : '设备型号',
						xtype : 'parameterComboTree',
						rootText : '功能',
						rootId : '1',
						storeUrl : 'sysParameter/getTreeNodeChildren',
						id : 'csContractDetailInfo' + 'deviceModel',
						selectMode : 'all',
						treeHeight : 300,
						rootVisible : false
					}
					},

					{
						text : '设备单价',
						width : 120,
						sortable : true,
						dataIndex : 'equipmentPrice',
						field : {
							emptyText : '设备单价',
							xtype : 'textfield',
							required : true
						}
					},

					{
						text : '设备数量',
						width : 120,
						sortable : true,
						dataIndex : 'deviceNumber',
						field : {
							emptyText : '设备数量',
							xtype : 'textfield',
							required : true
						}
					}, {
						text : 'SIM卡开始时间',
						width : 120,
						sortable : true,
						renderer : function(v) {
							if (!v || v == '') {
								return;
							}
							var d = new Date();
							d.setTime(v);
							return Ext.util.Format.date(d, 'Y-m-d');
						},
						dataIndex : 'openDate',
						field : {
							emptyText : 'SIM卡开始时间',
							xtype : 'datefield',
							format : 'Y-m-d'
						}
					},

					{
						text : 'SIM卡结束时间',
						width : 120,
						sortable : true,
						renderer : function(v) {
							if (!v || v == '') {
								return;
							}
							var d = new Date();
							d.setTime(v);
							return Ext.util.Format.date(d, 'Y-m-d');
						},
						dataIndex : 'endDate',
						field : {
							emptyText : 'SIM卡结束时间',
							xtype : 'datefield',
							format : 'Y-m-d'
						}
					},

					// {text : 'remark1',width : 120,sortable : true,dataIndex :
					// 'remark1',field : {xtype : 'textfield',required : true}},
					//		 	 		
					// {text : 'remark2',width : 120,sortable : true,dataIndex :
					// 'remark2',field : {xtype : 'textfield',required : true}},
					//		 	 		
					// {text : 'remark3',width : 120,sortable : true,dataIndex :
					// 'remark3',field : {xtype : 'textfield',required : true}},
					//		 	 		
					// {text : 'remark4',width : 120,sortable : true,dataIndex :
					// 'remark4',field : {xtype : 'textfield',required : true}},
					//		 	 		
					// {text : 'remark5',width : 120,sortable : true,dataIndex :
					// 'remark5',field : {xtype : 'textfield',required : true}},
					//		 	 		
					// {text : 'remark6',width : 120,sortable : true,dataIndex :
					// 'remark6',field : {xtype : 'textfield',required : true}},
					//		 	 		
					// {text : 'remark7',width : 120,sortable : true,dataIndex :
					// 'remark7',field : {xtype : 'textfield',required : true}},
					//		 	 		
					// {text : 'remark8',width : 120,sortable : true,dataIndex :
					// 'remark8',field : {xtype : 'textfield',required : true}},
					//		 	 		
					// {text : 'remark9',width : 120,sortable : true,dataIndex :
					// 'remark9',field : {xtype : 'textfield',required : true}},
					//		 	 		
					// {text : 'remark10',width : 120,sortable : true,dataIndex
					// : 'remark10',field : {xtype : 'textfield',required :
					// true}},
					//		 	 		
					// {text : 'remark11',width : 120,sortable : true,dataIndex
					// : 'remark11',field : {xtype : 'textfield',required :
					// true}},
					//		 	 		
					// {text : 'remark12',width : 120,sortable : true,dataIndex
					// : 'remark12',field : {xtype : 'textfield',required :
					// true}},

					// {text : 'remark14',width : 120,sortable : true,dataIndex
					// : 'remark14',field : {xtype : 'textfield',required :
					// true}},
					//		 	 		
					// {text : 'remark15',width : 120,sortable : true,dataIndex
					// : 'remark15',field : {xtype : 'textfield',required :
					// true}},
					//		 	 		
					// {text : 'remark16',width : 120,sortable : true,dataIndex
					// : 'remark16',field : {xtype : 'textfield',required :
					// true}},
					//		 	 		
					// {text : 'remark17',width : 120,sortable : true,dataIndex
					// : 'remark17',field : {xtype : 'textfield',required :
					// true}},
					//		 	 		
					// {text : 'remark18',width : 120,sortable : true,dataIndex
					// : 'remark18',field : {xtype : 'textfield',required :
					// true}},
					//		 	 		
					// {text : 'remark19',width : 120,sortable :
					// true,renderer:function(v){if(!v||v==''){return;}var d=
					// new Date();d.setTime(v); return
					// Ext.util.Format.date(d,'Y-m-d');},dataIndex :
					// 'remark19',field : {xtype : 'datefield',
					// format:'Y-m-d'}},
					//		 	 		
					//		 	 		
					// {text : 'remark20',width : 120,sortable :
					// true,renderer:function(v){if(!v||v==''){return;}var d=
					// new Date();d.setTime(v); return
					// Ext.util.Format.date(d,'Y-m-d');},dataIndex :
					// 'remark20',field : {xtype : 'datefield',
					// format:'Y-m-d'}},

					{
						text : 'id',
						width : 120,
						sortable : true,
						dataIndex : 'id',
						hidden : true
					}

					],
					initComponent : function() {

						this.createStore();

						this.rowEditor = Ext
								.create(
										'Ext.grid.plugin.RowEditing',
										{
											id : 'csContractDetailInfoListRowEditor',
											listeners : {
												beforeedit : function(editor,e, eOpts) {
													// add here
													Ext.getCmp('csContractDetailInfo' + 'deviceModel')
													.setLocalValue(e.record.data.deviceModel, e.record.data.deviceModelName);
													
													console.log(e.record.data.deviceModel);
													console.log(e.record.data.deviceModelName);
													
													var d = new Date();
													if (e.record.data.openDate > 0) {
														d
																.setTime(e.record.data.openDate);
														e.record.data.openDate = d;
													}

													var d = new Date();
													if (e.record.data.endDate > 0) {
														d
																.setTime(e.record.data.endDate);
														e.record.data.endDate = d;
													}

													var d = new Date();
													if (e.record.data.remark19 > 0) {
														d
																.setTime(e.record.data.remark19);
														e.record.data.remark19 = d;
													}

													var d = new Date();
													if (e.record.data.remark20 > 0) {
														d
																.setTime(e.record.data.remark20);
														e.record.data.remark20 = d;
													}
												},
												startEdit : function(record,
														columnHeader) {
													// add here
													Ext.getCmp('csContractDetailInfo' + 'deviceModel')
													.setLocalValue(e.record.data.deviceModel, e.record.data.deviceModelName);
													this.editRecord = record;
												},
												edit : function(editor, e) {
													var me = this;
													// add here
													e.record.data.deviceModel = Ext.getCmp('csContractDetailInfo' + 'deviceModel').getValue();
													e.record.data.deviceModelName = Ext.getCmp('csContractDetailInfo' + 'deviceModel').getTextValue();
													e.record
															.save({
																success : function(csContractDetailInfo,options) {
																	var data = Ext.decode(options.response.responseText);
																	if (data.extra) {
																		csContractDetailInfo.set('id',data.extra);
																	}
																	// add here
																	csContractDetailInfo.data.deviceModelName = Ext.getCmp('csContractDetailInfo' + 'deviceModel').getTextValue();
																	csContractDetailInfo
																			.commit();
																}
															});

												}
											}
										});

						;
						this.plugins = [ this.rowEditor ], this.tbar = this
								.createToolbar();
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
							var record = new Fes.model.CsContractDetailInfoModel(
									records[records.length - 1].data);

							this.showWindow(record);
						} else {
							Ext.Msg.alert('提示：', '请先选择需要编辑的记录！');
						}

					},

					saveRecode : function(obj) {
						var record = new Fes.model.CsContractDetailInfoModel(
								obj);
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
						me.store = Ext
								.create('Fes.store.CsContractDetailInfoStore');
						me.store.on('beforeload', function (store, options) {
				             var params = { paramsDeviceName : Ext.getCmp('csContractDetailInfoListDeviceName').getValue(),
										paramsDeviceModel : Ext.getCmp('csContractDetailInfo' + 'deviceModelQ').getValue()};
				        Ext.apply(me.store.proxy.extraParams, params); 
				    });
					},

					addRecord : function() {
						var records = this.getSelectionModel().getSelection();
						var record = new Fes.model.CsContractDetailInfoModel({

						});

						if (records.length > 0) {
							// record = records[records.length-1];
							record = new Fes.model.CsContractDetailInfoModel(
									{

										contractNumber : records[records.length - 1].data.contractNumber,

										deviceName : records[records.length - 1].data.deviceName,

										deviceModel : records[records.length - 1].data.deviceModel,

										equipmentPrice : records[records.length - 1].data.equipmentPrice,

										openDate : records[records.length - 1].data.openDate,

										endDate : records[records.length - 1].data.endDate,

										remark1 : records[records.length - 1].data.remark1,

										remark2 : records[records.length - 1].data.remark2,

										remark3 : records[records.length - 1].data.remark3,

										remark4 : records[records.length - 1].data.remark4,

										remark5 : records[records.length - 1].data.remark5,

										remark6 : records[records.length - 1].data.remark6,

										remark7 : records[records.length - 1].data.remark7,

										remark8 : records[records.length - 1].data.remark8,

										remark9 : records[records.length - 1].data.remark9,

										remark10 : records[records.length - 1].data.remark10,

										remark11 : records[records.length - 1].data.remark11,

										remark12 : records[records.length - 1].data.remark12,

										deviceNumber : records[records.length - 1].data.deviceNumber,

										remark14 : records[records.length - 1].data.remark14,

										remark15 : records[records.length - 1].data.remark15,

										remark16 : records[records.length - 1].data.remark16,

										remark17 : records[records.length - 1].data.remark17,

										remark18 : records[records.length - 1].data.remark18,

										remark19 : records[records.length - 1].data.remark19,

										remark20 : records[records.length - 1].data.remark20

									});
						}

						this.getStore().add(record);
						this.rowEditor.startEdit(record, 1);
					},

					deleteRecord : function() {
						var me = this;
						var records = this.getSelectionModel().getSelection();
						if (records.length > 0) {
							Fes.MsgBox.confirm('确定删除这' + records.length
									+ '个合同明细?', function(btn) {
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
					showWindow : function(rec) {
						var me = this;
						if (!_csContractDetailInfoWindow) {
							_csContractDetailInfoWindow = Ext
									.create(
											'Fes.view.CsContractDetailInfoWindow',
											{
												closeAction : 'hide',
												buttons : [
														{
															text : 'Save5',
															handler : function() {

																// alert(_csContractDetailInfoWindow.down('form').getValues());
																me
																		.saveRecode(_csContractDetailInfoWindow
																				.down(
																						'form')
																				.getValues());

															}
														},
														{
															text : 'Cancel',
															scope : this,
															handler : function() {
																_csContractDetailInfoWindow
																		.hide();
															}
														} ]
											})
						}
						if (rec && rec.data) {
							if (rec.data.signDate > 0) {
								var d = new Date();
								d.setTime(rec.data.signDate);
								rec.data.signDate = d;
							}
							_csContractDetailInfoWindow.down('form')
									.loadRecord(rec);
						}
						_csContractDetailInfoWindow.show();
					},
					createToolbar : function() {
						var me = this;
						return Ext
								.create(
										'Ext.toolbar.Toolbar',
										{
											items : [
														{
															xtype : 'textfield',
															emptyText : '客户名称条件暂不可用',
															readOnly: true,
															labelWidth : 20,
															flex : .6,
															id : 'csContractDetailInfoListCustomerName'
														},													
														{
															xtype : 'textfield',
															emptyText : '设备名称',
															labelWidth : 20,
															flex : .6,
															id : 'csContractDetailInfoListDeviceName'
														},
													{
															xtype : 'parameterComboTree',
															rootText : '功能',
															emptyText: '设备型号',
															rootId : '1',
															storeUrl : 'sysParameter/getTreeNodeChildren',
															id : 'csContractDetailInfo' + 'deviceModelQ',
															selectMode : 'all',
															treeHeight : 300,
															rootVisible : false
													},
													{
														xtype : 'button',
														text : '查询',
														iconCls : 'icon-search',
														handler : function() {
															me
																	.getStore()
																	.load(
																			/*{
																				params : {
																					paramsDeviceName : Ext.getCmp('csContractDetailInfoListDeviceName').getValue(),
																					paramsDeviceModel : Ext.getCmp('csContractDetailInfo' + 'deviceModelQ').getValue()
																				}
																			}*/);
														}

													},
													{
														xtype : 'button',
														text : ' 清空',
														iconCls : 'icon-no',
														handler : function() {
															Ext.getCmp('csContractDetailInfoListDeviceName').reset();
															Ext.getCmp('csContractDetailInfo' + 'deviceModelQ').setLocalValue(null, null);
														}
													},
													'-',
													Ext
															.create(
																	'Ext.Button',
																	{
																		text : '弹窗添加',
																		iconCls : 'icon-add',
																		handler : me.showWindow,
																		scope : me
																	}),
													Ext.create('Ext.Button', {
														text : '页面添加',
														iconCls : 'icon-add',
														handler : me.addRecord,
														scope : me
													}),
													'-',
													Ext
															.create(
																	'Ext.Button',
																	{
																		text : '编辑',
																		iconCls : 'icon-edit',
																		handler : me.editRecord,
																		scope : me
																	}),
													'-',
													{
														xtype : 'button',
														text : '删除',
														iconCls : 'icon-del',
														handler : me.deleteRecord,
														scope : me
													} ]
										});
					}
				});