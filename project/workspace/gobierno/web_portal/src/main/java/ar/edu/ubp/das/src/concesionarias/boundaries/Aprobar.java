package ar.edu.ubp.das.src.concesionarias.boundaries;

import ar.edu.ubp.das.mvc.db.Dao;
import ar.edu.ubp.das.src.concesionarias.forms.ConcesionariaForm;
import ar.edu.ubp.das.src.core.Interactor;

import java.util.Optional;
import java.util.function.Function;

public interface Aprobar extends Interactor {
    Function<Dao, Optional<String>> aprobarConcesionaria(ConcesionariaForm form);
}
