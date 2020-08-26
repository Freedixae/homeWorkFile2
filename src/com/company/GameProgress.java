package com.company;

import java.io.*;
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

    public void zipGame(String fileName, List<String> listFiles) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(fileName))) {
            for (String file : listFiles) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    ZipEntry entry = new ZipEntry(file.substring(file.lastIndexOf('/')));
                    zout.putNextEntry(entry);
                    byte[] b = new byte[fis.available()];
                    fis.read(b);
                    zout.write(b);
                    zout.closeEntry();
                    System.out.println("Done fis");
                } catch (IOException e) {
                    System.out.println("Error fis!");
                    ;
                }
            }
            System.out.println("Done zip");
        } catch (IOException e) {
            System.out.println("Error zip");
            ;
        }
    }

    public void del() {
        File file = new File("C://Games/savegames/");
        File[] ff = file.listFiles();
        for (File list : ff) {
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
