package boundaries.estado_cuentas;

import estado_cuentas.EstadoCuentaInteractor;
import estado_cuentas.boundaries.RegistrarCuota;
import estado_cuentas.forms.CuotaForm;
import mocks.MSCuotaDaoMock;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class RegistrarCuotaTest {

    @Test
    public void validarRegistrarSuccessfully(){
        RegistrarCuota registador = new EstadoCuentaInteractor();
        MSCuotaDaoMock cuotaDao = new MSCuotaDaoMock();

        CuotaForm cuota = new CuotaForm();
        cuota.setEstadoCuentaId(Long.valueOf(1));
        cuota.setFechaVencimiento(Timestamp.valueOf("2018-02-01 21:58:01"));
        cuota.setMonto(10000);
        cuota.setFechaPago(Timestamp.valueOf("2018-01-27 21:58:01"));

        Optional<Long> cuotaId = registador.registrarCuota(cuota).apply(cuotaDao);

        assertEquals(Optional.of(Long.valueOf(1)), cuotaId);
        assertEquals(true, cuotaDao.cuotas.contains(cuota));

        CuotaForm cuota2 = new CuotaForm();
        cuota2.setEstadoCuentaId(Long.valueOf(1));
        cuota2.setFechaVencimiento(Timestamp.valueOf("2018-02-01 21:58:01"));
        cuota2.setMonto(10000);
        cuota2.setFechaPago(Timestamp.valueOf("2018-01-27 21:58:01"));

        Optional<Long> cuotaId2 = registador.registrarCuota(cuota2).apply(cuotaDao);

        assertEquals(Optional.of(Long.valueOf(2)), cuotaId2);
        assertEquals(2, cuotaDao.cuotas.size());
    }

}