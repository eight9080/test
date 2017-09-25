package com.example.designpatterns.visitor.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartsOrder implements AtvPart{

    private List<AtvPart> parts = new ArrayList<>();

    public void addPart(AtvPart atvPart) {
        this.parts.add(atvPart);
    }

    public List<AtvPart> getParts() {
        return Collections.unmodifiableList(parts);
    }

    @Override
    public void accept(AtvPartVisitor visitor) {
        for (AtvPart part: parts) {
            part.accept(visitor);
        }
        visitor.visit(this);
    }

}