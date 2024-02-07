package com.aviva.user.service;

import com.aviva.user.model.ItemEntity;
import com.aviva.user.repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
public class ItemService {

  private final ItemRepository itemRepository;

  public ItemService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  public Page<ItemEntity> getItemsBySpecification(Specification<ItemEntity> specification, Pageable pageable) {
    return itemRepository.findAll(specification, pageable);
  }
}
