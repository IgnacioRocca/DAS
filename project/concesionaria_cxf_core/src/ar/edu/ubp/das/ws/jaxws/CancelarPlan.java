
package ar.edu.ubp.das.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.1.6
 * Fri Feb 16 01:48:28 ART 2018
 * Generated source version: 3.1.6
 */

@XmlRootElement(name = "cancelarPlan", namespace = "http://ws.das.ubp.edu.ar/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelarPlan", namespace = "http://ws.das.ubp.edu.ar/")

public class CancelarPlan {

    @XmlElement(name = "arg0")
    private beans.PlanBean arg0;

    public beans.PlanBean getArg0() {
        return this.arg0;
    }

    public void setArg0(beans.PlanBean newArg0)  {
        this.arg0 = newArg0;
    }

}

