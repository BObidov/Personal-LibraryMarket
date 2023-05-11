//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Repository;

import com.company.Personal_LibraryMarket.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface OrderRepository extends JpaRepository<Order, Integer> {


    Optional<Order> findByOrderIdAndDeletedAtIsNull(Integer id);

}
