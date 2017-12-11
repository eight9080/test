package com.example.alg.graphpck;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ReconstructItineraryTest {
    @Test
    public void findItinerary() throws Exception {


        final ReconstructItinerary r = new ReconstructItinerary();
        final List<String> itinerary = r.findItinerary(new String[][]{
                {"MUC", "LHR"}, {"JFK", "MUC"},
                {"SFO", "SJC"}, {"LHR", "SFO"}
        });

        assertEquals(Arrays.asList("JFK", "MUC", "LHR", "SFO", "SJC"),
                itinerary);

    }

    @Test
    public void findItinerary2() throws Exception {

        final ReconstructItinerary r = new ReconstructItinerary();
        final List<String> itinerary = r.findItinerary(new String[][]{
                {"JFK","SFO"},{"JFK","ATL"},
                {"SFO","ATL"},{"ATL","JFK"},
                {"ATL","SFO"}
        });

        final List<String> expect1 = Arrays.asList("JFK", "ATL", "JFK", "SFO", "ATL", "SFO");
        final boolean first = expect1.equals(itinerary);
        final boolean second = Arrays.asList("JFK", "SFO", "ATL", "JFK", "ATL", "SFO")
                .equals(itinerary);

        assertTrue(first || second);
    }

    @Test
    public void findItinerary3() throws Exception {


        final ReconstructItinerary r = new ReconstructItinerary();
        final List<String> itinerary = r.findItinerary(new String[][]{
                {"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}
        });

        assertEquals(Arrays.asList("JFK","NRT","JFK","KUL"),
                itinerary);

    }

}