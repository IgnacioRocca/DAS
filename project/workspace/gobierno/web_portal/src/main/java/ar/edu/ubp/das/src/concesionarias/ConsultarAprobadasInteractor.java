package ar.edu.ubp.das.src.concesionarias;

import ar.edu.ubp.das.mvc.action.DynaActionForm;
import ar.edu.ubp.das.mvc.db.DaoImpl;
import ar.edu.ubp.das.src.concesionarias.daos.MSConcesionariasDao;
import ar.edu.ubp.das.src.concesionarias.forms.ConcesionariaForm;
import ar.edu.ubp.das.src.concesionarias.model.ConcesionariasManager;
import ar.edu.ubp.das.src.core.Interactor;
import ar.edu.ubp.das.src.core.InteractorResponse;
import ar.edu.ubp.das.src.core.ResponseForward;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ConsultarAprobadasInteractor implements Interactor<List<ConcesionariaForm>> {

    ConcesionariasManager concesionariasManager;

    public ConsultarAprobadasInteractor(DaoImpl concesionariasDao) {
        this.concesionariasManager = new ConcesionariasManager(concesionariasDao);
    }

    @Override
    public InteractorResponse<List<ConcesionariaForm>> execute(DynaActionForm form) throws SQLException {

        final List<ConcesionariaForm> aprobadas = concesionariasManager.getDao().selectAprobadas();

        return new InteractorResponse(ResponseForward.SUCCESS, Optional.of(aprobadas));
    }
}