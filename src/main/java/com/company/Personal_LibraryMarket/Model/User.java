//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table (name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surName;
    private String email;               //unique
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;         //unique
    private LocalDateTime birthdate;

    @OneToMany(mappedBy = "user")
    private Set<Card> cards;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

}
