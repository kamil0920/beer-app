package org.moveApp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table
@Data
public class DataBeer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer punkapiId;

    @Column
    private String name;

    @Column
    private String tagline;

    @Column
    private String firstBrewed;

    @Column(length = 1000)
    private String description;

    @Column
    private String imageUrl;

    @Column
    private Float ibu;

    @Column(name = "food_pairing")
    @ElementCollection(targetClass=String.class)
    private List<String> foodPairing = new LinkedList<>();

}
