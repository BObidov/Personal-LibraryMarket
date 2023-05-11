//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Repository;

import com.company.Personal_LibraryMarket.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CardRepository extends JpaRepository<Card, Integer> {

    Optional<Card> findByCardIdAndDeletedAtIsNull(Integer id);


}
