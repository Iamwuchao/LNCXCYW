package GlobalInfo;

public enum NewsPageInfo {
	NEWSPAGEINFO;
	private final int newsCountOfCategory = 10;//每个栏目的新闻数目
	private final int newestNewsCount = 10;//每日推荐新闻数目
	private final int pictureNewsCount = 4;//焦点图片新闻数目
	
	public int getNewsCountOfCategory(){
		return this.newsCountOfCategory;
	}
	
	public int getNewestNewsCount(){
		return this.newestNewsCount;
	}
	
	public int getPictureNewsCount(){
		return this.pictureNewsCount;
	}
	
}
