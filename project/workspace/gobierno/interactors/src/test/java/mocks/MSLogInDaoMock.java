package mocks;

import ar.edu.ubp.das.mvc.action.DynaActionForm;
import ar.edu.ubp.das.mvc.db.Dao;
import login.forms.LogInForm;
import login.forms.UsuarioForm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MSLogInDaoMock implements Dao {
    public List<LogInForm> logins;

    public MSLogInDaoMock() {
        logins = new ArrayList<>();
    }

    @Override
    public DynaActionForm make(ResultSet result) throws SQLException {
        return null;
    }

    @Override
    public void insert(DynaActionForm form) throws SQLException {
        Optional<Long> max =
                logins.stream()
                        .filter( l -> l.getUsername().equals(((LogInForm) form).getUsername()) )
                        .map( l -> l.getId())
                        .max(Comparable::compareTo);

        LogInForm login = (LogInForm) form;
        login.setId(max.orElse(Long.valueOf(0)) + 1);
        logins.add(login);
    }

    @Override
    public void update(DynaActionForm form) throws SQLException {

    }

    @Override
    public void delete(DynaActionForm form) throws SQLException {

    }

    @Override
    public List<DynaActionForm> select(DynaActionForm form) throws SQLException {
        return logins.stream().collect(Collectors.toList());
    }

    @Override
    public boolean valid(DynaActionForm form) throws SQLException {
        return false;
    }
}