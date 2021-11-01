/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugas.tk4;

/**
 *
 * @author developer
 */
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProductFrame extends javax.swing.JFrame {

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
	private Vector<String> headerTable = new Vector<String>();
	private Vector<Vector<String>> dataTable = new Vector<Vector<String>>();

	public ProductFrame() {
            createForm();

            this.add(titleLabel, BorderLayout.NORTH);
            this.add(scrollPane, BorderLayout.CENTER);

            scrollPane.setViewportView(table);
            headerTable.add("ID");
            headerTable.add("Name");
            headerTable.add("Type");
            headerTable.add("Price");
            headerTable.add("Stock");
            dtm.addColumn(NORMAL, headerTable);
            
            dtm.addRow(dataTable);
            table.setModel(dtm);

            refreshData();

            this.setVisible(true);
	}
        
        public static void main(String args[]) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ProductFrame().setVisible(true);
                }
            });
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
