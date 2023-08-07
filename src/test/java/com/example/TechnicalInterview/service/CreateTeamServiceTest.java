package com.example.TechnicalInterview.service;

import com.example.TechnicalInterview.entity.Team;
import com.example.TechnicalInterview.repository.ITeamRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateTeamServiceTest {

    @Mock
    private ITeamRepository teamRepository;

    @InjectMocks
    private CreateTeamService createTeamService;

    @Test
    void testCreateTeam() {

        Team team = Team.builder()
                .name("Barcelona")
                .city("Barcelona")
                .owner("Lionel Messi")
                .stadiumCapacity(99000)
                .division(1)
                .competition("La Liga")
                .numberOfPlayers(25)
                .creationDate(LocalDate.now())
                .build();


        when(teamRepository.save(any())).thenReturn(team);

        Team result = createTeamService.createTeam(team);

        verify(teamRepository).save(team);
        Assertions.assertEquals("Barcelona", result.getName());
        Assertions.assertEquals("Barcelona", result.getCity());
        Assertions.assertEquals("Lionel Messi", result.getOwner());
        Assertions.assertEquals(99000, result.getStadiumCapacity());
        Assertions.assertEquals(1, result.getDivision());
        Assertions.assertEquals("La Liga", result.getCompetition());
        Assertions.assertEquals(25, result.getNumberOfPlayers());
        Assertions.assertEquals(LocalDate.now(), result.getCreationDate());
    }
}

