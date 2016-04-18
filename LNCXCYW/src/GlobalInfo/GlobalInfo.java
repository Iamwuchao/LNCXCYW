package GlobalInfo;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

public enum GlobalInfo {
	GLOBALINFO{
		
	}
	
	/*public final String HTMLPath;
	public final String NEWSPATH = "news";
	public final String HOMEPAGEPATH = "";
	public final String ROOTPATH;
	public final String ROOTURL;
	GlobalInfo(){
		ServletContext application = ServletActionContext.getServletContext();
		ROOTPATH = application.getRealPath("");
		HTMLPath = ROOTPATH+"/"+NEWSPATH;
		ROOTURL="/";
	}*/
}
