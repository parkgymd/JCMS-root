/*
 * jptGUIConfiguration.java
 *
 * Created on August 20, 2008, 1:08 PM
 */

package org.jax.cs.apps.jcms.jpt;

import java.io.*;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import java.util.UUID;
import javax.swing.JOptionPane;
import org.jax.cs.apps.jcms.jpt.jptGUIConstants;

/**
 *
 * @author  daves
 */
public class jptGUIConfiguration extends javax.swing.JFrame {

    private File PropFile;
    private Properties myConfiguration;
    
    /** Creates new form jptGUIConfiguration */
    public jptGUIConfiguration() {
        initComponents();
        
        loadProperties();
    }

    public Properties getProperties()
    {
        return ( myConfiguration);
    }

    private void setConfigDefaults(){
        
        databaseType.setSelectedIndex(0);
        applicationTreeDepth.setSelectedIndex(1);
        reportType.setSelectedIndex(1);
        reportTreeDepth.setSelectedIndex(3);
    
    }
    private void loadProperties()
    {
        String currentdir = "";
        
        // See if we can find a configuration file ...
        try {
            // May want to consider using Common.Utils

            if ( null == PropFile ){
                PropFile = new File(System.getProperty("user.home").trim() + File.separator + ".jpt" +  File.separator + "jptConfigFile.properties");
                if ( !PropFile.exists()){
                 currentdir = System.getenv("HOME").trim();
                    PropFile = new File(currentdir + File.separator + ".jpt" + File.separator + "jptConfigFile.properties");
                    if (! PropFile.exists()){
                        throw ( new Exception());
                    }
                }
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
            PropFile = null;
            return;
        }
        
        // Load the form with the properties file.
        try
        {   
            
            myConfiguration = new Properties();
            
            //  Load if there
            FileInputStream in = new FileInputStream(PropFile.getAbsoluteFile().toString());
            myConfiguration.load(in);
            in.close();

            // Load the form from the Config file.
            databaseType.setSelectedIndex(Integer.valueOf(myConfiguration.getProperty("databaseType")).intValue());

            msAccessDSN.setText(myConfiguration.getProperty("msAccessDSN"));

            dbPort.setText(myConfiguration.getProperty("dbPort"));

            dbHostname.setText(myConfiguration.getProperty("dbHostname"));

            dbUsername.setText(myConfiguration.getProperty("dbUsername"));

            dbPassword.setText(myConfiguration.getProperty("dbPassword"));

            dbDatabase.setText(myConfiguration.getProperty("dbDatabase"));

            reportType.setSelectedIndex(Integer.valueOf(myConfiguration.getProperty("reportType")).intValue());

            applicationTreeDepth.setSelectedIndex(Integer.valueOf(myConfiguration.getProperty("applicationTreeDepth")).intValue());

            applicationTreeDepth.setSelectedItem(myConfiguration.getProperty("applicationTreeDepth"));

            reportTreeDepth.setSelectedItem(myConfiguration.getProperty("reportTreeDepth"));

            }
            catch (Exception e)
            {
                e.printStackTrace();
                setConfigDefaults();
            }
                
    }

    private void createPropertyFile(){

        // We are here only if we don't have a config file.
        
        // Let's try to create the user.home dir first.
        try {
            PropFile = new File(System.getProperty("user.home").trim() + "\\.jpt");            
            PropFile.mkdirs();
            PropFile = new File(System.getProperty("user.home").trim() + "\\.jpt\\jptConfigFile.properties");            
            PropFile.createNewFile();
            if (!PropFile.canWrite()){
                PropFile = new File(System.getenv("HOME").trim() + "\\.jpt");
                PropFile.mkdirs();
                PropFile = new File(System.getenv("HOME").trim() + "\\.jpt\\jptConfigFile.properties");
                PropFile.createNewFile();
                if (!PropFile.canWrite()){
                    throw ( new Exception("Can't find configuration file."));
                }
            }
        }
        catch (Exception e) { //Handle the exception to allow caller to deal
            e.printStackTrace();
            PropFile = null;
            return;
        }
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbDatabaseType = new javax.swing.JLabel();
        msAccessDSN = new javax.swing.JTextField();
        databaseType = new javax.swing.JComboBox();
        lbMSAccessDSN = new javax.swing.JLabel();
        lbMySQLPort = new javax.swing.JLabel();
        dbPort = new javax.swing.JTextField();
        lbMySQLHostname = new javax.swing.JLabel();
        dbHostname = new javax.swing.JTextField();
        lbMySQLUsername = new javax.swing.JLabel();
        dbUsername = new javax.swing.JTextField();
        lbMySQLPassword = new javax.swing.JLabel();
        lbReportType = new javax.swing.JLabel();
        reportType = new javax.swing.JComboBox();
        lbReportTreeDepth = new javax.swing.JLabel();
        reportTreeDepth = new javax.swing.JComboBox();
        lbApplicationTreeDepth = new javax.swing.JLabel();
        applicationTreeDepth = new javax.swing.JComboBox();
        dbPassword = new javax.swing.JPasswordField();
        lbMySQLDatabase = new javax.swing.JLabel();
        dbDatabase = new javax.swing.JTextField();
        jbSave = new javax.swing.JButton();
        jbReload = new javax.swing.JButton();
        statusMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(org.jax.cs.apps.jcms.jpt.jptGUIApp.class).getContext().getResourceMap(jptGUIConfiguration.class);
        lbDatabaseType.setText(resourceMap.getString("lbDatabaseType.text")); // NOI18N
        lbDatabaseType.setName("lbDatabaseType"); // NOI18N

        msAccessDSN.setText(resourceMap.getString("msAccessDSN.text")); // NOI18N
        msAccessDSN.setName("msAccessDSN"); // NOI18N
        msAccessDSN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                msAccessDSNKeyPressed(evt);
            }
        });

        databaseType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MS Access", "MySQL" }));
        databaseType.setName("databaseType"); // NOI18N
        databaseType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                databaseTypeActionPerformed(evt);
            }
        });

        lbMSAccessDSN.setText(resourceMap.getString("lbMSAccessDSN.text")); // NOI18N
        lbMSAccessDSN.setName("lbMSAccessDSN"); // NOI18N
        lbMSAccessDSN.setOpaque(true);

        lbMySQLPort.setText(resourceMap.getString("lbMySQLPort.text")); // NOI18N
        lbMySQLPort.setName("lbMySQLPort"); // NOI18N

        dbPort.setText(resourceMap.getString("dbPort.text")); // NOI18N
        dbPort.setName("dbPort"); // NOI18N
        dbPort.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                dbPortInputMethodTextChanged(evt);
            }
        });
        dbPort.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dbPortKeyPressed(evt);
            }
        });

        lbMySQLHostname.setText(resourceMap.getString("lbMySQLHostname.text")); // NOI18N
        lbMySQLHostname.setName("lbMySQLHostname"); // NOI18N

        dbHostname.setText(resourceMap.getString("dbHostname.text")); // NOI18N
        dbHostname.setName("dbHostname"); // NOI18N
        dbHostname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dbHostnameKeyPressed(evt);
            }
        });

        lbMySQLUsername.setText(resourceMap.getString("lbMySQLUsername.text")); // NOI18N
        lbMySQLUsername.setName("lbMySQLUsername"); // NOI18N

        dbUsername.setText(resourceMap.getString("dbUsername.text")); // NOI18N
        dbUsername.setName("dbUsername"); // NOI18N
        dbUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dbUsernameKeyPressed(evt);
            }
        });

        lbMySQLPassword.setText(resourceMap.getString("lbMySQLPassword.text")); // NOI18N
        lbMySQLPassword.setName("lbMySQLPassword"); // NOI18N

        lbReportType.setText(resourceMap.getString("lbReportType.text")); // NOI18N
        lbReportType.setName("lbReportType"); // NOI18N
        lbReportType.setOpaque(true);

        reportType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TEXT", "HTML" }));
        reportType.setName("reportType"); // NOI18N
        reportType.setOpaque(false);
        reportType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportTypeActionPerformed(evt);
            }
        });

        lbReportTreeDepth.setText(resourceMap.getString("lbReportTreeDepth.text")); // NOI18N
        lbReportTreeDepth.setName("lbReportTreeDepth"); // NOI18N

        reportTreeDepth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        reportTreeDepth.setName("reportTreeDepth"); // NOI18N
        reportTreeDepth.setOpaque(false);
        reportTreeDepth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportTreeDepthActionPerformed(evt);
            }
        });

        lbApplicationTreeDepth.setText(resourceMap.getString("lbApplicationTreeDepth.text")); // NOI18N
        lbApplicationTreeDepth.setName("lbApplicationTreeDepth"); // NOI18N

        applicationTreeDepth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "3", "4", "5", "6" }));
        applicationTreeDepth.setName("applicationTreeDepth"); // NOI18N
        applicationTreeDepth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applicationTreeDepthActionPerformed(evt);
            }
        });

        dbPassword.setText(resourceMap.getString("dbPassword.text")); // NOI18N
        dbPassword.setName("dbPassword"); // NOI18N
        dbPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dbPasswordKeyPressed(evt);
            }
        });

        lbMySQLDatabase.setText(resourceMap.getString("lbMySQLDatabase.text")); // NOI18N
        lbMySQLDatabase.setName("lbMySQLDatabase"); // NOI18N

        dbDatabase.setName("dbDatabase"); // NOI18N
        dbDatabase.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dbDatabaseKeyPressed(evt);
            }
        });

        jbSave.setText(resourceMap.getString("jbSave.text")); // NOI18N
        jbSave.setName("jbSave"); // NOI18N
        jbSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSaveActionPerformed(evt);
            }
        });

        jbReload.setText(resourceMap.getString("jbReload.text")); // NOI18N
        jbReload.setName("jbReload"); // NOI18N
        jbReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbReloadActionPerformed(evt);
            }
        });

        statusMessage.setText(resourceMap.getString("statusMessage.text")); // NOI18N
        statusMessage.setName("statusMessage"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMySQLPassword)
                            .addComponent(lbMySQLUsername)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lbReportTreeDepth)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                    .addComponent(reportTreeDepth, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lbReportType)
                                    .addGap(77, 77, 77)
                                    .addComponent(reportType, 0, 102, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lbApplicationTreeDepth)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                    .addComponent(applicationTreeDepth, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbDatabaseType)
                                        .addComponent(lbMySQLPort)
                                        .addComponent(lbMySQLHostname)
                                        .addComponent(lbMSAccessDSN)
                                        .addComponent(lbMySQLDatabase))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dbDatabase, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                        .addComponent(dbHostname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                        .addComponent(dbPort, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                        .addComponent(msAccessDSN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                        .addComponent(databaseType, 0, 123, Short.MAX_VALUE)
                                        .addComponent(dbUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                        .addComponent(dbPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbReload))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(statusMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(databaseType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(msAccessDSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMSAccessDSN))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dbPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMySQLPort))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dbHostname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMySQLHostname)))
                    .addComponent(lbDatabaseType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMySQLDatabase))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMySQLUsername)
                    .addComponent(dbUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMySQLPassword)
                    .addComponent(dbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbApplicationTreeDepth)
                    .addComponent(applicationTreeDepth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reportType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbReportType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbReportTreeDepth)
                    .addComponent(reportTreeDepth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSave)
                    .addComponent(jbReload))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusMessage)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        // </editor-fold>
    }//GEN-END:initComponents
    
    
private void databaseTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_databaseTypeActionPerformed
// TODO add your handling code here:
//    JOptionPane.showMessageDialog(null, "This is the simple message dialog box.", "Homer Says Doh", 1);
    
     statusMessage.setText("");
            
    if ( jptGUIConstants.Access == databaseType.getSelectedIndex())
    {
        dbPort.setText("");
        dbHostname.setText("");
        dbUsername.setText("");
        dbPassword.setText("");
        dbDatabase.setText("");
        msAccessDSN.setText("ODBC DSN");
        dbPort.setEnabled(false);
        dbHostname.setEnabled(false);
        dbUsername.setEnabled(false);
        dbPassword.setEnabled(false);
        dbDatabase.setEnabled(false);
        msAccessDSN.setEnabled(true);
       

    }
    else if (jptGUIConstants.MySQL == databaseType.getSelectedIndex())
    {
        msAccessDSN.setEnabled(false);
        msAccessDSN.setText("");
        
        dbPort.setText("3306");
        dbHostname.setText("localhost");
        dbUsername.setText("root");
        dbPassword.setText("");
        dbDatabase.setText("jcms_db");
        dbPort.setEnabled(true);
        dbHostname.setEnabled(true);
        dbUsername.setEnabled(true);
        dbPassword.setEnabled(true);
        dbDatabase.setEnabled(true);
      
    }
}//GEN-LAST:event_databaseTypeActionPerformed

private void jbSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSaveActionPerformed
// TODO add your handling code here:
     String strURL = "";

    // Create Properties and manuipulate the object
    if ( PropFile == null ) {
        createPropertyFile();
    } 
    
    if ( null == myConfiguration){
        myConfiguration = new Properties();
    }
     
    try
    {
        myConfiguration.setProperty("msAccessDSN",msAccessDSN.getText());

        myConfiguration.setProperty("dbPort",dbPort.getText());

        myConfiguration.setProperty("dbHostname",dbHostname.getText());

        myConfiguration.setProperty("dbUsername", dbUsername.getText());

        myConfiguration.setProperty("dbPassword",dbPassword.getText());

        myConfiguration.setProperty("dbDatabase",dbDatabase.getText());

        myConfiguration.setProperty("databaseType",Integer.valueOf(databaseType.getSelectedIndex()).toString());

        // Set Access Driver which is the JDBC/ODBC
        if (jptGUIConstants.Access == databaseType.getSelectedIndex())
        {   // Save the Driver Type
            myConfiguration.setProperty("databaseTypeDriver","sun.jdbc.odbc.JdbcOdbcDriver");
            // Save the JDBC URL

            strURL = "jdbc:odbc:";
            strURL += msAccessDSN.getText();
            
            myConfiguration.setProperty("jdbcURL",strURL);
                    
        }
        
        // Set MySQL Driver
        if (jptGUIConstants.MySQL == databaseType.getSelectedIndex())
        {
            myConfiguration.setProperty("databaseTypeDriver","com.mysql.jdbc.Driver");
            // Save the JDBC URL

            strURL = "jdbc:mysql://"; 
            // localhost:3306/jpt_ut"
            strURL += dbHostname.getText() + ":";
            strURL += dbPort.getText() + "/";
            strURL += dbDatabase.getText();
            
            myConfiguration.setProperty("jdbcURL",strURL);
        }


        myConfiguration.setProperty("reportType",
            Integer.valueOf(reportType.getSelectedIndex()).toString());
        
        myConfiguration.setProperty("reportTreeDepth",
            reportTreeDepth.getItemAt(reportTreeDepth.getSelectedIndex()).toString());

        myConfiguration.setProperty("applicationTreeDepth",
            applicationTreeDepth.getItemAt(applicationTreeDepth.getSelectedIndex()).toString());

        System.out.println(PropFile.toString());

        // Create file if not there.
        if (!PropFile.isFile())
        {
            throw (new Exception("No Properties file."));
        }
        
        // Write to file.
        FileOutputStream PropOut = new FileOutputStream(PropFile.getAbsoluteFile().toString());
        myConfiguration.store(PropOut, "---No Comment---");
        PropOut.close();
        statusMessage.setText("Configuration saved to disc!");
    }
    catch (SecurityException  e)
    {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Security error: Review the help page link in the about box." , "Error", 1);
    }
    catch (Exception e)
    {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Unable to save configuration file! \n Review the help page link in the about box."  + e.getMessage() , "Error", 1);
    }

}//GEN-LAST:event_jbSaveActionPerformed

private void jbReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbReloadActionPerformed
// TODO add your handling code here:
    
    statusMessage.setText("");             

    loadProperties();
    
    statusMessage.setText("Current configuration on disc!");
//GEN-LAST:event_jbReloadActionPerformed
}                                        

private void dbPortInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dbPortInputMethodTextChanged

    statusMessage.setText("");//GEN-LAST:event_dbPortInputMethodTextChanged

}

private void applicationTreeDepthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applicationTreeDepthActionPerformed
// TODO add your handling code here:
    statusMessage.setText(""); 
            
}//GEN-LAST:event_applicationTreeDepthActionPerformed

private void reportTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportTypeActionPerformed
// TODO add your handling code here:
    statusMessage.setText(""); 
    
}//GEN-LAST:event_reportTypeActionPerformed

private void reportTreeDepthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportTreeDepthActionPerformed
// TODO add your handling code here:
    statusMessage.setText(""); 
    
}//GEN-LAST:event_reportTreeDepthActionPerformed

private void msAccessDSNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_msAccessDSNKeyPressed
// TODO add your handling code here:
    statusMessage.setText(""); 
    
}//GEN-LAST:event_msAccessDSNKeyPressed

private void dbPortKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dbPortKeyPressed
// TODO add your handling code here:
    statusMessage.setText(""); 
    
}//GEN-LAST:event_dbPortKeyPressed

private void dbHostnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dbHostnameKeyPressed
// TODO add your handling code here:
    statusMessage.setText(""); 
}//GEN-LAST:event_dbHostnameKeyPressed

private void dbDatabaseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dbDatabaseKeyPressed
// TODO add your handling code here:
    statusMessage.setText(""); 
    
}//GEN-LAST:event_dbDatabaseKeyPressed

private void dbUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dbUsernameKeyPressed
// TODO add your handling code here:
    statusMessage.setText(""); 
}//GEN-LAST:event_dbUsernameKeyPressed

private void dbPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dbPasswordKeyPressed
// TODO add your handling code here:
    statusMessage.setText(""); 
}//GEN-LAST:event_dbPasswordKeyPressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new jptGUIConfiguration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox applicationTreeDepth;
    private javax.swing.JComboBox databaseType;
    private javax.swing.JTextField dbDatabase;
    private javax.swing.JTextField dbHostname;
    private javax.swing.JPasswordField dbPassword;
    private javax.swing.JTextField dbPort;
    private javax.swing.JTextField dbUsername;
    private javax.swing.JButton jbReload;
    private javax.swing.JButton jbSave;
    private javax.swing.JLabel lbApplicationTreeDepth;
    private javax.swing.JLabel lbDatabaseType;
    private javax.swing.JLabel lbMSAccessDSN;
    private javax.swing.JLabel lbMySQLDatabase;
    private javax.swing.JLabel lbMySQLHostname;
    private javax.swing.JLabel lbMySQLPassword;
    private javax.swing.JLabel lbMySQLPort;
    private javax.swing.JLabel lbMySQLUsername;
    private javax.swing.JLabel lbReportTreeDepth;
    private javax.swing.JLabel lbReportType;
    private javax.swing.JTextField msAccessDSN;
    private javax.swing.JComboBox reportTreeDepth;
    private javax.swing.JComboBox reportType;
    private javax.swing.JLabel statusMessage;
    // End of variables declaration//GEN-END:variables

}
