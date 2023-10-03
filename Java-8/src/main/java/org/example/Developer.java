package org.example;

import java.util.List;
import java.util.Objects;

public class Developer {

    private final String name;

    private final List<String> languages;

    public Developer(String name, List<String> languages) {
        this.name = name;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public List<String> getLanguages() {
        return languages;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", languages=" + languages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return Objects.equals(name, developer.name) && Objects.equals(languages, developer.languages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, languages);
    }
}

