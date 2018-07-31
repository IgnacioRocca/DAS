package boundaries.login;

import ar.edu.ubp.das.src.login.LoginInteractor;
import ar.edu.ubp.das.src.login.boundaries.LogIn;
import ar.edu.ubp.das.src.login.daos.MSLogInDao;
import ar.edu.ubp.das.src.login.forms.LogInForm;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class LogInTest {

    final MSLogInDao loginDao = new MSLogInDao();

    @Test
    public void testMockDBIsEmpty() throws SQLException {

        final LogInForm loginRqst = new LogInForm();
        loginRqst.setUsername("pepe");

        assertEquals(false, loginDao.select(null).contains(loginRqst));
    }

    @Test
    public void testLoginSuccessfully() throws SQLException {

        final LogInForm loginRqst = new LogInForm();
        loginRqst.setUsername("pepe");

        final LogIn logueador = new LoginInteractor();
        final Optional<Long> logInId = logueador.login(loginRqst).apply(loginDao);

        assertEquals(true, loginDao.select(null).contains(loginRqst));
        assertEquals(logInId, Optional.of(new Long(1)));
        assert (logueador.isLoggedIn(loginRqst).apply(loginDao).equals(logInId));
    }

}
