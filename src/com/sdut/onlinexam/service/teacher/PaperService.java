package com.sdut.onlinexam.service.teacher;

import java.util.List;

import com.sdut.onlinexam.dao.teacher.IPaperDao;
import com.sdut.onlinexam.dao.teacher.PaperDao;
import com.sdut.onlinexam.po.Paper;

public class PaperService implements IPaperService {

	private IPaperDao pd=new PaperDao();
	@Override
	public int save(Paper paper) {
		pd.save(paper);
		return 0;
	}

	@Override
	public List getPaperByStudentId(int studentId, int testId) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List getPaperByStudentId(int studentId) {
		return pd.getPaperByStudentId(studentId);
	}

	@Override
	public List getPaperCompare(int teaId) {
		return pd.getPaperCompare(teaId);
	}

}
