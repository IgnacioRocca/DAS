
package service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.2.2
 * Sat Feb 17 21:37:36 ART 2018
 * Generated source version: 3.2.2
 */

@XmlRootElement(name = "doubleIt", namespace = "http://www.example.org/contract/DoubleItService")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doubleIt", namespace = "http://www.example.org/contract/DoubleItService")

public class DoubleIt {

    @XmlElement(name = "arg0")
    private int arg0;

    public int getArg0() {
        return this.arg0;
    }

    public void setArg0(int newArg0)  {
        this.arg0 = newArg0;
    }

}

