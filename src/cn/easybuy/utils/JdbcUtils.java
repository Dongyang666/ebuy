package cn.easybuy.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
 

public class JdbcUtils {
	//初始化连接池
	private static DataSource datasource;
	static {
		datasource = new ComboPooledDataSource();
	}
	//创建Dbutils常用工具类对象
	public static QueryRunner getQueryRunner(){
		return new QueryRunner(datasource) ;
		
	}
	public static DataSource getDatasource() {
		return datasource;
	}
	public static Connection getConnection() {
		try {
			return  datasource.getConnection();
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
