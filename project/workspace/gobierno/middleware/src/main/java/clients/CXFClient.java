package clients;

import beans.NotificationUpdate;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import utils.JsonUtils;

import java.util.List;

public class CXFClient implements ConcesionariaServiceContract {

    private final String wsdlUrl;

    public CXFClient(final String wsdlUrl) {
        this.wsdlUrl = wsdlUrl; // "http://localhost:8000/concesionarias_cxf_one_war/services/concesionaria_cxf_one_service?wsdl"
    }

    private <A> Object executeMethod(final String methodName, final A... params) {
        final JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        final Client client = dcf.createClient(wsdlUrl);
        try {
            // System.out.println("Consuming Service: " + client.getEndpoint().getService().getName().toString());
            final Object[] res = client.invoke(methodName, params);
            if (res.length == 0)
                return null;
            return res[0];
        } catch (final Exception e) {
            e.printStackTrace();
            System.out.println("Exception in response is " + e.getMessage());
        } finally {
            client.destroy();
        }
        return null;
    }

    @Override
    public List<NotificationUpdate> consultarPlanes(final String offset) {
        final Object res = executeMethod("consultarPlanes");
        final String jsonPlanBeans = res.toString();
        return JsonUtils.toObjectArray(jsonPlanBeans, NotificationUpdate.class);
    }

    @Override
    public NotificationUpdate consultarPlan(final Long planId) {
        final Object res = executeMethod("consultarPlan", planId);
        final String jsonPlanBean = res.toString();
        return JsonUtils.toObject(jsonPlanBean, NotificationUpdate.class);
    }

    @Override
    public void cancelarPlan(final Long planId) {
        executeMethod("cancelarPlan", planId);
    }
}