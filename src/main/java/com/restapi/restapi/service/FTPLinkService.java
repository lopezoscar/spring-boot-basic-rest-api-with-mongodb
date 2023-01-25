package com.restapi.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.restapi.dto.FTPLinkDTO;
import com.restapi.restapi.model.FTPLinkModel;
import com.restapi.restapi.repository.IFTPLinkRepository;

@Service
public class FTPLinkService {

    @Autowired
    private IFTPLinkRepository ftpLinkRepository;

    public FTPLinkModel createFTPLink (FTPLinkDTO newFTPLink) throws IllegalArgumentException {
        List<FTPLinkModel> existsFTPLink = ftpLinkRepository.findByUrl(newFTPLink.getFtpLink());
        if(existsFTPLink != null && existsFTPLink.size() > 0 ) {
            throw new IllegalArgumentException("FTP Link can`t be duplicated");
        }

        FTPLinkModel newFTPLinkData = new FTPLinkModel();
        newFTPLinkData.setFtpLink(newFTPLink.getFtpLink());
        return ftpLinkRepository.save(newFTPLinkData);
    }

    public List<FTPLinkModel> getFTPLinks () {
        List<FTPLinkModel> ftpLinks = ftpLinkRepository.findAll();
        return ftpLinks;
    }
}
