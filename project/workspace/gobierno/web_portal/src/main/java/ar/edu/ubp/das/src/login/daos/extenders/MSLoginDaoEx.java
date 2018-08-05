package ar.edu.ubp.das.src.login.daos.extenders;

import ar.edu.ubp.das.mvc.db.Dao;
import ar.edu.ubp.das.src.core.DaoExtender;
import ar.edu.ubp.das.src.login.forms.LogInForm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MSLoginDaoEx extends DaoExtender<LogInForm> {
    public MSLoginDaoEx(final Dao<LogInForm> dao) {
        super(dao);
    }

    public List<LogInForm> selectUserLoggIn(final LogInForm form) throws SQLException {
        this.connect();
        this.setProcedure("dbo.get_login_by_username(?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        this.setParameter(1, form.getUsername());
//        final List<LogInForm> logins = this.executeQuery().stream().map(x -> (LogInForm) x);/**/
        final List<LogInForm> logins = new ArrayList<>();
        this.disconnect();
        return logins;
    }

    // Needed For Tests Purpose
    public List<LogInForm> selectLastUserLogin(final LogInForm form) throws SQLException {
        this.connect();
        this.setProcedure("dbo.get_last_login_by_username(?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        this.setParameter(1, form.getUsername());
//        final List<LogInForm> logins = this.executeQuery().stream().map(x -> (LogInForm) x).collect(Collectors.toList());
        final List<LogInForm> logins = new ArrayList<>();
        this.disconnect();
        return logins;
    }

}
