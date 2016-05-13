package exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
	
	/*
	 * 在0~N-1的范围内生成m个不同的随机数
	 */
	private static List<Integer> RNG(int n,int m){
		int select = m;
		int remaining = n;
		Random random = new Random(System.currentTimeMillis());
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0;i<n;i++){
			int tem = random.nextInt()%remaining;
			if(tem < select){
				list.add(tem);
				select--;
			}
			remaining--;
		}
		return list;
	}
	
	static Exam getExam(ExamPaper paper,int countOfTitle){
		if(paper==null || countOfTitle<=0) return null;
		Exam newExam = new Exam(paper);
		ExamDao ed = new ExamDao();
		List<Integer> allTitleId = ed.getAllExamTitleId(paper);
		ArrayList<Integer> allTitleIdArray = new ArrayList<Integer>(allTitleId);
		List<Integer> randomNumbers = RNG(allTitleIdArray.size(),countOfTitle);
		LinkedList<ExamTitle> titleList = new LinkedList<ExamTitle>();
		for(int index:randomNumbers){
			ExamTitle title = ed.getExamTitleById(allTitleIdArray.get(index));
			newExam.addTitle(title);
			List<ExamOption> options = ed.getExamOptionsOfTitle(title);
		}
		return newExam;
	}
}
