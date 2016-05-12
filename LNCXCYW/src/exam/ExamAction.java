package exam;

import java.util.List;
import mode.ExamTitle;

public class ExamAction {
	private String paper;//表明是哪一个试卷
	private int countOftitle;//抽取该测试类型题目数量
	private List<ExamTitle> listOftitle;//存储抽取的试卷
	
	public String getPaper() {
		return paper;
	}

	public void setPaper(String paper) {
		this.paper = paper;
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
	
	public void getExamPaper(){
		
	}
	
	
	
}
