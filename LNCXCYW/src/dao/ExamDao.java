package dao;

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
}
