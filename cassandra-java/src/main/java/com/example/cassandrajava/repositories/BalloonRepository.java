package com.example.cassandrajava.repositories;

import com.example.cassandrajava.domain.Balloon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalloonRepository extends CrudRepository<Balloon, Integer> {
}
