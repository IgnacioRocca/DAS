package interactors.login;

import ar.edu.ubp.das.mvc.action.DynaActionForm;
import ar.edu.ubp.das.mvc.db.Dao;
import ar.edu.ubp.das.src.core.Interactor;
import ar.edu.ubp.das.src.core.InteractorResponse;
import ar.edu.ubp.das.src.core.ResponseForward;
import ar.edu.ubp.das.src.login.LoginInteractor;
import ar.edu.ubp.das.src.login.daos.MSLogInDao;
import ar.edu.ubp.das.src.login.daos.MSUsuariosDao;
import org.junit.Test;

import java.util.Optional;
import java.util.function.BiFunction;

public class LoginInteractorTest {

    Dao daoUsuarios = new MSUsuariosDao();
    Dao daoLogin = new MSLogInDao();

    BiFunction<String, String, Dao> daoFactoryMock = (daoName, daoPackage) -> {
        if (daoName.equals("Usuarios") && daoPackage.equals("login")) {
            return daoUsuarios;
        } else if (daoName.equals("LogIn") && daoPackage.equals("login")) {
            return daoLogin;
        } else return null;
    };


    @Test
    public void testLoginInteractor() {
        final Interactor action = new LoginInteractor();

        final DynaActionForm userForm = new DynaActionForm();
        userForm.setItem("username", "pepe");
        userForm.setItem("password", "123");

        final InteractorResponse response = action.execute(userForm).apply(daoFactoryMock);

        assert (response.getResponse() == ResponseForward.SUCCESS);
        assert (((Optional<Long>) response.getResult()).orElse(Long.MIN_VALUE) == 1);
    }

    @Test
    public void testLoginTwice() {
        final Interactor action = new LoginInteractor();

        final DynaActionForm userForm = new DynaActionForm();
        userForm.setItem("username", "pepe");
        userForm.setItem("password", "123");

        final InteractorResponse response = action.execute(userForm).apply(daoFactoryMock);

        assert (response.getResponse() == ResponseForward.SUCCESS);
        assert (((Optional<Long>) response.getResult()).orElse(Long.MIN_VALUE) == 1);


        final InteractorResponse response2 = action.execute(userForm).apply(daoFactoryMock);
        assert (response2.getResponse() == ResponseForward.SUCCESS);
        assert (((Optional<Long>) response2.getResult()).orElse(Long.MIN_VALUE) == 2);
    }

    @Test
    public void testMissingCredentials() {
        final Interactor action = new LoginInteractor();

        final DynaActionForm userForm = new DynaActionForm();
        userForm.setItem("username", "pepe");

        final InteractorResponse response = action.execute(userForm).apply(daoFactoryMock);

        assert (response.getResponse() == ResponseForward.WARNING);
        assert (((Optional<Long>) response.getResult()).equals(Optional.empty()));
    }

    @Test
    public void testLoginFailure() {
        final Interactor action = new LoginInteractor();

        final DynaActionForm userForm = new DynaActionForm();
        userForm.setItem("username", "no exists");
        userForm.setItem("password", "no password");

        final InteractorResponse response = action.execute(userForm).apply(daoFactoryMock);

        assert (response.getResponse() == ResponseForward.FAILURE);
        assert (((Optional<Long>) response.getResult()).equals(Optional.empty()));
    }
}
