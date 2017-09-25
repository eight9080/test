package com.example.alg;

import com.example.alg.model.CustomLinkedList;

public class AlgLinkedList {

    public CustomLinkedList.Node findMiddleElement(CustomLinkedList list){

        final CustomLinkedList.Node head = list.getHead();
        CustomLinkedList.Node current = head;
        CustomLinkedList.Node middle = head;
        int length = 0;

        while (current.getNext()!=null){
            length++;
            if(length%2==0){
                middle = middle.getNext();
            }
            current = current.getNext();
        }

        if(length%2==1){
            middle= middle.getNext();
        }
        System.out.println("Length of LinkedList: "+length);
        return middle;
    }

    public boolean findIfLoop(CustomLinkedList list){
        CustomLinkedList.Node fastNode = list.getHead();
        CustomLinkedList.Node slowNode = list.getHead();
        while(true){
            slowNode = slowNode.getNext();// 1 hop
            System.out.println("Fast node: "+ fastNode+ " slow node "+slowNode);
            if( fastNode.getNext()==null){
                return false;
            }else{
                fastNode= fastNode.getNext().getNext();
            }
            if(fastNode==null || slowNode ==null){
                return false;
            }
            if(slowNode.getData().equals(fastNode.getData())){
                System.out.println("Pointing back to : " +slowNode.getData());
                return true;
            }
        }
    }

    boolean hasLoop(CustomLinkedList list) {
        final CustomLinkedList.Node first = list.getHead();

        if(first == null) // list does not exist..so no loop either.
            return false;
        CustomLinkedList.Node slow, fast; // create two references.
        slow = fast = first; // make both refer to the start of the list.

        while(true) {
            slow = slow.getNext();          // 1 hop.
            if (fast.getNext() != null)
                fast = fast.getNext().getNext(); // 2 hops.
            else
                return false;          // next node null => no loop.
            if (slow == null || fast == null) // if either hits null..no loop.
                return false;

            if (slow == fast){ // if the two ever meet...we must have a loop.
                     System.out.println("Pointing back to : " +slow.getData());
                return true;
            }
        }
    }

    public CustomLinkedList.Node find3ThElementFromEndList(CustomLinkedList list){
        if(list.getHead()==null){
            return null;
        }
        CustomLinkedList.Node fastNode = list.getHead();
        CustomLinkedList.Node slowNode = list.getHead();
        while(true){
            if(fastNode==null || fastNode.getNext()==null){
                return slowNode;
            }
            slowNode= slowNode.getNext();
            fastNode= fastNode.getNext().getNext();
        }

    }

}
