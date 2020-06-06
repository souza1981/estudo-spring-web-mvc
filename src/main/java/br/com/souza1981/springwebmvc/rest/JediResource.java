package br.com.souza1981.springwebmvc.rest;

import br.com.souza1981.springwebmvc.exception.JediNotFoundException;
import br.com.souza1981.springwebmvc.model.Jedi;
import br.com.souza1981.springwebmvc.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class JediResource {

    @Autowired
    private JediService jediService;

    @GetMapping("/api/jedi")
    public List<Jedi> getAllJedis() {
        return jediService.findAll();
    }

    @GetMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> getAllJedis(@PathVariable("id") Long id) {
        Jedi jedi = jediService.findById(id);
        return ResponseEntity.ok(jedi);

    }

    @PostMapping("/api/jedi")
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi createJedi(@Valid @RequestBody Jedi jedi) {
        return jediService.save(jedi);
    }

    @PutMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> updateJedi(@PathVariable("id") Long id, @Valid @RequestBody Jedi jediDto) {

        Jedi jedi = jediService.update(id, jediDto);

        return ResponseEntity.ok(jedi);
    }

    @DeleteMapping("/api/jedi/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) throws JediNotFoundException {

        jediService.delete(id);



    }

}
