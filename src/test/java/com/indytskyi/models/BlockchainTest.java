package com.indytskyi.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import org.junit.jupiter.api.Test;

class BlockchainTest {

    @Test
    void addBlockWithIncreasingZerosCount() {
        //GIVEN
        Blockchain blockchain = new Blockchain();
        Block previousBlock = new Block("null", 1);
        previousBlock.setHashOfTheBlock("null");
        blockchain.getBlocks().add(previousBlock);
        Block block = new Block("null", 10);
        block.setTimeOfGeneratingBlock(System.currentTimeMillis());
        int expectedZerosCount = 1;

        //When
        blockchain.addBlock(block);
        assertEquals(expectedZerosCount, blockchain.getStartZeros());
    }

    @Test
    void addBlockWithDecreasingZerosCount() {
        //GIVEN
        Blockchain blockchain = new Blockchain();
        Block previousBlock = new Block("null", 1);
        previousBlock.setHashOfTheBlock("null");
        blockchain.getBlocks().add(previousBlock);
        Block block = new Block("null", 10);
        block.setTimeOfGeneratingBlock(LocalTime.now().toSecondOfDay());
        int expectedZerosCount = 0;

        //When
        blockchain.addBlock(block);
        assertEquals(expectedZerosCount, blockchain.getStartZeros());
    }

    @Test
    void addBlockWithTheSameZerosCount() {
        //GIVEN
        Blockchain blockchain = new Blockchain();
        Block previousBlock = new Block("null", 1);
        previousBlock.setHashOfTheBlock("null");
        blockchain.getBlocks().add(previousBlock);
        Block block = new Block("null", 10);
        block.setTimeOfGeneratingBlock(System.currentTimeMillis() - 100);
        int expectedZerosCount = 0;

        //When
        blockchain.addBlock(block);
        int actual = blockchain.getStartZeros();
        assertEquals(expectedZerosCount, actual);
    }

}