package com.restapi.restapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("links")
public class FTPLinkModel {
    @Id
    private String id;
  
    private String ftpLink;

    public FTPLinkModel () {}

    public FTPLinkModel(String id, String ftpLink) {
        super();
        this.id = id;
        this.ftpLink = ftpLink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFtpLink() {
        return ftpLink;
    }

    public void setFtpLink(String ftpLink) {
        this.ftpLink = ftpLink;
    }

}
