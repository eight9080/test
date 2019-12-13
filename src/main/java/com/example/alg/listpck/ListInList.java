package com.example.alg.listpck;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ListInList {


    public List<Item> searchForList(List<String> cart, List<String> sale) {

        final HashSet<String> onSale = new HashSet<>(sale);

        return cart.stream()
                .map(product -> new Item(product, onSale.contains(product)))
                .collect(Collectors.toList());

    }


    private static class Item {
        private String name;
        private boolean onSale;

        Item(String name, boolean onSale) {
            this.name = name;
            this.onSale = onSale;
        }
    }
}
