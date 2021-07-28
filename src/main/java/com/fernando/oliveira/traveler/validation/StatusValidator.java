package com.fernando.oliveira.traveler.validation;

import com.fernando.oliveira.traveler.domain.enums.StatusEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StatusValidator implements ConstraintValidator<Status, String> {

    private boolean required;

    @Override
    public void initialize(Status constraintAnnotation) {
        this.required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        for(StatusEnum statusEnum : StatusEnum.values()) {
            if(statusEnum.getCode().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
