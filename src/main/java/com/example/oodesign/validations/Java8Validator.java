package com.example.oodesign.validations;

public class Java8Validator implements EmployeeValidator {

    @Override
    public void validate(Employee employee) throws EmployeeException {
        final StringBuilder errorFields = new StringBuilder();

        errorFields.append(
                ValidatorUtil.notNullString
                    .and(ValidatorUtil.notEmptyString)
                    .and(ValidatorUtil.stringBetween(1, 100))
                    .test(employee.getFirstName())
                    .getFieldNameIfInvalid("firstName ").orElse(""));

        errorFields.append(
                ValidatorUtil.notNullString
                        .and(ValidatorUtil.notEmptyString)
                        .and(ValidatorUtil.stringBetween(1, 100))
                        .test(employee.getLastName())
                        .getFieldNameIfInvalid("lastName ").orElse(""));

        errorFields.append(
                ValidatorUtil.notNullString
                        .and(ValidatorUtil.notEmptyString)
                        .and(ValidatorUtil.stringBetween(3, 100))
                        .test(employee.getEmail())
                        .getFieldNameIfInvalid("email ").orElse(""));

        errorFields.append(
                ValidatorUtil.notNullInteger
                        .and(ValidatorUtil.greaterThanZero)
                        .and(ValidatorUtil.integerBetween(18, 60))
                        .test(employee.getAge())
                        .getFieldNameIfInvalid("age ").orElse(""));

        String errors = errorFields.toString().trim();
        if(!errors.isEmpty()){
            throw new EmployeeException(errors);
        }

    }
}
