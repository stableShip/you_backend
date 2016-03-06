package com.easygame.sdk.repository.model.po;

public class RolePermission {
    private Integer roleId;

    private Integer permissionId;

    private Byte permissionLevel;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Byte getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(Byte permissionLevel) {
        this.permissionLevel = permissionLevel;
    }
}