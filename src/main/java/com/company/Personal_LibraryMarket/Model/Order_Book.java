//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = ("order_books"))
public class Order_Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "order_book_seq_id")
    @SequenceGenerator(name = "order_book_seq_id", sequenceName = "order_book_seq_id", allocationSize = 1)
    @Column(name = ("order_book_id"))
    private Integer order_bookId;

    @Column(name = ("order_id"))
    private Integer orderId;
    @ManyToOne
    @JoinColumn(name = ("order_id"), insertable = false, updatable = false)
    private Order order;

    @OneToMany(mappedBy = "order_bookId", cascade = CascadeType.ALL)
    private Set<Book> book;

}
