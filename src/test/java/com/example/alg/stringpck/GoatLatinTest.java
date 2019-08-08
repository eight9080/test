package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class GoatLatinTest {

    @Test
    public void toGoatLatin() {

        final GoatLatin goatLatin = new GoatLatin();
        assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa",
                goatLatin.toGoatLatin("I speak Goat Latin"));
        assertEquals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa",
                goatLatin.toGoatLatin("The quick brown fox jumped over the lazy dog"));
        assertEquals("Eachmaa ordwmaaa onsistscmaaaa ofmaaaaa owercaselmaaaaaa andmaaaaaaa uppercasemaaaaaaaa etterslmaaaaaaaaa onlymaaaaaaaaaa",
                goatLatin.toGoatLatin("Each word consists of lowercase and uppercase letters only"));
    }
}