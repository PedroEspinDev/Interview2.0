package com.example.TechnicalInterview.controller;

import com.example.TechnicalInterview.entity.Team;
import com.example.TechnicalInterview.service.GetTeamsByStadiumCapacityDescService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/team")
public class GetTeamsByStadiumCapacityDescController {

    private final GetTeamsByStadiumCapacityDescService getTeamsByStadiumCapacityDescService;

    public GetTeamsByStadiumCapacityDescController(GetTeamsByStadiumCapacityDescService getTeamsByStadiumCapacityDescService) {
        this.getTeamsByStadiumCapacityDescService = getTeamsByStadiumCapacityDescService;
    }

    @GetMapping("/getAllByCapacity")
    public ResponseEntity<List<Team>> getAllByCapacity() {
        return ResponseEntity.ok(getTeamsByStadiumCapacityDescService.getAllByCapacity());
    }
}
