package cache;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import dao.DaoFactory;
import dao.ExamPaperDao;
import mode.*;
public class ExamPaperCache {
	private final LinkedList<ExamPaper> queue = new LinkedList<ExamPaper>();
	private final HashMap<String,ExamPaper> hashMap = new HashMap<String,ExamPaper>();
	private final AtomicBoolean isInited = new AtomicBoolean(false);
	ExamPaperCache(){
		if(isInited.compareAndSet(false, true))
		{
			ExamPaperDao epd = (ExamPaperDao) DaoFactory.getDaoByName(ExamPaperDao.class);
			List<ExamPaper> list = epd.getAllExamPaper();
			for(ExamPaper tem:list){
				queue.add(tem);
				hashMap.put(tem.getDescription(), tem);
			}
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