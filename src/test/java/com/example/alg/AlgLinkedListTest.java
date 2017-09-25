package com.example.alg;

import com.example.alg.model.CustomLinkedList;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class AlgLinkedListTest {
    @Test
    public void findMiddleElement() throws Exception {
        final CustomLinkedList list = new CustomLinkedList();
        list.addAll(Arrays.asList("1", "2", "3","4"));

        final CustomLinkedList.Node middleElement = new AlgLinkedList().findMiddleElement(list);
        assertThat(middleElement, notNullValue());
        assertThat(middleElement.getData(), is("2"));

    }

    @Test
    public void findIfLoop() throws Exception {
        final CustomLinkedList list = new CustomLinkedList();
        final CustomLinkedList.Node node3 = new CustomLinkedList.Node("3");
        list.addAll(Arrays.asList("1", "2", "3", "4"));
        list.add(node3);
        list.addAll(Arrays.asList("5", "6", "7"));
        final CustomLinkedList.Node node8 = new CustomLinkedList.Node("8");
        node8.setNext(node3);
        list.add(node8);

        final boolean hasLoop = new AlgLinkedList().hasLoop(list);
        assertThat(hasLoop, is(true));

        final boolean ifLoop = new AlgLinkedList().findIfLoop(list);
        assertThat(ifLoop, is(true));

    }

    @Test
    public void find3ThElementFromEndList() throws Exception {
        final CustomLinkedList list = new CustomLinkedList();
        list.addAll(Arrays.asList("1", "2", "3","4"));
        final CustomLinkedList.Node thirdElement = new AlgLinkedList().find3ThElementFromEndList(list);
        assertThat(thirdElement, notNullValue());
        assertThat(thirdElement.getData(), is("2"));
    }

    @Test
    public void getLastNElement() throws Exception {
        final CustomLinkedList list = new CustomLinkedList();
        list.addAll(Arrays.asList("1", "2", "3","4"));
        assertThat(list.getLastNode(3), is("2"));
        assertThat(list.getLastNode(2), is("3"));

    }
}