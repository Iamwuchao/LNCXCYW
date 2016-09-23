package mode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/*
 * 该类用于存储一道选择题
 */
@Entity
public class ExamTitle {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int emTitleId;//试卷中某一道题的ID
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private ExamPaper emPaper;//这道题所属试卷的ID
	
	@Column(length = 500)
	private String emTitle;
	

	public int getEmTitleId() {
		return emTitleId;
	}

	public void setEmTitleId(int emId) {
		this.emTitleId = emId;
	}

	public String getEmTitle() {
		return emTitle;
	}

	public void setEmTitle(String emTitle) {
		this.emTitle = emTitle;
	}

	public ExamPaper getEmPaper() {
		return emPaper;
	}

	public void setEmPaper(ExamPaper emPaper) {
		this.emPaper = emPaper;
	}
	
	public String toString(){
		return this.emTitle;
	}
}
