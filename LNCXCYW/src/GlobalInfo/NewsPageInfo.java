package GlobalInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum NewsPageInfo {
	NEWSPAGEINFO;
	private final int newsCountOfCategory = 20;//每个栏目的新闻数目
	private final int newestNewsCount = 10;//每日推荐新闻数目
	private final int pictureNewsCount = 4;//焦点图片新闻数目
	String[] zixun={"政策规章", "创新创业资讯","他山之石"};
	String[] xunlian={"创新创业训练计划", "创新创业年会"};
	String[] jingsai={"创新创业竞赛", "优秀创新创业作品"};
	String[] ziyuan={"创新创业培训", "创新创业理论","创新创业导师"};
	String[] chengguo={"创新创业教材", "创新创业课程", "创新创业典型"};
	String[] jiaoyujidi={"创新创业教育基地_政策文件", "创新创业教育基地_高校基地情况"};
	String[] xuanyujidi={"创新创业选育基地_政策文件", "创新创业选育基地_高校基地情况"};
	String[] gaigefangan={"创新创业改革实施方案_政策文件", "创新创业改革实施方案_高校情况"};
	String[] chuangyekecheng={"创新创业课程_政策文件", "创新创业课程"};
	
	@SuppressWarnings("serial")
	private final Map<String, List<String>> map=new HashMap<String, List<String>>(){
		{
			put("创新创业资讯", new ArrayList<String>(Arrays.asList(zixun)));
			put("创新创业训练", new ArrayList<String>(Arrays.asList(xunlian)));
			put("创新创业竞赛", new ArrayList<String>(Arrays.asList(jingsai)));
			put("创新创业资源", new ArrayList<String>(Arrays.asList(ziyuan)));
			put("创新创业成果", new ArrayList<String>(Arrays.asList(chengguo)));
			put("创新创业教育基地", new ArrayList<String>(Arrays.asList(jiaoyujidi)));
			put("创新创业选育基地", new ArrayList<String>(Arrays.asList(xuanyujidi)));
			put("创新创业改革实施方案", new ArrayList<String>(Arrays.asList(gaigefangan)));
			put("创新创业课程", new ArrayList<String>(Arrays.asList(chuangyekecheng)));
		}
	};
	
	
	
	public int getNewsCountOfCategory(){
		return this.newsCountOfCategory;
	}
	
	public int getNewestNewsCount(){
		return this.newestNewsCount;
	}
	
	public int getPictureNewsCount(){
		return this.pictureNewsCount;
	}

	public String[] getZixun() {
		return zixun;
	}

	public void setZixun(String[] zixun) {
		this.zixun = zixun;
	}

	public String[] getXunlian() {
		return xunlian;
	}

	public void setXunlian(String[] xunlian) {
		this.xunlian = xunlian;
	}

	public String[] getJingsai() {
		return jingsai;
	}

	public void setJingsai(String[] jingsai) {
		this.jingsai = jingsai;
	}

	public String[] getZiyuan() {
		return ziyuan;
	}

	public void setZiyuan(String[] ziyuan) {
		this.ziyuan = ziyuan;
	}

	public String[] getChengguo() {
		return chengguo;
	}

	public void setChengguo(String[] chengguo) {
		this.chengguo = chengguo;
	}

	public Map<String, List<String>> getMap() {
		return map;
	}


	
}
