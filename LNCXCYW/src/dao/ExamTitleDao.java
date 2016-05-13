package dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import mode.ExamPaper;
import mode.ExamTitle;
import mode.News;

public class ExamTitleDao extends BaseDaoImpl <ExamTitle,Integer>{
	public boolean addAllExamTitle(List<ExamTitle> list){
		
		return this.saveAll(list);
	}
	
	public List<ExamTitle> getAllExamTitle(ExamPaper paper){
		Session session = getSession();
		Criteria criteria=session.createCriteria(News.class);
		criteria.add(Restrictions.eq("emPaper_id",paper.getId()));
		List list = criteria.list();
		return list;
	}
	
	public boolean addExamTitle(ExamTitle examtitle){
		return this.save(examtitle);
	}
	
	public List<Integer> getAllTitleId(ExamPaper paper){
		Session session = this.getSession();
		String hql = "select emTitleId from ExamTitle where emPaper=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, paper);
		List<Integer> result = query.list();
		return result;
	}
}
