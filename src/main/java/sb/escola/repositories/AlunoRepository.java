package sb.escola.repositories;

import sb.escola.Configs.DataBaseConfig;
import sb.escola.entities.Aluno;
import sb.escola.entities.Turma;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {

    private DataBaseConfig db;
    private TurmaRepository turmaRepository;

    public AlunoRepository() {
        this.db = new DataBaseConfig();
        this.turmaRepository = new TurmaRepository();
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
                aluno.setTurma(getTurmasAluno(aluno));
                lista.add(aluno);
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Turma> getTurmasAluno(Aluno aluno) {
        return turmaRepository.getByAluno(aluno);
    }
}
