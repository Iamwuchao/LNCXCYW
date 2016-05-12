package exam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import dao.ExamDao;
import mode.ExamOption;
import mode.ExamPaper;
import mode.ExamTitle;

class Exam{
	private ExamPaper paper;
	private LinkedList<ExamTitle> listOftitle;
	private HashSet<ExamTitle> setOfTitle;
	private HashMap<ExamTitle,List<ExamOption>> totalPaper;
	Exam(ExamPaper paper){
		totalPaper = new HashMap<ExamTitle,List<ExamOption>>();
		setOfTitle = new HashSet<ExamTitle>();
		if(paper!=null)
			this.paper = paper;
	}
	
	boolean addTitle(ExamTitle title){
		if(title==null) return false;
		if(!title.getEmPaper().equals(this.paper)) return false;
		if(!setOfTitle.contains(title)){
			listOftitle.add(title);
			setOfTitle.add(title);
			this.totalPaper.put(title, new LinkedList<ExamOption>());
		}
		return true;
	}
	
	boolean addAllTitile(List<ExamTitle> listOfTitle){
		if(listOfTitle==null || listOfTitle.size()<1){
			return false;
		}
		else{
			for(ExamTitle title:listOfTitle){
				if(title.getEmPaper().equals(this.paper))
					addTitle(title);
				else return false;
			}
		}
		return true;
	}
	
	/*
	 * 给指定的题目添加选项
	 */
	boolean addExamOption(ExamTitle title,ExamOption examOption){
		if(title == null|| examOption==null) return false;
		if(!examOption.getEmTitle().equals(title)) return false;
		if(this.setOfTitle.contains(title)){
			List<ExamOption> list = this.totalPaper.get(title);
			list.add(examOption);
		}
		else{
			this.addTitle(title);
			List<ExamOption> list = this.totalPaper.get(title);
			list.add(examOption);
		}
		return true;
	}
	
	/*
	 * 获取整个试卷内容,得到totalPaper
	 */
	HashMap<ExamTitle, List<ExamOption>> getTotalExam(){
		return this.totalPaper;
	}
	
	ExamPaper getExamPaper(){
		return this.paper;
	}
	
	List<ExamTitle> getAllExamTitle(){
		return this.listOftitle;
	}
}
public class ExamUtil {
	
	/*
	 * 把试卷存入数据库
	 */
	void saveExamPaperToDB(Exam exam){
		ExamDao ed = new ExamDao();
		
		//存入paper
		ed.saveExamPaper(exam.getExamPaper());
		List<ExamTitle> list = exam.getAllExamTitle();
		HashMap<ExamTitle,List<ExamOption>> map = new HashMap<ExamTitle,List<ExamOption>>();
		
		//存入Title
		ed.saveAllExamTitle(list);
		
		//存入选项
		for(ExamTitle title:list){
			List<ExamOption> options = map.get(title);
			ed.saveAllExamOption(options);
		}
	}
}
