package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nota {
    private Map<Disciplina, Map<Aluno, List<Double>>> notasPorDisciplina;
    private Map<Disciplina, Map<Aluno, Double>> notaRecuperacao;

    private Aluno aluno;
    private Disciplina disciplina;
    private double media;
    private String situacao;

    public Nota(Aluno alunoSelecionado, Disciplina disciplinaSelecionada) {
        this.aluno = alunoSelecionado;
        this.disciplina = disciplinaSelecionada;
    }

    public void setNota(int i, double nota) {
        if (disciplina == null || aluno == null) {
            System.out.println("Aluno ou disciplina não definidos!");
            return;
        }

        notasPorDisciplina
            .computeIfAbsent(disciplina, d -> new HashMap<>())
            .computeIfAbsent(aluno, a -> new ArrayList<>());

        List<Double> notas = notasPorDisciplina.get(disciplina).get(aluno);

        if (notas.size() < 3) {
            notas.add(nota);
        } else if (i < notas.size()) {
            notas.set(i, nota);
        } else {
            System.out.println("Número de avaliações excedido!");
        }

        media = calcularMedia(disciplina, aluno);
        situacao = verificarSituacao(disciplina, aluno);
    }

    public String getMedia() {
        double m = calcularMedia(disciplina, aluno);
        return String.format("%.1f", m);
    }

    public String getSituacao() {
        return verificarSituacao(disciplina, aluno);
    }

    public Nota() {
        notasPorDisciplina = new HashMap<>();
        notaRecuperacao = new HashMap<>();
    }

    public void lancarNota(Disciplina disciplina, Aluno aluno, double nota) {
        notasPorDisciplina
            .computeIfAbsent(disciplina, d -> new HashMap<>())
            .computeIfAbsent(aluno, a -> new ArrayList<>());

        List<Double> notas = notasPorDisciplina.get(disciplina).get(aluno);
        if (notas.size() < 3) {
            notas.add(nota);
        } else {
            System.out.println("Já existem 3 notas lançadas para " + aluno.getNome() + " em " + disciplina.getNome());
        }
    }

    public void lancarRecuperacao(Disciplina disciplina, Aluno aluno, double nota) {
        notaRecuperacao
            .computeIfAbsent(disciplina, d -> new HashMap<>())
            .put(aluno, nota);
    }

    public double calcularMedia(Disciplina disciplina, Aluno aluno) {
        List<Double> notas = notasPorDisciplina
                .getOrDefault(disciplina, new HashMap<>())
                .getOrDefault(aluno, new ArrayList<>());

        if (notas.size() < 3) return 0.0;

        double soma = 0;
        for (double n : notas) soma += n;
        return soma / 3.0;
    }

    public double calcularNotaFinal(Disciplina disciplina, Aluno aluno) {
        double media = calcularMedia(disciplina, aluno);

        if (media >= 6.0) return media;

        Double rec = null;
        if (notaRecuperacao.containsKey(disciplina)) {
            rec = notaRecuperacao.get(disciplina).get(aluno);
        }

        if (rec == null) return media;
        return rec;
    }

    public String verificarSituacao(Disciplina disciplina, Aluno aluno) {
        double media = calcularMedia(disciplina, aluno);

        if (media >= 6.0) {
            return "Aprovado com média " + String.format("%.1f", media);
        } else {
            Double rec = null;
            if (notaRecuperacao.containsKey(disciplina)) {
                rec = notaRecuperacao.get(disciplina).get(aluno);
            }

            if (rec == null) {
                return "Em recuperação (média " + String.format("%.1f", media) + ")";
            } else {
                if (rec >= 5.0) {
                    return "Aprovado na recuperação (nota " + String.format("%.1f", rec) + ")";
                } else {
                    return "Reprovado na recuperação (nota " + String.format("%.1f", rec) + ")";
                }
            }
        }
    }

}


