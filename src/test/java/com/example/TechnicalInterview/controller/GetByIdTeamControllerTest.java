package com.example.TechnicalInterview.controller;

import com.example.TechnicalInterview.entity.Team;
import com.example.TechnicalInterview.service.GetByIdTeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = MockitoExtension.class)
public class GetByIdTeamControllerTest {

    private GetByIdTeamService getByIdTeamService;
    private GetByIdTeamController getByIdTeamController;

    @BeforeEach
    public void setUpControllerTest() {
        getByIdTeamService = mock(GetByIdTeamService.class);
        getByIdTeamController = new GetByIdTeamController(getByIdTeamService);
    }

    @Test
    void testGetByIdTeamFound() {

        Long teamId = 1L;

        Team exampleTeam = new Team();
        exampleTeam.setId(1L);
        exampleTeam.setName("Barcelona");
        exampleTeam.setCity("Barcelona");
        exampleTeam.setOwner("Lionel Messi");
        exampleTeam.setStadiumCapacity(99000);
        exampleTeam.setDivision(1);
        exampleTeam.setCompetition("La Liga");
        exampleTeam.setNumberOfPlayers(25);
        exampleTeam.getCreationDate();

        when(getByIdTeamService.getById(teamId)).thenReturn(exampleTeam);

        Team result = getByIdTeamService.getById(teamId);

        verify(getByIdTeamService, times(1)).getById(teamId);

        assertEquals(exampleTeam, result);
    }
}

