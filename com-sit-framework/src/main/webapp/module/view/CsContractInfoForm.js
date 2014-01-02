
Ext.define('Fes.view.CsContractInfoForm', {
	extend : 'Ext.form.Panel',
	alias : 'widget.csContractInfoForm',
	title : '',
  
	frame : true,
	//是否可以拖动 
    draggable:true, 
	bodyPadding:'5 5 0',
	width:600,
	fieldDefaults:{
		labelAlign:'left' ,
		xtype:'textfield',
		anchor:'95%',
		msgTarget: 'side' 
	},
	items:[
	       {
	    	   xtype:'container',
	    	   flex:1,
	    	   layout:'anchor',
	    	   item:[{
	    		   fieldLabel:'数据项含义',
	    		   name:'area'
	    		   
	    	   }]
	       }, {
	    	   xtype:'container',
	    	   flex:1,
	    	   layout:'anchor',
	    	   item:[{
	    		   fieldLabel:'客户类型',
	    		   name:'contractNumber'
	    		   
	    	   }]
	       }, {
	    	   xtype:'container',
	    	   flex:1,
	    	   layout:'anchor',
	    	   item:[{
	    		   fieldLabel:'客户名称',
	    		   name:'customerType'
	    		   
	    	   }]
	       }, {
	    	   xtype:'container',
	    	   flex:1,
	    	   layout:'anchor',
	    	   item:[{
	    		   fieldLabel:'区域',
	    		   name:'customerName'
	    		   
	    	   }]
	       }
	       ] 
});