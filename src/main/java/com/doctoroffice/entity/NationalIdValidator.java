package com.doctoroffice.entity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NationalIdValidator implements ConstraintValidator<CheckNationalId, String> {
    @Override
    public void initialize(CheckNationalId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (!s.matches("^\\d{10}$"))
            return false;

        int sum = 0;

        for (int i = 0; i < 9; i++)
        {
            sum += Character.getNumericValue(s.charAt(i)) * (10 - i);
        }

        int lastDigit = Integer.parseInt(String.valueOf(s.charAt(9)));
        int divideRemaining = sum % 11;

        return ((divideRemaining < 2 && lastDigit == divideRemaining) ||   (divideRemaining >= 2 && (11 - divideRemaining) == lastDigit ));
    }
}
