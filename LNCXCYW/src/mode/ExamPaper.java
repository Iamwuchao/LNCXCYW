package mode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*
 * 记录所有的试题类型
 */

@Entity
public class ExamPaper {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;//试卷ID
	
	//试卷名称
	@Column(length = 500)
	private String name;//试卷名称
	
	@Column(length = 5000)//考题描述
	private String description;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return this.id+":"+this.name+this.description;
	}
	
}
