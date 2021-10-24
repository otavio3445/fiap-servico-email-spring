package br.com.fiap.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmailDto {
	@NotBlank
	private String clienteId;
	private String nomeCliente;
	
	@Email
	@NotBlank
	private String para;

	@Email
	@NotBlank
	private String de;
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	private String texto;
}
