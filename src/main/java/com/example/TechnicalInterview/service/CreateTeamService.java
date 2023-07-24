package com.example.TechnicalInterview.service;

import com.example.TechnicalInterview.entity.Team;
import com.example.TechnicalInterview.repository.ITeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateTeamService {
    private final ITeamRepository teamRepository;

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }
}
