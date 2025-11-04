package com.example.First_Project.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class SistemaDeMensagens implements CommandLineRunner {
    @Autowired
    private Remetente remetente;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Mensagem enviada por: " + remetente.getName()
        + "\nE-mail: " + remetente.getEmail() + "\nCom telefones de contato: "
        + remetente.getTelefones());
        System.out.println("Seu Cadastro foi efetuado com sucesso.");
    }
}
