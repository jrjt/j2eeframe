
Ext.define('Fes.controller.DesktopController', {
	extend : 'Ext.app.Controller',

	models : ['Node'],

	refs : [{
				ref : 'navigation',
				selector : 'navigation'
			}, {
				ref : 'container',
				selector : 'fescontainer'
			}],

	init : function() {
 
		var me = this;
		this.control({
					'viewport' : {
						render : me.onRender
					},
					scope : me
				});
	},

	onRender : function() {
 
		var me = this;
		Ext.get('loading-msg').update('正在加载菜单...');
		Ext.Ajax.request({
					url : 'resource/root',// 获取面板的地址
					method : 'GET',
					callback : function(options, success, response) {
						me.createTree(Ext.JSON.decode(response.responseText));
					}
				});
	},

	createTree : function(datas) {
 
		var me = this;
		Ext.each(datas, function(data) {
					var tree = Ext.create("Ext.tree.Panel", {
								title : data.text,
								//iconCls : data.iconCls,
								useArrows : true,
								autoScroll : true,
								rootVisible : false,
								viewConfig : {
									loadingText : "正在加载..."
								},
							 	store : me.createTreeStore(data.id)
							});
					 tree.on('itemclick', me.onTreeItemClick, me);
					// console.log(data.text);
					  me.getNavigation().add(tree);
				});
		Ext.get('loading-msg').update('加载完成.');
		Ext.Function.defer(function() {
					Ext.get('loading-tip').remove();
				}, 1000);
	},

	onTreeItemClick : function(view, node) {
		var self = view;
		var tab = this.getContainer();
		if (node.isLeaf()||node.data.type === 'COMPONENT') { // 判断是否是根节点
			if (node.data.type === 'URL') { // 判断资源类型
				var panel = Ext.create('Ext.panel.Panel', {
					title : node.data.text,
					closable : true,
					iconCls : 'icon-activity',
					html : '<iframe width="100%" height="100%" frameborder="0" src="http://www.baidu.com"></iframe>'
				});
				tab.add(panel);
				tab.setActiveTab(panel);
			} else if (node.data.type === 'COMPONENT') {
				var id = 'panel_'+node.data.id;
				var panel =Ext.getCmp(id);

				if (!panel) {
					if (node.data.component.indexOf('DeptLayout') > -1) {

						Ext.require("Fes.controller.DeptController",
								function() {
									 var newController = application.getController('DeptController');
											 newController.init();
									panel = Ext.widget('mainlayout', {
												title : '机构管理',
												id : id,
												closable : false
											});
											
									//因为是异步，所以下面代码执行前 init方法已经结束
									tab.add(panel);
									tab.setActiveTab(panel);
								}, view);
                 }else if(node.data.component.indexOf('SysParameter') > -1){
                	 Ext.require("Fes.view.ParameterLayout");
                	 Ext.require("Fes.controller.ParameterController",
								function() {
									 var newController = application.getController('ParameterController');
											 newController.init();
									panel = Ext.create('Fes.view.ParameterLayout', {
												 title : '【参数管理】',
												id : id,
												closable : false
											});
											
									//因为是异步，所以下面代码执行前 init方法已经结束
									tab.add(panel);
									tab.setActiveTab(panel);
								}, view);
                	 
                	 
                 }else{
				 panel = Ext.create(node.data.component, {
				 			id:id,
							title : node.data.text,
							closable : false,
							iconCls : 'icon-activity'
						});
							tab.add(panel);
                 }
				
				}
				tab.setActiveTab(panel);
			}
		}
	},

	createTreeStore : function(id) {
 
		var me = this;
		return Ext.create("Ext.data.TreeStore", {
					defaultRootId : id, // 默认的根节点id 
					model : this.getNodeModel().$className,
					proxy : {
						type : 'ajax', // 获取方式
						url : 'resource/child' // 获取树节点的地址
					},
					clearOnLoad : true,
					nodeParam : 'id'// 设置传递给后台的参数名,值是树节点的id属性
				});
	}
});
