package util.mail;

import util.mail.MailSenderInfo;
import util.mail.SendTest;
import util.mail.SimpleMailSender;

public class SendTest {
	public static void main(String[] args) {  
        SendTest.send_163();  
    }  
	
	// 163邮箱  
    public static void send_163() {  
        // 这个类主要是设置邮件  
        MailSenderInfo mailInfo = new MailSenderInfo();  
        mailInfo.setMailServerHost("smtp.163.com");  
        mailInfo.setMailServerPort("25");  
        mailInfo.setValidate(true);  
        mailInfo.setUserName("wutongshu0325@163.com"); // 实际发送者  1
        mailInfo.setPassword("123456lu");// 您的邮箱密码  
        mailInfo.setFromAddress("wutongshu0325@163.com"); // 设置发送人邮箱地址 和1处相同 
        mailInfo.setToAddress("wutongshu1993@qq.com"); // 设置接受者邮箱地址  
        mailInfo.setSubject("么么么么哒");  
        mailInfo.setContent("设置邮箱内容<b>h6啊啊啊啊么么哒</b>");  
        // 这个类主要来发送邮件  用tomcat发送的时候需要把mail里面的jar包都放到tomcat的lib目录下
        SimpleMailSender sms = new SimpleMailSender();  
        sms.sendTextMail(mailInfo); // 发送文体格式  
       // sms.sendHtmlMail(mailInfo); // 发送html格式  
    }  
}
