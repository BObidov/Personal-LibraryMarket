//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Repository;

import com.company.Personal_LibraryMarket.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ImageRepository extends JpaRepository<Image, Integer> {

    Optional<Image> findByImageId(Integer id);


}
