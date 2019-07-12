package br.org.fiergs.caeeservice.services;

import br.org.fiergs.caeeservice.entities.Caee;
import br.org.fiergs.caeeservice.repositories.CaeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaeeService {

    @Autowired
    private CaeeRepository caeeRepository;

    public List<Caee> findAll() {
        return caeeRepository.findAll();
    }

    public Caee findByName(String name) {
        Optional<Caee> optCaee = caeeRepository.findByNameContainingIgnoreCase(name);
        return optCaee.orElse(null);
    }

    public Caee save(Caee caee) {
        Optional<Caee> optCaee = caeeRepository.findByNameContainingIgnoreCase(caee.getName());
        if (optCaee.isEmpty()) {
            return caeeRepository.save(caee);
        } else {
            throw new RuntimeException("Caee já cadastrado!");
        }

    }

    public Caee update(Caee caee) {
        Optional<Caee> optCaee = caeeRepository.findOneByNameIgnoreCaseAndIdNot(caee.getName(), caee.getId());
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
