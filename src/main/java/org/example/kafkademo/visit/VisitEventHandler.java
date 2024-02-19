package org.example.kafkademo.visit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@KafkaListener(id = "visit", topics = "topic-visit")
@Component
public class VisitEventHandler {
    private static final Logger logger = LoggerFactory.getLogger(VisitEventHandler.class);

    @KafkaHandler
    public void listen(String event) {
        logger.info("listen -> {}", event);
    }
}
