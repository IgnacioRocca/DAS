
package ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.2.2
 * Sun Feb 18 06:57:40 ART 2018
 * Generated source version: 3.2.2
 */

@XmlRootElement(name = "consultarPlanResponse", namespace = "http://ws.das.edu.ubp.ar/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarPlanResponse", namespace = "http://ws.das.edu.ubp.ar/")

public class ConsultarPlanResponse {

    @XmlElement(name = "return")
    private beans.PlanBean _return;

    public beans.PlanBean getReturn() {
        return this._return;
    }

    public void setReturn(beans.PlanBean new_return)  {
        this._return = new_return;
    }

}

