package com.devswpro.service.impl;

import com.devswpro.dao.IAccessDAO;
import com.devswpro.dao.ITransactionDAO;
import com.devswpro.dto.AccessDTO;
import com.devswpro.mapper.AccessMapper;
import com.devswpro.model.IntAccess;
import com.devswpro.model.IntTransaction;
import com.devswpro.service.IAccessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccessServiceImpl implements IAccessService {

    private final IAccessDAO dao;
    private final ITransactionDAO transactionDAO;

    @Override
    public List<AccessDTO> findByUser(String user) {
        List<IntAccess> list = dao.findByCreatedBy(user);
        return list.stream().map(AccessMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public AccessDTO findByCreatedByAndToken(String user, String token) {
        boolean permit = this.saveTransaction(user);
        if(!permit){
            return null;
        }
        return AccessMapper.map(dao.findByCreatedByAndToken(user, token));
    }

    @Override
    public IntAccess registrar(IntAccess obj) {
        return dao.save(obj);
    }

    @Override
    public IntAccess modificar(IntAccess obj) {
        return null;
    }

    @Override
    public List<IntAccess> listar() {
        return null;
    }

    @Override
    public IntAccess leer(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    public boolean saveTransaction(String user){
        IntTransaction transaction = new IntTransaction();
        transaction.setUser(user);
        transaction.setCreatedDate(LocalDateTime.now());
        transactionDAO.save(transaction);
        Long total = transactionDAO.countByUser(user);
        if(total > 2){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
