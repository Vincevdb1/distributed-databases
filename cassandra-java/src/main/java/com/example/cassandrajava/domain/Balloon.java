package com.example.cassandrajava.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Balloon {
    @PrimaryKey
    private int id;
    private String name;
}
