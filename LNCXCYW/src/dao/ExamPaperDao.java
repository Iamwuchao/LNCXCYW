package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import mode.ExamPaper;

public class ExamPaperDao extends BaseDaoImpl <ExamPaper,Integer>{
	
	public List<ExamPaper> getAllExamPaper(){
		Session session = this.getSession();
		Criteria crit = session.createCriteria(ExamPaper.class);
		crit.addOrder(Order.desc("id"));
		@SuppressWarnings("unchecked")
		List<ExamPaper> list = crit.list();
		session.close();
		return list;
	}
	
	public boolean addExamPaper(ExamPaper exam){
		return this.save(exam);
	}
	/**
	 * 根据试卷类别获取试卷,原则上一个类别最多只能返回一种试卷
	 * @param category
	 * @return
	 */
	public ExamPaper getExamPaperByCategory(String category){
		Session session = this.getSession();
		Criteria crit = session.createCriteria(ExamPaper.class).add(Restrictions.eq("name", category));
		List<ExamPaper> list = crit.list();
		ExamPaper examPaper = null;
		if (list.size()>=0) {
			examPaper = list.get(0);
		} 
		session.close();
		return examPaper;
	}
}
