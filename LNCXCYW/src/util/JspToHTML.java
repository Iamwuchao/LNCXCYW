package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import GlobalInfo.PathInfo;


public class JspToHTML {
	public static String getHTMLbyJSPPath(String pathofJsp,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		WrapperResponse wrapperResponse = new WrapperResponse(response);
		request.getRequestDispatcher(pathofJsp).include(request, wrapperResponse);
		return wrapperResponse.getContent();
	}
	
	static public  String getJspOutput(String jsppath)
	{
		WrapperResponse wrapperResponse = null;
		try
		{
			HttpServletRequest request = ServletActionContext.getRequest();        
			HttpServletResponse response = ServletActionContext.getResponse();
			
			wrapperResponse = new WrapperResponse(response);
			request.getRequestDispatcher(jsppath).include(request, wrapperResponse);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return wrapperResponse.getContent();
	}

	//去除
	private static  String filterChar(String newsContent){
		if(newsContent == null || newsContent.length() < 1) return "";
		StringBuilder sb = new StringBuilder();
		int length = newsContent.length();
		boolean flag = false;
		for(int i=0;i<length;i++){
			if(flag || newsContent.charAt(i)=='<'){
				flag = true;
				sb.append(newsContent.charAt(i));
			}
		}
		return sb.toString();
	}
	
	public static String writeHTML(PathInfo pathinfo,String newsContent) throws IOException{
		long time = System.currentTimeMillis();
		String fileName = String.valueOf(time)+".html";
		String tempath = pathinfo.getValue().length()>0?"/"+pathinfo.getValue() + "/":"";
		String temUrl = pathinfo.getValue().length()>0?pathinfo.getValue() + "/":"";
		String filePath = PathInfo.ROOTPATH.getValue()+ tempath+"/" + fileName;
		System.out.println("filePath  "+filePath);
		File file = new File(filePath);
		File parent = file.getParentFile();
		if(!parent.exists()){
			parent.mkdirs();
		}
		String url = PathInfo.ROOTURL.getValue()+ temUrl + fileName;
		
		
		BufferedWriter writer=null;		
		try {
			writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"utf-8")); 
			
			String newsContentByFilter = filterChar(newsContent);			
			System.out.println(newsContentByFilter);
			writer.write(new String(newsContentByFilter.getBytes("utf8"),"utf-8"));
			writer.close();
			
			System.out.println("hehe");
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("failed to create a html file ");
		} catch (IOException e) {
			throw new IOException("failed to write HTML FIle ");
		}finally{
			if(writer!=null){
				writer.close();
			}
		}
		return url;
	}
}
