package com.upcera.ddx.common.mail;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailSenderService {
	@Autowired
	private JavaMailSenderImpl javaMailSender;
	
	public void sendMail(File AttachmentFile,String from,String[] to,String subject,String text) throws Exception {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		mimeMessageHelper.setFrom(from);
		mimeMessageHelper.setTo(to);
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setText(text, true);
		if(AttachmentFile!=null){
			mimeMessageHelper.addAttachment(AttachmentFile.getName(), AttachmentFile);
		}
		javaMailSender.send(mimeMessage);
	}
}
