package com.example.cassandrajava.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table
@Builder
public class Balloon {
    @PrimaryKey
    private UUID id;
    private String name;
}
