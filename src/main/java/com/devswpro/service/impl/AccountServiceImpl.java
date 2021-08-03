package com.devswpro.service.impl;

import com.devswpro.dao.ITransactionDAO;
import com.devswpro.dao.IntAccountTypeDAO;
import com.devswpro.dto.AccountDTO;
import com.devswpro.dto.TransactionDTO;
import com.devswpro.mapper.AccountMapper;
import com.devswpro.model.IntAccountType;
import com.devswpro.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final IntAccountTypeDAO dao;
    private final ITransactionDAO transactionDAO;

    @Override
    public TransactionDTO getAll() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<IntAccountType> list = dao.findAll();
        Long totalTrans = transactionDAO.countByUser(auth.getPrincipal().toString());
        return TransactionDTO.builder()
                .totalTransaction(totalTrans)
                .accounts(list.stream().map(x -> AccountMapper.map(x, auth.getPrincipal().toString()))
                        .collect(Collectors.toList()))
                .build();
    }

}
