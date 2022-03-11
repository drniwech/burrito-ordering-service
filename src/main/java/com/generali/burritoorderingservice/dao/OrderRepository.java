package com.generali.burritoorderingservice.dao;

import com.generali.burritoorderingservice.model.TheOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<TheOrder, Long> {

    List<TheOrder> findByDescription(String description);
    TheOrder findById(long id);

}
