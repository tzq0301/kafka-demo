package org.example.kafkademo.visit;

import java.time.LocalDateTime;

public record VisitEvent(String visitor, LocalDateTime visitTime) {
    public VisitEvent(String visitor) {
        this(visitor, LocalDateTime.now());
    }
}
