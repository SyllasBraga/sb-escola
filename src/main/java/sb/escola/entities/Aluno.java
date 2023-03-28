package sb.escola.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public String toString() {
        List<String> turmasString = new ArrayList<>();
        turmas.forEach(x -> turmasString.add(x.getDisciplina()));

        return "Aluno{"+
                "matricula=" + matricula +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", dataMatricula=" + dataMatricula +
                ", endereco='" + endereco + '\'' +
                ", turmas=" + turmasString +
                '}'+'\n';
    }
}
