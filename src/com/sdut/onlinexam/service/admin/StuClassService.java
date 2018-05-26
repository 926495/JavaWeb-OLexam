package com.sdut.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.sdut.onlinexam.dao.admin.IStuClassDao;
import com.sdut.onlinexam.dao.admin.StuClassDao;
import com.sdut.onlinexam.po.StuClass;
import com.sdut.onlinexam.util.DBUtil;

public class StuClassService implements IStuClassService{

	private IStuClassDao scd = new StuClassDao();
	@Override
	public List findAll() {
		return scd.findAllStuClassInfo();
	}

	@Override
	public void addstuClass(StuClass sc) {
		scd.addStuClass(sc);
	}

	@Override
	public void updateStuClass(StuClass sc) {
		scd.updateStuClassById(sc);
	}

	@Override
	public Map<String, Object> findStuClassById(int id) {
		return scd.findStuClassById(id);
	}

	@Override
	public String findClassNamesByIds(String ids) {
		return scd.findClassNamesByIds(ids);
	}

	@Override
	public List<StuClass> findStuClassesByTeacherId(int teaId) {
		return null;
	}

	@Override
	public void deleteStuClass(int id) {
		scd.deleteStuClassById(id);
		
	}

}
