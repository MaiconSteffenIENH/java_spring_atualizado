package br.com.ienh.springacessobanco.services;

import br.com.ienh.springacessobanco.dto.ProfessorDTO;
import br.com.ienh.springacessobanco.entities.Professor;
import br.com.ienh.springacessobanco.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    public void salvarProfessor(ProfessorDTO professor){
        Professor novoProfessor = new Professor();
        novoProfessor.setNome(professor.nome());
        professorRepository.save(novoProfessor);
    }

    public void atualizarProfessor(ProfessorDTO professor){
        Professor novoProfessor = new Professor();
        novoProfessor.setId(professor.id());
        novoProfessor.setNome(professor.nome());
        professorRepository.save(novoProfessor);
    }

    public ProfessorDTO obterProfessorPorId(int id){
        ProfessorDTO professorDTO = null;
        Professor professor = professorRepository.findById(id).get();
        professorDTO = new ProfessorDTO(professor.getId(), professor.getNome());
        return professorDTO;
    }

    public void excluirProfessor(int id){
        professorRepository.deleteById(id);
    }

    public List<ProfessorDTO> obterTodos(){
        List<ProfessorDTO> professores = new ArrayList<>();
        professorRepository.findAll().forEach(professor -> {
            ProfessorDTO professorDTO = new ProfessorDTO(professor.getId(), professor.getNome());
            professores.add(professorDTO);
        });
        return professores;
    }

}
