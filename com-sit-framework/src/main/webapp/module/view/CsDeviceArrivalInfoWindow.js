Ext.define('Fes.view.CsDeviceArrivalInfoWindow',{
	extend: 'Ext.window.Window',
	alias: 'widget.csdevicearrivalinfowindow',
	title: '[设备到货信息]',
    width: 1000,
    height: 350,
    plain: true,
    headerPosition: 'top',
    
     
    constrain: true,
    buttonAlign: 'center',
    resizable: false,
     
    
    initComponent : function() {
    	 
    	Ext.apply(this,{ 
    	 
    	  items:  Ext.create('Fes.view.CsDeviceArrivalInfoForm')
    	});
		this.callParent(arguments);
	}
});
