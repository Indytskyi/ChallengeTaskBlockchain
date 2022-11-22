package com.indytskyi;

import com.indytskyi.models.Blockchain;
import com.indytskyi.service.BlockchainService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        int countOfTheThread = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(countOfTheThread);
        Blockchain blockchain = new Blockchain();
        BlockchainService blockchainService = new BlockchainService();
        blockchainService.builtAndPrintBlocks(blockchain, service);
        service.shutdown();
    }
}
