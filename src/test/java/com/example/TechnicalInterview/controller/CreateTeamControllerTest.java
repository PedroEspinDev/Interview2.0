package com.example.TechnicalInterview.controller;

import com.example.TechnicalInterview.entity.Team;
import com.example.TechnicalInterview.service.CreateTeamService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = MockitoExtension.class)
public class CreateTeamControllerTest {

    @Mock
    private CreateTeamService createTeamService;

    @InjectMocks
    private CreateTeamController createTeamController;

    @Test
    public void testCreateTeam() {

        Team team = new Team();
        team.setName("Barcelona");
        team.setCity("Barcelona");
        team.setOwner("Lionel Messi");
        team.setStadiumCapacity(99000);
        team.setDivision(1);
        team.setCompetition("La Liga");
        team.setNumberOfPlayers(25);
        team.getCreationDate();

        when(createTeamService.createTeam(any())).thenReturn(team);
    }
}
