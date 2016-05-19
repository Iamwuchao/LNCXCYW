package exam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import mode.ExamEvalution;
import mode.ExamOption;
import mode.ExamPaper;
import mode.ExamTitle;


//封装一个试卷类
public class Exam{
	private ExamPaper paper;//试卷类，表明该试卷的类型
	private LinkedList<ExamTitle> listOftitle;//题目列表
	private HashSet<ExamTitle> setOfTitle;
	private HashMap<ExamTitle,List<ExamOption>> totalPaper;
	private LinkedList<ExamEvalution> evalutionList;//保存评价标准
	
	public Exam(ExamPaper paper){
		totalPaper = new HashMap<ExamTitle,List<ExamOption>>();
		setOfTitle = new HashSet<ExamTitle>();
		listOftitle = new LinkedList<ExamTitle>();
		if(paper!=null)
			this.paper = paper;
	}
	
	public boolean addTitle(ExamTitle title){
		if(title==null) return false;
		if(title.getEmPaper().getId() != this.paper.getId()) return false;
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
				if(title.getEmPaper().getId() == this.paper.getId())
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
		if(examOption.getEmTitle().getEmTitleId() != title.getEmTitleId()) return false;
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
				if(title.getEmTitleId() != option.getEmTitle().getEmTitleId()) return false;
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
	
	//获取所有的评价规则
	public List<ExamEvalution> getAllExamEvalution(){
		return this.evalutionList;
	}
	
	public boolean addAllExamEvalution(List<ExamEvalution> examEvalutionList){
		for(ExamEvalution ee : examEvalutionList){
			//如果有不属于这个试卷的评价标准，直接返回false
			if(ee.getExamPaper().getId() != paper.getId()) return false;
		}
		
		for(ExamEvalution ee : examEvalutionList){
			evalutionList.add(ee);
		}
		return true;
	}
}
