//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Repository;

import com.company.Personal_LibraryMarket.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Optional<Author>findByAuthorId(Integer id);

}
