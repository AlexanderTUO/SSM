package com.tyk.message;

import com.tyk.dao.LogDao;
import com.tyk.pojo.SysLog;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;

public class MessageConsumer implements MessageListener {
    @Autowired
    private LogDao logDao;

    @Override
    public void onMessage(Message message) {
        try {
            String messages = new String(message.getBody(), "utf-8");
            String[] str = messages.split(",");
            SysLog log = new SysLog();
            log.setId(str[0]);
            log.setMethod(str[1]);
            logDao.addLog(log);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
