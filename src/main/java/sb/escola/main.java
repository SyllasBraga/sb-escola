package sb.escola;

import sb.escola.Configs.DataBaseConfig;
import sb.escola.entities.Aluno;
import sb.escola.entities.Turma;
import sb.escola.repositories.AlunoRepository;
import sb.escola.repositories.TurmaRepository;

import java.sql.Connection;

public class main {

    public static void main(String[] args){

        AlunoRepository alunoRepository = new AlunoRepository();

        for (Aluno aluno : alunoRepository.getAll()){
            System.out.println(aluno);
        }
    }
}
