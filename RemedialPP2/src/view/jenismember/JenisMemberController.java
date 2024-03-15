package view.jenismember;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.UUID;
import module.DaoModule;
import model.JenisMember;

public class JenisMemberController {
    private final DaoModule daoModule;
    private final JenisMemberFrame jenisMemberFrame;

    public JenisMemberController(DaoModule daoModule) {
        this.daoModule = daoModule;
        this.jenisMemberFrame = new JenisMemberFrame();
        jenisMemberFrame.addButtonSimpanActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpan();
            }
        });
    }

    public void showJenisMemberFrame() {
        List<JenisMember> jenisMemberList = daoModule.getJenisMemberDao().findAll();
        jenisMemberFrame.populateTable(jenisMemberList);
        jenisMemberFrame.setVisible(true);
    }

    public void simpan() {
        String nama = this.jenisMemberFrame.getNama();
        JenisMember jenisMember = new JenisMember();
        jenisMember.setId(UUID.randomUUID().toString());
        jenisMember.setNama(nama);
        this.jenisMemberFrame.addJenisMember(jenisMember);
        daoModule.getJenisMemberDao().insert(jenisMember);
    }
}
