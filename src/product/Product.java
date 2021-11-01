/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;
/**
 *
 * @author Rio Ardiyani
 */
public final class Product extends JFrame {
private Statement st;
    
// table
private JScrollPane scrollPane = new JScrollPane();
private JTable table = new JTable();
private DefaultTableModel dtm = new DefaultTableModel();

// label
private JLabel titleLabel = new JLabel("Product");

// connection
private Connect conn = new Connect();
private ResultSet rs = null;
private ResultSetMetaData rsm = null;

public Product() {
createForm();
this.add(titleLabel, BorderLayout.NORTH);
this.add(scrollPane, BorderLayout.CENTER);
titleLabel.setHorizontalAlignment(0);
scrollPane.setViewportView(table);
table.setModel(dtm);
refreshData();
this.setVisible(true);
}
public void refreshData() {
// lengkapi code disini
// Memberi nama pada setiap kolom tabel
dtm.addColumn("Product Name");
dtm.addColumn("Type Product");
dtm.addColumn("Price");
dtm.addColumn("Qty");
try{

// Mengambil data dari database
String queryCode = "SELECT * FROM product_detail";
rs=st.executeQuery(queryCode);

while (rs.next())
{ dtm.addRow(new
Object[]{
rs.getString("name"),
rs.getString("type"),
rs.getInt("price"),
rs.getInt("stock"),
});
}
}catch (Exception e)
{ e.printStackTrace();
System.out.println("Connection Error");
}
}
private void createForm()
{ this.setTitle("Product Form"); this.setSize(400,200);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setLocationRelativeTo(null);
}
public static void main(String[] args)
{ Product myWindow = new
Product();;
}
public class Connect
{ private Connection
con; public Connect() {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product?zeroDateTimeBehavior=CONVERT_TO_NULL","Rio Ardiyani","admin");
st = con.createStatement();
System.out.println("Connection Successful");
} catch (Exception e)
{ e.printStackTrace();
System.out.println("Connection Error");
}
}
public ResultSet executeQuery(String query) {
rs = null;
try {
rs = st.executeQuery(query);
} catch (SQLException e) {
    e.printStackTrace();
System.out.println("Connection Error");
}
return rs;
}
public void executeUpdate(String query) {
try {
    st.executeUpdate(query);
} catch (SQLException e) {
e.printStackTrace();
System.out.println("Connection Error");
}
}
}
}
