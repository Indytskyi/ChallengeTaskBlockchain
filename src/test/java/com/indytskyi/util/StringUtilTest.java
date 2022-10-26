package com.indytskyi.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StringUtilTest {

    @Test
    void applySha256() {
        //GiVEN
        var expected = 64;

        //WHEN
        var actual = StringUtil.applySha256("Hello").length();

        //THEN
        assertEquals(expected, actual);
    }
}