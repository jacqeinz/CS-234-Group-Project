/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cs234project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phoeb
 */
public class editMaterialWindow extends javax.swing.JFrame {
    private String type;
    private String reply;
    private int resp;
    private int cValue;
    private String materialFile;
    private String[] arrLine;
    
    private String oldFilename;
    
    /**
     * Creates new form editMaterialWindow
     */
    public editMaterialWindow(String materialName, int materialType, String materialFile, int type, String thing, int num) {
        initComponents();
      
        this.materialFile = materialFile;
        
        resp = num; 
        
        cValue = type;
        if(type == 1){
            this.type = "the title";
        }
        
        if(type == 2){
            if(materialType == 1){
                this.type = "the authors";
            }
            
            if(materialType == 1){
                this.type = "the directors";
            }
            
        }
        
        if(type == 3){
            this.type = " the year of publication";
        }
        
        if(type == 4){
            this.type = "the country";
        }
        
          
        editingType.setText("You are editing " + this.type);
        currentThing.setText("Your current " + this.type + " is " + thing + ". ");
        newType.setText("Please type your new " + this.type);
        jLabel1.setText(materialName + " Editing");
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        editingType = new javax.swing.JLabel();
        currentThing = new javax.swing.JLabel();
        newType = new javax.swing.JLabel();
        response = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        jLabel1.setText("Material Editing");

        editingType.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        editingType.setText("editing type");

        currentThing.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        currentThing.setText("current type");

        newType.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        newType.setText("New type");

        response.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(104, 104, 104))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newType, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(response))
                    .addComponent(currentThing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editingType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(editingType)
                .addGap(35, 35, 35)
                .addComponent(currentThing)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newType)
                    .addComponent(response, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(response.getText().isEmpty()){
            reply = "";
            
            new error().setVisible(true);
        }
        else{
            reply = response.getText();
            reply = reply.replaceAll("\\s+$", "");

            //System.out.println(reply);

            //userInfo.setText("Name " + name + " DOB: " + dateofBirth + " Address: " + address + " Phone #: " + phone);
            response.setText("");
            
            try {
                editMaterial();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(editMaterialWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(editMaterialWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void editMaterial() throws FileNotFoundException, InterruptedException{
        int rnum = 0;
        File inputFileC = new File(materialFile);
        Scanner inCount = new Scanner(inputFileC);
        
        while(inCount.hasNextLine()){ 
            String next = inCount.nextLine();
            rnum++;
        }
        
        inCount.close();
        
        resp--;
        
        File inputFile = new File(materialFile);
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("temp.txt");
        
        int count = 0;
        while(count < rnum && in.hasNextLine()){
            //System.out.println(count);
            String lineChange = in.nextLine();
            //System.out.println(lineChange);
                
            if(count == resp){
                
                arrLine = lineChange.split("~");
                
                //find file name 
                oldFilename = arrLine[1] + arrLine[3] + "Id" + arrLine[6]; 
                String rePlace2 = oldFilename.replaceAll("[^a-zA-Z0-9]", "");
                oldFilename = rePlace2;
                String temp3 = oldFilename +".txt";
                oldFilename = temp3; 
               
                if(cValue == 1){
                    
                    arrLine[1] = reply;
                    System.out.println("name is@" + arrLine[1]);
                }
                
                if(cValue == 2){
                    arrLine[2] = reply;
                    //System.out.println("The new DOB is: " + arrLine[4]);
                    
                }
                
                if(cValue == 3){
                    arrLine[3] = reply;
                    //System.out.println("The new address is: " + arrLine[5]);
                    
                }
                
                if(cValue == 4){
                    arrLine[4] = reply;
                    //System.out.println("The new phone is: " + arrLine[6]);
                    
                }
                
                
                
                out.println(count+1 + "~" + arrLine[1] + "~"  + arrLine[2] + "~" + arrLine[3]+  "~" + arrLine[4] +  "~" + arrLine[5] + "~" + arrLine[6]);
                
                
                //System.out.println("Printing" + count+1 + " _" + arrLine[1] + "_" + age + "_" + ageGroup + "_" + arrLine[4] + "_" + arrLine[5]+  "_" + arrLine[6] +  "_" + arrLine[7]);
                
                String iD;
                iD = arrLine[1] + arrLine[3] + "Id" + arrLine[6]; 
                //Trims whitespace and characters other than letters and numbers
                String rePlace = iD.replaceAll("[^a-zA-Z0-9]", "");
                iD = rePlace; 
                String temp = iD + ".txt";
                iD = temp;

                System.out.println("Old " + oldFilename + " new " + iD);
                //Creates file with fileCreate
                Files editF = new Files(oldFilename,iD);
                if(oldFilename != iD){
                    editF.fileCreate();

                    editF.fileReplace();
                }
                count++;
            }
            
            else{
                out.println(lineChange);
                //System.out.println("keep " + in.nextLine());
                count ++;
                //System.out.println("else");
            }
            
        }
        in.close();
        out.close();
        
        Files replace = new Files( "temp.txt" , materialFile);
        replace.fileReplace();
        
    }
    
    /**
     * @param args the command line arguments
     */
    public void editMwindow(String materialName, int materialType, String materialFile, int type, String thing, int num) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(editMaterialWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editMaterialWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editMaterialWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editMaterialWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editMaterialWindow(materialName, materialType, materialFile, type, thing, num).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel currentThing;
    private javax.swing.JLabel editingType;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel newType;
    private javax.swing.JTextField response;
    // End of variables declaration//GEN-END:variables
}
