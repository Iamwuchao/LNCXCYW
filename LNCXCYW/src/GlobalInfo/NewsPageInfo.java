package GlobalInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum NewsPageInfo {
	NEWSPAGEINFO;
	private final int newsCountOfCategory = 10;//每个栏目的新闻数目
	private final int newestNewsCount = 10;//每日推荐新闻数目
	private final int pictureNewsCount = 4;//焦点图片新闻数目
	String[] zixun={"通知公告", "工作动态","高校动态","政策规章","创新创业资讯","教指委工作动态"};
	String[] xunlian={"创新训练", "创业实践","创新创业培训"};
	String[] jingsai={"创新创业年会"};
	String[] ziyuan={"项目推介", "企业需求","高校创新创业教育季报","他山之石","创新创业理论","创新创业教材","创新创业课程","创新创业导师"};
	String[] chengguo={"优秀创新创业作品", "创新创业典型"};
	
	
	@SuppressWarnings("serial")
	private final Map<String, List<String>> map=new HashMap<String, List<String>>(){
		{
			put("创新创业资讯", new ArrayList<String>(Arrays.asList(zixun)));
			put("创新创业训练", new ArrayList<String>(Arrays.asList(xunlian)));
			put("创新创业竞赛", new ArrayList<String>(Arrays.asList(jingsai)));
			put("创新创业资源", new ArrayList<String>(Arrays.asList(ziyuan)));
			put("创新创业成果", new ArrayList<String>(Arrays.asList(chengguo)));
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
