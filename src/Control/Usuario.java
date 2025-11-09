package Control;

import Model.Pessoa;

import java.util.Scanner;

public class Usuario extends Pessoa {
    private Long id;
    private String senha;

    public void logarNoSistema(String nome, String senha, String email){
        Scanner leitor = new Scanner(System.in);


        if (getNome().equals(nome) && getEmail().equals(email) && getSenha().equals(senha)) {
            System.out.println("Logado no sistema!");
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
