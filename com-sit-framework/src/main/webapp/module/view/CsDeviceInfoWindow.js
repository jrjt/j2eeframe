Ext.define('Fes.view.CsDeviceInfoWindow',{
	extend: 'Ext.window.Window',
	alias: 'widget.csdeviceinfowindow',
	title: '[设备信息]',
    width: 1000,
    height: 350,
    plain: true,
    headerPosition: 'top',
    
     
    constrain: true,
    buttonAlign: 'center',
    resizable: false,
     
    
    initComponent : function() {
    	 
    	Ext.apply(this,{ 
    	 
    	  items:  Ext.create('Fes.view.CsDeviceInfoForm')
    	});
		this.callParent(arguments);
	}
});
