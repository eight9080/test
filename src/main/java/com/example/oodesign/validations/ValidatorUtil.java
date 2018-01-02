package com.example.oodesign.validations;

import java.util.Objects;

public class ValidatorUtil {

    public static final Validation<String> notNullString = GenericValidation.from(Objects::nonNull);

    public static final Validation<String> notEmptyString = GenericValidation.from(s -> !s.isEmpty());

    public static final Validation<Integer> notNullInteger = GenericValidation.from(Objects::nonNull);

    public static final Validation<Integer> greaterThanZero = GenericValidation.from(i -> i>0);

    public static Validation<String> stringMoreThan(int size){
        return GenericValidation.from(s-> s.length()>size);
    }

    public static Validation <String> stringLessThan(int size) {
        return GenericValidation.from(s -> ((String) s).length() < size);
    };

    public static Validation<String> stringBetween(int moreThan, int lessThan){
        return stringMoreThan(moreThan).and(stringLessThan(lessThan));
    }

    public static Validation <Integer> integerMoreThan(int limit) {
        return GenericValidation.from(s -> s > limit);
    };
    public static Validation <Integer> integerLessThan(int size) {
        return GenericValidation.from(s -> s < size);
    };
    public static Validation <Integer> integerBetween(int morethan, int lessThan) {
        return integerMoreThan(morethan).and(integerLessThan(lessThan));
    };

}
