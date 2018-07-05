package login.boundaries;

import ar.edu.ubp.das.mvc.db.Dao;
import beans.LogInForm;
import beans.UsuarioForm;
import core.Interactor;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public interface LogIn extends Interactor {
    Function<Dao, Optional<Long>> login(LogInForm req);

    Function<Dao, Boolean> validarUsuario(UsuarioForm req);

    Consumer<Dao> logout(LogInForm req);

    Function<Dao, Optional<Long>> isLoggedIn(LogInForm form);
}

