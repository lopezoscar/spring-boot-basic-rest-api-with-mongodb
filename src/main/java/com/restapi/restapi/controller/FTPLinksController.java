package com.restapi.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.restapi.dto.FTPLinkDTO;
import com.restapi.restapi.model.FTPLinkModel;
import com.restapi.restapi.service.FTPLinkService;

@RestController
@RequestMapping("/ftp-link")
public class FTPLinksController {

    @Autowired
    private FTPLinkService ftpLinkService;

    @PostMapping("/")
    public ResponseEntity<FTPLinkModel> createFTPServerLink(@RequestBody FTPLinkDTO newFTPLink) throws IllegalArgumentException {
        try{
            FTPLinkModel ftpLinkCreated = ftpLinkService.createFTPLink(newFTPLink);
            return new ResponseEntity<>(ftpLinkCreated, HttpStatus.CREATED);
        } catch (IllegalArgumentException iae) {
            //https://stackoverflow.com/questions/16232833/how-to-respond-with-an-http-400-error-in-a-spring-mvc-responsebody-method-retur
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<FTPLinkModel>> getFTPServerLink() {
        List<FTPLinkModel> response = ftpLinkService.getFTPLinks();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
