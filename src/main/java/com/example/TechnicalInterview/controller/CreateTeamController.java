package com.example.TechnicalInterview.controller;

import com.example.TechnicalInterview.entity.Team;
import com.example.TechnicalInterview.service.CreateTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class CreateTeamController {

    private final CreateTeamService createTeamService;

    @PostMapping("create")
    public ResponseEntity<String> create(@Valid @RequestBody Team team) {
        createTeamService.createTeam(team);
        return new ResponseEntity<>("Team added sucessfully", HttpStatus.CREATED);
    }
}
