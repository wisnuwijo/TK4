import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public final class ProductFrame extends JFrame {

	// table
	private JScrollPane scrollPane = new JScrollPane();
	private JTable table = new JTable();
	private DefaultTableModel dtm = new DefaultTableModel();

	// label
	private JLabel titleLabel = new JLabel("Product");

	// connection
//	private Connect conn = new Connect();
//	private ResultSet rs = null;
//	private ResultSetMetaData rsm = null;
	private Vector<String> headerTable = new Vector<String>();
	private Vector<Vector<String>> dataTable = new Vector<Vector<String>>();

	public ProductFrame() {
		createForm();

		this.add(titleLabel, BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);

		scrollPane.setViewportView(table);
		table.setModel(dtm);

		refreshData();

		this.setVisible(true);
	}

	public void refreshData() {
		// lengkapi code disini

	}

	private void createForm() {
		this.setTitle("Product Form");
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
}
