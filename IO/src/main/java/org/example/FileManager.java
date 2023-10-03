package org.example;

import java.io.*;

public class FileManager {

    void writeFile(File file, String content) {

        if (!file.exists()) {
            System.out.println("Файл не существует!");

            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

            writer.write(content);
        } catch (IOException e) {

            System.out.println(e.fillInStackTrace().getMessage());
        }


        System.out.println("Запись в файл успешно выполнена.");
    }

    void readFile(File file) {

        if (!file.exists()) {

            System.out.println("Файл не существует!");

            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }
        } catch (IOException e) {

            System.out.println(e.fillInStackTrace().getMessage());
        }
    }

    void createFile(File file) {

        if (file.exists()) {

            System.out.println("Файл уже существует!");

            return;
        }
        boolean created = false;

        try {

            created = file.createNewFile();
        } catch (IOException e) {

            System.out.println(e.fillInStackTrace().getMessage());
        }

        if (created) {

            System.out.println("Файл успешно создан.");
        } else {

            System.out.println("Не удалось создать файл!");
        }
    }

    void deleteFile(File file) {

        if (!file.exists()) {

            System.out.println("Файл не существует!");

            return;
        }

        boolean deleted = file.delete();

        if (deleted) {

            System.out.println("Файл успешно удалён.");
        } else {

            System.out.println("Не удалось удалить файл!");
        }
    }
}
