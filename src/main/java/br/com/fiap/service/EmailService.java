package br.com.fiap.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.fiap.model.EmailModel;
import br.com.fiap.model.StatusEmail;
import br.com.fiap.repository.EmailRepository;

@Service
public class EmailService {

	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
	private JavaMailSender emailSender;
	
	@SuppressWarnings("finally")
	public EmailModel sendEmail(EmailModel emailModel) {
		emailModel.setDataEnvio(LocalDateTime.now());
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(emailModel.getDe());
			message.setTo(emailModel.getPara());
			message.setSubject(emailModel.getTitulo());
			message.setText(emailModel.getTexto());
			
			emailSender.send(message);
			emailModel.setStatusEmail(StatusEmail.Enviado);
		} catch(MailException ex) {
			emailModel.setStatusEmail(StatusEmail.Erro);
		} finally {			
			return emailRepository.save(emailModel);
		}
	}
}
