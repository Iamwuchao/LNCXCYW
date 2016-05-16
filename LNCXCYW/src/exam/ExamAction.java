package exam;

import java.util.HashMap;
import java.util.List;

import GlobalInfo.ExamInfo;
import cache.Cache;

import com.opensymphony.xwork2.ActionSupport;

import mode.ExamOption;
import mode.ExamPaper;
import mode.ExamTitle;

public class ExamAction extends ActionSupport{
	private String paperName;//表明是哪一个试卷
	private int countOftitle;//抽取该测试类型题目数量
	private List<ExamTitle> listOftitle;//存储抽取的试卷
	private List<List<ExamOption>> optionsOfTitle;//题目的选项列表
	                                              //答题记录
	private List<ExamPaper> examPaperList;//所有试题类型的列表
	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public int getCountOftitle() {
		return countOftitle;
	}
	
	public void setCountOftitle(int countOftitle) {
		this.countOftitle = countOftitle;
	}

	public List<ExamTitle> getListOftitle() {
		return listOftitle;
	}

	public void setListOftitle(List<ExamTitle> listOftitle) {
		this.listOftitle = listOftitle;
	}
	
	public List<List<ExamOption>> getOptionsOfTitle() {
		return optionsOfTitle;
	}

	public void setOptionsOfTitle(List<List<ExamOption>> optionsOfTitle) {
		this.optionsOfTitle = optionsOfTitle;
	}

	public String getExamPaper(){
		ExamPaper exampaper = null;
		Exam exam = null;
		if(paperName!=null){
			exampaper = Cache.getExamPaper(paperName);
		}
		if(exampaper!=null){
			int count = countOftitle>0?countOftitle:ExamInfo.EXAMINFO.COUNTOFEXAMPAPER;
			exam = ExamUtil.getExam(exampaper, count);
			
			listOftitle = exam.getAllExamTitle();
			HashMap<ExamTitle, List<ExamOption>> map = exam.getTotalExam();
			for(ExamTitle title:listOftitle){
				optionsOfTitle.add(map.get(title));
			}
		}
		return SUCCESS;
	}
	
	public String getAllExamPaper(){
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		examPaperList = Cache.getAllExamPaper();
		for(ExamPaper tem:examPaperList){
			System.out.println("paper "+tem.getDescription());
		}
		return SUCCESS;
	}
	
	public String judgingPaper(){
		return paperName;
	}
	
}
