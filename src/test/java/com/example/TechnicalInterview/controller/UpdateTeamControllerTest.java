package com.example.TechnicalInterview.controller;

import com.example.TechnicalInterview.resources.TeamResource;
import com.example.TechnicalInterview.service.UpdateTeamService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.put;

@ExtendWith(MockitoExtension.class)
public class UpdateTeamControllerTest {

    @Mock
    private UpdateTeamService updateTeamService;

    @InjectMocks
    private UpdateTeamController updateTeamController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUpUpdateControllerTest() {
        updateTeamService = mock(UpdateTeamService.class);
        updateTeamController = new UpdateTeamController(updateTeamService);
        mockMvc = MockMvcBuilders.standaloneSetup(updateTeamController).build();
    }

    @Test
    public void testUpdateServiceWithExistingTeam() {

        Long teamId = 1L;
        TeamResource teamResource = TeamResource.builder()

                .id(teamId)
                .name("FC Barcelona")
                .city("Barcelona")
                .owner("Club members")
                .stadiumCapacity(99354)
                .division(1)
                .competition("La Liga")
                .numberOfPlayers(28)
                .build();

        doNothing().when(updateTeamService).updateService(teamId, teamResource);

        ObjectMapper objectMapper = new ObjectMapper();
        String teamResourceJson = objectMapper.writeValueAsString(teamResource);

        mockMvc.perform(put("/team/update/" + teamId)
                .contentType(MediaType.valueOf("application/json"))
                .content(teamResourceJson));
        verify(updateTeamService, times(1)).updateService(teamId, teamResource);
    }
}
