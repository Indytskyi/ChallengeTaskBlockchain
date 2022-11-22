package com.indytskyi.models;

import java.io.Serializable;
import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Block implements Serializable {

    private static final long serialVersionUID = 1L;
    private final long idOfMiner;
    private final int balance = 100;
    private long timestamp;
    private long timeOfGeneratingBlock;
    private final String hashOfThePreviousBlock;
    private int id;
    private long magicNumber;
    private String hashOfTheBlock;
    private String messageN;

    public Block(String hashOfThePreviousBlock, long idOfMiner) {
        timeOfGeneratingBlock = LocalTime.now().toSecondOfDay();
        this.hashOfThePreviousBlock = hashOfThePreviousBlock;
        this.idOfMiner = idOfMiner;
    }

    @Override
    public String toString() {
        return "\nBlock:" +
                "\nCreated by miner" + idOfMiner +
                "\nminer" + idOfMiner + " gets " + balance + " VC" +
                "\nId: " + id +
                "\nTimestamp: " + timestamp +
                "\nMagic number: " + magicNumber +
                "\nHash of the previous block:\n" + hashOfThePreviousBlock +
                "\nHash of the block:\n" + hashOfTheBlock +
                "\nBlock data:" +
                "\nBlock was generating for " + (timeOfGeneratingBlock / 1000) + " seconds" +
                messageN;
    }
}
