package com.indytskyi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BlockServiceTest {

    @Test
    void addBlock() {
        //GIVEN
        BlockService blockService = new BlockService();
        String expected = "Hello";
        //WHEN
        var actual = blockService.addBlock(expected, 2, 3);

        //THEN
        assertEquals(expected, actual.getHashOfThePreviousBlock());
    }
}