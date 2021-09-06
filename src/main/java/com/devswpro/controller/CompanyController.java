package com.devswpro.controller;

import com.devswpro.dto.AccessDTO;
import com.devswpro.dto.CompanyDTO;
import com.devswpro.mapper.AccessMapper;
import com.devswpro.model.IntCompany;
import com.devswpro.service.IAccessService;
import com.devswpro.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final ICompanyService companyService;
    private final IAccessService accessService;

    @GetMapping(value = "/{ruc}", produces = "application/json")
    public ResponseEntity<Object> findByRuc(@PathVariable("ruc") String ruc, @RequestHeader("user-access") String userAccess ,@RequestHeader("token-access") String token){
        if(!accessService.validateMaxTransaction(userAccess)){
            return new ResponseEntity<>(AccessMapper.mapError("Alcanzó el límite de consultas"), HttpStatus.UNAUTHORIZED);
        }
        AccessDTO access = accessService.findByCreatedByAndToken(userAccess, token);
        if(Objects.isNull(access)){
            return new ResponseEntity<>(AccessMapper.mapError("Usuario no encontrado"), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(companyService.findByRuc(ruc), HttpStatus.OK);
    }

    @PostMapping(produces="application/json",consumes="application/json")
    public ResponseEntity<CompanyDTO> save(@Valid @RequestBody IntCompany company){
        IntCompany model = companyService.registrar(company);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{ruc}").buildAndExpand(model.getRuc()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(produces="application/json",consumes="application/json")
    public ResponseEntity<CompanyDTO> update(@Valid @RequestBody IntCompany company){
        IntCompany model = companyService.modificar(company);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{ruc}").buildAndExpand(model.getRuc()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping(value = "/send", produces = "application/json")
    public void sendMessage(){
        accessService.sendMessage();
    }

}
