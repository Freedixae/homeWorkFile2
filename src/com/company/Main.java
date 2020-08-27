package com.company;

public class Main {

    public static void main(String[] args) {
        GameProgress playerOne = new GameProgress(2, 4, 100);
        GameProgress playerTwo = new GameProgress(10, 1, 500);
        GameProgress playerThree = new GameProgress(999, 25, 20000);

        playerOne.saveGame("C://Games/savegames/save.txt", playerOne);
        playerTwo.saveGame("C://Games/savegames/save2.txt", playerTwo);
        playerThree.saveGame("C://Games/savegames/save3.txt", playerThree);

        playerOne.zipGame("C://Games/savegames/save.zip");
        playerOne.del();
    }
}