package com.dg;

import com.example.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayComparatorTest {

    private int[] toSort;
    private int[] sortedInts;
    private int[] sortedRangeInts;
    private HashMap<Integer, String> map = new HashMap<>();
    private Employee[] employees;
    private Employee[] employeesSorted;
    private Employee[] employeesSortedByAge;


    @Before
    public void initVariables() {

        toSort = new int[]{5, 1, 89, 255, 7, 88, 200, 123, 66};
        sortedInts = new int[]{1, 5, 7, 66, 88, 89, 123, 200, 255};
        sortedRangeInts = new int[]{5, 1, 89, 7, 88, 200, 255, 123, 66};

        map.put(55, "John");
        map.put(22, "Apple");
        map.put(66, "Earl");
        map.put(77, "Pearl");
        map.put(12, "George");
        map.put(6, "Rocky");

        employees = new Employee[] { new Employee("John", 23, 5000), new Employee("Steve", 26, 6000), new Employee("Frank", 33, 7000), new Employee("Earl", 43, 10000), new Employee("Jessica", 23, 4000), new Employee("Pearl", 33, 6000) };
        employeesSorted = new Employee[] { new Employee("Earl", 43, 10000), new Employee("Frank", 33, 70000), new Employee("Jessica", 23, 4000), new Employee("John", 23, 5000), new Employee("Pearl", 33, 4000), new Employee("Steve", 26, 6000) };
        employeesSortedByAge = new Employee[] { new Employee("John", 23, 5000), new Employee("Jessica", 23, 4000), new Employee("Steve", 26, 6000), new Employee("Frank", 33, 70000), new Employee("Pearl", 33, 4000), new Employee("Earl", 43, 10000) };

    }


    @Test
    public void givenIntArray_whenUsingSort_thenSortedArray() {
        Arrays.sort(toSort);
        assertTrue(Arrays.equals(toSort, sortedInts));
    }

    @Test
    public void givenIntArray_whenUsingRangeSort_thenRangeSortedArray() {
        Arrays.sort(toSort, 3, 7);
        assertTrue(Arrays.equals(toSort, sortedRangeInts));
    }
    @Test
    public void givenIntArray_whenUsingParallelSort_thenArraySorted() {
        Arrays.parallelSort(toSort);
        assertTrue(Arrays.equals(toSort, sortedInts));
    }

    @Test
    public void givenList_whenUsingSort_thenSortedList() {
        List<Integer> toSortList = IntStream.of(toSort).boxed().collect(Collectors.toList());
        Collections.sort(toSortList);
        assertTrue(Arrays.equals(toSortList.toArray(), Arrays.stream(sortedInts).mapToObj(Integer::valueOf).toArray()));
    }

    @Test
    public void givenSet_whenUsingSort_thenSortedSet() {
        Set<Integer> integersSet = IntStream.of(toSort).boxed().collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> descSortedIntegersSet = new LinkedHashSet<>(Arrays.asList(new Integer[]{255, 200, 123, 89, 88, 66, 7, 5, 1}));
        List<Integer> list = new ArrayList<>(integersSet);
        list.sort((i1, i2) -> i2 - i1);

        integersSet = new LinkedHashSet<>(list);

        assertTrue(Arrays.equals(integersSet.toArray(), descSortedIntegersSet.toArray()));
    }

    @Test
    public void givenMap_whenSortingByKeys_thenSortedMap() {
        System.out.println("***givenMap_whenSortingByKeys_thenSortedMap");
        Integer[] sortedKeys = new Integer[]{6, 12, 22, 55, 66, 77};

        final Integer[] resultedSortedKeys = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .peek(a -> System.out.println("key: "+a.getKey()+" Value "+a.getValue()))
                .map(Map.Entry::getKey).toArray(Integer[]::new);
         assertArrayEquals(sortedKeys, resultedSortedKeys);

    }
    @Test
    public void givenMap_whenSortingByValues_thenSortedMap() {
        System.out.println("***givenMap_whenSortingByValues_thenSortedMap");
        String[] sortedValues = new String[]
                {"Apple", "Earl", "George", "John", "Pearl", "Rocky"};
        final String[] resultedSortedValues = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .peek(a -> System.out.println("key: "+a.getKey()+" Value "+a.getValue()))
                .map(Map.Entry::getValue)
                .toArray(String[]::new);
        assertArrayEquals(sortedValues, resultedSortedValues);

    }
    @Test
    public void givenEmpArray_SortEmpArray_thenSortedArrayinNaturalOrder() {
        Arrays.sort(employees);

        assertTrue(Arrays.equals(employees, employeesSorted));
    }

    @Test
    public void givenIntegerArray_whenUsingSort_thenSortedArray() {
        Integer [] integers = Arrays.stream(toSort).mapToObj(Integer::valueOf).toArray(Integer[]::new);
        Arrays.sort(integers, Comparator.comparingInt(a -> a));
        assertTrue(Arrays.equals(integers,
                Arrays.stream(sortedInts).mapToObj(Integer::valueOf).toArray(Integer[]::new)));
    }

    @Test
    public void givenArrayObjects_whenUsingComparing_thenSortedArrayObjects() {
        List<Employee> employeesList = Arrays.asList(employees);
        employeesList.sort(Comparator.comparing(Employee::getAge));
        assertArrayEquals(employeesSortedByAge, employeesList.toArray());
    }



}
