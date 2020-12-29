package com.fc.msp.vo;

import org.apache.zookeeper.data.ACL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ACL
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/14 10:55 下午
 * @Version 1.0
 */
public class AclSetVO implements Serializable {
    private int version;
    private List<String> acls;

    /**
     * Gets the value of version. *
     *
     * @return the value of version
     */
    public int getVersion() {
        return version;
    }

    /**
     * Sets the version. *
     * <p>You can use getVersion() to get the value of version</p>
     * * @param version version
     */
    public void setVersion(int version) {
        this.version = version;
    }


    /**
     * Gets the value of acls. *
     *
     * @return the value of acls
     */
    public List<String> getAcls() {
        return acls;
    }

    /**
     * Sets the acls. *
     * <p>You can use getAcls() to get the value of acls</p>
     * * @param acls acls
     */
    public void setAcls(List<String> acls) {
        this.acls = acls;
    }

    public AclSetVO(int version, List<ACL> acls) {
        this.version = version;
        this.acls = init(acls);
    }
    List<String> init(List<ACL> acls){
        this.acls = new ArrayList<>();
        for(ACL acl: acls){
            this.acls.add(acl.getId().getScheme() + " " + acl.getId().getId() + " " + acl.getPerms());
        }
        return this.acls;
    }
    @Override
    public String toString() {
        return "AclSetVO{" +
                "version=" + version +
                ", acls=" + acls +
                '}';
    }
}
