  
Ext.define('Fes.view.SysParameterForm', {
	extend: 'Ext.form.Panel',
	xtype: 'sysparameterform',
	alias: 'widget.sysparameterform',
	
    frame: true,
    bodyPadding: 10,
    border: 0,
    id: 'sysparameterform-id',
    fieldDefaults: {
        labelAlign: 'right',
        anchor: '99%',
        labelWidth: 110
    },
    defaults:{layout:'anchor',
    		  defaults:{anchor:'100%'}
    },
    layout: 'column',
    items: [
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '参数名称',name: 'parName'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '参数代码',name: 'parCode'},
	      	 
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '上级参数',name: 'parUpId'},
					
					{xtype:'hidden',name:'id'}
						        	
						          
						            
             ]

}); 