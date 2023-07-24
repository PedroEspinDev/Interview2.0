package com.example.TechnicalInterview.controller;

import com.example.TechnicalInterview.entity.Team;
import com.example.TechnicalInterview.service.GetAllTeamsService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class GetAllTeamsController {

    private final GetAllTeamsService getAllService;

    @GetMapping("/getAll")
    public List<Team> getTeams() {
        return getAllService.getAll();
    }
}
