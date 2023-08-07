package com.example.TechnicalInterview.service;

import com.example.TechnicalInterview.entity.Team;
import com.example.TechnicalInterview.repository.ITeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = MockitoExtension.class)
public class DeleteTeamServiceTest {

    private ITeamRepository teamRepository;
    private DeleteTeamService deleteTeamService;

    @BeforeEach
    public void setUpServiceTest() {
        teamRepository = mock(ITeamRepository.class);
        deleteTeamService = new DeleteTeamService(teamRepository);
    }

    @Test
    void testDeleteTeamById() {

        Long teamId = 1L;
        Team exampleTeam = new Team(teamId,

                "Barcelona",
                "Barcelona",
                "Lionel Messi",
                99000,
                1,
                "La Liga",
                25,
                null);

        when(teamRepository.findById(teamId)).thenReturn(Optional.of(exampleTeam));

        deleteTeamService.deleteById(teamId);

        verify(teamRepository, times(1)).delete(exampleTeam);

    }
}

