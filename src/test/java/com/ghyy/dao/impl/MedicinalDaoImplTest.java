package com.ghyy.dao.impl;



import com.ghyy.domain.Medicinal;

public class MedicinalDaoImplTest {

	public void testAdd() {
		Medicinal m = new Medicinal();
		m.setDw("��");
		m.setId(1);
		m.setName("��Ī���ֽ���");
		m.setPizhwh("��ҩ׼��");
		m.setShpchd("������ҩ");
		m.setShpgg("0.25g*20s");
		m.setSpbh("010101");
		m.setSpid("spid00000");
		MedicinalDaoImpl dao = new MedicinalDaoImpl();
		dao.add(m);
	}

}
