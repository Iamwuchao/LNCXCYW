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
 *该类用于存储一道题的一个选项 
 */

@Entity
public class ExamOption {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int emOpId;//选项的编号
	
	@Column(length = 50)
	private String emStrID;//用于记录这是 哪一个选项 A B 或是C
	
	@Column(length = 500)
	private String emOption;//选项的内容
	
	@Column
	private int emOptionWeight;//选项分值
	
	@ManyToOne
	@JoinColumn
	@Fetch(FetchMode.SELECT)
	private ExamTitle emTitle;//表明其属于哪一个试题

	public int getEmOpId() {
		return emOpId;
	}

	public void setEmId(int emOpId) {
		this.emOpId = emOpId;
	}

	public String getEmOption() {
		return emOption;
	}

	public void setEmOption(String emOption) {
		this.emOption = emOption;
	}

	public ExamTitle getEmTitle() {
		return emTitle;
	}

	public void setEmTitle(ExamTitle emTitle) {
		this.emTitle = emTitle;
	}

	public int getEmOptionWeight() {
		return emOptionWeight;
	}

	public void setEmOptionWeight(int emOptionWeight) {
		this.emOptionWeight = emOptionWeight;
	}

	public String getEmStrID() {
		return emStrID;
	}

	public void setEmStrID(String emStrID) {
		this.emStrID = emStrID;
	}
	
	
}