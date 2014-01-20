Ext.define('Fes.view.CustomerInfoWindow',{
	extend: 'Ext.window.Window',
	alias: 'widget.customerinfowindow',
	title: '添加 客户信息',
    width: 1000,
    height: 350,
    plain: true,
    headerPosition: 'top',
    
     
    constrain: true,
    buttonAlign: 'center',
    resizable: false,
     
    
    initComponent : function() {
    	 
    	Ext.apply(this,{ 
    	 
    	  items:  Ext.create('Fes.view.CustomerInfoForm')
    	});
		this.callParent(arguments);
	}
});
