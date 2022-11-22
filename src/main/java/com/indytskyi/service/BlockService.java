package com.indytskyi.service;

import com.indytskyi.util.StringUtil;
import com.indytskyi.models.Block;
import java.time.LocalTime;
import java.util.Random;

public class BlockService {
    public Block addBlock(String hashOfThePreviousBlock, int startZeros, long idOfMiner) {
        Block block = new Block(hashOfThePreviousBlock, idOfMiner);
        block.setTimestamp(LocalTime.now().toSecondOfDay());
        block.setTimeOfGeneratingBlock(System.currentTimeMillis());
        findMagicNumber(startZeros, block);
        return block;
    }

    private void findMagicNumber(int zeroes, Block block) {
        final Random random = new Random();
        do {
            block.setMagicNumber(random.nextLong());
            block.setHashOfTheBlock(StringUtil.applySha256(block.getId() + block.getTimeOfGeneratingBlock() +
                    block.getHashOfThePreviousBlock() + block.getMagicNumber()));
        } while (!isHasCurrentZeros(zeroes, block));
    }

    private boolean isHasCurrentZeros(int zeroes, Block block) {
        for (int i = 0; i < zeroes; i++) {
            if (block.getHashOfTheBlock().charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

}
