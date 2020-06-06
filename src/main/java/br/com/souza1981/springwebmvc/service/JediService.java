package br.com.souza1981.springwebmvc.service;

import br.com.souza1981.springwebmvc.exception.JediNotFoundException;
import br.com.souza1981.springwebmvc.model.Jedi;
import br.com.souza1981.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class JediService {

    @Autowired
    private JediRepository jediRepository;

    public List<Jedi> findAll() {
        return jediRepository.findAll();
    }

    public Jedi findById(Long id) throws JediNotFoundException {
        Optional<Jedi> jedi = jediRepository.findById(id);
        if (jedi.isPresent()) {
            return jedi.get();
        }

        throw new JediNotFoundException();
    }

    public Jedi save(Jedi jedi) {
        jediRepository.save(jedi);
    }

    public Jedi update(Long id, Jedi jediDto) {
        Optional<Jedi> jediEntity = jediRepository.findById(id);

        if (jediEntity.isPresent()){
            final Jedi jedi = jediEntity.get();
            jedi.setName(jediDto.getName());
            jedi.setLastName(jedi.getLastName());
            jediRepository.save(jedi);
            return jedi;
        }

        throw new JediNotFoundException()
    }

    public void delete(Long id) throws JediNotFoundException {
        Jedi jedi = findById(id);
       jediRepository.delete(jedi);
    }
}
