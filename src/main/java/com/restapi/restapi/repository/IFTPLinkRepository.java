package com.restapi.restapi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.restapi.restapi.model.FTPLinkModel;

public interface IFTPLinkRepository extends MongoRepository<FTPLinkModel, String> {

    @Query("{}")
    List<FTPLinkModel> findAll ();

    @Query("{ftpLink: '?0'}")
    List<FTPLinkModel> findByUrl(String url);

    public long count();
}