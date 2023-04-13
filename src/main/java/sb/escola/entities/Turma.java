package sb.escola.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Turma {

    private Long id;
    private String serie;
    private String disciplina;
    private List<Aluno> alunos;
    private Professor professor;

    public Turma(Long id, String serie, String disciplina, List<Aluno> alunos, Professor professor) {
        this.id = id;
        this.serie = serie;
        this.disciplina = disciplina;
        this.alunos = alunos;
        this.professor = professor;
    }

    public Turma() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {

        List<String> listaNomesAlunos = new ArrayList<>();
        alunos.forEach(x -> listaNomesAlunos.add(x.getNomeCompleto()));

        return "Turma{" +
                "id=" + id +
                ", serie='" + serie + '\'' +
                ", disciplina='" + disciplina + '\'' +
                ", alunos=" +  listaNomesAlunos+
                ", professor=" + professor.getNomeCompleto() +
                '}';
    }
}
