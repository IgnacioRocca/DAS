package ar.edu.ubp.das.src.concesionarias.actions;

import ar.edu.ubp.das.mvc.action.Action;
import ar.edu.ubp.das.mvc.action.ActionMapping;
import ar.edu.ubp.das.mvc.action.DynaActionForm;
import ar.edu.ubp.das.mvc.config.ForwardConfig;
import ar.edu.ubp.das.mvc.db.DaoFactory;
import concesionarias.ConsultarAprobadasInteractor;
import concesionarias.RegistrarInteractor;
import concesionarias.forms.ConcesionariaForm;
import core.Interactor;
import core.InteractorResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RegistrarConcesionariaAction implements Action {
    @Override
    public ForwardConfig execute(ActionMapping mapping, DynaActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException, RuntimeException {
        Interactor action = new RegistrarInteractor();
        InteractorResponse result = action.execute(form).apply(DaoFactory::getDao);

        Optional<Long> concesionariaId = ((Optional<Long>)result.getResult());


        request.setAttribute("concesionariaId", concesionariaId);

        return mapping.getForwardByName(result.getResponse().getForward());
    }
}