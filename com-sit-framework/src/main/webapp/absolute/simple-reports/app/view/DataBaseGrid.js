Ext.define('SimpleReports.view.DataBaseGrid', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.databasegrid',
    initComponent: function() {
    	var me = this;
        Ext.applyIf(me, {
            dockedItems: [{
                xtype: 'toolbar',
                dock: 'top',
                items: [{
                    xtype: 'button',
                    text: '导出报表',
                    handler: function() {
                    	var vExportContent = getExcelUrl.getExcelUrl(me, "SQL报表");
                        if (Ext.isIE6 || Ext.isIE7 || Ext.isIE8 || Ext.isSafari) {
                            var fd = Ext.get('frmDummy');
                            if (!fd) {
                                fd = Ext.DomHelper.append(Ext.getBody(), {
                                    tag: 'form',
                                    method: 'post',
                                    id: 'frmDummy',
                                    action: Ext.appPath + '/exportexcel.jsp',
                                    target: '_blank',
                                    name: 'frmDummy',
                                    cls: 'x-hidden',
                                    cn: [{
                                        tag: 'input',
                                        name: 'exportContent',
                                        id: 'exportContent',
                                        type: 'hidden'
                                    }]
                                },
                                true);
                            }
                            fd.child('#exportContent').set({
                                value: vExportContent
                            });
                            fd.dom.submit();
                        } else {
                            document.location = 'data:application/vnd.ms-excel;base64,' + Base64.encode(vExportContent);
                        }
                    }
                }]
            }],
            columns: []
        });
        me.callParent(arguments);
    }
});