package br.com.ienh.springacessobanco.dto;

import jakarta.validation.constraints.Size;

public record CategoriaDTO(
        Integer id,

        @Size(max = 40, min = 5, message = "O nome deve ter entre 5 e 40 caracteres.")
        String nome) {
}
