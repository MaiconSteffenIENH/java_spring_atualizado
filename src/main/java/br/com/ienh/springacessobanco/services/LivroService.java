package br.com.ienh.springacessobanco.services;

import br.com.ienh.springacessobanco.dto.CategoriaDTO;
import br.com.ienh.springacessobanco.dto.LivroDTO;
import br.com.ienh.springacessobanco.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {
    @Autowired
    LivroRepository livroRepository;
    public List<LivroDTO> obterTodos(){
        List<LivroDTO> livros = new ArrayList<>();
        livroRepository.findAll().forEach(livro -> {
            LivroDTO livroDTO = new LivroDTO(
                    livro.getId(),
                    livro.getTitulo(),
                    livro.getEditora(),
                    livro.getAutor().getId(),
                    livro.getCategoria().getId()
            );
            livros.add(livroDTO);
        });
        return livros;
    }
}
