package sb.escola.repositories;

import sb.escola.configs.DataBaseConfig;
import sb.escola.entities.Aluno;
import sb.escola.entities.Turma;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {

    private DataBaseConfig db;

    public AlunoRepository(DataBaseConfig db) {
        this.db = db;
    }

    public List<Aluno> getAll() {

        String sql = "select * from aluno";
        List<Aluno> lista = new ArrayList<>();

        try {
            PreparedStatement statement = db.connectDatase().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setMatricula(Long.valueOf(rs.getInt("id")));
                aluno.setNomeCompleto(rs.getString("nome_completo"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setDataMatricula(rs.getDate("data_matricula"));
                aluno.setTurma(getTurmaAluno(aluno));
                lista.add(aluno);
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Aluno getById(Long id){

        String sql = "select * from aluno where id=?";
        Aluno aluno = new Aluno();

        try {
            PreparedStatement statement = db.connectDatase().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                aluno.setMatricula(Long.valueOf(rs.getInt("id")));
                aluno.setNomeCompleto(rs.getString("nome_completo"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setDataMatricula(rs.getDate("data_matricula"));
                aluno.setTurma(getTurmaAluno(aluno));
            }

            return aluno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean create(Aluno aluno){

        String sql = "insert into aluno values(default, ?, ?, ?)";

        try {
            PreparedStatement statement = db.connectDatase().prepareStatement(sql);
            statement.setString(1, aluno.getNomeCompleto());
            statement.setDate(2, new Date(aluno.getDataMatricula().getTime()));
            statement.setString(3, aluno.getEndereco());

            return statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean update(Aluno aluno){

        String sql = "update aluno set nome_completo=?, data_matricula=?, endereco=? where id=?";

        try {
            PreparedStatement statement = db.connectDatase().prepareStatement(sql);
            statement.setString(1, aluno.getNomeCompleto());
            statement.setDate(2, new Date(aluno.getDataMatricula().getTime()));
            statement.setString(3, aluno.getEndereco());
            statement.setInt(4, aluno.getMatricula().intValue());

            return statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean delete(Aluno aluno){

        String sql = "delete from aluno where id=?";

        try {
            PreparedStatement statement = db.connectDatase().prepareStatement(sql);
            statement.setInt(1, aluno.getMatricula().intValue());

            return statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Turma> getTurmaAluno(Aluno aluno){

        List<Turma> lista = new ArrayList<>();
        String sql = "call pr_aluno_turma(?);";

        try {
            PreparedStatement statement = db.connectDatase().prepareStatement(sql);
            statement.setLong(1, aluno.getMatricula());
            ResultSet result = statement.executeQuery();

            while (result.next()){

                Turma turma = new Turma();
                turma.setDisciplina(result.getString("disciplina"));

                lista.add(turma);
            }

            return lista;

        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

}
