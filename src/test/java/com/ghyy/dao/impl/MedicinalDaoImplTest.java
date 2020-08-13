package com.ghyy.dao.impl;



import com.ghyy.domain.Medicinal;

public class MedicinalDaoImplTest {

	public void testAdd() {
		Medicinal m = new Medicinal();
		m.setDw("合");
		m.setId(1);
		m.setName("阿莫西林胶囊");
		m.setPizhwh("国药准字");
		m.setShpchd("华北制药");
		m.setShpgg("0.25g*20s");
		m.setSpbh("010101");
		m.setSpid("spid00000");
		MedicinalDaoImpl dao = new MedicinalDaoImpl();
		dao.add(m);
	}

}
