package com.aviva.user;

import com.aviva.user.model.ItemEntity;
import com.aviva.user.repository.ItemRepository;
import com.aviva.user.service.ItemService;
import com.aviva.user.specifications.ItemSpecifications;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Test
    public void testGetItemsBySpecification() {

        Specification<ItemEntity> specification = ItemSpecifications.hasCategory("Apple");
        Pageable pageable = Pageable.unpaged();
        Page<ItemEntity> mockedPage = new PageImpl<>(Collections.singletonList(new ItemEntity()));
        Mockito.when(itemRepository.findAll(Mockito.eq(specification), Mockito.eq(pageable))).thenReturn(mockedPage);
        Page<ItemEntity> result = itemService.getItemsBySpecification(specification, pageable);

        assertEquals(mockedPage, result);
    }
}