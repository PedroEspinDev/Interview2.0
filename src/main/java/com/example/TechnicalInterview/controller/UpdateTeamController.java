package com.example.TechnicalInterview.controller;

import com.example.TechnicalInterview.exceptions.TeamNotFoundException;
import com.example.TechnicalInterview.resources.TeamResource;
import com.example.TechnicalInterview.service.UpdateTeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Validated
@RestController
@RequestMapping("/team")
public class UpdateTeamController {
    private final UpdateTeamService updateTeamService;

    public UpdateTeamController(UpdateTeamService updateTeamService) {
        this.updateTeamService = updateTeamService;
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void updateTeam(@PathVariable Long id, @Valid @RequestBody TeamResource teamResource) {
        updateTeamService.updateService(id, teamResource);
    }

    @ExceptionHandler(TeamNotFoundException.class)
    public ResponseEntity<String> handleInvalidInitialStatusException(final RuntimeException exception) {

        return ResponseEntity.
                status(HttpStatus.NOT_FOUND).
                body(exception.getMessage());
    }
}
