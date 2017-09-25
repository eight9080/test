package com.dg;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Base64;

import static org.hamcrest.Matchers.is;

public class Base64Test {

    @Test
    public void encodeAndDecode() {
        final String rawString = "duke";

        final Base64.Encoder encoder = Base64.getEncoder();
        final byte[] encodedContent = encoder.encode(rawString.getBytes());

        final Base64.Decoder decoder = Base64.getDecoder();
        final String decodedString = new String(decoder.decode(encodedContent));

        Assert.assertThat(decodedString, is(rawString));


    }
}
