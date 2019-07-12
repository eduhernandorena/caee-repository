package br.org.fiergs.caeeservice.controllers;

import br.org.fiergs.caeeservice.entities.Caee;
import br.org.fiergs.caeeservice.services.CaeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/caee", produces = MediaType.APPLICATION_JSON_VALUE)
public class CaeeController {

    @Autowired
    private CaeeService caeeService;

    @GetMapping
    public List<Caee> list() {
        return caeeService.findAll();
    }

    @GetMapping("/name/{name}")
    public Caee listByName(@PathVariable("name") String name) {
        return caeeService.findByName(name);
    }

    @PostMapping
    public Caee save(@RequestBody @Valid Caee caee) {
        return caeeService.save(caee);
    }

    @PutMapping
    public Caee update(@RequestBody @Valid Caee caee) {
        return caeeService.update(caee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        caeeService.delete(id);
    }
}
