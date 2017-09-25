package com.example.designpatterns.visitor.bank;

public interface IAsset {

    void accept(IVisitor visitor);
}
