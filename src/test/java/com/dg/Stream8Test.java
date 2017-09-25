package com.dg;

import com.example.Company;
import com.example.Developer;
import com.example.Person;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Stream8Test {

    @Test
    public void testDistinctElements(){
        Person lokesh = new Person(1, "Lokesh", "Gupta");
        Person brian = new Person(2, "Brian", "Clooney");
        Person alex = new Person(3, "Alex", "Kolen");

        //Add some random persons
        Collection<Person> list = Arrays.asList(lokesh,brian,alex,lokesh,brian,lokesh);
        final List<Person> resultedList = list.stream().filter(distinctByKey(Person::getId)).collect(Collectors.toList());

        final List<Person> expectedList = Arrays.asList(lokesh, brian, alex);
        assertEquals(expectedList, resultedList);
        assertNotEquals(expectedList, list);

    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor){
        final ConcurrentHashMap<Object, Boolean> map = new ConcurrentHashMap<>();
        return t-> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE)==null;
    }


    @Test
    public void flatMapStream(){
        List<Company> companyList = new ArrayList<>();

        Company gName = new Company("Google");
        gName.add("Gmail");
        gName.add("Docs");
        gName.add("Google Apps");

        Company yName = new Company("Yahoo");
        yName.add("YMail");
        yName.add("Yahoo Sites");

        companyList.add(gName);
        companyList.add(yName);

        // Returns a stream consisting of the results of replacing each element of this stream with the contents of a mapped
        // stream produced by applying the provided mapping function to each element
        log("Here is a list of all Company product list:");

        final List<String> productList = companyList.stream()
                .flatMap(elem -> elem.getProducts().stream()).collect(Collectors.toList());
        log(productList.toString());
        assertEquals(Arrays.asList("Gmail", "Docs", "Google Apps", "YMail", "Yahoo Sites"), productList);
    }

    @Test
    public void temporalExample(){
        // A date-time without a time-zone in the ISO-8601 calendar system
        // String time = LocalDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-mm-yyyy");
        // Let's return currentitme - 1 year
        final LocalDateTime dateTime = LocalDateTime.now().minusYears(1);

        log(dateTime.format(dateFormatter));

        // TemporalAdjusters: Adjusters are a key tool for modifying temporal objects
        log("\n- get 1st Day of Month: " + dateTime.with(TemporalAdjusters.firstDayOfMonth()));

        // Returns the "last day of month" adjuster
        log("- get Last Day of Month: " + dateTime.with(TemporalAdjusters.lastDayOfMonth()));

        // Returns the "first day of year" adjuster
        log("- get 1st Day of Year: " + dateTime.with(TemporalAdjusters.firstDayOfYear()));

        // Returns the next day-of-week adjuster
        log("- get next Day Of Week: "
                + dateTime.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY)));

        // Returns the "last day of year" adjuster
        log("- get last Day of Year: " + dateTime.with(TemporalAdjusters.lastDayOfYear()));

        // Returns the last in month adjuster
        log("- get last Day Of Week: "
                + dateTime.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY)));

    }

    @Test
    public void streamArray(){
        final Integer[] expectedIntegers = {1, 10, 100, 1000, 10000};
        final int[] expectedInts = {1, 10, 100, 1000, 10000};
        Stream<Integer> powerOfTen = Stream.of(1, 10, 100, 1000, 10000);
        final Integer[] integers = powerOfTen.toArray(Integer[]::new);

        System.out.println(Arrays.toString(integers));
        assertArrayEquals(expectedIntegers, integers);

        final int[] intArray = Stream.of(1, 10, 100, 1000, 10000).mapToInt(x -> x).toArray();
        System.out.println(Arrays.toString(intArray));
        assertArrayEquals(expectedInts, intArray);

        final int[] expectedInts2 = {1, 2, 3, 4, 5};
        Stream<String> numbers = Stream.of("1", "2", "3", "4", "5");
        final int[] ints = numbers.mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(ints));
        assertArrayEquals(expectedInts2, ints);

        String[] expectedCities = {"London", "Paris", "Tokyo"};
        Stream<String> cities = Stream.of("London", "Paris", "Tokyo");
        final String[] citiesArray = cities.toArray(String[]::new);
        System.out.println(Arrays.toString(citiesArray));
        assertArrayEquals(expectedCities, citiesArray);


        ArrayList<Integer> list = Stream.of(11, 22, 33, 44, 55).collect(Collectors.toCollection(ArrayList::new));
        Integer[] iArray = list.toArray(new Integer[list.size()]);
        assertArrayEquals(new Integer[]{11, 22, 33, 44, 55}, iArray);

    }

    @Test
    public void flatMap() {

        List<Developer> team = Arrays.asList(
                new Developer(18, "java"),
                new Developer(20, "java"),
                new Developer(35, "javascript"),
                new Developer(50, "javascript"),
                new Developer(50, "logo"));

        final Map<String, List<Developer>> developersByLanguages = team.stream()
                .collect(Collectors.groupingBy(Developer::getFavoriteLanguage));

        System.out.println(developersByLanguages);


        final Map<String, Double> favoriteLanguageByAverageAge = team.stream()
                .collect(Collectors.groupingBy(Developer::getFavoriteLanguage,
                        Collectors.averagingInt(Developer::getAge)));

        System.out.println(favoriteLanguageByAverageAge);

    }

    @Test
    public void createStream_whenFindAnyResultIsPresent_thenCorrect(){
        List<String> list = Arrays.asList("A","B","C","D");
        final Optional<String> result = list.stream().findAny();

        assertThat(result.isPresent(), is(true));
        System.out.println(result.get());
        assertThat(result.get(), anyOf(is("A"), is("B"), is("C"), is("D")));
    }

    @Test
    public void createParallelStream_whenFindAnyResultIsNotFirst_thenCorrect() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        final Optional<Integer> result = list.stream().parallel().filter(num -> num < 4).findAny();
        assertThat(result.isPresent(), is(true));
        System.out.println(result.get());
        assertThat(result.get(), anyOf(is(1), is(2), is(3)));
    }

    @Test
    public void createStream_whenFindFirstResultIsPresent_thenCorrect() {

        List<String> list = Arrays.asList("A", "B", "C", "D");

        final Optional<String> result = list.stream().findFirst();
        assertThat(result.isPresent(), is(true));
        assertThat(result.get(), is("A"));

    }

    private static void log(String msg) {
        System.out.println(msg);

    }

}
