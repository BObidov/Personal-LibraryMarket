//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "book_id")
    private Integer bookId;
    @Column(name = "book_name")
    private String bookName;
    private Double price;
    private Integer page;
    private String published;
    private Integer amount;

    @Column(name = "author_id", insertable = false, updatable = false)
    private Integer authorId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "image_id", insertable = false, updatable = false)
    private Integer imageId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;

    private Integer goalsId;
    @OneToMany(mappedBy = "goalsBook")
    private Set<Goals> goals;

    @Column(name = "publisher_id", insertable = false, updatable = false)
    private Integer publisherId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Column(name = "order_book_id", insertable = false ,updatable = false)
    private Integer orderBookId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_book_id")
    private Order_Book orderBook;




}
