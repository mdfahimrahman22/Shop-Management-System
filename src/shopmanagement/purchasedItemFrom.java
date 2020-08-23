/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopmanagement;

import java.awt.event.KeyEvent;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fahim
 */
public class purchasedItemFrom extends javax.swing.JDialog {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    DefaultTableModel dtm;
    String user;

    /** Creates new form purchasedItemFrom */
    public purchasedItemFrom(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        buttonAnimation();
        conn = JConnection.connectdb();
        setTableModel();
        this.user = "admin";
        showProducts();

    }

    public purchasedItemFrom(java.awt.Frame parent, boolean modal, String user) {
        super(parent, modal);
        initComponents();
        buttonAnimation();
        conn = JConnection.connectdb();
        setTableModel();
        this.user = user;
        showProducts();

    }

    public void setTableModel() {
        dtm = (DefaultTableModel) productTable.getModel();
        productTable.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        productTable.setGridColor(Color.black);
        productTable.setShowHorizontalLines(true);
        productTable.setShowVerticalLines(true);
    }

    public void buttonAnimation() {

        refreshButton.setVisible(true);
        refreshButton1.setVisible(false);
        addItemButton.setVisible(true);
        addItemButton1.setVisible(false);
        removeButton.setVisible(true);
        removeButton1.setVisible(false);
        searchButton1.setVisible(false);
        searchButton2.setVisible(true);
        updateButton.setVisible(true);
        updateButton1.setVisible(false);
    }

    public void showProducts() {

        String sql = "select * from products where user=" + "\'" + user + "\'";

        try {

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            dtm.setRowCount(0);
            while (rs.next()) {
                Object[] obj = {rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), rs.getInt(7), rs.getInt(8), rs.getDate(9), rs.getTime(10)};
                dtm.addRow(obj);
            }

//            productTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Can not fetch data from database.");

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

        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        searchButton2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchButton1 = new javax.swing.JLabel();
        addItemButton = new javax.swing.JLabel();
        addItemButton1 = new javax.swing.JLabel();
        removeButton = new javax.swing.JLabel();
        removeButton1 = new javax.swing.JLabel();
        addItemButton2 = new javax.swing.JLabel();
        updateButton = new javax.swing.JLabel();
        updateButton1 = new javax.swing.JLabel();
        refreshButton = new javax.swing.JLabel();
        refreshButton1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Product Name", "Type", "Purchase Rate", "Sales Rate", "Vat", "Stock", "Last Update", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable.setRowHeight(20);
        productTable.getTableHeader().setReorderingAllowed(false);
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productTable);
        if (productTable.getColumnModel().getColumnCount() > 0) {
            productTable.getColumnModel().getColumn(0).setResizable(false);
            productTable.getColumnModel().getColumn(1).setResizable(false);
            productTable.getColumnModel().getColumn(2).setResizable(false);
            productTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            productTable.getColumnModel().getColumn(3).setResizable(false);
            productTable.getColumnModel().getColumn(4).setResizable(false);
            productTable.getColumnModel().getColumn(5).setResizable(false);
            productTable.getColumnModel().getColumn(6).setResizable(false);
            productTable.getColumnModel().getColumn(7).setResizable(false);
            productTable.getColumnModel().getColumn(8).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 807, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchField.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        searchField.setForeground(new java.awt.Color(153, 153, 153));
        searchField.setText("Search");
        searchField.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                searchFieldMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                searchFieldMouseMoved(evt);
            }
        });
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFieldFocusGained(evt);
            }
        });
        searchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchFieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchFieldMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchFieldMousePressed(evt);
            }
        });
        searchField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                searchFieldPropertyChange(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchFieldKeyTyped(evt);
            }
        });
        searchField.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                searchFieldVetoableChange(evt);
            }
        });
        jPanel2.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 180, 30));

        searchButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search - Copy.png"))); // NOI18N
        searchButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButton2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchButton2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                searchButton2MouseReleased(evt);
            }
        });
        jPanel2.add(searchButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 120, 50));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Purchased Items");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        searchButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search - Copy.png"))); // NOI18N
        searchButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchButton1MouseExited(evt);
            }
        });
        jPanel2.add(searchButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 120, 40));

        addItemButton.setBackground(new java.awt.Color(255, 51, 51));
        addItemButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addItem.jpg"))); // NOI18N
        addItemButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addItemButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addItemButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addItemButtonMouseReleased(evt);
            }
        });
        jPanel2.add(addItemButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 110, 40));

        addItemButton1.setBackground(new java.awt.Color(255, 51, 51));
        addItemButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addItem.jpg"))); // NOI18N
        addItemButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addItemButton1MouseClicked(evt);
            }
        });
        jPanel2.add(addItemButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 102, 30));

        removeButton.setBackground(new java.awt.Color(255, 51, 51));
        removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove.jpg"))); // NOI18N
        removeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                removeButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                removeButtonMouseReleased(evt);
            }
        });
        jPanel2.add(removeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 110, 40));

        removeButton1.setBackground(new java.awt.Color(255, 51, 51));
        removeButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove.jpg"))); // NOI18N
        removeButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeButton1MouseClicked(evt);
            }
        });
        jPanel2.add(removeButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 72, 115, 40));

        addItemButton2.setBackground(new java.awt.Color(255, 51, 51));
        addItemButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addItem.jpg"))); // NOI18N
        addItemButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addItemButton2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addItemButton2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addItemButton2MouseReleased(evt);
            }
        });
        jPanel2.add(addItemButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 110, 40));

        updateButton.setBackground(new java.awt.Color(255, 51, 51));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.jpg"))); // NOI18N
        updateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updateButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                updateButtonMouseReleased(evt);
            }
        });
        jPanel2.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 75, 102, 32));

        updateButton1.setBackground(new java.awt.Color(255, 51, 51));
        updateButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.jpg"))); // NOI18N
        updateButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateButton1MouseClicked(evt);
            }
        });
        jPanel2.add(updateButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 80, 102, 30));

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh2.png"))); // NOI18N
        refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                refreshButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                refreshButtonMouseReleased(evt);
            }
        });
        jPanel2.add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, 30, 30));

        refreshButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        refreshButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshButton1MouseClicked(evt);
            }
        });
        jPanel2.add(refreshButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldFocusGained

    private void searchFieldMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFieldMouseDragged

    }//GEN-LAST:event_searchFieldMouseDragged

    private void searchFieldMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFieldMouseMoved

    }//GEN-LAST:event_searchFieldMouseMoved

    private void searchFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFieldMouseEntered

    }//GEN-LAST:event_searchFieldMouseEntered

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered

    }//GEN-LAST:event_jPanel2MouseEntered

    private void searchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFieldMouseClicked
        searchField.setText("");
        searchField.setForeground(Color.black);
    }//GEN-LAST:event_searchFieldMouseClicked

    private void searchButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButton1MouseEntered

    }//GEN-LAST:event_searchButton1MouseEntered

    private void searchButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButton1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_searchButton1MouseExited

    private void searchButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButton2MousePressed
        searchButton1.setVisible(true);
        searchButton2.setVisible(false);
    }//GEN-LAST:event_searchButton2MousePressed

    private void searchButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButton2MouseReleased
        searchButton1.setVisible(false);
        searchButton2.setVisible(true);
    }//GEN-LAST:event_searchButton2MouseReleased

    private void searchFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFieldMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldMousePressed

    private void addItemButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addItemButtonMouseClicked
        MainPage main = new MainPage();
        new addNewItemForm(main, true, user).setVisible(true);
    }//GEN-LAST:event_addItemButtonMouseClicked

    private void addItemButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addItemButtonMousePressed
        addItemButton.setVisible(false);
        addItemButton1.setVisible(true);
    }//GEN-LAST:event_addItemButtonMousePressed

    private void addItemButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addItemButtonMouseReleased
        addItemButton.setVisible(true);
        addItemButton1.setVisible(false);
    }//GEN-LAST:event_addItemButtonMouseReleased

    private void addItemButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addItemButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addItemButton1MouseClicked

    private void removeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeButtonMouseClicked

        String id, sql;
        if (productTable.getRowCount() == 0) {
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "There is no data to delete.", "Warning",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            int[] rows = productTable.getSelectedRows();
            if (rows.length == 0) {
                final JPanel panel = new JPanel();
                JOptionPane.showMessageDialog(panel, "No row selected.", "No selection",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                String warningMassage = "Are you sure ?\nDelete products from database!!";
                int DialogResult = JOptionPane.showConfirmDialog(this, warningMassage, "Delete", JOptionPane.YES_NO_OPTION);
                if (DialogResult == 0) {
                    try {
                        for (int i = 0; i < rows.length; i++) {
                            id = dtm.getValueAt(rows[i], 0).toString();
                            sql = "DELETE FROM products WHERE product_id=" + "\'" + id + "\' AND user=" + "\'" + user + "\'";
                            pst = conn.prepareStatement(sql);
                            pst.execute();
                        }
                        showProducts();
                    } catch (SQLException ex) {
                        final JPanel panel = new JPanel();
                        JOptionPane.showMessageDialog(panel, "Can not delete from database.", "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    //            System.out.println(productTable.getSelectedRow());
                }
            }
        }
    }//GEN-LAST:event_removeButtonMouseClicked

    private void removeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeButtonMousePressed
        removeButton.setVisible(false);
        removeButton1.setVisible(true);
    }//GEN-LAST:event_removeButtonMousePressed

    private void removeButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeButtonMouseReleased
        removeButton.setVisible(true);
        removeButton1.setVisible(false);
    }//GEN-LAST:event_removeButtonMouseReleased

    private void removeButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_removeButton1MouseClicked

    private void addItemButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addItemButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addItemButton2MouseClicked

    private void addItemButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addItemButton2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_addItemButton2MousePressed

    private void addItemButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addItemButton2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_addItemButton2MouseReleased

    private void updateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseClicked

        if (productTable.getRowCount() == 0) {
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "There is no data to update.", "Warning",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            int row = productTable.getSelectedRow();
            if (row == -1) {
                final JPanel panel = new JPanel();
                JOptionPane.showMessageDialog(panel, "No row selected.", "No selection",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {

                MainPage main = new MainPage(user);
                new updateProduct(main, true, user, (String) dtm.getValueAt(row, 0)).setVisible(true);
            }
        }
    }//GEN-LAST:event_updateButtonMouseClicked

    private void updateButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMousePressed
        updateButton.setVisible(false);
        updateButton1.setVisible(true);
    }//GEN-LAST:event_updateButtonMousePressed

    private void updateButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseReleased
        updateButton.setVisible(true);
        updateButton1.setVisible(false);
    }//GEN-LAST:event_updateButtonMouseReleased

    private void updateButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton1MouseClicked

    private void refreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseClicked

        showProducts();

    }//GEN-LAST:event_refreshButtonMouseClicked

    private void refreshButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshButton1MouseClicked

    private void refreshButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMousePressed
        refreshButton.setVisible(false);
        refreshButton1.setVisible(true);
    }//GEN-LAST:event_refreshButtonMousePressed

    private void refreshButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseReleased
        refreshButton.setVisible(true);
        refreshButton1.setVisible(false);
    }//GEN-LAST:event_refreshButtonMouseReleased

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        showProducts();
    }//GEN-LAST:event_formWindowGainedFocus

    private void searchFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_searchFieldPropertyChange

    }//GEN-LAST:event_searchFieldPropertyChange

    private void searchFieldVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_searchFieldVetoableChange

    }//GEN-LAST:event_searchFieldVetoableChange


    private void searchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyTyped

    }//GEN-LAST:event_searchFieldKeyTyped

    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
       searchField.setForeground(Color.black);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String searchItem = "";
            searchItem = searchField.getText();
            String id;

            if (!searchItem.equals("")) {
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    id = (String) productTable.getValueAt(i, 0);
                    if (!id.equals(searchItem)) {
                        dtm.removeRow(i);
                    }
                }
                if (dtm.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Result not found");
                    searchField.setText("");
                    showProducts();
                }
            }
        }
    }//GEN-LAST:event_searchFieldKeyPressed
    int[] i = new int[5];
    int index = 0;
    String searchItem = "";
    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
//        System.out.println("Text:" + searchField.getText());
        searchItem = searchField.getText();
        String id;

        if (!searchItem.equals("")) {
            int x = index++;
            if (x == 4) {
                index = 0;
            }
            i[x] = searchItem.length();
//            System.out.println(i[x] + " " + x);
            if (x != 0) {
                if (i[x] < i[x - 1]) {
                    showProducts();
                    searchItem = searchField.getText();
                    for (int i = 0; i < dtm.getRowCount(); i++) {
                        id = (String) productTable.getValueAt(i, 0);
                        if (!id.contains(searchItem)) {
                            dtm.removeRow(i);
                        }
                    }
                } else {
                    for (int i = 0; i < dtm.getRowCount(); i++) {
                        id = (String) productTable.getValueAt(i, 0);
                        if (!id.contains(searchItem)) {
                            dtm.removeRow(i);
                        }
                    }
                }
            }
        } else {
            showProducts();
        }
    }//GEN-LAST:event_searchFieldKeyReleased

    private void searchButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButton2MouseClicked
        String searchItem = "";
        searchItem = searchField.getText();
        String id;

        if (!searchItem.equals("")) {
            for (int i = 0; i < dtm.getRowCount(); i++) {
                id = (String) productTable.getValueAt(i, 0);
                if (!id.equals(searchItem)) {
                    dtm.removeRow(i);
                }
            }
            if (dtm.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Result not found");
                searchField.setText("");
                showProducts();
            }

        }
    }//GEN-LAST:event_searchButton2MouseClicked

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_productTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(purchasedItemFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(purchasedItemFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(purchasedItemFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(purchasedItemFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                purchasedItemFrom dialog = new purchasedItemFrom(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addItemButton;
    private javax.swing.JLabel addItemButton1;
    private javax.swing.JLabel addItemButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productTable;
    private javax.swing.JLabel refreshButton;
    private javax.swing.JLabel refreshButton1;
    private javax.swing.JLabel removeButton;
    private javax.swing.JLabel removeButton1;
    private javax.swing.JLabel searchButton1;
    private javax.swing.JLabel searchButton2;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel updateButton;
    private javax.swing.JLabel updateButton1;
    // End of variables declaration//GEN-END:variables
}
