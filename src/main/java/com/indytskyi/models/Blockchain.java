package com.indytskyi.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Blockchain implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<Block> blocks = new ArrayList<>();
    private final int countOfBlocks = 15;
    private int startZeros;

    public synchronized void addBlock(Block block) {
        if (isValid(block)) {
            block.setTimeOfGeneratingBlock(System.currentTimeMillis() - block.getTimeOfGeneratingBlock());

            validZerosInHash(block);
            block.setId(blocks.size() + 1);
            System.out.println(block);
            blocks.add(block);
        }
    }

    public String getHashOfThePreviousBlock() {
        return blocks.isEmpty() ? "0" : blocks.get(blocks.size() - 1).getHashOfTheBlock();
    }

    private void validZerosInHash(Block block) {

        if (block.getTimeOfGeneratingBlock() > 2000) {
            startZeros = startZeros == 0 ? 0 : startZeros - 1;
            block.setMessageN("\nN was decreased to " + startZeros);

        } else if (block.getTimeOfGeneratingBlock() < 20) {
            startZeros += 1;
            block.setMessageN("\nN was increased to " + startZeros);

        } else
            block.setMessageN("\nN stays the same");
    }

    private boolean isValid(Block block) {
        return getHashOfThePreviousBlock().equals(block.getHashOfThePreviousBlock());
    }
}
