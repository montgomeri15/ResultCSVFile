package org.example.person.incomingdata;

import lombok.*;

@RequiredArgsConstructor
@Getter
@ToString

public class Person {
    @NonNull private final String name;
    @NonNull private final int age;
    @NonNull private final Sex sex;

    public byte[] personsListInBytes() {
        return (this.getName() + ", "+
                this.getAge() + ", " +
                this.getSex() + "\n").getBytes();
    }
}


