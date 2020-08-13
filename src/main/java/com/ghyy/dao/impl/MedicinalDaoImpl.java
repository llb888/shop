package com.ghyy.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.ghyy.domain.Medicinal;
import com.ghyy.utils.Dbutils;

public class MedicinalDaoImpl {
	public void add(Medicinal medicinal) {
		try {
			Connection conn = Dbutils.getConnection();
			Dbutils.startTransaction();
			QueryRunner qr = new QueryRunner();
			String sql = "insert into spkfk(spid,spbh,name,shpchd,shpgg,dw,pizhwh)values(?,?,?,?,?,?,?)";
			Object[] params = new Object[] { medicinal.getSpid(), medicinal.getSpbh(), medicinal.getName(),
					medicinal.getShpchd(), medicinal.getShpgg(), medicinal.getDw(), medicinal.getPizhwh() };
			qr.update(conn, sql, params);
			Dbutils.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("aaaaaaaaaaaa");
			e.printStackTrace();
		} finally {
			Dbutils.close();
		}

	}

	public void delete(Medicinal medicinal) {

	}

	public void update(Medicinal medicinal) {

	}

	public Medicinal get(Medicinal medicinal) {
		return null;
	}
}
