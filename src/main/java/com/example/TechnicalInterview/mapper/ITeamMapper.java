package com.example.TechnicalInterview.mapper;

import com.example.TechnicalInterview.entity.Team;
import com.example.TechnicalInterview.resources.TeamResource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ITeamMapper {

    TeamResource entityToDto(Team team);

    Team dtoToEntity(TeamResource teamResource);

    ITeamMapper INSTANCE = Mappers.getMapper(ITeamMapper.class);
}
