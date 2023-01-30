package com.example.recipeapp.model.validation;

import com.example.recipeapp.model.exceptions.ValidationException;
import org.apache.commons.lang3.StringUtils;

public class Validation {

    public static String validateString(String value) throws ValidationException {
        //if (value == null || value.isBlank() || value.isEmpty())
        if (StringUtils.isBlank(value)) {
            throw new ValidationException("Введите корректные данные!");
        } else {
            return value;
        }
    }

    public static Integer validateQuantity(Integer value) throws ValidationException {
        if (value == null || value < 0) {
            throw new ValidationException("Введите целое положительное число!");
        } else {
            return value;
        }
    }
}
