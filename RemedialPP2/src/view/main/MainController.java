package view.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import module.DaoModule;
import view.jenismember.JenisMemberController;
import view.member.MemberController;

public class MainController {
    private final MainFrame mainFrame;
    private final MemberController memberController;
    private final JenisMemberController jenisMemberController;

    public MainController() {
        mainFrame = new MainFrame();
        DaoModule daoModule = new DaoModule();
        memberController = new MemberController(daoModule);
        jenisMemberController = new JenisMemberController(daoModule);

        mainFrame.addButtonJenisMemberActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showJenisMemberFrame();
            }
        });

        mainFrame.addButtonMemberActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMemberFrame();
            }
        });
    }

    public void showMainFrame() {
        mainFrame.setVisible(true);
    }

    public void showJenisMemberFrame() {
        jenisMemberController.showJenisMemberFrame();
    }

    public void showMemberFrame() {
        memberController.showMemberFrame();
    }

    void showMainFrame() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
