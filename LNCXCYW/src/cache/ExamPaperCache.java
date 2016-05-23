package cache;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import dao.DaoFactory;
import dao.ExamPaperDao;
import mode.*;
public class ExamPaperCache {
	private final LinkedList<ExamPaper> queue = new LinkedList<ExamPaper>();
	private final HashMap<String,ExamPaper> hashMap = new HashMap<String,ExamPaper>();
	ExamPaperCache(){
		ExamPaperDao epd = (ExamPaperDao) DaoFactory.getDaoByName(ExamPaperDao.class);
		List<ExamPaper> list = epd.getAllExamPaper();
		for(ExamPaper tem:list){
			queue.add(tem);
			hashMap.put(tem.getName(), tem);
		}
	}
	
	public LinkedList<ExamPaper> getAllExamPaper(){
		LinkedList<ExamPaper> newlist = new LinkedList<ExamPaper>();
		synchronized(queue){
			for(ExamPaper paper:queue){
				newlist.add(paper);
			}
		}
		return newlist;
	}
	
	public ExamPaper getExamPaper(String description){
		return hashMap.get(description);
	}
}
