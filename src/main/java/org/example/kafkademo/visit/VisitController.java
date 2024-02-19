package org.example.kafkademo.visit;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visit")
public class VisitController {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public VisitController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/{visitor}")
    public String hello(@PathVariable String visitor) {
        kafkaTemplate.send("topic-visit", visitor, new VisitEvent(visitor).toString());

        return """
                <h1>
                    Hello %s
                </h1>
                """.formatted(visitor);
    }
}
