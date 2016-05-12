package dao;

import java.util.List;

import org.hibernate.Criteria;
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
}
