package com.example.alg.stringpck;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RepeatedDnaSeqTest {

    @Test
    public void findRepeatedDnaSequences() {

        final RepeatedDnaSeq r = new RepeatedDnaSeq();
        final List<String> repeatedDnaSequences = r.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        final List<String> expect = Arrays.asList("AAAAACCCCC", "CCCCCAAAAA");
        Assertions.assertThat(repeatedDnaSequences)
                .isNotNull()
                .isNotEmpty()
                .hasSize(2)
                .contains("AAAAACCCCC", "CCCCCAAAAA");

    }
}