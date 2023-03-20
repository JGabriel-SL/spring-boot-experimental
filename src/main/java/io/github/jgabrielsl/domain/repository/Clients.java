package io.github.jgabrielsl.domain.repository;

import io.github.jgabrielsl.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Clients extends JpaRepository<Client, Integer> {

    List<Client> findByNameLike(String name);

    /** List<Client> findByNameLikeOrId(String name, Integer id); */

    @Query(value = "select c from Client c where c.id = :id")
    List<Client> getClientById(Integer id);

    /** @Query( value = "select * from clients c where c.id = :id", nativeQuery = true)
    List<Client> getClientById( @Param("id") Integer id ); */

    boolean existsByName(String name);


}
