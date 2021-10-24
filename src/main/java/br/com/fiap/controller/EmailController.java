package br.com.fiap.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.dto.EmailDto;
import br.com.fiap.model.EmailModel;
import br.com.fiap.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send-email")
	public ResponseEntity<EmailModel> sendEmail(@RequestBody @Valid EmailDto emailDto){
		EmailModel emailModel = new EmailModel();
		BeanUtils.copyProperties(emailDto, emailModel);
		emailService.sendEmail(emailModel);
		
		return new ResponseEntity<>(emailModel, HttpStatus.OK);
		
	}
}
