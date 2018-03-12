package com.example.alg.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest {

    final LongestPalindrome l = new LongestPalindrome();

    @Test
    public void longestPalindromicSubstringLinear() throws Exception {
        assertEquals(3, l.longestPalindromicSubstringLinear("babad"));
    }

    @Test
    public void longestPalindrome() throws Exception {


        final LongestPalindrome l = new LongestPalindrome();
        assertEquals("bab",l.longestPalindrome("babad"));

        assertEquals("bb",l.longestPalindrome("cbbd"));


    }

    @Test
    public void noLongestPalindrome() {

        final LongestPalindrome l = new LongestPalindrome();

        assertEquals(9, l.noLongestPalindrome("bbbcccccaa"));

        assertEquals(2, l.noLongestPalindrome("bb"));

        String text = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        assertEquals(983, l.noLongestPalindrome(text));

        assertEquals(5, l.noLongestPalindrome("bananas"));
        assertEquals(7, l.noLongestPalindrome("aaaAaaaa"));
        assertEquals(7, l.noLongestPalindrome("abccccdd"));


    }
}