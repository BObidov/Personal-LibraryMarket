//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("publishers"))
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ("publisher_id"))
    private Integer publisherId;
    private LocalDateTime publisher;
    private String location;

    @Column(name = ("publisher_book_id"))
    private Integer publisherBookId;
    @OneToOne(mappedBy = "publisher")
    private Book publisherBook;

}
