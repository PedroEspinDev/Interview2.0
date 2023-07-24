package com.example.TechnicalInterview.controller;

import com.example.TechnicalInterview.entity.Team;
import com.example.TechnicalInterview.service.GetByIdTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class GetByIdTeamController {

    private final GetByIdTeamService getByIdTeamService;

    @GetMapping("/getTeamById/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        Team team = getByIdTeamService.getById(id);
        return ResponseEntity.ok(team);
    }
}
