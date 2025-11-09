package Model;

import java.time.LocalDateTime;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private LocalDateTime dataDeNascimento;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    public LocalDateTime getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDatadeNascimento(LocalDateTime dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
