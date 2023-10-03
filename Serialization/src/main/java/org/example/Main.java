package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Создать список объектов типа "Человек" с полями имя, возраст и род деятельности. Данный список объектов должен быть
 * сериализован в файл при помощи интерфейса Serializable, при этом поле род деятельности не должно сериализовываться - оно должно быть
 * вычислимым. Соответственно при десериализации оно должно вычисляться (и заполняться в объектах) по следующему правилу: если человеку
 * от 0 до 3 лет - он сидит дома, если человеку от 3 до 7 лет - ходит в детский сад, от 7 до 18 лет - учится в школе,
 * от 17 до 23 - учится в институте, от 24 до 65 - работает, от 65 и выше - на пенсии.
 */

public class Main {
    public static void main(String[] args) {

        String filename = "D:\\dev\\task-Three\\Serialization\\src\\main\\java\\org\\example\\file\\people.txt";
        List<Human> people = new ArrayList<>();

        people.add(new Human("Петрович", 80));
        people.add(new Human("Петр", 30));
        people.add(new Human("Петя", 10));
        people.add(new Human("Петруша", 5));
        people.add(new Human("Петенька", 2));

        // Сериализация списка объектов в файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(people);
            System.out.println("Список объектов успешно сериализован в файл " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десериализация списка объектов из файла
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Human> deserializedPeople = (ArrayList<Human>) ois.readObject();
            System.out.println("Список объектов успешно десериализован из файла " + filename);
            System.out.println(deserializedPeople);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}