package contract;

public interface ConcesionariaServiceContract {
    public String consultarPlanes();

    public String consultarPlan(Long planId);

    public void cancelarPlan(Long planId);
}