//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table (name = ("users"))
public class User {

    @Id
    @GeneratedValue(generator = "user_seq_id")
    @SequenceGenerator(name = "user_seq_id", sequenceName = "user_seq_id", allocationSize = 1)
    @Column(name = ("user_id"))
    private Integer userId;
    private String name;
    private String surname;
    private String email;
    private String password;
    @Column(name = ("birth_date"))
    private LocalDate birthDate;
    @Column(name = ("phone_number"))
    private String phoneNumber;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private Set<Card> card;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private Set<Order> userOrder;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;
    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;
    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;

}
