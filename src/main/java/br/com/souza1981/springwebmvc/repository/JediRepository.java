package br.com.souza1981.springwebmvc.repository;


import br.com.souza1981.springwebmvc.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Long> {

    List<Jedi> findByNameContainingIgnoreCase(final String name);
}
