package org.example.kafkademo;

import jakarta.annotation.Resource;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.config.TopicBuilder;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestKafkaDemoApplication {

    @Bean
    @ServiceConnection
    KafkaContainer kafkaContainer() {
        return new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest"));
    }

//    @Bean
//    @Primary
//    public NewTopic newTopic() {
//        return TopicBuilder.name("topic-visit")
//                .compact()
//                .build();
//    }

    public static void main(String[] args) {
        SpringApplication.
                from(KafkaDemoApplication::main).
                with(TestKafkaDemoApplication.class).
                run(args);
    }

}
