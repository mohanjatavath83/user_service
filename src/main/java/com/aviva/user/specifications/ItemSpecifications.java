package com.aviva.user.specifications;

import com.aviva.user.model.ItemEntity;
import org.springframework.data.jpa.domain.Specification;

public class ItemSpecifications {

    public static Specification<ItemEntity> hasCategory(String category) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("category"), category);
    }
}