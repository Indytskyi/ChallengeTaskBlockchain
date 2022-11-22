package com.indytskyi.service;

import com.indytskyi.models.Blockchain;
import java.util.concurrent.ExecutorService;

public class BlockchainService {
    public void builtAndPrintBlocks(Blockchain blockchain, ExecutorService service) {
        for (int i = 1; i <= blockchain.getCountOfBlocks(); i++) {
            service.submit(new Miner(blockchain));
        }
    }
}
