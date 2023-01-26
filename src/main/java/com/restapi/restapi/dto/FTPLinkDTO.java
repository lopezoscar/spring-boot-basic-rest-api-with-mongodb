package com.restapi.restapi.dto;

public class FTPLinkDTO {

    private String ftpLink;

    // https://stackoverflow.com/questions/53191468/no-creators-like-default-construct-exist-cannot-deserialize-from-object-valu
    protected FTPLinkDTO() {
    }

    public FTPLinkDTO(String ftpLink) {
        this.ftpLink = ftpLink;
    }

    public String getFtpLink() {
        return ftpLink;
    }

    public void setFtpLink(String ftpLink) {
        this.ftpLink = ftpLink;
    }

}
