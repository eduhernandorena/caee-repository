package br.org.fiergs.caeeservice.services;

import br.org.fiergs.caeeservice.entities.Caee;
import br.org.fiergs.caeeservice.repositories.CaeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CaeeService {

    @Autowired
    private CaeeRepository caeeRepository;

    public List<Caee> findAll() {
        return caeeRepository.findAll();
    }

    public List<Caee> findByDescription(String description) {
        Optional<List<Caee>> optCaee = caeeRepository.findByDescriptionContainingIgnoreCase(description);
        return optCaee.orElseGet(ArrayList::new);
    }

    public Caee findByCode(String code) {
        Optional<Caee> optCaee = caeeRepository.findByCode(code);
        return optCaee.orElseGet(null);
    }

    public Caee save(Caee caee) {
        Optional<Caee> optCaee = caeeRepository.findByCodeOrDescription(caee.getCode(), caee.getDescription());
        if (optCaee.isEmpty()) {
            return caeeRepository.save(caee);
        } else {
            throw new RuntimeException("Caee já cadastrado!");
        }

    }

    public Caee update(Caee caee) {
        Optional<Caee> optCaee = caeeRepository.findOneByDescriptionContainingIgnoreCaseOrCodeAndIdNot(caee.getDescription(), caee.getCode(), caee.getId());
        if (optCaee.isEmpty()) {
            return caeeRepository.save(caee);
        } else {
            throw new RuntimeException("Caee já cadastrado!");
        }
    }

    public void delete(Long id) {
        caeeRepository.deleteById(id);
    }

}
