package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        GameProgress playerOne = new GameProgress(2, 4, 100);
        GameProgress playerTwo = new GameProgress(10, 1, 500);
        GameProgress playerThree = new GameProgress(999, 25, 20000);

        playerOne.saveGame("C://Games/savegames/save.txt", playerOne);
        playerTwo.saveGame("C://Games/savegames/save2.txt", playerTwo);
        playerThree.saveGame("C://Games/savegames/save3.txt", playerThree);

        ArrayList<String> listGame = new ArrayList<>();
        listGame.add("C://Games/savegames/save.txt");
        listGame.add("C://Games/savegames/save2.txt");
        listGame.add("C://Games/savegames/save3.txt");

        playerOne.zipGame("C://Games/savegames/save.zip", listGame);

        playerOne.del();
    }
}