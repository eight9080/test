package com.example.alg.triepkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {
    @Test
    public void insert() throws Exception {


        final TrieNode to = new TrieNode('o', true);

        final TrieNode tea = new TrieNode('a', true);
        final TrieNode ted = new TrieNode('d', true);
        final TrieNode te = new TrieNode('e');
        te.child('a', tea);
        te.child('d', ted);

        final TrieNode t = new TrieNode('t');
        t.child('o', to);
        t.child('e', te);

        final TrieNode tA = new TrieNode('A', true);

        final TrieNode root = new TrieNode();
        root.child('t', t);
        root.child('A', tA);

        final Trie trie = new Trie();

        trie.insert("to");
        trie.insert("ted");
        assertTrue(trie.search("to"));
        assertTrue(trie.startsWith("t"));
        assertFalse(trie.startsWith("n"));

    }

}