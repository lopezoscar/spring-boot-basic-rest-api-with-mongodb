package com.restapi.restapi.repository;

import com.restapi.restapi.model.FTPLinkModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface IFTPLinkRepository extends MongoRepository<FTPLinkModel, String> {

    Optional<List<FTPLinkModel>> findAllByFtpLink(String url);

}