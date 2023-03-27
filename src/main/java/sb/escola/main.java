package sb.escola;

import sb.escola.entities.Aluno;
import sb.escola.repositories.AlunoRepository;
import sb.escola.utils.StringParaDate;

import java.text.ParseException;
import java.time.LocalDateTime;

public class main {

    public static void main(String[] args) throws ParseException {

        AlunoRepository alunoRepository = new AlunoRepository();
        Aluno aluno = new Aluno(5L, "André", new StringParaDate().converter("2006-03-24"), "GV", null);

        System.out.println(alunoRepository.update(aluno));
    }
}
