package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import mode.ExamOption;
import mode.ExamTitle;

public class ExamOptionDao extends BaseDaoImpl <ExamOption,Integer>{
	public ExamOptionDao(){
		super.setClass(ExamOption.class);
	}
	
//	public List<ExamOption> getAllExamOption(ExamTitle et){
//		Session session = getSession();
//		Criteria criteria=session.createCriteria(News.class);
//		criteria.add(Restrictions.eq("emTitle_emTitleId",et.getEmTitleId()));
//		List list = criteria.list();
//		return list;
//	}
	public List<ExamOption> getAllExamOption(ExamTitle et){
		Session session = getSession();
		Criteria criteria=session.createCriteria(ExamOption.class);
		criteria.add(Restrictions.eq("emTitle.emTitleId",et.getEmTitleId()));
		List<ExamOption> list = criteria.list();
		session.close();
		return list;
	}
	
	public boolean addAllExamOption(List<ExamOption> list){
		return this.saveAll(list);
	}
	
	
}
