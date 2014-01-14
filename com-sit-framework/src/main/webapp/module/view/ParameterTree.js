Ext.define("Fes.view.ParameterTree",{
	extend:'Ext.tree.Panel',
	alias :'widget.parameterTree',
	rootVisible:true, 
	 
	//store:'ParameterStore4Tree',
	animate:true,
	 
	initComponent : function() {
		 var self=this;
		 
		 self.store= Ext.create('Ext.data.TreeStore',{ 
			 					 autoLoad:true,
			 					 nodeParam : 'id',	
								 root : {  
					                   id : self.rootId,  
					                   text : self.rootText,
					                   expanded : false
					               },
								 proxy: {
								        type: 'rest',
								     	url: 'sysParameter/getTreeNodeChildren',
								     	reader:{
								           type : 'json',
								            root:'root',
								           totalProperty : 'total'// 数据的总数
								       },
								        
								       writer:{
								           type:'json'
								           
								       }
								    }
						 		}
		 );
		 
		 self.callParent();
		 self.getStore().load({
				callback : function(re, options,success) {
					 
					 self.getStore().getRootNode().expand();
				}
			});
		
		 
	} 
});
