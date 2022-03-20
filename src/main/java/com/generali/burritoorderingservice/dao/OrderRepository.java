package com.generali.burritoorderingservice.dao;

import com.generali.burritoorderingservice.model.TheOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<TheOrder, Long> {

    List<TheOrder> findByDescription(String description);
    TheOrder findById(long id);

    //TODO: test following queries
    @Query("SELECT o FROM TheOrder o WHERE o.description = ?1 and o.protein.type = ?2")
    List<TheOrder> findByDescriptionProteinType(String desc, String type);

    @Query(
            value = "SELECT * FROM TheOrder o WHERE o.description = ?1",
            nativeQuery = true)
    TheOrder findTheOrderByDescriptionNative(String desc);

    @Query("SELECT DISTINCT o FROM TheOrder o JOIN o.tortilla t WHERE t.type LIKE %?1%")
    Page<TheOrder> findAllWithTortilla(String keyword, Pageable pageable);
}
