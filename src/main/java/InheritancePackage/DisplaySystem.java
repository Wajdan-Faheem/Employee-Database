/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InheritancePackage;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.DefaultCellEditor;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Muhammad Faheem
 */
public class DisplaySystem extends javax.swing.JFrame {
        Menu menu = new Menu();
        LoginPage LP = new LoginPage();
        public MyHashTable theHT = Menu.theHT;
        EmailingEmployee EE = new EmailingEmployee();
    boolean found = false;

    public void ClearTable() {
        theHT.clear();
        PrintWriter pw;
        try {
            pw = new PrintWriter(LP.fileName);
            pw.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public void Editing() {
        String filePath = LP.fileName;
        File file = new File(filePath);
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < Table.getRowCount(); i++) {
                for (int j = 0; j < Table.getColumnCount(); j++) {
                    bw.write(Table.getValueAt(i, j).toString() + ",");
                }
                bw.newLine();
            }

            bw.close();
            fw.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

    }

    public void ReadFromFile() {
        String fileName = LP.fileName;
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);

            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            String reading;
            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                reading = tableLines[i].toString().trim();
                String[] dataRow = reading.split(",");
                model.addRow(dataRow);
            }
            reader.close();
            br.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public void Search(String s) {

        String fileName = LP.fileName;

        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);

            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(s) && parts[0].equals("Full-Time")) {
                    JOptionPane.showMessageDialog(null, "Type of Employee: " + parts[0] + "\n" + "Employee Number: " + parts[1] +  "\n" + "Employee Email Address: " + parts[2] + "\n" + "Employee First Name: " + parts[3] + "\n"
                            + "Employee Last Name: " + parts[4] + "\n" + "Employee Gender: " + parts[5] + "\n" + "Work Location: " + parts[6] + "\n" + "Deduction Rate: " + parts[7] + "\n" + "Gross Income: " + parts[11] + "\n"+"Net Income: "+parts[12]);
                    found = true;
                } else if (parts[1].equals(s) && parts[0].equals("Part-Time")) {
                    JOptionPane.showMessageDialog(null, "Type of Employee: " + parts[0] + "\n" + "Employee Number: " + parts[1] + "\n" + "Employee Email Address: " + parts[2] + "\n" + "Employee First Name: " + parts[3] + "\n"
                            + "Employee Last Name: " + parts[4] + "\n" + "Employee Gender: " + parts[5] + "\n" + "Work Location: " + parts[6] + "\n" + "Deduction Rate: " + parts[7] + "\n" + "Hourly Wage: " + parts[8] + "\n"
                            + "Hours Per Week: " + parts[9] + "\n" + "Weeks Per Year: " + parts[10]+"\n"+"Gross Income: "+parts[11]+"\n"+"Net Income: "+parts[12]);
                    found = true;
                }
            }
            if (found == false) {
                JOptionPane.showMessageDialog(null, "Employee number is not in the database!");
            }
            reader.close();
            br.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
      
    public DisplaySystem() {
        initComponents();
        ReadFromFile();
        UsernameLabel.setText((String) LP.fileName);
        this.setOpacity(0.95f);
        menu.Hashing();
    }

    /**
     * This method is called from    within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        MenuBar = new javax.swing.JPanel();
        SignOutPanel = new javax.swing.JPanel();
        SignOutLabel = new javax.swing.JLabel();
        EditPanel = new javax.swing.JPanel();
        EditLabel = new javax.swing.JLabel();
        RemovePanel = new javax.swing.JPanel();
        RemoveLabel = new javax.swing.JLabel();
        ViewPanel = new javax.swing.JPanel();
        ViewLabel = new javax.swing.JLabel();
        AddPanel = new javax.swing.JPanel();
        AddLabel = new javax.swing.JLabel();
        MenuPanel = new javax.swing.JPanel();
        MenuLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ToolPanel = new javax.swing.JPanel();
        ToolLabel = new javax.swing.JLabel();
        ClearTable = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        ClearTableLabel = new javax.swing.JLabel();
        SaveEdit = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        SaveEditLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        EmailingPanel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        Find = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        UsernameLabel = new javax.swing.JLabel();
        ExitPanel = new javax.swing.JPanel();
        ExitLabel = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Part-Time", "Full-Time" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Information and Mangement System");
        setMaximumSize(new java.awt.Dimension(1229, 690));
        setMinimumSize(new java.awt.Dimension(1229, 690));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1229, 690));
        getContentPane().setLayout(null);

        MenuBar.setBackground(new java.awt.Color(0, 102, 153));
        MenuBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SignOutPanel.setBackground(new java.awt.Color(0, 102, 153));
        SignOutPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignOutPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SignOutPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SignOutPanelMouseExited(evt);
            }
        });
        SignOutPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SignOutLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SignOut.png"))); // NOI18N
        SignOutPanel.add(SignOutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        MenuBar.add(SignOutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 50, 30));

        EditPanel.setBackground(new java.awt.Color(0, 102, 153));
        EditPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EditPanelMouseExited(evt);
            }
        });
        EditPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EditLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Edit_1.png"))); // NOI18N
        EditPanel.add(EditLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        MenuBar.add(EditPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 50, 30));

        RemovePanel.setBackground(new java.awt.Color(0, 102, 153));
        RemovePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RemovePanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RemovePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RemovePanelMouseExited(evt);
            }
        });
        RemovePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RemoveLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Remove.png"))); // NOI18N
        RemovePanel.add(RemoveLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        MenuBar.add(RemovePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 50, 30));

        ViewPanel.setBackground(new java.awt.Color(0, 102, 153));
        ViewPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ViewPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ViewPanelMouseExited(evt);
            }
        });
        ViewPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ViewLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View.png"))); // NOI18N
        ViewPanel.add(ViewLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        MenuBar.add(ViewPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 50, 30));

        AddPanel.setBackground(new java.awt.Color(0, 102, 153));
        AddPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddPanelMouseExited(evt);
            }
        });
        AddPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Add.png"))); // NOI18N
        AddPanel.add(AddLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        MenuBar.add(AddPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 50, 30));

        MenuPanel.setBackground(new java.awt.Color(0, 102, 153));
        MenuPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuPanelMouseExited(evt);
            }
        });
        MenuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MenuLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu.png"))); // NOI18N
        MenuPanel.add(MenuLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        MenuBar.add(MenuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 50, 30));

        getContentPane().add(MenuBar);
        MenuBar.setBounds(0, 0, 50, 1000);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ToolPanel.setBackground(new java.awt.Color(0, 0, 0));
        ToolPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        ToolPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ToolPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ToolPanelMouseExited(evt);
            }
        });
        ToolPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ToolLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        ToolLabel.setForeground(new java.awt.Color(255, 255, 255));
        ToolLabel.setText("Display Employee Management System");
        ToolPanel.add(ToolLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        jPanel1.add(ToolPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1150, 50));

        ClearTable.setBackground(new java.awt.Color(0, 0, 0));
        ClearTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        ClearTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ClearTableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ClearTableMouseExited(evt);
            }
        });
        ClearTable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cleartable.png"))); // NOI18N
        ClearTable.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        ClearTableLabel.setBackground(new java.awt.Color(255, 255, 255));
        ClearTableLabel.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        ClearTableLabel.setForeground(new java.awt.Color(255, 255, 255));
        ClearTableLabel.setText("Clear Table");
        ClearTable.add(ClearTableLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 90, -1));

        jPanel1.add(ClearTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 110, 80));

        SaveEdit.setBackground(new java.awt.Color(0, 0, 0));
        SaveEdit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        SaveEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveEditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SaveEditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SaveEditMouseExited(evt);
            }
        });
        SaveEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/saveEdit.png"))); // NOI18N
        SaveEdit.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        SaveEditLabel.setBackground(new java.awt.Color(255, 255, 255));
        SaveEditLabel.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        SaveEditLabel.setForeground(new java.awt.Color(255, 255, 255));
        SaveEditLabel.setText("Save Edit");
        SaveEdit.add(SaveEditLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 90, -1));

        jPanel1.add(SaveEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 70, 90, 80));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));

        Table.setBackground(new java.awt.Color(0, 0, 0));
        Table.setForeground(new java.awt.Color(255, 255, 255));
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PTE/FTE", "Employee Number", "Email Address", "First Name", "Last Name", "Gender", "Workplace ", "Deduction Rate", "Hourly Wage", "Hrs/Week", "Weeks/per Year", "Gross Income", "Net Income"
            }
        ));
        Table.setGridColor(new java.awt.Color(0, 0, 0));
        Table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(jComboBox1));
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 1140, 460));

        EmailingPanel.setBackground(new java.awt.Color(0, 0, 0));
        EmailingPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        EmailingPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmailingPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EmailingPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EmailingPanelMouseExited(evt);
            }
        });
        EmailingPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/send email.png"))); // NOI18N
        EmailingPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        EmailLabel.setBackground(new java.awt.Color(255, 255, 255));
        EmailLabel.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        EmailLabel.setForeground(new java.awt.Color(255, 255, 255));
        EmailLabel.setText("Email");
        EmailLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        EmailingPanel.add(EmailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 50, 20));

        jPanel1.add(EmailingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 90, 80));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(50, 50, 1180, 640);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });
        jPanel3.setLayout(null);
        jPanel3.add(jSeparator1);
        jSeparator1.setBounds(100, 40, 210, 10);

        Find.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        Find.setForeground(new java.awt.Color(255, 153, 0));
        Find.setBorder(null);
        Find.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FindKeyPressed(evt);
            }
        });
        jPanel3.add(Find);
        Find.setBounds(100, 10, 210, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        jPanel3.add(jLabel7);
        jLabel7.setBounds(60, 10, 32, 30);

        UsernameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/User_Icon.png"))); // NOI18N
        UsernameLabel.setText("Username");
        jPanel3.add(UsernameLabel);
        UsernameLabel.setBounds(1090, 0, 100, 40);

        ExitPanel.setBackground(new java.awt.Color(255, 255, 255));
        ExitPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        ExitPanel.setMaximumSize(new java.awt.Dimension(32, 32));
        ExitPanel.setMinimumSize(new java.awt.Dimension(32, 32));
        ExitPanel.setPreferredSize(new java.awt.Dimension(32, 32));
        ExitPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitPanelMouseExited(evt);
            }
        });
        ExitPanel.setLayout(new java.awt.GridLayout(1, 0));

        ExitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ExitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Exit2.png"))); // NOI18N
        ExitPanel.add(ExitLabel);

        jPanel3.add(ExitPanel);
        ExitPanel.setBounds(1190, 0, 32, 32);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 1230, 50);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private int xMouse, yMouse;
    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y= evt.getYOnScreen();
        setLocation(x-xMouse,y-yMouse); 
    }//GEN-LAST:event_jPanel3MouseDragged

    private void MenuPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPanelMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Menu().setVisible(true);
    }//GEN-LAST:event_MenuPanelMouseClicked

    private void MenuPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPanelMouseEntered
        MenuPanel.setBackground(new Color(255,153,0));
    }//GEN-LAST:event_MenuPanelMouseEntered

    private void MenuPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPanelMouseExited
        // TODO add your handling code here:
        MenuPanel.setBackground(new Color(0,102,153));
    }//GEN-LAST:event_MenuPanelMouseExited

    private void AddPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPanelMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new AddEmployee().setVisible(true);        
    }//GEN-LAST:event_AddPanelMouseClicked

    private void AddPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPanelMouseEntered
        // TODO add your handling code here:
        AddPanel.setBackground(new Color(255,153,0));

    }//GEN-LAST:event_AddPanelMouseEntered

    private void AddPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPanelMouseExited
        // TODO add your handling code here:
        AddPanel.setBackground(new Color(0,102,153));
    }//GEN-LAST:event_AddPanelMouseExited

    private void RemovePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemovePanelMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new RemoveEmployee().setVisible(true);
    }//GEN-LAST:event_RemovePanelMouseClicked

    private void RemovePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemovePanelMouseEntered
        // TODO add your handling code here:
       RemovePanel.setBackground(new Color(255,153,0));

    }//GEN-LAST:event_RemovePanelMouseEntered

    private void RemovePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemovePanelMouseExited
        // TODO add your handling code here:
       RemovePanel.setBackground(new Color(0,102,153));

    }//GEN-LAST:event_RemovePanelMouseExited

    private void EditPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditPanelMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new EditEmployee().setVisible(true);
    }//GEN-LAST:event_EditPanelMouseClicked

    private void EditPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditPanelMouseEntered
        // TODO add your handling code here:
       EditPanel.setBackground(new Color(255,153,0));
    }//GEN-LAST:event_EditPanelMouseEntered

    private void EditPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditPanelMouseExited
        // TODO add your handling code here:
       EditPanel.setBackground(new Color(0,102,153));
    }//GEN-LAST:event_EditPanelMouseExited

    private void ViewPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewPanelMouseClicked
        this.dispose();
        new DisplaySystem().setVisible(true);        
    }//GEN-LAST:event_ViewPanelMouseClicked

    private void ViewPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewPanelMouseEntered
        // TODO add your handling code here:
       ViewPanel.setBackground(new Color(255,153,0));
    }//GEN-LAST:event_ViewPanelMouseEntered

    private void ViewPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewPanelMouseExited
       ViewPanel.setBackground(new Color(0,102,153));
    }//GEN-LAST:event_ViewPanelMouseExited

    private void SignOutPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignOutPanelMouseClicked
       new LoginPage().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_SignOutPanelMouseClicked

    private void SignOutPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignOutPanelMouseEntered
       SignOutPanel.setBackground(new Color(255,153,0));
    }//GEN-LAST:event_SignOutPanelMouseEntered

    private void SignOutPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignOutPanelMouseExited
       SignOutPanel.setBackground(new Color(0,102,153));
    }//GEN-LAST:event_SignOutPanelMouseExited

    private void ExitPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitPanelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitPanelMouseClicked

    private void ExitPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitPanelMouseEntered
        ExitLabel.setForeground(Color.WHITE);
        ExitPanel.setBackground(new Color(255, 255, 255));
        ExitPanel.setBorder(new LineBorder(new Color(255, 153, 0), 1, true));
    }//GEN-LAST:event_ExitPanelMouseEntered

    private void ExitPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitPanelMouseExited
        ExitLabel.setForeground(new Color(255, 153, 0));
        ExitPanel.setBackground(new Color(0, 102, 153));
        ExitPanel.setBorder(new LineBorder(Color.WHITE, 0, true));
    }//GEN-LAST:event_ExitPanelMouseExited

    private void SaveEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveEditMouseExited
        // TODO add your handling code here:
        SaveEditLabel.setForeground(Color.white);
        SaveEdit.setBackground(Color.BLACK);
        SaveEdit.setBorder(new LineBorder(Color.WHITE,1,true));
    }//GEN-LAST:event_SaveEditMouseExited

    private void SaveEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveEditMouseEntered
        // TODO add your handling code here:
        SaveEditLabel.setForeground(Color.WHITE);
        SaveEdit.setBackground(new Color(255,153,0));
        SaveEdit.setBorder(new LineBorder(new Color(255,153,0),1,true));
    }//GEN-LAST:event_SaveEditMouseEntered

    private void SaveEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveEditMouseClicked
       ClearTable();
        Editing();
        ReadFromFile();
        new DisplaySystem().setVisible(true);
        DisplaySystem.this.dispose();
    }//GEN-LAST:event_SaveEditMouseClicked

    private void ToolPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ToolPanelMouseExited
        ToolLabel.setForeground(Color.WHITE);
        ToolPanel.setBackground(Color.BLACK);
        ToolPanel.setBorder(new LineBorder(Color.WHITE,1,true));
    }//GEN-LAST:event_ToolPanelMouseExited

    private void ToolPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ToolPanelMouseEntered
        ToolLabel.setForeground(Color.WHITE);
        ToolPanel.setBackground(new Color(255,153,0));
        ToolPanel.setBorder(new LineBorder(new Color(255,153,0),1,true));
    }//GEN-LAST:event_ToolPanelMouseEntered

    private void ClearTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearTableMouseClicked
        ClearTable();
        DisplaySystem.this.dispose();
        new DisplaySystem().setVisible(true);
        JOptionPane.showMessageDialog(null,"SYSTEM HAS BEEN CLEARED!");    }//GEN-LAST:event_ClearTableMouseClicked

    private void ClearTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearTableMouseEntered
        ClearTableLabel.setForeground(Color.WHITE);
        ClearTable.setBackground(new Color(255,153,0));
        ClearTable.setBorder(new LineBorder(new Color(255,153,0),1,true));    }//GEN-LAST:event_ClearTableMouseEntered

    private void ClearTableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearTableMouseExited
    ClearTableLabel.setForeground(Color.white);
        ClearTable.setBackground(Color.BLACK);
        ClearTable.setBorder(new LineBorder(Color.WHITE,1,true));    }//GEN-LAST:event_ClearTableMouseExited

    private void FindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FindKeyPressed
        // TODO add your handling code here:
         if (evt.getKeyCode()==KeyEvent.VK_ENTER){
          Search(Find.getText().trim());
         }
    }//GEN-LAST:event_FindKeyPressed

    private void EmailingPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmailingPanelMouseClicked
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        int selectedRow = Table.getSelectedRow();
        
        new EmailingEmployee().setVisible(true);
        EmailingEmployee.EmailField.setText(model.getValueAt(selectedRow, 2).toString().trim());
        this.dispose();
    }//GEN-LAST:event_EmailingPanelMouseClicked

    private void EmailingPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmailingPanelMouseEntered
        EmailLabel.setForeground(Color.WHITE);
        EmailingPanel.setBackground(new Color(255,153,0));
        EmailingPanel.setBorder(new LineBorder(new Color(255,153,0),1,true));    }//GEN-LAST:event_EmailingPanelMouseEntered

    private void EmailingPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmailingPanelMouseExited
    EmailLabel.setForeground(Color.white);
        EmailingPanel.setBackground(Color.BLACK);
        EmailingPanel.setBorder(new LineBorder(Color.WHITE,1,true));    }//GEN-LAST:event_EmailingPanelMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplaySystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddLabel;
    private javax.swing.JPanel AddPanel;
    private javax.swing.JPanel ClearTable;
    private javax.swing.JLabel ClearTableLabel;
    private javax.swing.JLabel EditLabel;
    private javax.swing.JPanel EditPanel;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JPanel EmailingPanel;
    private javax.swing.JLabel ExitLabel;
    private javax.swing.JPanel ExitPanel;
    private javax.swing.JTextField Find;
    private javax.swing.JPanel MenuBar;
    private javax.swing.JLabel MenuLabel;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JLabel RemoveLabel;
    private javax.swing.JPanel RemovePanel;
    private javax.swing.JPanel SaveEdit;
    private javax.swing.JLabel SaveEditLabel;
    private javax.swing.JLabel SignOutLabel;
    private javax.swing.JPanel SignOutPanel;
    private javax.swing.JTable Table;
    private javax.swing.JLabel ToolLabel;
    private javax.swing.JPanel ToolPanel;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JLabel ViewLabel;
    private javax.swing.JPanel ViewPanel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
