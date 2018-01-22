package cn.easybuy.dao;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.easybuy.utils.JdbcUtils;

/**
 * 基础dao的实现类，实现最基本的增删查改的方法
 */
@SuppressWarnings("unchecked")
public abstract  class BaseDaoImpl<T> implements IBaseDao<T> {
		//保存当前运行类的参数化类型中的实际类型
		@SuppressWarnings("rawtypes")
		private Class clazz ;
		private String className;
		@SuppressWarnings("rawtypes")
		public BaseDaoImpl() {
			//this.getClass()当前运行类的字节码
			//this表示当前运行类
			//getGenericSuperclass()获取父类，即参数化类型
			Type type = this.getClass().getGenericSuperclass();
			ParameterizedType pt =(ParameterizedType)type;
			//可能会有多个参数化类型 获取实际类型参数
			Type[] types = pt.getActualTypeArguments();
			 clazz = (Class) types[0];
			className=clazz.getSimpleName();
		}
	
		@Override
		public T findById(int id){
			String sql="select * from "+className +" where id= ?";
			try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<T>( clazz),id);
			} catch (SQLException e) { 
				e.printStackTrace();
				throw new RuntimeException();
			}

			}
		@Override
		public List<T> getAll(){
			String sql="select * from "+className;
			try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<T>(clazz));
			} catch (SQLException e) { 
				e.printStackTrace();
				throw new RuntimeException();
			}

		}
		@Override
		public boolean add(T t){
			int b=0;
		Field[] f =clazz.getDeclaredFields();
		StringBuilder sb = new StringBuilder();
		String sql = "insert into "+ className+" values (";
		sb.append(sql);
		for (int i = 0; i < f.length; i++) {
			try {
				f[i].setAccessible(true);
				Object value =f[i].get(t);
				if(value instanceof String||value instanceof  Timestamp){
					sb.append("'"+value+"'");
				}
				else sb.append(value);
			} catch (Exception e) {
				System.out.println(e);
				}
			if(i!=f.length-1) sb.append(",");
		}
		sb.append(")");
		sql =sb.toString();
		try {
			 b =JdbcUtils.getQueryRunner().update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(b>0)return true;
		else return false;
			
		}
		@Override
		public boolean delete(int id){
			int b= 0;
			String sql="delete  from "+className +" where id= ?";
			try {
		 b = JdbcUtils.getQueryRunner().update(sql, id);
			} catch (SQLException e) { 
				e.printStackTrace();
				throw new RuntimeException();
			}
			if(b>0) return true;
			
			else return false;
			
		}
		
		
		@Override
		public boolean update(T t){
			String sql = "update "+className+" set ";
			StringBuilder sb =new StringBuilder("update "+className+" set ");
			Field[] f =clazz.getDeclaredFields();
			Object []params = new Object[f.length];
			int j=0;
			for (int i = 0; i < f.length; i++) {
				f[i].setAccessible(true);
				try {
					if(f[i].getName()!="id"){
					sb.append(f[i].getName()+"= "+"?");
					params[j]=f[i].get(t);
					j++;
					if(i!=f.length-1) sb.append(",");
	  			  }
					else params[f.length-1]=f[i].get(t);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
			sb.append(" where id = ?");
			sql=sb.toString();
			try {
				JdbcUtils.getQueryRunner().update(sql, params);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
			
		}
		
		
	}	
