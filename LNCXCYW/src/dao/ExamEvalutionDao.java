package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import mode.ExamEvalution;
import mode.ExamPaper;

/*
 * 保存试卷一个分数段的评价标准
 */
public class ExamEvalutionDao extends BaseDaoImpl <ExamEvalution,Integer>{
	
	//获取一个试卷所有的评价标准
	public List<ExamEvalution> getExamEvalutionByPaper(ExamPaper examPaper){
		Session session = this.getSession();
		Criteria crit = session.createCriteria(ExamEvalution.class);
		crit.add(Restrictions.eq("examPaper.id",examPaper.getId()));
		List<ExamEvalution> list = crit.list();
		session.close();
		return list;
	}
	
}
