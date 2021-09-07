package com.devswpro.jms;

/*
import com.devswpro.dao.ITransactionDAO;
import com.devswpro.dao.IUserAccountDAO;
import com.devswpro.model.IntTransaction;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.time.LocalDateTime;
import java.util.Map;
*/

public class Listener {
    /*
    private final IUserAccountDAO userAccountDAO;
    private final ITransactionDAO transactionDAO;

    @JmsListener(destination = "TRANSACTION.QUEUE")
    public String receiveMessage(final Message jsonMessage) throws JMSException {
        String messageData = "";
        if(jsonMessage instanceof TextMessage) {
            TextMessage textMessage = (TextMessage)jsonMessage;
            messageData = textMessage.getText();
            Map map = new Gson().fromJson(messageData, Map.class);
            String user = map.get("name").toString();
            IntTransaction transaction = new IntTransaction();
            transaction.setUser(user);
            transaction.setCreatedDate(LocalDateTime.now());
            transactionDAO.save(transaction);

            log.info("Insertando nueva transacción para " + map.get("name"));
        }
        return null;
    }
    */
}
