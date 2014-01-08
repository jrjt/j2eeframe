var _sysParameterWindow=false;
Ext.define('Fes.view.SysParameterList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.sysParameterlist',
	title : '[参数]列表',
 
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	multiSelect : true,
	simpleSelect : true,
	viewConfig : {
		loadingText : '正在加载[参数]列表'
	},
createRoleCombox:function(){
 
},
	columns : [	
	{xtype : 'rownumberer'}, 
						{text : '参数名称',width : 120,sortable : true,dataIndex : 'parName',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '参数代码',width : 120,sortable : true,dataIndex : 'parCode',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '上级参数',width : 120,sortable : true,dataIndex : 'parUpId',field : {xtype : 'textfield',required : true}},
		 	 		
	 	 		
	 	 		{text : 'id',width : 120,sortable : true,dataIndex : 'id',hidden:true}
	 	 		
	],
	initComponent : function() {
	 
		this.createStore();
		 
		this.rowEditor = Ext.create('Ext.grid.plugin.RowEditing', {
				id:'sysParameterListRowEditor',
				listeners : {
					beforeedit:function( editor,  e,  eOpts ){
				 
					  
					  
					  
					},
					startEdit:function(record, columnHeader ){
			
						this.editRecord=record;
					},
					edit : function(editor, e) {
					 
						e.record.save({
									success : function(sysParameter, options) {
										var data = Ext.decode(options.response.responseText);
										if (data.extra) {
											sysParameter.set('id', data.extra);
										}
										sysParameter.commit();
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
		var record = new Fes.model.SysParameterModel(obj);
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
		me.store = Ext.create('Fes.store.SysParameterStore');
	},

	addRecord : function() {
		var records = this.getSelectionModel().getSelection();
		var record = new Fes.model.SysParameterModel({
			
		});

		if (records.length > 0){
			// record =	records[records.length-1];
			record= new Fes.model.SysParameterModel({
			
						parName:records[records.length-1].data.parName,
				 	
						parCode:records[records.length-1].data.parCode,
				 	
						parUpId:records[records.length-1].data.parUpId,
				 	
 
								});
		}
		
	
		this.getStore().add(record);
		this.rowEditor.startEdit(record, 1);
	},

	deleteRecord : function() {
		var me = this;
		var records = this.getSelectionModel().getSelection();
		if (records.length > 0) {
			Fes.MsgBox.confirm('确定删除这' + records.length + '个参数?',
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
		if(!_sysParameterWindow){
			_sysParameterWindow= Ext.create('Fes.view.SysParameterWindow', { 
				buttons : [
				            {
				                text: 'Save5',
				                handler: function(){
				                	  
				            		  
				            			//alert(_sysParameterWindow.down('form').getValues());
				            			me.saveRecode(_sysParameterWindow.down('form').getValues());
				            		 
				                }
				            },
				            {
				                text: 'Cancel',
				                scope: this,
				                handler: function(){
				                	_sysParameterWindow.hide();
				                }
				            }
				        ]
			})
			 
		}
		_sysParameterWindow.show();
	},
	createToolbar : function() {
		var me = this;
		return Ext.create('Ext.toolbar.Toolbar', {
					items : [{
								xtype : 'textfield',
								fieldLabel : 'ID',
								labelWidth : 40,
								flex : .6,
								id : 'sysParameterId'
							},{
								xtype : 'button',
								text : '查询',
								iconCls : 'icon-search',
								handler : function() {
									me.getStore().load({
										params : {
											id : Ext.getCmp('sysParameterId').getValue()
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