package com.ghyy.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Dbutils {

	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	private static DataSource datasource;

	static {
		datasource = new ComboPooledDataSource("ghyy");
		System.out.println(datasource);
		try {
			System.out.println(datasource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static synchronized Connection getConnection() throws SQLException {
		Connection conn = tl.get();
		if (conn == null) {
			conn = datasource.getConnection();
			// ���»�����Ӽ��뵽�̼߳�����
			tl.set(conn);
		}
		System.out.println(conn);
		return conn;
	}

	// ��������
	public static void startTransaction() {
		try {
			// ��ȡ����
			Connection conn = getConnection();
			// ��������
			/*
			 * setAutoCommit�ܵ���˵���Ǳ������ݵ������ԣ�һ��ϵͳ�ĸ��²�������Ҫ�漰���ű�����SQL�����в���
			 * ѭ���������Ľ��в��������������ڿ�ʼʱ�����ˣ�conn.setAutoCommit(false);
			 * ���Ž���conn.commit(),�����㼴ʹ�����ʱ�򱨴��޸ĵ�����Ҳ�����ύ�����ݿ⣬
			 */
			conn.setAutoCommit(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void commit() {
		try {
			Connection conn = tl.get();
			if (conn != null) {
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rollback() {
		try {
			// �Ӽ���tc�еõ�һ������
			Connection conn = tl.get();
			if (conn != null) {
				// �÷�������ȡ���ڵ�ǰ�����н��еĸ��ģ����ͷŵ�ǰConnection������е��������ݿ������˷���ֻ�����ֶ�����ģʽ�²ſ���
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void close() {
		try {
			// �Ӽ���tc�еõ�һ������
			Connection conn = tl.get();
			if (conn != null) {
				// �÷�������ȡ���ڵ�ǰ�����н��еĸ��ģ����ͷŵ�ǰConnection������е��������ݿ������˷���ֻ�����ֶ�����ģʽ�²ſ���
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
