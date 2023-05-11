//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Repository;

import com.company.Personal_LibraryMarket.Model.Book;
import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@CodePointLength
public interface BookRepository extends JpaRepository<Book, Integer> {

    Optional<Book> findByBookId(Integer id);

}
