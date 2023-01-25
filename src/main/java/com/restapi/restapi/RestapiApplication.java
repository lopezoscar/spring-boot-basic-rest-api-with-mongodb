package com.restapi.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.restapi.restapi.repository.IFTPLinkRepository;

@SpringBootApplication
@EnableMongoRepositories
public class RestapiApplication {

	@Autowired
	IFTPLinkRepository ftpLinkRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

}
