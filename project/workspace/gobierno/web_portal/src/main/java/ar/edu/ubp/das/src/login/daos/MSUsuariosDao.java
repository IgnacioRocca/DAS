package ar.edu.ubp.das.src.login.daos;

import ar.edu.ubp.das.mvc.db.DaoImpl;
import ar.edu.ubp.das.src.login.forms.UsuarioForm;

import java.sql.SQLException;
import java.util.List;

public class MSUsuariosDao extends DaoImpl<UsuarioForm> {

    public MSUsuariosDao() {
        super(UsuarioForm.class);
    }

    @Override
    public void insert(final UsuarioForm form) throws SQLException {
        executeProcedure("dbo.insert_usuario(?, ?, ?)", form, "username", "password", "rol");
    }

    @Override
    public void update(final UsuarioForm form) throws SQLException {
        executeProcedure("dbo.update_usuario_password(?, ?)", form, "username", "password");
    }

    @Override
    public void delete(final UsuarioForm form) throws SQLException {
        executeProcedure("dbo.delete_usuario(?)", form, "username");
    }

    @Override
    public List<UsuarioForm> select(final UsuarioForm form) throws SQLException {
        return executeQueryProcedure("dbo.get_usuarios", form);
    }

    @Override
    public boolean valid(final UsuarioForm form) throws SQLException {
        // TODO Auto-generated method stub
        return true;
    }
}
