package com.example.abuseapp.speaknativeappjava.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@ToString
@Table(catalog = "speaknativedb", schema = "[dbo]" , name = "[phrases]")
public class Phrase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "referencelang")
    private String eng;

    @Column(name = "targetlang")
    private String rus;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userid")
    private User user;
}
