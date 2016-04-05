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


public class JspToHTML {
	public static String getHTMLbyJSPPath(String pathofJsp,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		WrapperResponse wrapperResponse = new WrapperResponse(response);
		request.getRequestDispatcher(pathofJsp).include(request, wrapperResponse);
		return wrapperResponse.getContent();
	}
	
	static public  String getJspOutput(String jsppath)
//	throws Exception
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

	
	
	public static String writeHTML(String newContent) throws IOException{
		long time = System.currentTimeMillis();
		String filePath = GlobalInfo.GLOBALINFO.HTMLPath+String.valueOf(time)+".html";
		File file = new File(filePath);
		RandomAccessFile fileInputStream = null;
		try {
			fileInputStream = new RandomAccessFile(file,"rws");
			Charset cs = Charset.forName("utf-8");
			ByteBuffer bb = cs.encode(newContent);
			fileInputStream.write(bb.array());
			System.out.println("hehe");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new FileNotFoundException("failed to create a html file ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IOException("failed to write HTML FIle ");
		}finally{
			if(fileInputStream!=null){
				fileInputStream.close();
			}
		}
		return filePath;
	}
}
