package view.member;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import model.JenisMember;
import model.Member;

public class MemberFrame extends JFrame {
    private List<JenisMember> jenisMemberList;
    private List<Member> memberList;
    final JTextField textFieldNama;
    MemberTableModel tableModel;
    final JComboBox<String> comboJenis;
    final JButton buttonSimpan;
    final JButton buttonExportPdf;
    final JTable table;

    public MemberFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelInput = new JLabel("Nama : ");
        labelInput.setBounds(15, 40, 350, 10);

        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        JLabel labelJenis = new JLabel("Jenis Member: ");
        labelJenis.setBounds(15, 100, 350, 10);

        comboJenis = new JComboBox<>();
        comboJenis.setBounds(15, 120, 150, 30);

        buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 160, 100, 40);

        buttonExportPdf = new JButton("Export PDF");
        buttonExportPdf.setBounds(120, 160, 100, 40);

        table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 220, 350, 200);

        this.add(buttonSimpan);
        this.add(buttonExportPdf);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(labelJenis);
        this.add(comboJenis);
        this.add(scrollableTable);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public void populateTable(List<Member> memberList) {
        this.memberList = memberList;
        tableModel = new MemberTableModel(memberList);
        table.setModel(tableModel);
    }

    public void populateComboJenis(List<JenisMember> jenisMemberList) {
        this.jenisMemberList = jenisMemberList;
        comboJenis.removeAllItems();
        for (JenisMember jenisMember : jenisMemberList) {
            comboJenis.addItem(jenisMember.getNama());
        }
    }

    public String getNama() {
        return textFieldNama.getText();
    }

    public JenisMember getJenisMember() {
        return jenisMemberList.get(comboJenis.getSelectedIndex());
    }

    public void addMember(Member member) {
        tableModel.add(member);
        textFieldNama.setText("");
    }

    public void showAlert(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void addButtonSimpanActionListener(ActionListener actionListener) {
        buttonSimpan.addActionListener(actionListener);
    }

    public void addButtonExportPdfActionListener(ActionListener actionListener) {
        buttonExportPdf.addActionListener(actionListener);
    }

    public List<Member> getMemberList() {
        return memberList;
    }
}
