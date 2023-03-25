package entities;

import java.util.Date;
import java.util.List;

public class Aluno extends Pessoa{

    private List<Turma> turmas;

    public Aluno(Long matricula, String nomeCompleto, Date dataMatricula, String endereco, List<Turma> turmas) {
        super(matricula, nomeCompleto, dataMatricula, endereco);
        this.turmas = turmas;
    }

    public Aluno() {
    }

    public List<Turma> getTurma() {
        return turmas;
    }

    public void setTurma(List<Turma> turma) {
        this.turmas = turma;
    }
}
