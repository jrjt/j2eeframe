Ext.define('Fes.view.CsContractDetailInfoWindow',{
	extend: 'Ext.window.Window',
	alias: 'widget.cscontractdetailinfowindow',
	title: '[合同明细]',
    width: 1000,
    height: 350,
    plain: true,
    headerPosition: 'top',
    
     
    constrain: true,
    buttonAlign: 'center',
    resizable: false,
     
    
    initComponent : function() {
    	 
    	Ext.apply(this,{ 
    	 
    	  items:  Ext.create('Fes.view.CsContractDetailInfoForm')
    	});
		this.callParent(arguments);
	}
});
