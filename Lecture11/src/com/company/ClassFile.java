package com.company;

import java.io.BufferedWriter;
import java.nio.file.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ClassFile {

    private String defaultPath, defaultFile;
    private String str;

    Scanner scanner = new Scanner(System.in);



    public void scannerForFile(){
        System.out.println("Введите директорию куда будет записан файл");
        defaultPath = scanner.nextLine();
        try {
            Files.createDirectory(Paths.get(defaultPath));
        } catch (IOException e) {
        }
        System.out.println("Название txt файла (без расширения)");
        defaultFile = scanner.nextLine() + ".txt";
    }

    public void writeString() {
        scannerForFile();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        str = scanner.next();

        String defaultPathFile = defaultPath+"\\"+defaultFile;
        File file = new File(defaultPathFile);

        try {
            Files.write(file.toPath(), str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Строка записана в файл");

    }

    public void writeStrings(){
        scannerForFile();

        str = "";
        String defaultPathFile = defaultPath+"\\"+defaultFile;

        File file = new File(defaultPathFile);

        try {
            Files.write(file.toPath(), str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), StandardOpenOption.APPEND)) {
            System.out.println("Введите строки. Для выхода из режима ввода введите quit");
            scanner.next();

            boolean running = true;
            while (running) {
                if (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if ("quit".equals(line)) {
                        running = false;
                    } else {
                        writer.write(line);
                        writer.newLine();
                    }
                }
            }
            System.out.println("Строки записаны в файл");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createDir() {
        System.out.println("Введите директорию для создания");
        defaultPath = scanner.nextLine();
        try {
            Path directoryPath = Paths.get(defaultPath);
            Files.createDirectory(directoryPath);

            System.out.println("Создана директория");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Такой файл уже существует!!!");
        }
    }

    public void removeDir(){
        System.out.println("Введите директорию для удаления");
        defaultPath = scanner.nextLine();
        try {
            Path directoryPath = Paths.get(defaultPath);
            Files.delete(directoryPath);

            System.out.println("Директория удалена");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Директория не существует!!!");
        }
    }

}