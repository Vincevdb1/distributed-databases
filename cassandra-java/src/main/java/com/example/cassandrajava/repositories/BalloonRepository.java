package com.example.cassandrajava.repositories;

import com.example.cassandrajava.domain.Balloon;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalloonRepository extends CrudRepository<Balloon, UUID> {
}
