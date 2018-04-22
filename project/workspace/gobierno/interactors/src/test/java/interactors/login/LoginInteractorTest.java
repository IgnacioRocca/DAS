package interactors.login;

import ar.edu.ubp.das.mvc.action.DynaActionForm;
import ar.edu.ubp.das.mvc.db.Dao;
import core.Interactor;
import core.InteractorResponse;
import core.ResponseForward;
import login.LoginInteractor;
import mocks.MSLogInDaoMock;
import mocks.MSUsuariosDaoMock;
import org.junit.Test;
import java.util.*;
import java.util.function.BiFunction;

public class LoginInteractorTest {

    Dao daoUsuarios = new MSUsuariosDaoMock();
    Dao daoLogin = new MSLogInDaoMock();
    BiFunction<String, String, Dao> daoFactoryMock = (daoName, daoPackage) -> {
        if(daoName.equals("Usuarios") && daoPackage.equals("login")) {
            return daoUsuarios;
        }
        else if (daoName.equals("LogIn") && daoPackage.equals("login")) {
            return daoLogin;
        }
        else return null;
    };


    @Test
    public void testLoginInteractor() {
        Interactor action = new LoginInteractor();

        DynaActionForm userForm = new DynaActionForm();
        userForm.setItem("username", "pepe");
        userForm.setItem("password", "123");

        InteractorResponse response = action.execute(userForm).apply(daoFactoryMock);

        assert(response.getResponse() == ResponseForward.SUCCESS);
        assert(((Optional<Long>)response.getResult()).orElse(Long.MIN_VALUE) == 1);

    }

    @Test
    public void testLoginTwice() {
        Interactor action = new LoginInteractor();

        DynaActionForm userForm = new DynaActionForm();
        userForm.setItem("username", "pepe");
        userForm.setItem("password", "123");

        InteractorResponse response = action.execute(userForm).apply(daoFactoryMock);

        assert(response.getResponse() == ResponseForward.SUCCESS);
        assert(((Optional<Long>)response.getResult()).orElse(Long.MIN_VALUE) == 1);


        InteractorResponse response2 = action.execute(userForm).apply(daoFactoryMock);
        assert(response2.getResponse() == ResponseForward.FAILURE);
        assert(((Optional<Long>)response2.getResult()).isPresent() == false);
    }
}