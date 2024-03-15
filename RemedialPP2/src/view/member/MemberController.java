package view.member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import model.JenisMember;
import model.Member;
import module.DaoModule;

public class MemberController {
    private final DaoModule daoModule;
    private final MemberFrame memberFrame;
    private final MemberPdfExport memberPdfExport;

    public MemberController(DaoModule daoModule) {
        this.daoModule = daoModule;
        this.memberFrame = new MemberFrame();
        this.memberPdfExport = new MemberPdfExport();

        this.memberFrame.addButtonSimpanActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpan();
            }
        });

        this.memberFrame.addButtonExportPdfActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportPdf();
            }
        });
    }

    public void showMemberFrame() {
        List<Member> memberList = daoModule.getMemberDao().findAll();
        memberFrame.populateTable(memberList);

        List<JenisMember> jenisMemberList = daoModule.getJenisMemberDao().findAll();
        memberFrame.populateComboJenis(jenisMemberList);

        memberFrame.setVisible(true);
    }

    public void simpan() {
        String nama = memberFrame.getNama();
        if (nama.isEmpty()) {
            memberFrame.showAlert("Nama tidak boleh kosong");
            return;
        }

        JenisMember jenisMember = memberFrame.getJenisMember();
        Member member = new Member();
        member.setId(UUID.randomUUID().toString());
        member.setNama(nama);
        member.setJenisMember(jenisMember);

        memberFrame.addMember(member);
        daoModule.getMemberDao().insert(member);
    }

    public void exportPdf() {
        try {
            memberPdfExport.export(memberFrame.getMemberList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
