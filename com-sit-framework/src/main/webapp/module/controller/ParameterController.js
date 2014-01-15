/*
* ClassName 部门管理控制器
*/


Ext.define("Fes.controller.ParameterController",{
		extend:	'Ext.app.Controller',
		GridDoActionUtil:Ext.create("Fes.util.GridDoActionUtil"),
		init:function(){
			 return;
			  this.getGridObj = function(button){
			  	 return button.ownerCt.ownerCt;
			  },
			  this.getTreeObj = function(button){
			  		return button.ownerCt.ownerCt.ownerCt.ownerCt.child("#west-tree").child("#parameter-tree");
			  },
				this.control({
					 
					'parameterList button[id=parameterDelete]':{
					  click:function(deleteButton){
						  
								var grid = this.getGridObj(deleteButton);
								var tree = this.getTreeObj(deleteButton);	
								this.GridDoActionUtil.doDelete(grid,tree);
						}
					
					},
					'parameterList button[id=parameterSave]':{
						click:function(addButton){
								var grid = this.getGridObj(addButton);
								var tree = this.getTreeObj(addButton);	
								this.GridDoActionUtil.doSave(grid,tree);
						}
				  },
					//设定列表添加按钮的事件
					'parameterList button[id=parameterAdd]':{
						click:function(addButton){
						 
							//得到数据表格的对象
							var grid = this.getGridObj(addButton);
							var modelObj = {
									text:'',
								//	id:'A01',
									info:'',
									orderIndex:0,
									manager:'',
									nodeType:'Root',
									leaf:true
							};
							//得到tree
							var tree = this.getTreeObj(addButton);
							this.GridDoActionUtil.doInsert(grid,modelObj,tree);	
						}
					},
					//设定列表添加按钮的事件
					'parameterList button[id=parameterInsert]':{
						click:function(addButton){
						 
							//得到数据表格的对象
							var grid = this.getGridObj(addButton);
							var records = grid.getSelectionModel().getSelection();
						
							var record = new Fes.model.ParameterModel({
								parameterName : '新建机构'
							});
							if (records.length > 0){
								// record =	records[records.length-1];
								record= new Fes.model.ParameterModel({
														parameterName : '新建机构',	
														 password:	records[records.length-1].data.password,
														 parentParameterName:			records[records.length-1].data.parentParameterName,
														 parameterId:			records[records.length-1].data.parameterId,
														 parentId:	records[records.length-1].data.parentId
													});
							}
							
						
							grid.getStore().add(record);
							grid.rowEditor.startEdit(record, 1);
						}
					}
				});	
		},
		views:[
		   
			'ParameterLayout',
			'ParameterTree'
		],
		stores:[
				'SysParameterStore' ,'ParameterStore4Tree'
		],
		models:[
				'SysParameterModel'
		]
});