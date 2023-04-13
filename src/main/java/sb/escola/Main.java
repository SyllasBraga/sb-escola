package sb.escola;

import sb.escola.configs.DataBaseConfig;
import sb.escola.entities.Aluno;
import sb.escola.repositories.AlunoRepository;
import sb.escola.repositories.ProfessorRepository;
import sb.escola.repositories.TurmaRepository;

public class Main {

    public static void main (String[] args){

        DataBaseConfig db = new DataBaseConfig();
        AlunoRepository alunoRepository = new AlunoRepository(db);
        ProfessorRepository professorRepository = new ProfessorRepository(db);
        TurmaRepository turmaRepository = new TurmaRepository(db, professorRepository, alunoRepository);

        for (Aluno aluno : alunoRepository.getAll()){
            System.out.println(aluno);
        }

    }
}
