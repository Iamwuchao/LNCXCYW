package GlobalInfo;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

public enum PathInfo {
	ROOTPATH(),
	NEWSPATH("news"),
	ROOTURL("/"),
	HOMEPAGEPATH("");
	private final String value;
	PathInfo(){
		ServletContext application = ServletActionContext.getServletContext();
		this.value = application.getRealPath("");
	}
	PathInfo(String value){
		this.value = value;
	}
	public String getValue(){
		return this.value;
	}
}
