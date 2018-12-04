package ar.edu.ubp.das.src.jobs;

import ar.edu.ubp.das.mvc.config.DatasourceConfig;
import ar.edu.ubp.das.src.jobs.runner.JobRunner;
import ar.edu.ubp.das.src.jobs.sorteo.ISorteoInvariantsHolder;
import ar.edu.ubp.das.src.jobs.sorteo.SorteoInvariantsHolder;
import beans.NotificationUpdate;
import clients.ConcesionariaServiceContract;
import clients.IClientFactory;
import clients.factory.ClientType;
import org.junit.Before;
import org.junit.Test;
import org.quartz.JobExecutionException;
import util.TestDB;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

public class JobsSpec {

    DatasourceConfig dataSourceConfig;

    @Before
    public void setup() throws SQLException {
        TestDB.getInstance().cleanDB();
        TestDB.getInstance().setUpDB();

        dataSourceConfig = TestDB.getInstance().getDataSourceConfig();
    }

    @Test
    public void test_job_creation() throws InterruptedException {
        final JobRunner runner = new JobRunner();
        runner.contextInitialized(null);
        System.out.println("----------------------");
//        Thread.sleep(10000L);
        runner.contextDestroyed(null);
    }

    @Test
    public void verifyPlanIsCanceladoSuccessfully() {
        final SorteoInvariantsHolder holder = new SorteoInvariantsHolder();
        assertTrue(holder.isPlanCancelado(new NotificationUpdate()));
    }

    // TESTS SORTEO
    @Test
    public void test_sorteo_base() throws JobExecutionException {
        class SorteoInvariantsHolderMock implements ISorteoInvariantsHolder {
            @Override
            public Boolean isPlanCancelado(final NotificationUpdate planBeanResponse) {
                return true;
            }
        }
        class ClientFactoryMock implements IClientFactory {

            @Override
            public Optional<ConcesionariaServiceContract> getClientFor(final ClientType configTecno, final Map<String, String> params) {
                return Optional.of(new ConcesionariaServiceContract() {
                    @Override
                    public List<NotificationUpdate> consultarPlanes(final String offset) {
                        return null;
                    }

                    @Override
                    public NotificationUpdate consultarPlan(final Long planId) {
                        return null;
                    }

                    @Override
                    public void cancelarPlan(final Long planId) {

                    }
                });
            }
        }

//        final SorteoJob sorteoJob = new SorteoJob(dataSourceConfig, new ClientFactoryMock(), new SorteoInvariantsHolderMock());
//        sorteoJob.verificarCancelacionCuenta();
    }
}
