package view.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private final JButton buttonJenisMember;
    private final JButton buttonMember;

    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        this.setLayout(new FlowLayout());

        this.buttonJenisMember = new JButton("Jenis Member");
        this.buttonMember = new JButton("Member");

        this.add(buttonJenisMember);
        this.add(buttonMember);
    }

    public JButton getButtonJenisMember() {
        return buttonJenisMember;
    }

    public JButton getButtonMember() {
        return buttonMember;
    }

    public void addButtonJenisMemberActionListener(ActionListener actionListener) {
        buttonJenisMember.addActionListener(actionListener);
    }

    public void addButtonMemberActionListener(ActionListener actionListener) {
        buttonMember.addActionListener(actionListener);
    }
}
