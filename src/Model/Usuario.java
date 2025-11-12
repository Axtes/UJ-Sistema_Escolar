package Model;

import java.time.LocalDate;
import java.util.Scanner;

public class Usuario {
    private Long id;
    private static Long autoId = 1L;
    private String nome;
    private String senha;
    private TipoUsuario tipoUsuario;
    private String cpf;
    private LocalDate dataDeNascimento;
    private String email;
    private Scanner leitor = new Scanner(System.in);

    public Usuario() {
        id = autoId++;
    }

    public void manterDados(Usuario novoUsuario) {
        novoUsuario.setNome(getNome());
        novoUsuario.setSenha(getSenha());
        novoUsuario.setTipoUsuario(getTipoUsuario());
        novoUsuario.setCpf(getCpf());
        novoUsuario.setDataDeNascimento(getDataDeNascimento());
        novoUsuario.setEmail(getEmail());
    }

    public void logarNoSistema(){
        System.out.println("Por favor insira seu email");
        senha = leitor.nextLine();
        System.out.println("Por favor insira sua senha");
        email = leitor.nextLine();

        if (getEmail().equals(email) && getSenha().equals(senha)) {
            System.out.println("Logado no sistema!");
        } else {
            System.out.println("Credenciais inválidas, por-favor tente novamente!");
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
