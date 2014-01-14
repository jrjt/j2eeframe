/*
* ClassName 部门管理Main布局
*/

Ext.define("Fes.view.ParameterLayout",{
		extend:'Ext.panel.Panel',
		alias:'widget.parameterLayout',
		  requires : ["Fes.view.ParameterTree",'Fes.view.SysParameterList'],  
		defaults:{
			  split:true,//面板右边框中间出现一个小箭头，可以收起面板
				bodyStyle:'padding:1px'
		}, 
		layout:'border',
		items:[{
			title:'部门树形',
			region:'west',
			iconCls:'parameter_table',
			xtype:'panel',
			margins:'5 2 5 5',
			width:200,
			collapsible:true,//面板是可以被折叠的
			id:'west-parameter-tree',
			layout:'fit',//充满整个面板
			items:[{
				xtype:'parameterTree', 
				rootId : 0,  
				rootText : '参数',
				expanded : false,
				listeners:{
					itemclick:function( view, record,  item,  index,  e,  eOpts ){
					 	 
						  
						//Ext.JSON.encode(Ext.getCmp('parameter-grid').getStore().getBaseParam());
						Ext.getCmp('parameter-grid').getStore().load(
								{
									
									params : {
										 id:record.data.id,
										 parameterName:record.data.text
									}
								 
								}
						);
					}
				},
				id:'parameter-tree'
			}]
		},{
			title:'部门数据表格',
			iconCls:'parameter_table',
			region:'center',
			xtype:'panel',
			id:'center-grid',
			margins:'5 5 5 0',
			layout:'fit',//充满整个面板
			border:0,
			items:[{
					id:'parameter-grid',
					xtype:'sysParameterList',
					region:'center',
					layout:'fit',//充满整个面板
						listeners:{
							beforeload:function(store, operation, eOpts ){
								
							}
						}
						
						
			}]
		}]
});

