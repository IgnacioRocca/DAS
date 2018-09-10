package ar.edu.ubp.das.src.login.actions;

import ar.edu.ubp.das.mvc.action.Action;
import ar.edu.ubp.das.mvc.action.ActionMapping;
import ar.edu.ubp.das.mvc.action.DynaActionForm;
import ar.edu.ubp.das.mvc.config.ForwardConfig;
import ar.edu.ubp.das.mvc.db.DaoFactory;
import ar.edu.ubp.das.mvc.db.DaoImpl;
import ar.edu.ubp.das.src.core.InteractorResponse;
import ar.edu.ubp.das.src.login.LogoutInteractor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class LogoutAction implements Action {

    @Override
    public ForwardConfig execute(final ActionMapping mapping, final DynaActionForm form, final HttpServletRequest request,
                                 final HttpServletResponse response) throws SQLException, RuntimeException {

        final DaoImpl loginDao = DaoFactory.getDao("LogIn", "login");

        final LogoutInteractor action = new LogoutInteractor(loginDao);
        final InteractorResponse<Long> result = action.execute(form);

        final Long logInId = result.getResult();

        final HttpSession session = request.getSession();
        session.setAttribute("LogInId", logInId);

        return mapping.getForwardByName(result.getResponse().getForward());
    }

}
