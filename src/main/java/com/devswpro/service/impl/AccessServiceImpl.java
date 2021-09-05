package com.devswpro.service.impl;

import com.devswpro.dao.IAccessDAO;
import com.devswpro.dao.ITransactionDAO;
import com.devswpro.dao.IUserAccountDAO;
import com.devswpro.dao.IUsuarioDAO;
import com.devswpro.dto.AccessDTO;
import com.devswpro.dto.QueueDTO;
import com.devswpro.jms.Producer;
import com.devswpro.mapper.AccessMapper;
import com.devswpro.model.IntAccess;
import com.devswpro.model.IntTransaction;
import com.devswpro.model.IntUserAccount;
import com.devswpro.model.Usuario;
import com.devswpro.service.IAccessService;
import com.google.gson.Gson;
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
    private final IUsuarioDAO userDAO;
    private final IUserAccountDAO userAccountDAO;
    private final Producer producer;

    @Override
    public List<AccessDTO> findByUser(String user) {
        List<IntAccess> list = dao.findByCreatedBy(user);
        return list.stream().map(AccessMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public AccessDTO findByCreatedByAndToken(String user, String token) {
        this.saveTransaction(user);
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
        return dao.findByIdAccess(id);
    }

    @Override
    public void eliminar(Integer id) {
        dao.deleteById(id);
    }

    public void saveTransaction(String user){
        final String json = new Gson().toJson(new QueueDTO(user, "1.1.1.1"));
        producer.sendMessage("TRANSACTION.QUEUE", json);
    }

    @Override
    public void sendMessage() {
        try {
            QueueDTO queueDTO = new QueueDTO("johanc.cca@gmail.com", "1.1.1.1");
            final Gson gson = new Gson();
            final String json = gson.toJson(queueDTO);
            producer.sendMessage("TRANSACTION.QUEUE", json);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
