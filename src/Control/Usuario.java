package Control;

import Model.Aluno;
import Model.Professor;
import Model.TipoUsuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Usuario {
    private Long id;
    private String nome;
    private String senha;
    private TipoUsuario tipoUsuario;
    private String cpf;
    private LocalDateTime dataDeNascimento;
    private String email;
    private Scanner leitor = new Scanner(System.in);

    public void cadastrarUsuario(Usuario usuario, Aluno aluno, Professor professor) {
        System.out.println("Por favor Digite o seu nome");
        nome = leitor.nextLine();
        usuario.setNome(nome);

        System.out.println("Por favor Digite a sua senha");
        senha = leitor.nextLine();
        usuario.setSenha(senha);

        System.out.print("Digite a sua data de nascimento no formato(dd/MM/yyyy): ");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataDeNascimentoStr = leitor.next();
        dataDeNascimento = LocalDateTime.parse(dataDeNascimentoStr, formato);
        usuario.setDataDeNascimento(dataDeNascimento);

        System.out.println("Digite o seu CPF somente com números!");
        cpf = leitor.nextLine();
        usuario.setCpf(cpf);

        System.out.println("Digite o seu email!");
        email = leitor.nextLine();
        usuario.setEmail(email);

        System.out.println("Por fim, qual tipo de usuário você é? Digite 'p' para Professor e 'a' para Aluno!");
        String tipoUsuario;
        tipoUsuario = leitor.nextLine();

        if (tipoUsuario.equalsIgnoreCase("P")) {
            usuario.setTipoUsuario(TipoUsuario.PROFESSOR);
        } else if (tipoUsuario.equalsIgnoreCase("A")) {
            usuario.setTipoUsuario(TipoUsuario.ALUNO);
        }

        System.out.println("Cadastrado Realizado com Sucesso!!");
    }

    public void logarNoSistema(String nome, String senha, String email){
        System.out.println("Por favor insira seu email");
        senha = leitor.nextLine();
        System.out.println("Por favor insira sua senha");
        email = leitor.nextLine();

        if (getEmail().equals(email) && getSenha().equals(senha)) {
            System.out.println("Logado no sistema!");
        } else {
            System.out.println("Credencias inválidas, por-favor tente novamente!");
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

    public LocalDateTime getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDateTime dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
