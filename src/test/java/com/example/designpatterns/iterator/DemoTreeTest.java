package com.example.designpatterns.iterator;

import com.example.designpatterns.iterator.tree.DemoTree;
import org.junit.Test;

import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class DemoTreeTest {

    @Test
    public void startEmpty() throws Exception {
        final DemoTree<String> tree = new DemoTree<>();
        assertThat(tree, notNullValue());
    }

    @Test
    public void storeValueInRootNode() throws Exception {
        final DemoTree<Integer> tree = createTreeWithValues(1);
        assertThat(tree.getValue(),is(1) );
    }

    @Test
    public void storeSecondValueInLeftNode() throws Exception {
        final DemoTree<Integer> tree = createTreeWithValues(2);
        assertThat(tree.getLeftChild().getValue(),is(2) );
    }

    @Test
    public void storeThirdValueInRightNode() throws Exception {
        final DemoTree<Integer> tree = createTreeWithValues(3);
        assertThat(tree.getRightChild().getValue(),is(3) );
    }

    @Test
    public void storeFourthValueInLeftLeftNode() throws Exception {
        final DemoTree<Integer> tree = createTreeWithValues(4);
        assertThat(tree.getLeftChild().getLeftChild().getValue(),is(4) );
    }

    @Test
    public void storeFifthValueInLeftRightNode() throws Exception {
        final DemoTree<Integer> tree = createTreeWithValues(5);
        assertThat(tree.getLeftChild().getRightChild().getValue(),is(5) );
    }

    @Test
    public void storeSixthValueInRightLeftNode() throws Exception {
        final DemoTree<Integer> tree = createTreeWithValues(6);
        assertThat(tree.getRightChild().getLeftChild().getValue(),is(6) );
    }

    @Test
    public void listValuesInDepthFirstOrder() throws Exception {
        final DemoTree<Integer> tree = createTreeWithValues(6);
        final String result = tree.toList().stream().map(v -> v.toString()).collect(Collectors.joining(" "));
        assertThat(result, is("1 2 4 5 3 6"));

        final Iterator<Integer> iterator = tree.iterator();
        while (iterator.hasNext()){
            System.out.println("Value: " + iterator.next());
        }

        tree.setUseBreadthFirstIterator(true);
        final Iterator<Integer> iterator2 = tree.iterator();
        while (iterator2.hasNext()){
            System.out.println("Value: " + iterator2.next());
        }
    }

    private DemoTree<Integer> createTreeWithValues(int numberOfValues){
        if(numberOfValues<=0) return null;
        final DemoTree<Integer> tree = new DemoTree<>(1);
        IntStream.range(2, numberOfValues+1).forEach(val -> tree.add(val));
        return tree;
    }

//    private void displayTree
}