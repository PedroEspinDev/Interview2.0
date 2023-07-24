package com.example.TechnicalInterview.validators;

import com.example.TechnicalInterview.entity.Team;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CapacityStadiumValidator implements ConstraintValidator<CapacityStadium, Team> {

    @Override
    public boolean isValid(Team team, ConstraintValidatorContext context) {
        return team.getDivision() == 1 && team.getStadiumCapacity() > 50000 ||
                team.getDivision() == 2 && team.getStadiumCapacity() > 10000 ||
                team.getDivision() == 3 && team.getStadiumCapacity() > 3000;
    }
}
