package com.indytskyi.service;

import com.indytskyi.entity.Block;
import com.indytskyi.entity.Blockchain;

public class Miner implements Runnable {
    private final Blockchain blockchain;
    private final BlockService blockService = new BlockService();

    public Miner(Blockchain blockchain) {
        this.blockchain = blockchain;
    }

    @Override
    public void run() {
        while (blockchain.getBlocks().size() < 15) {
            Block block = blockService.addBlock(blockchain.getHashOfThePreviousBlock(),
                    blockchain.getStartZeros(), Thread.currentThread().getId());
            blockchain.addBlock(block);

        }

    }
}
