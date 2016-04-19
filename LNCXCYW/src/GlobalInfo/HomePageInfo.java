package GlobalInfo;

public enum HomePageInfo {
	HOMEPAGEINFO;
	private final int newsCountOfCategory = 10;
	private final int newestNewsCount = 10;
	
	public int getNewsCountOfCategory(){
		return this.newsCountOfCategory;
	}
	
	public int getNewestNewsCount(){
		return this.newestNewsCount;
	}
	
}
