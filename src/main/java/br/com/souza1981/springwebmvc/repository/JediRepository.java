package br.com.souza1981.springwebmvc.repository;

import br.com.souza1981.springwebmvc.modelo.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {

    private List<Jedi> jedis;

    public JediRepository() {
        jedis = new ArrayList<>();
        jedis.add(new Jedi("Luke", "SkyWalker"));
    }

    public List<Jedi> getAllJedi() {
        return jedis;
    }

    public void add(Jedi jedi) {
        jedis.add(jedi);


    }
}
