package com.example.RabbitCheck;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.function.Consumer;

@Component
@Slf4j
public class SomeConsumer {
    @Autowired
    private ServiceS serviceS;

    @Bean
    public Consumer<SomeDTO> recieveMessage() throws AmqpRejectAndDontRequeueException {
        return someMsgR -> {
            try {
                serviceS.receiveMsgMQ(someMsgR.getMessage());
            } catch (Exception e) {
                log.error("consumeTestMsg error : ", e);
                throw new AmqpRejectAndDontRequeueException(e);
            }
        };
    }
}

