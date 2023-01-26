package com.restapi.restapi.controller;

import com.restapi.restapi.dto.FTPLinkDTO;
import com.restapi.restapi.model.FTPLinkModel;
import com.restapi.restapi.service.FTPLinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/ftp-link")
public class FTPLinksController {

    private final FTPLinkService ftpLinkService;

    public FTPLinksController(FTPLinkService ftpLinkService) {
        this.ftpLinkService = ftpLinkService;
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public FTPLinkModel createFTPServerLink(@RequestBody FTPLinkDTO newFTPLink) {
        try {
            FTPLinkModel ftpLinkCreated = ftpLinkService.createFTPLink(newFTPLink);
            return ftpLinkCreated;
        } catch (IllegalArgumentException iae) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FTPLinkModel>> getFTPServerLink() {
        List<FTPLinkModel> response = ftpLinkService.getFTPLinks();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
