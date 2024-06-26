package br.com.ienh.springacessobanco.services;

import br.com.ienh.springacessobanco.dto.CategoriaDTO;
import br.com.ienh.springacessobanco.entities.Categoria;
import br.com.ienh.springacessobanco.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> obterTodos(){
        List<CategoriaDTO> categorias = new ArrayList<>();
        categoriaRepository.findAll().forEach(categoria -> {
            CategoriaDTO categoriaDTO = new CategoriaDTO(categoria.getId(), categoria.getNome());
            categorias.add(categoriaDTO);
        });
        return categorias;
    }


    public void salvarCategoria(CategoriaDTO categoria){
        Categoria novaCategoria = new Categoria();
        novaCategoria.setNome(categoria.nome());
        categoriaRepository.save(novaCategoria);
    }
}
