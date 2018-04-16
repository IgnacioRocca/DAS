package ar.edu.ubp.das.src.login.actions;

import java.sql.SQLException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.ubp.das.mvc.action.Action;
import ar.edu.ubp.das.mvc.action.ActionMapping;
import ar.edu.ubp.das.mvc.action.DynaActionForm;
import ar.edu.ubp.das.mvc.config.ForwardConfig;
import ar.edu.ubp.das.mvc.db.DaoFactory;
import ar.edu.ubp.das.src.login.boundaries.LogIn;
import ar.edu.ubp.das.src.login.interactors.LogInImpl;
import ar.edu.ubp.das.src.login.boundaries.LogInReq;
import ar.edu.ubp.das.src.login.boundaries.LogInResp;
import ar.edu.ubp.das.src.login.daos.MSUsuariosDao;

public class ValidarUsuarioAction implements Action {

	@Override
	public ForwardConfig execute(ActionMapping mapping, DynaActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, RuntimeException {

		MSUsuariosDao dao = (MSUsuariosDao) DaoFactory.getDao("Usuarios", "login");

		Optional<ForwardConfig> respuesta =
			form.getItem( "usuario").flatMap( u -> {
				return form.getItem( "clave").map( c -> {
					LogInReq req = new LogInReq(u, c);

					// CREA UN INTERACTOR
					LogIn auth = new LogInImpl();

					// EJECUTA EL INTERACTOR Y OBTIENE RESP
					LogInResp resp = auth.logIn(req).apply(dao);

					// form.setItem("respuesta", resp.getResult()); ??
					request.setAttribute("respuesta", resp.getResult());

					return mapping.getForwardByName( "success" );
				});
			});

		return respuesta.orElse(mapping.getForwardByName( "failure" ));
	}

}