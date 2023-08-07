package com.example.TechnicalInterview.controller;

import com.example.TechnicalInterview.entity.Team;
import com.example.TechnicalInterview.service.GetAllTeamsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = MockitoExtension.class)
public class GetAllTeamsControllerTest {

    private GetAllTeamsService getAllTeamsService;
    private GetAllTeamsController getAllTeamsController;

    @BeforeEach
    public void setUpServiceTest() {
        getAllTeamsService = mock(GetAllTeamsService.class);
        getAllTeamsController = new GetAllTeamsController(getAllTeamsService);
    }

    @Test
    public void testGetAllTeams() {

        List<Team> exampleTeams = new ArrayList<>();
        exampleTeams.add(new Team(1L, "Barcelona",
                "Barcelona",
                "Lionel Messi",
                99000,
                1,
                "La Liga",
                25,
                null));

        exampleTeams.add(new Team(2L,
                "Real Madrid",
                "Madrid",
                "Sergio Ramos",
                84000,
                1,
                "La Liga",
                26,
                null));

        exampleTeams.add(new Team(3L,
                "Real Betis",
                "Sevilla",
                "Club members",
                60721,
                1,
                "La Liga",
                28,
                null));

        when(getAllTeamsService.getAll()).thenReturn(exampleTeams);

        List<Team> result = getAllTeamsController.getTeams();

        verify(getAllTeamsService, times(1)).getAll();

    }
}
