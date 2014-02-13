var _csContractInfoWindow = false;
Ext
		.define(
				'Fes.view.CsContractInfoList',
				{
					extend : 'Ext.grid.Panel',
					alias : 'widget.csContractInfolist',
					title : '[合同信息]列表',
					requires : [ "Fes.util.ParameterComboTree",
									'Ext.toolbar.Paging' ],// add here
					iconCls : 'icon-grid-list',
					rowLines : true,
					columnLines : true,
					multiSelect : true,
					simpleSelect : true,
					viewConfig : {
						loadingText : '正在加载[合同信息]列表'
					},
					createRoleCombox : function() {

					},
					columns : [ {
						xtype : 'rownumberer'
					}, {
						text : '区域',
						renderer : function(v, c, r) {
							return r.data.areaName;
						},
						sortable : true,
						dataIndex : 'area',
						field : Ext.create('Fes.util.ParameterComboTree', {
							width : 110,
							emptyText : '区域',
							xtype : 'parameterComboTree',
							rootText : '功能',
							rootId : '1',
							storeUrl : 'sysParameter/getTreeNodeChildren',
							id : 'csContractInfoList' + 'area',
							selectMode : 'all',
							treeHeight : 300,
							rootVisible : false
						})
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
					},

					{
						text : '客户类型',
						renderer : function(v, c, r) {
							return r.data.customerTypeName;
						},
						sortable : true,
						dataIndex : 'customerType',
						field : Ext.create('Fes.util.ParameterComboTree', {
							width : 110,
							emptyText : '客户类型',
							xtype : 'parameterComboTree',
							rootText : '功能',
							rootId : '1',
							storeUrl : 'sysParameter/getTreeNodeChildren',
							id : 'csContractInfoList' + 'customerType',
							selectMode : 'all',
							treeHeight : 300,
							rootVisible : false
						})
					},

					{
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
						text : '合同名称',
						width : 120,
						sortable : true,
						dataIndex : 'contractName',
						field : {
							emptyText : '合同名称',
							xtype : 'textfield',
							required : true
						}
					},

					{
						text : '合同类型',
						renderer : function(v, c, r) {
							return r.data.contractTypeName;
						},
						sortable : true,
						dataIndex : 'contractType',
						field : Ext.create('Fes.util.ParameterComboTree', {
							width : 110,
							emptyText : '合同类型',
							xtype : 'parameterComboTree',
							rootText : '功能',
							rootId : '1',
							storeUrl : 'sysParameter/getTreeNodeChildren',
							id : 'csContractInfoList' + 'contractType',
							selectMode : 'all',
							treeHeight : 300,
							rootVisible : false
						})
					},

					{
						text : '项目编号',
						width : 120,
						sortable : true,
						dataIndex : 'projectNumber',
						field : {
							emptyText : '项目编号',
							xtype : 'textfield',
							required : true
						}
					},

					{
						text : '签订时间',
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
						dataIndex : 'signDate',
						field : {
							emptyText : '签订时间',
							xtype : 'datefield',
							format : 'Y-m-d'
						}
					},

					{
						text : '到期时间',
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
							emptyText : '到期时间',
							xtype : 'datefield',
							format : 'Y-m-d'
						}
					},

					{
						text : '合同额',
						width : 120,
						sortable : true,
						dataIndex : 'contractMoney',
						field : {
							emptyText : '合同额',
							xtype : 'textfield',
							required : true
						}
					},

					{
						text : '结算凭证金额',
						width : 120,
						sortable : true,
						dataIndex : 'settlementMoney',
						field : {
							emptyText : '结算凭证金额',
							xtype : 'textfield',
							required : true
						}
					},

					{
						text : '是否立项',
						width : 120,
						sortable : true,
						dataIndex : 'projectInfo',
						field : {
							emptyText : '是否立项',
							xtype : 'textfield',
							required : true
						}
					},

					{
						text : '首付款金额',
						width : 120,
						sortable : true,
						dataIndex : 'firstPaymoney',
						field : {
							emptyText : '首付款金额',
							xtype : 'textfield',
							required : true
						}
					},

					{
						text : '首付款回款时间',
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
						dataIndex : 'firstPaymoneyDate',
						field : {
							emptyText : '首付款回款时间',
							xtype : 'datefield',
							format : 'Y-m-d'
						}
					},

					{
						text : '第二笔金额',
						width : 120,
						sortable : true,
						dataIndex : 'secondPaymoney',
						field : {
							emptyText : '第二笔金额',
							xtype : 'textfield',
							required : true
						}
					},

					{
						text : '第二笔回款时间',
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
						dataIndex : 'secondPaymoneyDate',
						field : {
							emptyText : '第二笔回款时间',
							xtype : 'datefield',
							format : 'Y-m-d'
						}
					},

					{
						text : '尾款金额',
						width : 120,
						sortable : true,
						dataIndex : 'endPaymoney',
						field : {
							emptyText : '尾款金额',
							xtype : 'textfield',
							required : true
						}
					},

					{
						text : '尾款回款时间',
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
						dataIndex : 'endPaymoneyDate',
						field : {
							emptyText : '尾款回款时间',
							xtype : 'datefield',
							format : 'Y-m-d'
						}
					},

					{
						text : '其他回款金额',
						width : 120,
						sortable : true,
						dataIndex : 'otherPaymoney',
						field : {
							emptyText : '其他回款金额',
							xtype : 'textfield',
							required : true
						}
					},

					{
						text : '其他回款时间',
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
						dataIndex : 'otherPaymoneyDate',
						field : {
							emptyText : '其他回款时间',
							xtype : 'datefield',
							format : 'Y-m-d'
						}
					},

					{
						text : '发票信息',
						width : 120,
						sortable : true,
						dataIndex : 'remark1',
						field : {
							emptyText : '发票信息',
							xtype : 'textfield',
							required : true
						}
					},
//
//					{
//						text : '备用字段2',
//						width : 120,
//						sortable : true,
//						dataIndex : 'remark2',
//						field : {
//							xtype : 'textfield',
//							required : true
//						}
//					},
//
//					{
//						text : '备用字段3',
//						width : 120,
//						sortable : true,
//						dataIndex : 'remark3',
//						field : {
//							xtype : 'textfield',
//							required : true
//						}
//					},
//
//					{
//						text : '备用字段4',
//						width : 120,
//						sortable : true,
//						dataIndex : 'remark4',
//						field : {
//							xtype : 'textfield',
//							required : true
//						}
//					},
//
//					{
//						text : '备用字段5',
//						width : 120,
//						sortable : true,
//						dataIndex : 'remark5',
//						field : {
//							xtype : 'textfield',
//							required : true
//						}
//					},

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
											id : 'csContractInfoListRowEditor',
											listeners : {
												beforeedit : function(editor,
														e, eOpts) {
													
													// add here
													Ext.getCmp('csContractInfoList' + 'area').setLocalValue(e.record.data.area, e.record.data.areaName);
													Ext.getCmp('csContractInfoList' + 'customerType').setLocalValue(e.record.data.customerType, e.record.data.customerTypeName);
													Ext.getCmp('csContractInfoList' + 'contractType').setLocalValue(e.record.data.contractType, e.record.data.contractTypeName);
										
													var d = new Date();
													if (e.record.data.signDate > 0) {
														d
																.setTime(e.record.data.signDate);
														e.record.data.signDate = d;
													}

													var d = new Date();
													if (e.record.data.endDate > 0) {
														d
																.setTime(e.record.data.endDate);
														e.record.data.endDate = d;
													}

													var d = new Date();
													if (e.record.data.firstPaymoneyDate > 0) {
														d
																.setTime(e.record.data.firstPaymoneyDate);
														e.record.data.firstPaymoneyDate = d;
													}

													var d = new Date();
													if (e.record.data.secondPaymoneyDate > 0) {
														d
																.setTime(e.record.data.secondPaymoneyDate);
														e.record.data.secondPaymoneyDate = d;
													}

													var d = new Date();
													if (e.record.data.endPaymoneyDate > 0) {
														d
																.setTime(e.record.data.endPaymoneyDate);
														e.record.data.endPaymoneyDate = d;
													}

													var d = new Date();
													if (e.record.data.otherPaymoneyDate > 0) {
														d
																.setTime(e.record.data.otherPaymoneyDate);
														e.record.data.otherPaymoneyDate = d;
													}

												},
												startEdit : function(record,
														columnHeader) {
													this.editRecord = record;
												},
												edit : function(editor, e) {

													// add here
													e.record.data.area = Ext.getCmp('csContractInfoList'+ 'area').getValue();
													e.record.data.areaName = Ext.getCmp('csContractInfoList'+ 'area').getTextValue();
													
													e.record.data.customerType = Ext.getCmp('csContractInfoList'+ 'customerType').getValue();
													e.record.data.customerTypeName = Ext.getCmp('csContractInfoList'+ 'customerType').getTextValue();
													
													e.record.data.contractType = Ext.getCmp('csContractInfoList'+ 'contractType').getValue();
													e.record.data.contractTypeName = Ext.getCmp('csContractInfoList'+ 'contractType').getTextValue();
													
													e.record
															.save({
																success : function(
																		csContractInfo,
																		options) {
																	var data = Ext
																			.decode(options.response.responseText);
																	if (data.extra) {
																		csContractInfo
																				.set(
																						'id',
																						data.extra);
																	}
																	// add here
																	e.record.data.areaName = Ext.getCmp('csContractInfoList'+ 'area').getTextValue();
																	e.record.data.customerTypeName = Ext.getCmp('csContractInfoList'+ 'customerType').getTextValue();
																	e.record.data.contractTypeName = Ext.getCmp('csContractInfoList'+ 'contractType').getTextValue();
																	csContractInfo.commit();
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
							var record = new Fes.model.CsContractInfoModel(
									records[records.length - 1].data);
							this.showWindow(record);
						} else {
							Ext.Msg.alert('提示：', '请先选择需要编辑的记录！');
						}

					},

					saveRecode : function(obj) {
						var record = new Fes.model.CsContractInfoModel(obj);
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
						me.store = Ext.create('Fes.store.CsContractInfoStore');
						
						me.store.on('beforeload', function (store, options) {
				             var params = {paramsArea: Ext.getCmp('csContractInfoList' + 'areaQ').getValue(),
                                                    paramsCustomerName:Ext.getCmp('csContractInfoCustomerName').getValue(),
				        		                    paramsCustomerType:Ext.getCmp('csContractInfoList' + 'customerTypeQ').getValue(),
				        		                    paramsContractType:Ext.getCmp('csContractInfoList' + 'contractTypeQ').getValue()};
				        Ext.apply(me.store.proxy.extraParams, params); 
				    });
					},

					addRecord : function() {
						var records = this.getSelectionModel().getSelection();
						var record = new Fes.model.CsContractInfoModel({
						});

						if (records.length > 0) {
							record = new Fes.model.CsContractInfoModel(
									{
										area : records[records.length - 1].data.area,

										customerName : records[records.length - 1].data.customerName,

										customerType : records[records.length - 1].data.customerType,

										contractNumber : records[records.length - 1].data.contractNumber,

										contractName : records[records.length - 1].data.contractName,

										contractType : records[records.length - 1].data.contractType,

										projectNumber : records[records.length - 1].data.projectNumber,

										signDate : records[records.length - 1].data.signDate,

										endDate : records[records.length - 1].data.endDate,

										contractMoney : records[records.length - 1].data.contractMoney,

										settlementMoney : records[records.length - 1].data.settlementMoney,

										projectInfo : records[records.length - 1].data.projectInfo,

										firstPaymoney : records[records.length - 1].data.firstPaymoney,

										firstPaymoneyDate : records[records.length - 1].data.firstPaymoneyDate,

										secondPaymoney : records[records.length - 1].data.secondPaymoney,

										secondPaymoneyDate : records[records.length - 1].data.secondPaymoneyDate,

										endPaymoney : records[records.length - 1].data.endPaymoney,

										endPaymoneyDate : records[records.length - 1].data.endPaymoneyDate,

										otherPaymoney : records[records.length - 1].data.otherPaymoney,

										otherPaymoneyDate : records[records.length - 1].data.otherPaymoneyDate,

										remark1 : records[records.length - 1].data.remark1,

										remark2 : records[records.length - 1].data.remark2,

										remark3 : records[records.length - 1].data.remark3,

										remark4 : records[records.length - 1].data.remark4,

										remark5 : records[records.length - 1].data.remark5

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
									+ '个合同信息?', function(btn) {
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
						if (!_csContractInfoWindow) {
							_csContractInfoWindow = Ext
									.create(
											'Fes.view.CsContractInfoWindow',
											{
												closeAction : 'hide',
												buttons : [
														{
															text : 'Save5',
															handler : function() {
																me.saveRecode(_csContractInfoWindow.down('form').getValues());
															}
														},
														{
															text : 'Cancel',
															scope : this,
															handler : function() {
																_csContractInfoWindow.hide();
															}
														} ]
											});
						}
						if (rec && rec.data) {
							if (rec.data.signDate > 0) {
								var d = new Date();
								d.setTime(rec.data.signDate);
								rec.data.signDate = d;
							}
							_csContractInfoWindow.down('form').loadRecord(rec);
						}
						_csContractInfoWindow.show();
					},
					exportExcel : function(){ // 导出EXCEL报表
						this.getEl().mask('正在生成报表，请稍候...');
						Ext.Ajax.request({
							 method : 'GET',
					         url : 'toExcel/getReport',
					         success : function(response, options) {
					        	 Ext.Msg.alert("SUCCESS","建设中……");
					         },
							 failure: function(response,options){
								 Ext.Msg.alert("FAILURE","建设中……");
							 }
						});
						this.getEl().unmask();
					},
					createToolbar : function() {
						var me = this;
						return Ext
								.create(
										'Ext.toolbar.Toolbar',
										{
											items : [
													{
														xtype : 'parameterComboTree',
														rootText : '功能',
														labelWidth : 20,
														rootId : '1',
														emptyText:'区域',
														storeUrl : 'sysParameter/getTreeNodeChildren',
														id : 'csContractInfoList' + 'areaQ',
														selectMode : 'all',
														treeHeight : 300,
														rootVisible : false
													},
													{
														xtype : 'textfield',
														labelWidth : 20,
														flex : .6,
														emptyText:'客户名称',
														id : 'csContractInfoCustomerName'
													},
													{
														xtype : 'parameterComboTree',
														rootText : '功能',
														labelWidth : 20,
														rootId : '1',
														emptyText:'客户类型',
														storeUrl : 'sysParameter/getTreeNodeChildren',
														id : 'csContractInfoList' + 'customerTypeQ',
														selectMode : 'all',
														treeHeight : 300,
														rootVisible : false
													},
													{
														xtype : 'parameterComboTree',
														rootText : '功能',
														labelWidth : 20,
														rootId : '1',
														emptyText:'合同类型',
														storeUrl : 'sysParameter/getTreeNodeChildren',
														id : 'csContractInfoList' + 'contractTypeQ',
														selectMode : 'all',
														treeHeight : 300,
														rootVisible : false
													},
													{
														xtype : 'button',
														text : '查询',
														iconCls : 'icon-search',
														handler : function() {
															me.getStore().load();
														}
													},
													{
														xtype : 'button',
														text : ' 清空',
														iconCls : 'icon-no',
														handler : function() {// 清空搜索条件文本框
															Ext.getCmp('csContractInfoList' + 'areaQ').setLocalValue(null, null);
															Ext.getCmp('csContractInfoCustomerName').reset();
															Ext.getCmp('csContractInfoList' + 'customerTypeQ').setLocalValue(null, null);
															Ext.getCmp('csContractInfoList' + 'contractTypeQ').setLocalValue(null, null);
														}
													},
													'-',
													Ext.create('Ext.Button',{
														text : '导出报表',
														iconCls : 'icon-download',
														handler : me.exportExcel,
														scope : me
													}),
													Ext.create('Ext.Button', {
														text : '页面添加',
														iconCls : 'icon-add',
														handler : me.addRecord,
														scope : me
													}),
													'-',
													Ext.create('Ext.Button',{
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