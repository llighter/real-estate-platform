package com.llighter.estateservice.repository;

import com.llighter.estateservice.model.Items;
import org.springframework.data.repository.CrudRepository;

public interface ItemsRepository extends CrudRepository<Items, Integer> {
}
