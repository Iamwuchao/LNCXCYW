package dao;

import java.util.LinkedList;
import java.util.List;

import mode.ExamOption;
import mode.ExamPaper;
import mode.ExamTitle;

public class ExamDao {
	public boolean saveExamPaper(ExamPaper paper){
		ExamPaperDao epd = (ExamPaperDao) DaoFactory.getDaoByName(ExamPaperDao.class);
		return epd.addExamPaper(paper);
	}
	
	public boolean saveExamTitle(ExamTitle title){
		ExamTitleDao  etd = (ExamTitleDao) DaoFactory.getDaoByName(ExamTitleDao.class);
		return etd.save(title);
	}
	
	public boolean saveExamOption(ExamOption option){
		ExamOptionDao eod = (ExamOptionDao) DaoFactory.getDaoByName(ExamOption.class);
		return eod.save(option);
	}
	
	public boolean saveAllExamOption(List<ExamOption> options){
		ExamOptionDao eod = (ExamOptionDao) DaoFactory.getDaoByName(ExamOption.class);
		return eod.saveAll(options);
	}
	
	public boolean saveAllExamTitle(List<ExamTitle> titles){
		ExamTitleDao  etd = (ExamTitleDao) DaoFactory.getDaoByName(ExamTitleDao.class);
		return etd.addAllExamTitle(titles);
	}
	
	public List<Integer> getAllExamTitleId(ExamPaper paper){
		ExamTitleDao  etd = (ExamTitleDao) DaoFactory.getDaoByName(ExamTitleDao.class);
		return etd.getAllTitleId(paper);
	}
	
	public ExamTitle getExamTitleById(int id){
		ExamTitleDao  etd = (ExamTitleDao) DaoFactory.getDaoByName(ExamTitleDao.class);
		return etd.getExamTitleById(id);
		/*List<ExamTitle> list =  etd.findById("emTitleId",id);
		if(list!=null && list.size() >0 ) return list.get(0);
		else return null;*/
	}
	
	public List<ExamOption> getExamOptionsOfTitle(ExamTitle title){
		ExamOptionDao eod = (ExamOptionDao) DaoFactory.getDaoByName(ExamOptionDao.class);
		if(title!=null)
		return eod.getAllExamOption(title);
		else{
			return new LinkedList<ExamOption>();
		}
	}
}
