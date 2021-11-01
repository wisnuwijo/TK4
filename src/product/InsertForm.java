/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Rio Ardiyani
 */
public class InsertForm extends javax.swing.JFrame {
public Statement st;
private Connect conn = new Connect();
private ResultSet rs = null;
private ResultSetMetaData rsm = null;
public InsertForm()
{ initComponents();
}
@SuppressWarnings("unchecked")

// <editor-fold defaultstate="collapsed" desc="Generated Code">
private void initComponents() {
jPanel1 = new javax.swing.JPanel();
jLabel1 = new javax.swing.JLabel();
jName = new javax.swing.JLabel();
jType = new javax.swing.JLabel(); 
jPrice = new javax.swing.JLabel(); 
jStock = new javax.swing.JLabel(); 
jTName = new javax.swing.JTextField();
jCType = new javax.swing.JComboBox<>();
jBInsert = new javax.swing.JButton();
jTPrice = new javax.swing.JSpinner();
jTStock = new javax.swing.JSpinner();
setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
setTitle("Insert Form");
jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
jLabel1.setText("Product");
jName.setText("Name");
jType.setText("Type");
jPrice.setText("Price");
jStock.setText("Stock");
jCType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{ "Drink","Food" }));
jBInsert.setText("Insert");
jBInsert.addActionListener(new java.awt.event.ActionListener()
{public void actionPerformed(java.awt.event.ActionEvent evt) {
jBInsertActionPerformed(evt);
}
});

javax.swing.GroupLayout jPanel1Layout = new
javax.swing.GroupLayout(jPanel1);
jPanel1.setLayout(jPanel1Layout);
jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,jPanel1Layout.createSequentialGroup()
.addGap(20, 20, 20)
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, 76,javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jStock, javax.swing.GroupLayout.PREFERRED_SIZE, 76,javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 76,javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jType, javax.swing.GroupLayout.PREFERRED_SIZE, 76,javax.swing.GroupLayout.PREFERRED_SIZE))
.addGap(27, 27, 27)
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jTName, javax.swing.GroupLayout.Alignment.TRAILING)
.addComponent(jTPrice)
.addComponent(jTStock)
.addComponent(jCType, 0, 168, Short.MAX_VALUE))
.addContainerGap())
.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
.addGroup(jPanel1Layout.createSequentialGroup()
.addGap(114, 114, 114)
.addComponent(jBInsert)
.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE))
);
jPanel1Layout.setVerticalGroupjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(jPanel1Layout.createSequentialGroup()
.addComponent(jLabel1)
.addGap(29, 29, 29)
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, 27,javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jTName, javax.swing.GroupLayout.PREFERRED_SIZE, 27,javax.swing.GroupLayout.PREFERRED_SIZE))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
.addComponent(jType, javax.swing.GroupLayout.PREFERRED_SIZE, 27,javax.swing.GroupLayout.PREFERRED_SIZE)
.addGroup(jPanel1Layout.createSequentialGroup()
.addGap(2, 2, 2)
.addComponent(jCType)))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 27,javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jTPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 27,javax.swing.GroupLayout.PREFERRED_SIZE))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jStock, javax.swing.GroupLayout.PREFERRED_SIZE, 27,javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jTStock, javax.swing.GroupLayout.PREFERRED_SIZE, 27,javax.swing.GroupLayout.PREFERRED_SIZE))
.addGap(30, 30, 30)
.addComponent(jBInsert)
.addGap(0,12,Short.MAX_VALUE))
);
javax.swing.GroupLayout layout = new
javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addContainerGap()
.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE)
.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE))
);
layout.setVerticalGroup( layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()addContainerGap()
.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE)
.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE))
);
pack();
setLocationRelativeTo(null);
}
// </editor-fold
private void jBInsertActionPerformed(java.awt.event.ActionEvent evt) {
int Price=0,Stock=0;
String isiName = jTName.getText();
String isiType = (String)jCType.getSelectedItem();
Price = (Integer)jTPrice.getValue();
Stock = (Integer)jTStock.getValue();
if (jTName.getText().equals("")){JOptionPane.showMessageDialog(null, "Name Harus Diisi!", "Peringatan",JOptionPane.WARNING_MESSAGE );
} else if (Price<1 || Price>200000)
{ JOptionPane.showMessageDialog(null, "Price Harus Diantara 1 - 200000!","Peringatan", JOptionPane.WARNING_MESSAGE );
} else if (Stock<1 || Stock>100)
{ JOptionPane.showMessageDialog(null, "Stock Harus Diantara 1 - 100!","Peringatan", JOptionPane.WARNING_MESSAGE );
} else {
try{

// Insert data dari database
String queryCode = "INSERT INTO product_detail"+"(Name, Type, Price, Stock) " +"VALUES ('"+isiName+"','"+isiType+"', '"+Price+"', '"+Stock+"')";
System.out.println(""+queryCode);
st.execute(queryCode);
JOptionPane.showMessageDialog(rootPane, "Sukses Menambah Data KeDatabase!");
Clean();
}catch (Exception e)
{ e.printStackTrace
();
System.out.println("Connection Error");
}
}
}
public static void main(String args[])
{ java.awt.EventQueue.invokeLater(new Runnable()
{
public void run() {
new InsertForm().setVisible(true);
}
});
}
public void Clean()
{ jTName.setText(""
);
jTPrice.setValue(0);
jTStock.setValue(0);
}
public class Connect {
private Connection con;
public Connect() {
try
{ Class.forName("com.mysql.cj.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product?zeroDateTimeBehavior=CONVERT_TO_NULL","Rio Ardiyani","admin");
st = con.createStatement();
} catch (Exception e)
{ e.printStackTrace();
System.out.println("Connection Error");
}
}
}

// Variables declaration - do not modify
private javax.swing.JButton jBInsert;
private javax.swing.JComboBox<String> jCType;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jName;
private javax.swing.JPanel jPanel1;
private javax.swing.JLabel jPrice;
private javax.swing.JLabel jStock;
private javax.swing.JTextField jTName;
private javax.swing.JSpinner jTPrice;
private javax.swing.JSpinner jTStock;
private javax.swing.JLabel jType;

// End of variables declaration
}

