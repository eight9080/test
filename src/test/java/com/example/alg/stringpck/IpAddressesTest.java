package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class IpAddressesTest {

    @Test
    public void validIPAddress() {

        final IpAddresses i = new IpAddresses();

        assertEquals("IPv4", i.validIPAddress("172.16.254.1"));
        assertEquals("Neither", i.validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334"));
        assertEquals("IPv6", i.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        assertEquals("Neither", i.validIPAddress("256.256.256.256"));
    }
}