package com.example.TechnicalInterview.controller;

import com.example.TechnicalInterview.service.DeleteTeamService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/team")
public class DeleteTeamController {

    private final DeleteTeamService deleteTeamService;

    public DeleteTeamController(DeleteTeamService deleteTeamService) {
        this.deleteTeamService = deleteTeamService;
    }
    @DeleteMapping("deleteById/{id}")
    public void deleteTeam(@PathVariable Long id) {
        deleteTeamService.deleteById(id);
    }
}
