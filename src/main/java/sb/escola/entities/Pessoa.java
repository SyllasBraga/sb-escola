package sb.escola.entities;

import java.util.Date;

public abstract class Pessoa {

    protected Long matricula;
    protected String nomeCompleto;
    protected Date dataMatricula;
    protected String endereco;

    public Pessoa(Long matricula, String nomeCompleto, Date dataMatricula, String endereco) {
        this.matricula = matricula;
        this.nomeCompleto = nomeCompleto;
        this.dataMatricula = dataMatricula;
        this.endereco = endereco;
    }

    public Pessoa() {
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "matricula=" + matricula +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", dataMatricula=" + dataMatricula +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
