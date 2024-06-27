package br.com.ienh.springacessobanco.services;

import br.com.ienh.springacessobanco.dto.AutorDTO;
import br.com.ienh.springacessobanco.entities.Autor;
import br.com.ienh.springacessobanco.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutorService {
    @Autowired
    AutorRepository autorRepository;

    public List<AutorDTO> obterTodos() {
        List<AutorDTO> autores = new ArrayList<>();
        autorRepository.findAll().forEach(autor -> {
            AutorDTO autorDTO = new AutorDTO(autor.getId(), autor.getNome());
            autores.add(autorDTO);
        });
        return autores;
    }

    public void excluirAutor(int id) {
        autorRepository.deleteById(id);
    }

    public void salvarAutor(AutorDTO autor) {
        Autor novoAutor = new Autor();
        novoAutor.setNome(autor.nome());
        autorRepository.save(novoAutor);
    }

    public void atualizarAutor(AutorDTO autor) {
        Autor atualizarAutor = new Autor();
        atualizarAutor.setId(autor.id());
        atualizarAutor.setNome(autor.nome());
        autorRepository.save(atualizarAutor);
    }

    public AutorDTO obterAutorPorID(int id) {
        AutorDTO autorDTO = null;
        Autor autor = autorRepository.findById(id).orElse(null);
        if (autor != null) {
            autorDTO = new AutorDTO(autor.getId(), autor.getNome());
        }
        return autorDTO;
    }
}
