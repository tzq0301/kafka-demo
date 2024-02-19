package org.example.kafkademo.visit;

import java.time.LocalDateTime;

public record Visit(String visitor, LocalDateTime visitTime) {
    public Visit(String visitor) {
        this(visitor, LocalDateTime.now());
    }
}
