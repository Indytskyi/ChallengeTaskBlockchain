package com.indytskyi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.util.concurrent.MoreExecutors;
import com.indytskyi.models.Blockchain;
import java.util.concurrent.ExecutorService;
import org.junit.jupiter.api.Test;

class BlockchainServiceTest {

    @Test
    public void testSummationWithConcurrency() {
        //GIVEN
        var expectedBlocks = 15;
        ExecutorService service = MoreExecutors.newDirectExecutorService();
        Blockchain blockchain = new Blockchain();
        BlockchainService blockchainService = new BlockchainService();

        //WHEN
        blockchainService.builtAndPrintBlocks(blockchain, service);
        service.shutdown();

        //THEN
        var actual = blockchain.getBlocks().size();
        assertEquals(expectedBlocks, actual);
    }

}