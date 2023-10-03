package org.example;

import java.io.Serializable;

class Human implements Serializable {

    private final String name;
    private final int age;
    private final Activity activity;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.activity = calculateActivity();
    }

    private Activity calculateActivity() {
        if (age >= 0 && age < 3) {
            return Activity.HOME;
        } else if (age >= 3 && age < 7) {
            return Activity.KINDERGARTEN;
        } else if (age >= 7 && age < 18) {
            return Activity.SCHOOL;
        } else if (age >= 18 && age < 24) {
            return Activity.UNIVERSITY;
        } else if (age >= 24 && age < 65) {
            return Activity.WORK;
        } else {
            return Activity.RETIREMENT;
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", activity=" + activity.getActivityName() +
                '}';
    }
}
