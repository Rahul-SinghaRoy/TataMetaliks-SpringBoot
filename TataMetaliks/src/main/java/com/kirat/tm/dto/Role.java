package com.kirat.tm.dto;

public class Role {
	private String rolename;

    private String roleid;

    private String typeid;

    private String createdate;

    private String groupid;

    private String updatedate;

    public String getRolename ()
    {
        return rolename;
    }

    public void setRolename (String rolename)
    {
        this.rolename = rolename;
    }

    public String getRoleid ()
    {
        return roleid;
    }

    public void setRoleid (String roleid)
    {
        this.roleid = roleid;
    }

    public String getTypeid ()
    {
        return typeid;
    }

    public void setTypeid (String typeid)
    {
        this.typeid = typeid;
    }

    public String getCreatedate ()
    {
        return createdate;
    }

    public void setCreatedate (String createdate)
    {
        this.createdate = createdate;
    }

    public String getGroupid ()
    {
        return groupid;
    }

    public void setGroupid (String groupid)
    {
        this.groupid = groupid;
    }

    public String getUpdatedate ()
    {
        return updatedate;
    }

    public void setUpdatedate (String updatedate)
    {
        this.updatedate = updatedate;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [rolename = "+rolename+", roleid = "+roleid+", typeid = "+typeid+", createdate = "+createdate+", groupid = "+groupid+", updatedate = "+updatedate+"]";
    }
}
