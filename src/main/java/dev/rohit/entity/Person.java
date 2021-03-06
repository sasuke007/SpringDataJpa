package dev.rohit.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "persons")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries(value = {
        @NamedQuery(name = "find_all_persons", query = "select p from Person p")
})
public class Person {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String location;

    private LocalDateTime birthdate;
}
