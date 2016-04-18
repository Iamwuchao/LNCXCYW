package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import GlobalInfo.GlobalInfo;
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
		RandomAccessFile fileOutputStream = null;
		try {
			fileOutputStream = new RandomAccessFile(file,"rws");
			System.out.println(newsContent);
		//	Charset cs = Charset.forName("utf-8");
		//	ByteBuffer bb = cs.encode(newContent);
			//while(bb.hasRemaining())
				fileOutputStream.writeUTF(newsContent);
			System.out.println("hehe");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new FileNotFoundException("failed to create a html file ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IOException("failed to write HTML FIle ");
		}finally{
			if(fileOutputStream!=null){
				fileOutputStream.close();
			}
		}
		return url;
	}
}
