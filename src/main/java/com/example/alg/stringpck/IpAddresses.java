package com.example.alg.stringpck;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IpAddresses {

    private enum IPTYPE {
        IPv4 (".", "\\."),
        IPv6 (":", "\\:");
        private String delimiter;
        private String escapeDelimiter;

        IPTYPE(String delimiter, String escapeDelimiter) {
            this.delimiter = delimiter;
            this.escapeDelimiter = escapeDelimiter;
        }
    }

    private final static Predicate<String> lengthValidationIp4 = (ip) -> ip.length() > 7;
    private final static Predicate<String> marginsValidationIp4 = (ip) -> !(ip.startsWith(IPTYPE.IPv4.delimiter) || ip.endsWith(IPTYPE.IPv4.delimiter));

    private final static Predicate<String> lengthValidationIp6 = (ip) -> ip.length() > 15;
    private final static Predicate<String> marginsValidationIp6 = (ip) -> !(ip.startsWith(IPTYPE.IPv6.delimiter) || ip.endsWith(IPTYPE.IPv6.delimiter));

    private final static Map<IPTYPE, Predicate<String>> basicValidation = new HashMap<>();

    static {
        basicValidation.put(IPTYPE.IPv4, lengthValidationIp4.and(marginsValidationIp4));
        basicValidation.put(IPTYPE.IPv6, lengthValidationIp6.and(marginsValidationIp6));
    }

    private final static Map<IPTYPE, Predicate<String[]>> partsValidation = new HashMap<>();

    static {
        partsValidation.put(IPTYPE.IPv4, (
                String[] tokens) ->
        {
            if (tokens.length != 4) {
                return false;
            }
            return Arrays.stream(tokens)
                    .map(IpAddresses::isValidIp4Part)
                    .filter(b -> !b).findFirst().orElse(true);
        });
        partsValidation.put(IPTYPE.IPv6, (
                String[] tokens) ->
        {
            if (tokens.length != 8) {
                return false;
            }
            return Arrays.stream(tokens)
                    .map(IpAddresses::isValidIp6Part)
                    .filter(b -> !b).findFirst().orElse(true);
        });
    }

    /**
     * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
     * <p>
     * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
     * <p>
     * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
     * <p>
     * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
     * <p>
     * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
     * <p>
     * Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
     * <p>
     * Note: You may assume there is no extra space or special characters in the input string.
     * <p>
     * Example 1:
     * Input: "172.16.254.1"
     * <p>
     * Output: "IPv4"
     * <p>
     * Explanation: This is a valid IPv4 address, return "IPv4".
     * Example 2:
     * Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
     * <p>
     * Output: "IPv6"
     * <p>
     * Explanation: This is a valid IPv6 address, return "IPv6".
     * Example 3:
     * Input: "256.256.256.256"
     * <p>
     * Output: "Neither"
     * <p>
     * Explanation: This is neither a IPv4 address nor a IPv6 address.
     */
    public String validIPAddress(String IP) {

        if(validateIp(IP, IPTYPE.IPv4)){
            return IPTYPE.IPv4.toString();
        }
        if(validateIp(IP, IPTYPE.IPv6)){
            return IPTYPE.IPv6.toString();
        }
        return "Neither";
    }

    private boolean validateIp(String ip, IPTYPE ipType) {
        if(!basicValidation.get(ipType).test(ip)){
            return false;
        }
        final String[] tokens = ip.split(ipType.escapeDelimiter);
        return partsValidation.get(ipType).test(tokens);
    }

    private boolean isIpv4(String ip, Predicate<String> basicValidation, Predicate<String[]> validateAllParts) {
        if (!basicValidation.test(ip)) {
            return false;
        }
        final String[] parts = ip.split("\\.");
        return validateAllParts.test(parts);
    }

    private  static boolean isValidIp4Part(String part) {
        if (part.startsWith("0") && part.length() > 1) {
            return false;
        }
        try {
            final int number = Integer.parseInt(part);
            if (number < 0 || number > 255) {
                return false;
            }
            if (number == 0 && part.charAt(0) != '0') {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isIpv6(String ip, Predicate<String> basicValidation, Predicate<String[]> validateAllParts) {
        if (!basicValidation.test(ip)) {
            return false;
        }
        final String[] parts = ip.split("\\:");
        return validateAllParts.test(parts);

    }

    private static boolean isValidIp6Part(String part) {
        if (part.length() == 0 || part.length() > 4) {
            return false;
        }
        for (char c : part.toCharArray()) {
            boolean isDigit = c >= 48 && c <= 57;
            boolean isUppercaseAF = c >= 65 && c <= 70;
            boolean isLowerCaseAF = c >= 97 && c <= 102;
            if (!(isDigit || isUppercaseAF || isLowerCaseAF))
                return false;
        }
        return true;
    }
}
