package exam;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cache.Cache;
import dao.DaoFactory;
import dao.ExamOptionDao;
import dao.ExamTitleDao;
import mode.ExamOption;
import mode.ExamPaper;
import mode.ExamTitle;

public class ExamManageAction {
	private String status;
	private String title;
	private String category;
	private List<String> categoryList;
	private List<String> optionList;
	private List<Integer> checkList;
	
	
	
	/*
	 * 添加试题
	 */
	public String examAdd(){
		List<ExamPaper> paperList=Cache.getAllExamPaper();
		categoryList.clear();
		for(ExamPaper paper: paperList){
			categoryList.add(paper.getDescription());
		}
		System.out.println(categoryList);
		
		return ActionSupport.SUCCESS;
	}
	
	
	
	/*
	 * 添加一道题
	 * 
	 * 标题title
	 * 选项optionList
	 * 权值checkList
	 * 类型category
	 */
	public String examTitleAdd(){
		System.out.println("examTitleAdd: "+title+category+optionList+checkList);
		status="0";
		ExamTitle etitle=new ExamTitle();
		etitle.setEmTitle(title);
		ExamPaper examPaper=Cache.getExamPaper(category);
		etitle.setEmPaper(examPaper);
		
		ExamTitleDao dao=(ExamTitleDao)DaoFactory.getDaoByName(ExamTitleDao.class);
		if(!dao.save(etitle)){
			status="1";
			System.out.println("插入题目失败！");
			return ActionSupport.SUCCESS;
		};
		
		List<ExamOption> options=new ArrayList<ExamOption>();;
		for(int i=0; i<optionList.size(); i++){
			ExamOption eoption=new ExamOption();
			eoption.setEmTitle(etitle);
			eoption.setEmStrID("A"+i);
			eoption.setEmOption(optionList.get(i));
			eoption.setEmOptionWeight(checkList.get(i));
			options.add(eoption);
		}
		
		ExamOptionDao dao2=(ExamOptionDao)DaoFactory.getDaoByName(ExamOptionDao.class);
		if(!dao2.saveAll(options)){
			status="1";
			System.out.println("插入选项失败！");
			return ActionSupport.SUCCESS;
		};
		return ActionSupport.SUCCESS;
	}
	
	/*
	 * getters and setters
	 */
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<String> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<String> optionList) {
		this.optionList = optionList;
	}

	public List<Integer> getCheckList() {
		return checkList;
	}

	public void setCheckList(List<Integer> checkList) {
		this.checkList = checkList;
	}
	
}
