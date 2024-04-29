package org.idrist.idristamdoganspringproje.repository;


import org.idrist.idristamdoganspringproje.entity.Categories;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {


    Optional<Categories> findById(long id);
}
