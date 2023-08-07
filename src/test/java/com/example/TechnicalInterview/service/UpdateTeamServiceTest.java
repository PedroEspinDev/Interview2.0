package com.example.TechnicalInterview.service;

import com.example.TechnicalInterview.entity.Team;
import com.example.TechnicalInterview.mapper.TeamMapper;
import com.example.TechnicalInterview.repository.ITeamRepository;
import com.example.TechnicalInterview.resources.TeamResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UpdateTeamServiceTest {
    private ITeamRepository teamRepository;
    private TeamMapper teamMapper;
    private UpdateTeamService updateTeamService;

    @BeforeEach
    public void setUp() {
        teamRepository = mock(ITeamRepository.class);
        teamMapper = mock(TeamMapper.class);
        updateTeamService = new UpdateTeamService(teamRepository, teamMapper);
    }

    @Test
    public void testUpdateServiceWithExistingTeam() {
        Long teamId = 1L;

        Team existingTeam = new Team(teamId, "Barcelona",
                "Barcelona",
                "Lionel Messi",
                99000,
                1,
                "La Liga",
                25,
                null);

        TeamResource teamResource = new TeamResource(teamId,"Barcelona",
                "Barcelona",
                "Lionel Messi",
                99000,
                1,
                "La Liga",
                25);

        Team updatedTeam = new Team(teamId,
                "Barcelona",
                "Barcelona",
                "Xavi Hernandez",
                99000,
                1,
                "La Liga",
                25,
                null);

        when(teamRepository.findById(teamId)).thenReturn(Optional.of(existingTeam));
        when(teamMapper.map(existingTeam, teamResource)).thenReturn(updatedTeam);
        when(teamRepository.save(updatedTeam)).thenReturn(updatedTeam);

        updateTeamService.updateService(teamId, teamResource);

        verify(teamRepository, times(1)).findById(teamId);

        verify(teamMapper, times(1)).map(existingTeam, teamResource);

        verify(teamRepository, times(1)).save(updatedTeam);
    }

}


