package com.fc.msp.vo;

import org.apache.zookeeper.data.Stat;

/**
 * @ClassName StatValueVO
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/15 12:07 上午
 * @Version 1.0
 */
public class StatValueVO {
    private byte[] value;
    private Stat stat;

    public StatValueVO(byte[] value, Stat stat) {
        this.value = value;
        this.stat = stat;
    }

    /**
     * Gets the value of value. *
     *
     * @return the value of value
     */
    public byte[] getValue() {
        return value == null?"".getBytes():value;
    }

    /**
     * Sets the value. *
     * <p>You can use getValue() to get the value of value</p>
     * * @param value value
     */
    public void setValue(byte[] value) {
        this.value = value;
    }

    /**
     * Gets the value of stat. *
     *
     * @return the value of stat
     */
    public Stat getStat() {
        return stat;
    }

    /**
     * Sets the stat. *
     * <p>You can use getStat() to get the value of stat</p>
     * * @param stat stat
     */
    public void setStat(Stat stat) {
        this.stat = stat;
    }
}
