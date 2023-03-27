package sb.escola;

import sb.escola.Configs.DataBaseConfig;
import sb.escola.entities.Turma;
import sb.escola.repositories.TurmaRepository;

import java.sql.Connection;

public class main {

    public static void main(String[] args){

        TurmaRepository obj = new TurmaRepository();
        Turma turma = new Turma(6L,"9º ano", "Cálculo III", null, null);
        for (Turma t : obj.getAll()){
            System.out.println(t.toString());
        }

        System.out.println(obj.getById(3L));
        System.out.println(obj.delete(turma));
    }
}
