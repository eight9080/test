package com.example.oodesign.validations;

import java.util.Optional;

public class GenericValidationResult {
    private boolean isValid;

    public static GenericValidationResult ok(){
        return new GenericValidationResult(true);
    }

    public static GenericValidationResult fail(){
        return new GenericValidationResult(false);
    }

    private GenericValidationResult(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean isValid() {
        return isValid;
    }

    public Optional<String> getFieldNameIfInvalid(String field){
        return this.isValid()? Optional.empty() : Optional.of(field);
    }

}
