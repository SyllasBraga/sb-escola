package sb.escola;

import sb.escola.entities.Aluno;
import sb.escola.entities.Professor;
import sb.escola.entities.Turma;
import sb.escola.repositories.AlunoRepository;
import sb.escola.repositories.ProfessorRepository;
import sb.escola.utils.StringParaDate;

import java.text.ParseException;
import java.time.LocalDateTime;

public class main {

    public static void main(String[] args) throws ParseException {

        Professor professor = new Professor(4L, "José Maria",
                new StringParaDate().converter("2001-10-10"),
                "Peçanha", 9999.0, "Sistemas de Informação - EAD");
        ProfessorRepository obj = new ProfessorRepository();

        System.out.println(obj.update(professor));
    }
}
