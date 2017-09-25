package com.example.designpatterns.exception;

public class BusinessException  extends RuntimeException{

    private BusinessReason businessReason;

    public BusinessException(BusinessReason businessReason) {
        super(businessReason.toString());
        this.businessReason = businessReason;
    }

    public BusinessReason getBusinessReason() {
        return businessReason;
    }

    public enum BusinessReason{
        REPORT_NOT_APPROVED,

        NO_CARDS, MAX_NO_CARDS
    }

}