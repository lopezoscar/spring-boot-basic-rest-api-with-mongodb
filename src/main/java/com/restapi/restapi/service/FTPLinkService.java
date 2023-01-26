package com.restapi.restapi.service;

import com.restapi.restapi.dto.FTPLinkDTO;
import com.restapi.restapi.model.FTPLinkModel;
import com.restapi.restapi.repository.IFTPLinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FTPLinkService {

    private final IFTPLinkRepository ftpLinkRepository;

    public FTPLinkService(IFTPLinkRepository ftpLinkRepository) {
        this.ftpLinkRepository = ftpLinkRepository;
    }

    public FTPLinkModel createFTPLink(FTPLinkDTO newFTPLink) throws IllegalArgumentException {
        Optional<List<FTPLinkModel>> allFtpLink = ftpLinkRepository.findAllByFtpLink(newFTPLink.getFtpLink());
        validateFTPLink(allFtpLink);
        FTPLinkModel newFTPLinkData = new FTPLinkModel(newFTPLink.getFtpLink());
        return ftpLinkRepository.save(newFTPLinkData);
    }

    public List<FTPLinkModel> getFTPLinks() {
        List<FTPLinkModel> ftpLinks = ftpLinkRepository.findAll();
        return ftpLinks;
    }
    
    private void validateFTPLink(Optional<List<FTPLinkModel>> allFtpLink) {
        if (allFtpLink.isPresent()) {
            List<FTPLinkModel> ftpLinkModels = allFtpLink.get();
            if (ftpLinkModels.size() > 0) {
                throw new IllegalArgumentException("FTP Link can't be duplicated");
            }
        }
    }

}
