package exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import dao.ExamDao;
import mode.ExamEvalution;
import mode.ExamOption;
import mode.ExamPaper;
import mode.ExamTitle;

public class ExamUtil {
	
	/*
	 * 把试卷存入数据库
	 */
	public static void saveExamPaperToDB(Exam exam){
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
			int tem = random.nextInt(remaining);
			if(tem < select){
				list.add(tem);
				select--;
			}
			remaining--;
		}
		return list;
	}
	
	/*
	 * 生成一张指定类型，包含该类型所有的题目的试卷
	 */
	public static Exam getAllExam(ExamPaper paper){
		if(paper==null) return null;
		
		Exam newExam = new Exam(paper);//创建新试卷
		
		ExamDao ed = new ExamDao();
		
		
		//获取该试卷的所有评价标准
		List<ExamEvalution> examEvalutionList = ed.getAllExamEvalutionByPaper(paper);
		newExam.addAllExamEvalution(examEvalutionList);
		
		//获取该类型的全部题目ID
		List<Integer> allTitleId = ed.getAllExamTitleId(paper);
		ArrayList<Integer> allTitleIdArray = new ArrayList<Integer>(allTitleId);
		System.out.println(allTitleIdArray);
		
		for(int index:allTitleIdArray){
		//	System.out.println("find ExamUtil "+"ExamTitleId "+allTitleIdArray.get(index));
			ExamTitle title = ed.getExamTitleById(index);
			newExam.addTitle(title);
			List<ExamOption> optionsList = ed.getExamOptionsOfTitle(title);
			newExam.addAllExamOptions(title, optionsList);
		}
		return newExam;
	}
	
	
	/*
	 * 生成一张指定类型，指定题目数量的试卷
	 */
	public static Exam getExam(ExamPaper paper,int countOfTitle){
		if(paper==null || countOfTitle<=0) return null;
		
		Exam newExam = new Exam(paper);//创建新试卷
		
		ExamDao ed = new ExamDao();
		
		
		//获取该试卷的所有评价标准
		List<ExamEvalution> examEvalutionList = ed.getAllExamEvalutionByPaper(paper);
		newExam.addAllExamEvalution(examEvalutionList);
		
		//获取该类型的全部题目ID
		List<Integer> allTitleId = ed.getAllExamTitleId(paper);
		ArrayList<Integer> allTitleIdArray = new ArrayList<Integer>(allTitleId);
		
		if(countOfTitle < allTitleIdArray.size()) countOfTitle = allTitleIdArray.size();
		
		//随机抽取题目，获取随机题目的列表
		List<Integer> randomNumbers = RNG(allTitleIdArray.size(),countOfTitle);
		
		for(int index:randomNumbers){
		//	System.out.println("find ExamUtil "+"ExamTitleId "+allTitleIdArray.get(index));
			ExamTitle title = ed.getExamTitleById(allTitleIdArray.get(index));
		/*	if(title!=null)
			System.out.println("Exam Util 70 title "+title.getEmTitle());
			else{
				System.out.println("Exam Util 70 title "+" title is null");
				
			}*/
			newExam.addTitle(title);
			List<ExamOption> optionsList = ed.getExamOptionsOfTitle(title);
			newExam.addAllExamOptions(title, optionsList);
		}
		return newExam;
	}
}
