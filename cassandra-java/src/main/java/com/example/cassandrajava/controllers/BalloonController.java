package com.example.cassandrajava.controllers;

import com.example.cassandrajava.domain.Balloon;
import com.example.cassandrajava.repositories.BalloonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/balloons")
public class BalloonController {
    @Autowired
    private BalloonRepository balloonRepository;

    @GetMapping
    public List<Balloon> getAllBalloons() {
        return (List<Balloon>) balloonRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> addDummyBalloon() {
        var balloon = Balloon.builder().id(UUID.randomUUID()).name("balloon1").build();

        balloonRepository.save(balloon);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
