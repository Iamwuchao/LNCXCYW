package util;

import java.util.Random;

public class Password {
 public static String getNewPassword(){
	 long nowTime = System.currentTimeMillis();
	 int hight = (int)(nowTime>>32);
	 int low = (int)nowTime;
	 int seed = hight^low;
	 Random random = new Random(seed);
	 int tem = random.nextInt();
	 String password = Integer.toHexString(tem);
	 return password;
 }
}
