package com.indytskyi.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StringUtilTest {

    @Test
    void applySha256() {
        //GiVEN
        var expected = "185f8db32271fe25f561a6fc938b2e264306ec304eda518007d1764826381969";

        //WHEN
        var actual = StringUtil.applySha256("Hello");

        //THEN
        assertEquals(expected, actual);
    }
}