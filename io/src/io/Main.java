package io;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("java.txt"); // another path new File(src/java.txt)
        try {
            if (file.createNewFile()){
                System.out.println(file.getName() + " created file");
            }else {
                System.out.println(file.getName() + "file already exist ");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    //file.delete(); if you delete this file.
}