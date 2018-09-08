package ar.edu.ubp.das.src.concesionarias.actions;

import ar.edu.ubp.das.mvc.action.Action;
import ar.edu.ubp.das.mvc.action.ActionMapping;
import ar.edu.ubp.das.mvc.action.DynaActionForm;
import ar.edu.ubp.das.mvc.config.ForwardConfig;
import ar.edu.ubp.das.src.concesionarias.AprobarInteractor;
import ar.edu.ubp.das.src.core.InteractorResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class AprobarConcesionariaAction implements Action {
    @Override
    public ForwardConfig execute(final ActionMapping mapping, final DynaActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws SQLException, RuntimeException {
        final AprobarInteractor action = new AprobarInteractor();
        final InteractorResponse<String> result = action.execute(form);

        final String codigo = result.getResult();


        request.setAttribute("codigo", codigo);

        return mapping.getForwardByName(result.getResponse().getForward());
    }
}
