package module;

import dao.JenisMemberDao;
import dao.MemberDao;

public class DaoModule {
    private final JenisMemberDao jenisMemberDao;
    private final MemberDao memberDao;

    public DaoModule() {
        this.jenisMemberDao = new JenisMemberDao();
        this.memberDao = new MemberDao();
    }

    public JenisMemberDao getJenisMemberDao() {
        return jenisMemberDao;
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }
}
