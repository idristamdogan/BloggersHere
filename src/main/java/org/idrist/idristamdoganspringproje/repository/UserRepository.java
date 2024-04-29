package org.idrist.idristamdoganspringproje.repository;

import org.idrist.idristamdoganspringproje.entity.Categories;
import org.idrist.idristamdoganspringproje.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



    User findByNameIgnoreCaseAndLastnameIgnoreCase(String name, String lastname);

    Optional<User> findById(Long id);
}
