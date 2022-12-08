package org.example.person;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString

public class Person {
    private final String name;
    private final int age;
    private final Sex sex;
}
