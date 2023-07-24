package com.example.TechnicalInterview.service;

import com.example.TechnicalInterview.entity.Team;
import com.example.TechnicalInterview.exceptions.TeamNotFoundException;
import com.example.TechnicalInterview.repository.ITeamRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteTeamService {

    private final ITeamRepository teamRepository;

    public DeleteTeamService(ITeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
    public void deleteById(Long id) {
        Team team = teamRepository.findById(
                id).orElseThrow(() -> new TeamNotFoundException("Team id not found"));

        teamRepository.delete(team);
    }
}
