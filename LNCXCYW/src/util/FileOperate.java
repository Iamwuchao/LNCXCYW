package util;

import java.io.File;

import GlobalInfo.PathInfo;

public class FileOperate {
	
	public static void deleteFile(String path) throws Exception{
		System.out.println("deleteFile:"+path);
		File file=new File(path);
		if(file.isFile()&&file.exists()){
			file.delete();
			System.out.println("ok");
		}else{
			throw new Exception("file does not exist!");
		}
	}
	
	public static String getPictrueAddress(String content){
		String re[];
		re=content.split("\"");
		for(int i=0; i<re.length; i++){
			if(re[i].contains("/upload/image")){				
				String address=PathInfo.ROOTPATH.getValue()+re[i];
				File file=new File(address);
				if(file.isFile()){
					return re[i];
				}
			}
		}
		return null;
	}
}
