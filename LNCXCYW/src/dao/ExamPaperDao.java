package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import mode.ExamPaper;

public class ExamPaperDao extends BaseDaoImpl <ExamPaper,Integer>{
	
	public List<ExamPaper> getAllExamPaper(){
		Session session = this.getSession();
		Criteria crit = session.createCriteria(ExamPaper.class);
		crit.addOrder(Order.asc("id"));
		@SuppressWarnings("unchecked")
		List<ExamPaper> list = crit.list();
		session.close();
		return list;
	}
	
	public boolean addExamPaper(ExamPaper exam){
		return this.save(exam);
	}
}
