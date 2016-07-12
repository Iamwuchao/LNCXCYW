package mode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="newscategory_table")
public class NewsCategory {
	private int categoryId;
	private String newscategory;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getCategoryId() {
		return categoryId;
	}
	
	@Column(name="newscategory")
	public String getNewscategory() {
		return newscategory;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public void setNewscategory(String newscategory) {
		this.newscategory = newscategory;
	}
	public String toString(){
		return "categoryId:"+categoryId+" newscategory:"+newscategory;
	} 
	
}
