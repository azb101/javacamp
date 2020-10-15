package com.example.abuseapp.speaknativeappjava.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@ToString
@Entity
@Table(catalog = "speaknativedb", schema = "dbo" , name = "appusers")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @ToString.Exclude
    private String password;
}