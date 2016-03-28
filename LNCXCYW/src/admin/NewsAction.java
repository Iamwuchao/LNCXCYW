package admin;

import com.opensymphony.xwork2.ActionSupport;

public class NewsAction extends ActionSupport{
	private String title;
	private String classify;
	private String author;
	private String content;
	
	
	
	public String newsSubmit() {
		System.out.println("newsSubmit:");
		System.out.println(title+""+classify);
		return SUCCESS;
	}





	
	
	
	/*
	 * getters and setters
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
