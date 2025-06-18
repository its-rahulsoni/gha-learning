package com.gha.learning.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringOperationsTest {

    @Test
    public void testConcatStrings_NormalStrings() {
        StringUtil util = new StringUtil();
        String result = util.concatStrings("Hello", "World");
        assertEquals("HelloWorld", result);
    }

    @Test
    public void testConcatStrings_WithEmptyString() {
        StringUtil util = new StringUtil();
        String result = util.concatStrings("", "World");
        assertEquals("World", result);
    }

    @Test
    public void testConcatStrings_BothEmpty() {
        StringUtil util = new StringUtil();
        String result = util.concatStrings("", "");
        assertEquals("", result);
    }


}
