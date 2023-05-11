//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Repository;

import com.company.Personal_LibraryMarket.Model.Goals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface GoalsRepository extends JpaRepository<Goals, Integer> {

    Optional<Goals> findByGoalsId(Integer id);

}
