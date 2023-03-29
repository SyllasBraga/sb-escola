package sb.escola.repositories;

import sb.escola.configs.DataBaseConfig;
import sb.escola.entities.Aluno;
import sb.escola.entities.Professor;
import sb.escola.entities.Turma;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurmaRepository {

    public DataBaseConfig db;
    public ProfessorRepository professorRepository;
    public AlunoRepository alunoRepository;

    public TurmaRepository(){
        this.db = new DataBaseConfig();
        this.professorRepository = new ProfessorRepository();
        this.alunoRepository = new AlunoRepository();
    }

    public List<Turma> getAll(){

        List<Turma> lista = new ArrayList<>();
        String sql = "select * from turma";

        try {
            PreparedStatement statement = db.connectDatase().prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){

                Turma turma = new Turma();
                turma.setId(Long.valueOf(result.getInt("id")));
                turma.setDisciplina(result.getString("disciplina"));
                turma.setSerie(result.getString("serie"));
                turma.setAlunos(getAlunosTurma(turma));
                turma.setProfessor(getProfessor(turma));

                lista.add(turma);
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Turma getById(Long id){

        Turma turma = new Turma();
        String sql = "select * from turma where id = ?";

        try {
            PreparedStatement statement = db.connectDatase().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()){

                turma.setId(Long.valueOf(result.getInt("id")));
                turma.setDisciplina(result.getString("disciplina"));
                turma.setSerie(result.getString("serie"));
                turma.setAlunos(getAlunosTurma(turma));
                turma.setProfessor(getProfessor(turma));

            }

            return turma;

        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }
    public List<Turma> getByAluno(Aluno aluno){

        List<Turma> lista = new ArrayList<>();
        String sql = "call pr_aluno_turma(?);";

        try {
            PreparedStatement statement = db.connectDatase().prepareStatement(sql);
            statement.setLong(1, aluno.getMatricula());
            ResultSet result = statement.executeQuery();

            while (result.next()){

                Turma turma = new Turma();
                turma.setId(Long.valueOf(result.getInt("id")));
                turma.setDisciplina(result.getString("disciplina"));
                turma.setSerie(result.getString("serie"));
                turma.setProfessor(getProfessor(turma));

                lista.add(turma);
            }

            return lista;

        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    public boolean create(Turma turma){

        String sql = "insert into turma values (default, ?,?,?)";

        try {
            PreparedStatement statement = db.connectDatase().prepareStatement(sql);
            statement.setString(1, turma.getSerie());
            statement.setString(2, turma.getDisciplina());
            statement.setInt(3, turma.getProfessor().getMatricula().intValue());

            return statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Turma turma){

        String sql = "update turma set serie=?, disciplina=?, id_professor=? where id=?";

        try{
            PreparedStatement statement = db.connectDatase().prepareStatement(sql);
            statement.setString(1, turma.getSerie());
            statement.setString(2, turma.getDisciplina());
            statement.setInt(3, turma.getProfessor().getMatricula().intValue());
            statement.setInt(4, turma.getId().intValue());

            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(Turma turma){

        String sql = "delete from turma where id=?";

        try{
            PreparedStatement statement = db.connectDatase().prepareStatement(sql);
            statement.setInt(1, turma.getId().intValue());

            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Aluno> getAlunosTurma(Turma turma){
        return alunoRepository.getByTurma(turma);
    }

    public Professor getProfessor(Turma turma){
        return professorRepository.getByTurma(turma);
    }
}
