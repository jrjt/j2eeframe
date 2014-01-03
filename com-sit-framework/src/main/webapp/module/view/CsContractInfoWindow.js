Ext.define('Fes.view.CsContractInfoWindow',{
	extend: 'Ext.window.Window',
	alias: 'widget.cscontractinfowindow',
	title: '添加 合同表',
    width: 1000,
    height: 350,
    plain: true,
    headerPosition: 'top',
    
     
    constrain: true,
    buttonAlign: 'center',
    resizable: false,
     
    
    initComponent : function() {
    	 
    	Ext.apply(this,{ 
    	 
    	  items:  Ext.create('Fes.view.CsContractInfoForm')
    	});
		this.callParent(arguments);
	}
});
