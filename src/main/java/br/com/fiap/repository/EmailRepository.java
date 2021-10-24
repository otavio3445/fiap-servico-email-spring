package br.com.fiap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.model.EmailModel;

public interface EmailRepository extends MongoRepository<EmailModel, String> {

}
