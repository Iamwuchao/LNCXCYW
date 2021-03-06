package exam;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

import dao.DaoFactory;
import dao.ExamEvalutionDao;
import dao.ExamOptionDao;
import dao.ExamPaperDao;
import dao.ExamTitleDao;
import mode.ExamEvalution;
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
	//返回的数据
	private String exam_table;
	private List<List<ExamOption> > qoption = new ArrayList<List<ExamOption>>();
	private List<ExamTitle> qtitle = new ArrayList<>();
	
	
	//试卷评价相关变量
	private List<Integer> emEvaLowList;
	private List<Integer> emEvaHighList;
	private List<String> emEvaDesList;
	
	//添加书卷
	private String paperNameInput;
	private String paperDescInput;//试卷描述
	/*
	 * 添加试题,需要检验试题名字是否重复，原则上是不能重复
	 */
	public String examAdd(){
		System.out.println("###############");
		System.out.println("ExamManageAction.examAdd()");

		ExamPaperDao dao = new ExamPaperDao();	
		List<ExamPaper> paperList=dao.getAllExamPaper();
		categoryList = new ArrayList<>();
		for(ExamPaper paper: paperList){
			categoryList.add(paper.getName());
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
//		ExamPaper examPaper=Cache.getExamPaperByName(category);
		ExamPaper examPaper = new ExamPaperDao().getExamPaperByCategory(category);
		etitle.setEmPaper(examPaper);
		
		ExamTitleDao dao=(ExamTitleDao)DaoFactory.getDaoByName(ExamTitleDao.class);
		if(!dao.save(etitle)){
//			status="0";
			System.out.println("插入题目失败！");
			return ActionSupport.SUCCESS;
		};
		
		List<ExamOption> options=new ArrayList<ExamOption>();;
		for(int i=0; i<optionList.size(); i++){
			ExamOption eoption=new ExamOption();
			eoption.setEmTitle(etitle);
			eoption.setEmStrID(String.valueOf((char)('A'+i)));
			eoption.setEmOption(optionList.get(i));
			eoption.setEmOptionWeight(checkList.get(i));
			options.add(eoption);
		}
		
		ExamOptionDao dao2=(ExamOptionDao)DaoFactory.getDaoByName(ExamOptionDao.class);
		if(!dao2.saveAll(options)){
//			status="1";
			System.out.println("插入选项失败！");
			return ActionSupport.SUCCESS;
		};
		status = "1";
		
		//插入成功以后将题目和选项提出来显示在页面
		 qtitle = dao.getAllExamTitle(examPaper);
		
		 qoption.clear();
		for ( ExamTitle title : qtitle) {
			qoption.add(dao2.getAllExamOption(title)) ;
		}
		exam_table = util.JspToHTML.getJspOutput("/jsp/admin/widgets/examManageTable.jsp");
		return ActionSupport.SUCCESS;
	}
	/**
	 * 试卷评价插入
	 * @return
	 */
	public String examEvaAdd(){
//		ExamPaper examPaper=Cache.getExamPaperByName(category);
		ExamPaper examPaper = new ExamPaperDao().getExamPaperByCategory(category);
		ExamEvalutionDao examEvaDao = new ExamEvalutionDao();
		for(int i=0;i<emEvaDesList.size();i++){
			ExamEvalution evalution = new ExamEvalution();
			evalution.setDescription(emEvaDesList.get(i));
			evalution.setExamPaper(examPaper);
			evalution.setHighScore(emEvaHighList.get(i));
			evalution.setLowScore(emEvaLowList.get(i));
			examEvaDao.save(evalution);
		}
		
		
		
		 status="3";
		 return ActionSupport.SUCCESS;
	 }
	/**
	 * 插入试题及试题描述
	 * @return
	 */
	public String examPaperAdd(){
		System.out.println("++++######"+paperNameInput+paperDescInput);
		ExamPaperDao dao = new ExamPaperDao();
		ExamPaper examPaper = new ExamPaper();
		examPaper.setName(paperNameInput);
		examPaper.setDescription(paperDescInput);
		dao.addExamPaper(examPaper);
		status="4";
//		List<ExamPaper> paperList=Cache.getAllExamPaper();
		List<ExamPaper> paperList=dao.getAllExamPaper();
		categoryList = new ArrayList<>();
		for(ExamPaper paper: paperList){
			categoryList.add(paper.getName());
		}
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * 试卷预览
	 * @return
	 */
	public String examPreShow(){
		
//		ExamPaper examPaper=Cache.getExamPaperByName(category);
		ExamPaper examPaper = new ExamPaperDao().getExamPaperByCategory(category);
		ExamTitleDao dao=(ExamTitleDao)DaoFactory.getDaoByName(ExamTitleDao.class);
		//插入成功以后将题目和选项提出来显示在页面
		 qtitle = dao.getAllExamTitle(examPaper);
		 ExamOptionDao dao2=(ExamOptionDao)DaoFactory.getDaoByName(ExamOptionDao.class);
		 for ( ExamTitle title : qtitle) {
				qoption.add(dao2.getAllExamOption(title)) ;
			}
		exam_table = util.JspToHTML.getJspOutput("/jsp/admin/widgets/examManageTable.jsp");
		status="2";
		return ActionSupport.SUCCESS;
	}
	 
	public List<List<ExamOption>> getQoption() {
		return qoption;
	}



	public void setQoption(List<List<ExamOption>> qoption) {
		this.qoption = qoption;
	}



	public List<ExamTitle> getQtitle() {
		return qtitle;
	}



	public void setQtitle(List<ExamTitle> qtitle) {
		this.qtitle = qtitle;
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



	public List<String> getCategoryList() {
		return categoryList;
	}



	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}



	public String getExam_table() {
		return exam_table;
	}



	public void setExam_table(String exam_table) {
		this.exam_table = exam_table;
	}



	public List<Integer> getEmEvaLowList() {
		return emEvaLowList;
	}



	public void setEmEvaLowList(List<Integer> emEvaLowList) {
		this.emEvaLowList = emEvaLowList;
	}



	public List<Integer> getEmEvaHighList() {
		return emEvaHighList;
	}



	public void setEmEvaHighList(List<Integer> emEvaHighList) {
		this.emEvaHighList = emEvaHighList;
	}



	public List<String> getEmEvaDesList() {
		return emEvaDesList;
	}



	public void setEmEvaDesList(List<String> emEvaDesList) {
		this.emEvaDesList = emEvaDesList;
	}



	public String getPaperNameInput() {
		return paperNameInput;
	}



	public void setPaperNameInput(String paperNameInput) {
		this.paperNameInput = paperNameInput;
	}



	public String getPaperDescInput() {
		return paperDescInput;
	}



	public void setPaperDescInput(String paperDescInput) {
		this.paperDescInput = paperDescInput;
	}
	
}
