/****
Copyright (c) 2015 The Jackson Laboratory

This is free software: you can redistribute it and/or modify it 
under the terms of the GNU General Public License as published by  
the Free Software Foundation, either version 3 of the License, or  
(at your option) any later version.
 
This software is distributed in the hope that it will be useful,  
but WITHOUT ANY WARRANTY; without even the implied warranty of 
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU 
General Public License for more details.

You should have received a copy of the GNU General Public License 
along with this software.  If not, see <http://www.gnu.org/licenses/>.
****/

package jcms.integrationtier.cv;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import jcms.integrationtier.base.ITBaseEntity;
import jcms.integrationtier.base.ITBaseEntityInterface;

/**
 * <b>File name:</b>  CvMouseOriginEntity.java  <p>
 * <b>Date developed:</b>  August 2010 <p>
 * <b>Purpose:</b>  Contains all mouse origin information  <p>
 * <b>Inputs:</b>  None   <p>
 * <b>Outputs:</b>  Named queries can be invoked from a local or remote session
 *                  beans.  EJB query language provides support
 *                  for setting query parameters as indicated by
 *                  colon and parameter syntax, :ParameterName.  <p>
 * <b>Last changed by:</b>   $Author$ <p>
 * <b>Last changed date:</b> $Date$   <p>
 * @author Kavitha Rama
 * @version $Revision$
 */
@Entity
@Table(name = "cv_MouseOrigin")
@NamedQueries({
    @NamedQuery(
        name = "CvMouseOriginEntity.findAll",
        query = "SELECT c FROM CvMouseOriginEntity c " +
                "ORDER BY c.mouseOrigin"),

    @NamedQuery(
        name = "CvMouseOriginEntity.findBykey",
        query = "SELECT c FROM CvMouseOriginEntity c WHERE c.mouseOriginkey = :key"),

    @NamedQuery(name = "CvMouseOriginEntity.findByMouseOriginkey", query = "SELECT c FROM CvMouseOriginEntity c WHERE c.mouseOriginkey = :mouseOriginkey"),
    @NamedQuery(name = "CvMouseOriginEntity.findByMouseOrigin", query = "SELECT c FROM CvMouseOriginEntity c WHERE c.mouseOrigin = :mouseOrigin"),
    @NamedQuery(name = "CvMouseOriginEntity.findByVersion", query = "SELECT c FROM CvMouseOriginEntity c WHERE c.version = :version")})

public class CvMouseOriginEntity extends ITBaseEntity implements Serializable, ITBaseEntityInterface {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "_mouseOrigin_key", nullable = false)
    private Integer mouseOriginkey;

    @Basic(optional = false)
    @Column(name = "mouseOrigin", nullable = false, length = 32)
    private String mouseOrigin;
    
    @Basic(optional = false)
    @Column(name = "version", nullable = false)
    private int version;

    public CvMouseOriginEntity() {
    }

    public CvMouseOriginEntity(Integer mouseOriginkey) {
        this.mouseOriginkey = mouseOriginkey;
    }

    public CvMouseOriginEntity(Integer mouseOriginkey, String mouseOrigin, int version) {
        this.mouseOriginkey = mouseOriginkey;
        this.mouseOrigin = mouseOrigin;
        this.version = version;
    }

    public Integer getMouseOriginkey() {
        return mouseOriginkey;
    }

    public void setMouseOriginkey(Integer mouseOriginkey) {
        this.mouseOriginkey = mouseOriginkey;
    }

    public String getMouseOrigin() {
        return mouseOrigin;
    }

    public void setMouseOrigin(String mouseOrigin) {
        this.mouseOrigin = mouseOrigin;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mouseOriginkey != null ? mouseOriginkey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CvMouseOriginEntity)) {
            return false;
        }
        CvMouseOriginEntity other = (CvMouseOriginEntity) object;
        if ((this.mouseOriginkey == null && other.mouseOriginkey != null) || (this.mouseOriginkey != null && !this.mouseOriginkey.equals(other.mouseOriginkey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jcms.integrationtier.cv.CvMouseOriginEntity[mouseOriginkey=" + mouseOriginkey + "]";
    }

    @Override
    public Integer getKey() {
        return mouseOriginkey;
    }

    @Override
    public ITBaseEntityInterface getEntity() {
        return this ;
    }

    @Override
    public void printDetail()
    {

    }

}
