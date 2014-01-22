
Ext.define('Fes.view.Container', {
		   	alias: 'widget.fescontainer',
			extend : 'Ext.tab.Panel',
			requires : ['Ext.app.Portlet', 'Ext.app.PortalColumn', 'Ext.app.PortalPanel',
					   'Ext.app.PortalDropZone', 'Ext.ux.TabReorderer','Ext.ux.TabCloseMenu'],
			activeTab : 0,
			enableTabScroll : true,
			 
			//border : true,
			 
			region : 'center',
			split : true
		});


console.log('Container...');