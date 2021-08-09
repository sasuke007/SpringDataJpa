package dev.rohit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reviews")
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue
    @Column(insertable = false,updatable = false)
    private Long id;

    private String description;

    @Column(nullable = false)
    private String rating;

}
