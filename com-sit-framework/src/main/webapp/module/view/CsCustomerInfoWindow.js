Ext.define('Fes.view.CsCustomerInfoWindow',{
	extend: 'Ext.window.Window',
	alias: 'widget.cscustomerinfowindow',
	title: '[客户信息]',
    width: 1000,
    height: 350,
    plain: true,
    headerPosition: 'top',
    
     
    constrain: true,
    buttonAlign: 'center',
    resizable: false,
     
    
    initComponent : function() {
    	 
    	Ext.apply(this,{ 
    	 
    	  items:  Ext.create('Fes.view.CsCustomerInfoForm')
    	});
		this.callParent(arguments);
	}
});
