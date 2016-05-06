package util;

import java.io.File;

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
}
