package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Задача - найти разработчиков с уникальными языками программирования, используя Stream API.
 * Для данного примера ожидаемый результат [Наташа, Элла].
 */

public class Main {
    public static void main(String[] args) {

        Developer dev1 = new Developer("Наташа", Arrays.asList("Java", "C++"));
        Developer dev2 = new Developer("Эрнест", Arrays.asList("Java", "Python"));
        Developer dev3 = new Developer("Элла", Arrays.asList("С#", "Python", "JavaScript"));

        Stream<Developer> developerStream = Stream.of(dev1, dev2, dev3);

        // Фильтруем только языки, используемые только одним разработчиком
        List<String> uniqueDevelopers = developerStream
                .flatMap(dev -> dev.getLanguages().stream()
                        .map(language -> new AbstractMap.SimpleEntry<>(dev.getName(), language))) // Преобразуем каждый язык в пару (имя разработчика, язык)
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toSet()))) // Группируем по языкам и собираем множества имен разработчиков
                .values()
                .stream()
                .filter(strings -> strings.size() == 1) // Получаем множества имен разработчиков для каждого языка
                .flatMap(Set::stream) // Соединяем все множества в один поток
                .distinct() // находим уникальных
                .collect(Collectors.toList());

        System.out.println(uniqueDevelopers);
    }
}

