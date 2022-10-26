package com.indytskyi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.indytskyi.entity.Blockchain;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Test;

class BlockchainServiceTest {

    @Test
    public void testSummationWithConcurrency() {
        int countOfTheThread = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(countOfTheThread);
        Blockchain blockchain = new Blockchain();
        BlockchainService blockchainService = new BlockchainService();;
        blockchainService.builtAndPrintBlocks(blockchain, service);
        service.shutdown();
    }

}