package org.example;

import java.io.*;
import java.util.Scanner;

/**
 * реализовать файловый менеджер (в виде консольного приложения). На вход программе указывается абсолютный путь к файлу
 * и ключ операции (с параметрами), которую необходимо выполнить над файлом. Должны быть реализованы операции создания файла,
 * удаления, чтения, записи в файл. Учесть пограничные случаи и не забыть про удобную обработку исключений с выводом валидаций пользователю в консоль.
 * <p>
 * Пример вызова программы:
 * >>c:\\testdata\myfile.txt -create (создаст пустой файл) (D:\dev\task-Three\IO\src\main\java\org\example\myfile.txt -create)
 * или
 * >>c:\\testdata\myfile.txt -write "blablabla" (запишет в файл строку blablabla) (D:\dev\task-Three\IO\src\main\java\org\example\myfile.txt -write "blablabla")
 */

public class Main {
    public static void main(String[] args) {

        FileManager fm = new FileManager();

        menu(fm);
    }

    private static void menu(FileManager fm) {

        System.out.println("Введи путь к файлу и, через пробел, желаемое действие (-create, -delete, -write, -read)" +
                "\nНапример: D:\\dev\\task-Three\\IO\\src\\main\\java\\org\\example\\myfile.txt -create");

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");


        if (input.length < 2 || input.length > 3) {

                System.out.println("Некорректный ввод");

                menu(fm);
        }

        switch (input[1]) {
            case "-create":
                fm.createFile(new File(input[0]));
                break;
            case "-delete":
                fm.deleteFile(new File(input[0]));
                break;
            case "-write":
                fm.writeFile(new File(input[0]), input[2].replaceAll("\"", ""));
                break;
            case "-read":
                fm.readFile(new File(input[0]));
                break;
            default:
                System.out.println("Некорректный ввод");
                break;
        }
    }
}