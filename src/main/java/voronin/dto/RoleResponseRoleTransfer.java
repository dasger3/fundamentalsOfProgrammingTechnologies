package voronin.dto;

import voronin.model.RoleUser;

public class RoleResponseRoleTransfer {

    public static RoleResponse to(RoleUser r) {
        return new RoleResponse(r.getIdRole(), r.getName(), r.getLevelAccess());
    }

    public static RoleUser from(RoleResponse pr) {
        RoleUser r = new RoleUser();
        r.setIdRole(pr.getId());
        r.setName(pr.getName());
        r.setLevelAccess(pr.getLevelAccess());
        return r;
    }
}
