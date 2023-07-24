package com.example.TechnicalInterview.service;

import com.example.TechnicalInterview.entity.Team;
import com.example.TechnicalInterview.exceptions.TeamNotFoundException;
import com.example.TechnicalInterview.mapper.TeamMapper;
import com.example.TechnicalInterview.repository.ITeamRepository;
import com.example.TechnicalInterview.resources.TeamResource;
import org.springframework.stereotype.Service;

@Service
public class UpdateTeamService {
    private final ITeamRepository teamRepository;
    private final TeamMapper teamMapper;
    public UpdateTeamService(ITeamRepository teamRepository, TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    public void updateService(Long id,TeamResource teamResource) {
        Team team = teamRepository.findById(id).
                orElseThrow(() -> new TeamNotFoundException("No team found with that id"));

        teamRepository.save(teamMapper.map(team, teamResource));
    }
}
