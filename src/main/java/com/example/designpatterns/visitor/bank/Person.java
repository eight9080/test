package com.example.designpatterns.visitor.bank;

import java.util.ArrayList;
import java.util.List;

public class Person implements IAsset{

    public List<IAsset> assets = new ArrayList<>();

    public List<IAsset> getAssets() {
        return assets;
    }

    @Override
    public void accept(IVisitor visitor) {
        assets.stream()
                .forEach(asset -> asset.accept(visitor));
    }
}
