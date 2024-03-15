package view.jenismember;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import model.JenisMember;

public class JenisMemberFrame extends JFrame {
    private List<JenisMember> jenisMemberList;
    private final JTextField textFieldNama;
    private JenisMemberTableModel tableModel;
    private final JTable table;
    private final JButton buttonSimpan;

    public JenisMemberFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelInput = new JLabel("Nama : ");
        labelInput.setBounds(15, 40, 350, 10);

        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 100, 100, 40);

        table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 150, 350, 200);

        this.add(buttonSimpan);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(scrollableTable);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public String getNama() {
        return textFieldNama.getText();
    }

    public void addJenisMember(JenisMember jenisMember) {
        tableModel.add(jenisMember);
        textFieldNama.setText("");
    }

    public void addButtonSimpanActionListener(ActionListener actionListener) {
        buttonSimpan.addActionListener(actionListener);
    }

    public void populateTable(List<JenisMember> jenisMemberList) {
        this.jenisMemberList = jenisMemberList;
        tableModel = new JenisMemberTableModel(jenisMemberList);
        table.setModel(tableModel);
    }
}
