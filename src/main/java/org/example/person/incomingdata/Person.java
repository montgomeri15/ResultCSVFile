package org.example.person.incomingdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString

public class Person {
    private final String name;
    private final int age;
    private final Sex sex;

    public byte[] personsListInBytes() {
        return (this.getName() + ",\t"+
                this.getAge() + ",\t" +
                this.getSex() + "\n").getBytes();
    }
}


