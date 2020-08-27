package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int lvl;
    private int weapons;
    private int health;

    public GameProgress(int lvl, int weapons, int health) {
        this.lvl = lvl;
        this.weapons = weapons;
        this.health = health;
    }

    public void saveGame(String fileOutputStream, GameProgress gameProgress) {
        try (FileOutputStream saveGame = new FileOutputStream(fileOutputStream);
             ObjectOutputStream save = new ObjectOutputStream(saveGame)) {
            save.writeObject(gameProgress);
            System.out.println("Done!");
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    public static List<File> listGame(String path) {
        File file = new File(path);
        File[] ff = file.listFiles();
        List<File> f = Arrays.asList(ff);
        return f;
    }

    public void zipGame(String path) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path))) {
            for (File file : listGame("C://Games/savegames/")) {
                if (file.getName().endsWith(".zip")) continue;
                try (FileInputStream fis = new FileInputStream(file)) {
                    ZipEntry entry = new ZipEntry(file.getName());
                    zout.putNextEntry(entry);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zout.write(buffer);
                    zout.closeEntry();
                    System.out.println("done fis");
                } catch (IOException e) {
                    System.out.println("error fis");
                }
            }
            System.out.println("done zip");
        } catch (IOException e) {
            System.out.println("error zip");
        }
    }

    public void del() {
        for (File list : listGame("C://Games/savegames/")) {
            String name = list.getName();
            String type = name.substring(name.lastIndexOf('.'));
            if (type.equals(".txt")) {
                list.delete();
            }
        }
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "lvl=" + lvl +
                ", weapons=" + weapons +
                ", health=" + health +
                '}';
    }
}
