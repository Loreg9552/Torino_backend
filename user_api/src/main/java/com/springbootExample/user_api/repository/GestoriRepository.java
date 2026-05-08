package com.springbootExample.user_api.repository;
import java.util.Optional;

import com.springbootExample.user_api.model.Gestori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestoriRepository extends JpaRepository<Gestori, Long> {
    Optional<Gestori> findByUserNameAndPassword(String username, String password);
}
