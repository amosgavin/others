package com.avc.email;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

class SeUglyBO{
	private String host = "smtp.qq.com"; // ���巢���û��ʺ�����

	private String from = "2880349990@qq.com";//�����ʼ�������

	private String user = "2880349990@qq.com"; // ������û�

	private String password = "kagmknqykijedghb"; // ��ҵQQ��Ȩ��
	/**
	 * @param to  �ռ���
	 * @param title  ����
	 * @param content ����
	 * @return boolean
	 * @throws IOException
	 */
	public boolean send(String to, String title, String content) throws IOException {
		//System.out.println(to);
		boolean ioke = true;
		try {
			System.out.println(to+"======"+title+"======"+content);
			// ����smtp
			Properties pro = new Properties();
			pro.put("smtp.qq.com", host);
			pro.put("smtp.qq.com", "true");// ******
			pro.put("mail.smtp.ssl.enable", "true");

			Session session = Session.getDefaultInstance(pro);
			session.setDebug(true); // �Ƿ��ڿ���̨������

			MimeMessage message = new MimeMessage(session); // ������ĸ����䵽�ĸ�����ĵ�ַ������
			message.setFrom(new InternetAddress(from));
			message.addRecipients(Message.RecipientType.TO, new InternetAddress[]{
								new InternetAddress(to)});

			message.setSubject(title);
			message.setText("Java������������2");//�ʼ�����������
			message.saveChanges();

			Transport tran = session.getTransport("smtp"); // ͨ��SMTPЧ���û�������Ƚ�������
			tran.connect(host, user, password);
			tran.sendMessage(message, message.getAllRecipients());
			tran.close();

		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ioke = false;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ioke = false;
		}

		return ioke;
	}
}
	public class SendEmailDemo2 {
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			SeUglyBO se=new SeUglyBO();
			try {

				se.send("1547959612@qq.com","��������","������ô");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}