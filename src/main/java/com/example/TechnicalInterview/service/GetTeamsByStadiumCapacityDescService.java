package com.example.TechnicalInterview.service;

import com.example.TechnicalInterview.entity.Team;
import com.example.TechnicalInterview.repository.ITeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetTeamsByStadiumCapacityDescService {

    private final ITeamRepository teamRepository;

    public List<Team> getAllByCapacity() {
        return teamRepository.findAllByOrderByStadiumCapacityDesc();
    }
}
