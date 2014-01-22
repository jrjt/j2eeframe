package com.sunshineroad.framework.freeTable.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunshineroad.framework.freeTable.dao.FreeTableDao;
import com.sunshineroad.framework.freeTable.entity.MyDataBase;

public class FreeTableDaoImpl implements FreeTableDao {
	   private SessionFactory sessionFactory;

	@Resource(name="sessionFactory_system")
	    public void setSessionFactory(SessionFactory sessionFactory){
	    	this.sessionFactory = sessionFactory;
	    }

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	/**
     * 获取表名
     * @return    List<表>
     */
    public List<MyDataBase> getTables(){
        List<MyDataBase> mdbls=new ArrayList<MyDataBase>();
        Session se=sessionFactory.getCurrentSession();
        SQLQuery sq=se.createSQLQuery("show tables");
        List<String> sls=sq.list();
        for(String str:sls){
            if("jbpm".equals(str.substring(0, 4)))
                continue;
            MyDataBase mdb=new MyDataBase();
            mdb.setTableName(str);
            mdbls.add(mdb);
        }
        return mdbls;
    }
    
    /**
     * 获取字段名    
     * @param tablename    表名
     * @return
     */
    public List<MyDataBase> getFields(String tablename){
        List<MyDataBase> mdbls=new ArrayList<MyDataBase>();
        Session se=sessionFactory.getCurrentSession() ;
        SQLQuery sq=se.createSQLQuery("desc "+tablename).addScalar("Field");
        List<String> sls=sq.list();
        for(String str:sls){
            MyDataBase mdb=new MyDataBase();
            mdb.setFieldname(str);
            mdbls.add(mdb);
        }
        return mdbls;
    }
    
    /**
     * 获取字段
     * @param tablename 表名
     * @return
     */
    public String[] getFieldsInArray(String tablename){
        String[] fields;
           Session se=sessionFactory.getCurrentSession() ; 
        SQLQuery sq=se.createSQLQuery("desc "+tablename).addScalar("Field");
        List<String> sls=sq.list();
        fields=new String[sls.size()];
        for(int i=0;i<sls.size();i++){
            fields[i]=sls.get(i);
        }
        return fields;
    }
    
    /**
     * 获取表内容
     * @param tablename
     * @return
     */
    public String[][] getTableContent(String tablename){
        String[][] content=null;
        Session se=sessionFactory.getCurrentSession() ;
        SQLQuery sq=se.createSQLQuery("select * from "+tablename);
        List<Object[]> ls=sq.list();
        content=new String[ls.size()][getFields(tablename).size()];
        for(int i=0;i<ls.size();i++){
            Object[] strs=ls.get(i);
            for(int j=0;j<strs.length;j++){
                content[i][j]=strs[j]==null?"":strs[j].toString();
            }
        }
        return content;
    }
    
    /**
     * 将字段名集合处理为JSON格式的字符串
     * @param tablename    对应表名
     * @return    字符串数组，每一项为一个Ext中grid的一个header
     */
    public String[] getfiledsHeaders(String tablename){
        String[] fields=this.getFieldsInArray(tablename);
        String[] content=new String[fields.length];
        String temp="{text:'#1',dataIndex:'#1',flex:1}";
        
        for(int i=0;i<fields.length;i++){
            content[i]=temp.replace("#1", fields[i]);
        }
        return content;
    }
    
    /**
     * 将数据处理为JSON格式的字符串
     * @param tablename    对应表名
     * @return    字符串数组，每一项为一条数据库记录
     */
    public String[] getContentStr(String tablename){
        String[] fields=this.getFieldsInArray(tablename);
        String[][] content=this.getTableContent(tablename);
        String jsonContent[]=new String[content.length];
        for(int i=0;i<content.length;i++){
            String temp="";
            for(int j=0;j<fields.length;j++){
                temp=temp+"'"+fields[j]+"':'"+content[i][j]+"',";
            }
            temp="{"+temp.substring(0, temp.length()-1)+"}";
            jsonContent[i]=temp;
        }
    
        return jsonContent;
    }
}
