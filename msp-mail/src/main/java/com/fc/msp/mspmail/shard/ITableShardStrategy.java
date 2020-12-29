package com.fc.msp.mspmail.shard;

// 分表的策略类
public interface ITableShardStrategy {
    /**
     * 分表实现接口
     * @Description
     * @Author fangcheng
     * @param tableName :
     * @return
     * @throws
     * @Date 2020/10/21 3:58 下午
     */
    String tableShard(String tableName);

}
