package ar.edu.ubp.das.src.login.daos.extenders;

import ar.edu.ubp.das.mvc.action.DynaActionForm;
import ar.edu.ubp.das.mvc.db.Dao;
import ar.edu.ubp.das.src.core.DaoExtender;
import ar.edu.ubp.das.src.login.forms.UsuarioForm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MSUsuariosDaoEx extends DaoExtender {
    public MSUsuariosDaoEx(final Dao dao) {
        super(dao);
    }

    public List<DynaActionForm> selectByUserNameAndPassword(final UsuarioForm form) throws SQLException {
        this.connect();
        this.setProcedure(
                "dbo.get_usuarios_by_username_password(?, ?)",
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
        this.setParameter(1, form.getUsername());
        this.setParameter(2, form.getPassword());
        final List<DynaActionForm> usuarios = this.executeQuery();
        this.disconnect();
        return usuarios;
    }
}
