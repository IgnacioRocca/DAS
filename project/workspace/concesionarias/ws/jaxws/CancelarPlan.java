
package ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.2.2
 * Sun Feb 18 06:57:16 ART 2018
 * Generated source version: 3.2.2
 */

@XmlRootElement(name = "cancelarPlan", namespace = "http://ws.das.edu.ubp.ar/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelarPlan", namespace = "http://ws.das.edu.ubp.ar/")

public class CancelarPlan {

    @XmlElement(name = "planGanador")
    private beans.PlanBean planGanador;

    public beans.PlanBean getPlanGanador() {
        return this.planGanador;
    }

    public void setPlanGanador(beans.PlanBean newPlanGanador)  {
        this.planGanador = newPlanGanador;
    }

}

