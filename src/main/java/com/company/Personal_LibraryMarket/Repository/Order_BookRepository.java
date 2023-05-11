//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Repository;

import com.company.Personal_LibraryMarket.Model.Order_Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface Order_BookRepository extends JpaRepository<Order_Book, Integer> {

    Optional<Order_Book> findByOrderBookId(Integer id);

}
