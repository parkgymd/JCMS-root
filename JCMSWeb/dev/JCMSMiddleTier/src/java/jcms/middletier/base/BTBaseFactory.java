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

package jcms.middletier.base;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author rkavitha
 */
public class BTBaseFactory implements BTConstantsInterface
{
    private Context context         = null;
    private String  jndiServerName  = null;

    /**
     * Creates a new instance of CvDAO
     */
    public BTBaseFactory ()
    {

    }

    /**
     *  Creates a new instance of CvDAO
     *  <b>Purpose:</b>  Sets the hostname and port of the JNDI server.  <br>
     *  <b>Overview:</b>  Sets the hostname and port of the JNDI server.
     *                    Format is HOSTNAME:PORTNUMBER  <br>
     *  @param jndiServerName JNDI server name and port number separated by a colon.
     */
    public BTBaseFactory(String jndiServerName)
    {
        if (jndiServerName != null)
        {
            this.jndiServerName = jndiServerName;
        }
    }

    /**
     *  <b>Purpose:</b>  Gets a valid JNDI context.  <br>
     *  <b>Overview:</b>  Gets a valid JNDI context. <br>
     *  @throws NamingException JNDI lookup error
     */
    protected Context getContext() throws NamingException
    {
        try
        {
            // Add jndi.properties file to classpath.
            if (context == null)
            {
                if ((jndiServerName != null) && (jndiServerName.length() > 0))
                {
                    // Get context using the JNDI Server Name and Port set by
                    // the remote application code.  Client Application.
                    Hashtable<String, String> ht = new Hashtable<String, String>();
                    ht.put( "java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory" );
                    ht.put( "java.naming.provider.url", this.jndiServerName );
                    ht.put( "java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interface" );

                    context = new InitialContext(ht);
                }
                else
                {
                    context = new InitialContext();
                }
            }

            return context;
        }
        catch (NamingException ne)
        {
            throw new NamingException("Failed to get initial context.\n  " + ne);
        }
    }

    /**
     *  <b>Purpose:</b>  Closes the class JNDI context.  <br>
     *  <b>Overview:</b>  Closes the class JNDI context. <br>
     */
    protected void closeContext()
    {
        try
        {
            context.close ();
        }
        catch (NamingException ex)
        {
            ex.printStackTrace();
        }
    }

}
