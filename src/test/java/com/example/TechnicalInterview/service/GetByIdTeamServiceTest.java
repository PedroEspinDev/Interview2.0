package com.example.TechnicalInterview.service;

import com.example.TechnicalInterview.entity.Team;
import com.example.TechnicalInterview.repository.ITeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = MockitoExtension.class)
public class GetByIdTeamServiceTest {

        private ITeamRepository teamRepository;
        private GetByIdTeamService getByIdTeamService;

        @BeforeEach
        public void setUpServiceTest() {
                teamRepository = mock(ITeamRepository.class);
                getByIdTeamService = new GetByIdTeamService(teamRepository);
        }
        @Test
        void testGetByIdTeamFound() {

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

                Team result = getByIdTeamService.getById(teamId);

                verify(teamRepository, times(1)).findById(teamId);

                assertEquals(exampleTeam, result);
    }
}
