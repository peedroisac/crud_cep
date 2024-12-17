package org.example.cep_project.meuapp.main;

import org.example.cep_project.meuapp.model.Endereco;
import org.example.cep_project.meuapp.repository.EnderecoRepository;
import org.example.cep_project.meuapp.service.ViaCepService;

public class Main {
    public static void main(String[] args) {
        ViaCepService viaCepService = new ViaCepService();
        EnderecoRepository enderecoRepository = new EnderecoRepository();

        String cep = "01001000";  // Exemplo de CEP

        // Buscar o endereço pela API ViaCEP
        Endereco endereco = viaCepService.buscarEnderecoPorCep(cep);

        if (endereco != null) {
            System.out.println("Endereço encontrado: " + endereco.getLogradouro());
            // Salvar no banco de dados
            enderecoRepository.save(endereco);
            System.out.println("Endereço salvo no banco de dados!");
        } else {
            System.out.println("Endereço não encontrado.");
        }
    }
}
