//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "order_books")
public class Order_Book {

    @Id
    @Column(name = "order_book_id")
    private Integer orderBookId;

    @Column(name = "order_id", insertable = false, updatable = false)
    private Integer orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToMany(mappedBy = "orderBook")
    private Set<Book> book;

}
