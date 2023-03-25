package sb.escola.entities;

import java.util.Map;

public class Turma {

    private Long id;
    private String serie;
    private String disciplina;
    private Map<Long, Aluno> alunos;
    private Professor professor;

    public Turma(Long id, String serie, String disciplina, Map<Long, Aluno> alunos, Professor professor) {
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

    public Map<Long, Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Map<Long, Aluno> alunos) {
        this.alunos = alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
