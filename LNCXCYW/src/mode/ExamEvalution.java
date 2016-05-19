package mode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/*
 *该类主要用于记录试卷的评判标准 
 *按分数段给出评价
 */
@Entity
public class ExamEvalution {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;//自增主键
	
	@Column
	private int lowScore;//下界
	
	@Column
	private int highScore;//上界
	
	@Column(length = 5000)
	private String description;//该分数段的测评结果
	
	@ManyToOne
	@JoinColumn
	@Fetch(FetchMode.SELECT)
	private ExamPaper examPaper;//该标准属于哪一张表
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLowScore() {
		return lowScore;
	}

	public int getHighScore() {
		return highScore;
	}

	public String getDescription() {
		return description;
	}

	
	public ExamPaper getExamPaper() {
		return examPaper;
	}

	public void setExamPaper(ExamPaper examPaper) {
		this.examPaper = examPaper;
	}

	public void setLowScore(int lowScore) {
		this.lowScore = lowScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
