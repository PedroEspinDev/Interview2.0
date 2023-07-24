package com.example.TechnicalInterview.service;

import com.example.TechnicalInterview.entity.Team;
import com.example.TechnicalInterview.exceptions.TeamNotFoundException;
import com.example.TechnicalInterview.repository.ITeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GetByIdTeamService {

    private final ITeamRepository teamRepository;

    public Team getById(Long id) throws TeamNotFoundException {

        Team team = teamRepository.
                findById(id).
                orElseThrow(() ->
                        new TeamNotFoundException("No team found with that id"));
        return team;
    }
}
