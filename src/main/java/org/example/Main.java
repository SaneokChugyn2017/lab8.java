package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("1 Задание");
        List<String> list = new ArrayList<>(Arrays.asList("кот", "мышь", "рог", "рог", "кот", "клавиатура", "кампуктер", "камуктер"));

        System.out.println(list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getKey().length() == list.stream()
                        .map(String::length)
                        .min(Integer::compareTo)
                        .orElse(0) && entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", ")));

        System.out.println("-------------");
        System.out.println("2 Задание");
        System.out.println(" ");
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Иван", "1", 1, 4.75),
                new Student("Александр", "2", 3, 4.5),
                new Student("Кирилл", "3", 2, 5),
                new Student("Андрей", "4", 3, 4),
                new Student("Егор", "5", 5, 3)

        ));
        int N = 3; // Количество искомых студентов

        System.out.println(students.stream()
                .sorted(Comparator.comparing(Student::getPoint).reversed())
                .limit(N)
                .sorted(Comparator.comparing(Student::getCourse))
                .map(Student::getName)
                .collect(Collectors.joining(", ", N + " самых успешных студентов зовут: ", ";")));

    }
}

class Students {
    private String name;
    private String id;
    private int course;
    private double point;

    public Students(String name, String id, int course, double point) {
        this.name = name;
        this.id = id;
        this.course = course;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getCourse() {
        return course;
    }

    public double getPoint() {
        return point;
    }
}