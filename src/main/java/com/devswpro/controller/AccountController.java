package com.devswpro.controller;

import com.devswpro.dto.TransactionDTO;
import com.devswpro.service.impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/byUser/{accountType}", produces = "application/json")
    public ResponseEntity<String> generateAccount(@PathVariable("accountType") String accountType){
        service.generateAccount(accountType);
        return new ResponseEntity<>("payment complete", HttpStatus.CREATED);
    }
}
