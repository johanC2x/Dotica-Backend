package com.devswpro.controller;

import com.devswpro.dto.TransactionDTO;
import com.devswpro.service.impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountServiceImpl service;

    @GetMapping(value = "/byUser", produces = "application/json")
    public ResponseEntity<TransactionDTO> getAccount(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

}
