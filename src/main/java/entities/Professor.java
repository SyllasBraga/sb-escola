package entities;

import java.util.Date;

public class Professor extends Pessoa{

    private Double salario;
    private String graduacao;

    public Professor(Long matricula, String nomeCompleto, Date dataMatricula,
                     String endereco, Double salario, String graduacao) {
        super(matricula, nomeCompleto, dataMatricula, endereco);
        this.salario = salario;
        this.graduacao = graduacao;
    }

    public Professor() {
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }
}
