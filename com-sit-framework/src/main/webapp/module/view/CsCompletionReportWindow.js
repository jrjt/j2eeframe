Ext.define('Fes.view.CsCompletionReportWindow',{
	extend: 'Ext.window.Window',
	alias: 'widget.cscompletionreportwindow',
	title: '[完工报告]',
    width: 1000,
    height: 350,
    plain: true,
    headerPosition: 'top',
    
     
    constrain: true,
    buttonAlign: 'center',
    resizable: false,
     
    
    initComponent : function() {
    	 
    	Ext.apply(this,{ 
    	 
    	  items:  Ext.create('Fes.view.CsCompletionReportForm')
    	});
		this.callParent(arguments);
	}
});
