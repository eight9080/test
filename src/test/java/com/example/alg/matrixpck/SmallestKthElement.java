package com.example.alg.matrixpck;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * Example:
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * return 13.
 */
public class SmallestKthElement {

    public int kthSmallest(int[][] matrix, int k) {
        final int noRows = matrix.length;
        final int noColumns = matrix[0].length;

        final PriorityQueue<Element> heap = new PriorityQueue<>(Comparator.comparing(Element::getValue));

        for (int i = 0; i < noColumns; i++) {
            heap.add(new Element(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k-1; i++) {
            final Element element = heap.poll();
            if(element.getNoRow()==noRows-1){
                continue;
            }
            heap.add(new Element(element.getNoRow()+1, element.getNoColumn(),
                    matrix[element.getNoRow()+1][element.getNoColumn()]));
        }


        return heap.poll().getValue();
    }


    private static class Element {
        private int noRow;
        private int noColumn;
        private int value;

        Element(int noRow, int noColumn, int value) {
            this.noRow = noRow;
            this.noColumn = noColumn;
            this.value = value;
        }

        private int getNoRow() {
            return noRow;
        }

        private int getNoColumn() {
            return noColumn;
        }

        private int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "noRow=" + noRow +
                    ", noColumn=" + noColumn +
                    ", value=" + value +
                    '}';
        }
    }

}
