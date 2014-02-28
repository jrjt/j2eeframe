/**
 * @class SimpleReports.view.tasks.EditWindow
 * @extends Ext.window.Window
 */
Ext.define('SimpleReports.view.tasks.SqlWindow', {
    extend: 'Ext.window.Window',
    xtype: 'taskSqlWindow',
    requires: ['SimpleReports.view.DataBaseGrid'],
    closeAction: 'hide',
    modal: true,
    width: 900,
    height: 500,
    minWidth: 500,
    minHeight: 350,
    layout: 'fit',

    initComponent: function() {
        this.items = [Ext.create('SimpleReports.view.DataBaseGrid',{})];
        this.callParent(arguments);
    }
});