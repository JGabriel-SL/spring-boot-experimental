package io.github.jgabrielsl.domain.repository;

import io.github.jgabrielsl.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Clients extends JpaRepository<Client, Integer> {

    List<Client> findByNameLike(String name);

    List<Client> findByNameLikeOrId(String name, Integer id);

    boolean existsByName(String name);


}
