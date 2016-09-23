package cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import dao.DaoFactory;
import dao.ExamPaperDao;
import mode.ExamPaper;
import exam.Exam;
import exam.ExamUtil;

public class ExamCache{
	private final ConcurrentHashMap<ExamPaper,ArrayList<Exam>> examMap = new ConcurrentHashMap<ExamPaper,ArrayList<Exam>>();
	private final LinkedList<ExamPaper> queue = new LinkedList<ExamPaper>();
	
	private final HashMap<String,ExamPaper> paperMap = new HashMap<String,ExamPaper>();
	private final int countOfExamPaper = 5;

	ExamCache(){
		ExamPaperDao epd = (ExamPaperDao) DaoFactory.getDaoByName(ExamPaperDao.class);
		List<ExamPaper> list = epd.getAllExamPaper();
		for(ExamPaper tem:list){
			queue.add(tem);
			paperMap.put(tem.getName(), tem);
		}
		
		for(ExamPaper paper:list){
			ArrayList<Exam> cachePaper= new ArrayList<Exam>();
			Exam exam = ExamUtil.getAllExam(paper);
			cachePaper.add(exam);
			examMap.put(paper, cachePaper);
		}
	}
	
	Exam getExam(ExamPaper paper,int index){
		System.out.println("index "+index);
		if(paper!=null && index>=0){
			List<Exam> list = examMap.get(paper);
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			for(Exam exam:list){				
				System.out.println("paperId  "+exam.getExamPaper().getId());
				//System.out.println(exam);
			}
			System.out.println("#############################");
			if(index<list.size()){
				return list.get(index);
			}
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		}
		System.out.println("************************************");
		return null;
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
	
	public ExamPaper getExamPaperByName(String name){
		return paperMap.get(name);
	}
	
	public int getCountOfExamPaper(){
		return this.countOfExamPaper;
	}
}
