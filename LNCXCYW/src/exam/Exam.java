package exam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import mode.ExamOption;
import mode.ExamPaper;
import mode.ExamTitle;

public class Exam{
	private ExamPaper paper;
	private LinkedList<ExamTitle> listOftitle;
	private HashSet<ExamTitle> setOfTitle;
	private HashMap<ExamTitle,List<ExamOption>> totalPaper;
	public Exam(ExamPaper paper){
		totalPaper = new HashMap<ExamTitle,List<ExamOption>>();
		setOfTitle = new HashSet<ExamTitle>();
		if(paper!=null)
			this.paper = paper;
	}
	
	public boolean addTitle(ExamTitle title){
		if(title==null) return false;
		if(!title.getEmPaper().equals(this.paper)) return false;
		if(!setOfTitle.contains(title)){
			listOftitle.add(title);
			setOfTitle.add(title);
			this.totalPaper.put(title, new LinkedList<ExamOption>());
		}
		return true;
	}
	
	public boolean addAllTitile(List<ExamTitle> listOfTitle){
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
	public boolean addExamOption(ExamTitle title,ExamOption examOption){
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
	
	public boolean addAllExamOptions(ExamTitle title,List<ExamOption> optionsList){
		if(title == null|| optionsList==null || optionsList.isEmpty()) return false;
		else if(setOfTitle.contains(title)){
			
			//检测选项是否属于这个题目
			for(ExamOption option:optionsList){
				if(!title.equals(option.getEmTitle())) return false;
			}
			totalPaper.put(title, optionsList);
			return true;
		}
		else return false;
	}
	
	/*
	 * 获取整个试卷内容,得到totalPaper
	 */
	public HashMap<ExamTitle, List<ExamOption>> getTotalExam(){
		return this.totalPaper;
	}
	
	public ExamPaper getExamPaper(){
		return this.paper;
	}
	
	public List<ExamTitle> getAllExamTitle(){
		return this.listOftitle;
	}
}
