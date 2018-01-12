package com.example.alg.permutations;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class IPAddressesTest {
    @Test
    public void restoreIpAddresses() throws Exception {

        final IPAddresses ip = new IPAddresses();
        final List<String> ipAddresses = ip.restoreIpAddresses("25525511135");

        assertEquals(Arrays.asList("255.255.11.135", "255.255.111.35"), ipAddresses);

    }

}