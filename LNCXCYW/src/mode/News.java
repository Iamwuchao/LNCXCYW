package mode;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="news_table")

public class News {
	private int newsId;
	private String newsTile;
	private String news_address;
	private String news_content;
	private User author;
	private NewsCategory category;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getNewsId() {
		return newsId;
	}
	
	@Column(name="news_tile")
	public String getNewsTile() {
		return newsTile;
	}
	
	@Column(name="news_address")
	public String getNews_address() {
		return news_address;
	}
	
	@Column(name="news_content")
	public String getNews_content() {
		return news_content;
	}
	
	@Column(name="author_id")
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	public User getAuthor() {
		return author;
	}
	
	@Column(name="category_id")
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.LAZY)
	@JoinColumn(name="category_id")
	public NewsCategory getCategory() {
		return category;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public void setNewsTile(String newsTile) {
		this.newsTile = newsTile;
	}
	public void setNews_address(String news_address) {
		this.news_address = news_address;
	}
	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public void setCategory(NewsCategory category) {
		this.category = category;
	}
	
	
}
