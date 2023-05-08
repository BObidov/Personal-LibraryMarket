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
@Table (name = ("books"))
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "book_seq_id")
    @SequenceGenerator(name = "book_seq_id", sequenceName = "book_seq_id", allocationSize = 1)
    @Column(name = ("book_id"))
    private Integer bookId;
    @Column(name = ("book_name"))
    private String bookName;
    @Column(name = ("book_price"))
    private Integer bookPrice;
    @Column(name = ("book_published"))
    private LocalDateTime bookPublished;
    @Column(name = ("book_page"))
    private Integer bookPage;
    @Column(name = ("book_amount"))
    private Integer bookAmount;

    @Column(name = ("author_id"))
    private Integer authorId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = ("author_id"), insertable = false, updatable = false)
    private Author author;

    @Column(name = ("image_id"))
    private Integer imageId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = ("image_id"), insertable = false, updatable = false)
    private Image image;

    @Column(name = ("publisher_id"))
    private Integer publisherId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = ("publisher_id"), insertable = false, updatable = false)
    private Publisher publisher;

    @OneToMany(mappedBy = "goals_bookId", cascade = CascadeType.ALL)
    private Set<Goals> goals;

    @Column(name = ("order_book_id"))
    private Integer order_bookId;
    @ManyToOne
    @JoinColumn(name = ("order_book_id"), insertable = false, updatable = false)
    private Order_Book orderBook;


}
