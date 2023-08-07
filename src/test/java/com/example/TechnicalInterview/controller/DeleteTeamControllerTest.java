package com.example.TechnicalInterview.controller;

import com.example.TechnicalInterview.entity.Team;
import com.example.TechnicalInterview.service.DeleteTeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = MockitoExtension.class)
public class DeleteTeamControllerTest {
    private DeleteTeamService deleteTeamService;
    private DeleteTeamController deleteTeamController;

    @BeforeEach
    public void setUpControllerTest() {
        deleteTeamService = mock(DeleteTeamService.class);
        deleteTeamController = new DeleteTeamController(deleteTeamService);
    }

    @Test
    public void testDeleteTeamById() {

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

        doNothing().when(deleteTeamService).deleteById(teamId);

        deleteTeamController.deleteTeam(teamId);

        verify(deleteTeamService, times(1)).deleteById(teamId);
    }

}


