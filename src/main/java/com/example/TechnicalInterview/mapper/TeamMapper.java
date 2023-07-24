package com.example.TechnicalInterview.mapper;

import com.example.TechnicalInterview.entity.Team;
import com.example.TechnicalInterview.resources.TeamResource;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {
    private final ITeamMapper teamMapper;

    public TeamMapper(ITeamMapper teamMapper) {
        this.teamMapper = teamMapper;
    }
    public Team map (Team team, TeamResource teamResource) {
        if (null == team || null == teamResource){
            return team;
        }

        team.setName(teamResource.getName());
        team.setCity(teamResource.getCity());
        team.setOwner(teamResource.getOwner());
        team.setStadiumCapacity(teamResource.getStadiumCapacity());
        team.setDivision(teamResource.getDivision());
        team.setCompetition(teamResource.getCompetition());
        team.setNumberOfPlayers(teamResource.getNumberOfPlayers());

        return team;
    }
}
