package com.fc.msp.mspmail.shard;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateTableShardStrategy
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/25 3:09 下午
 * @Version 1.0
 */
// 按天切分的分表策略类
public class DateTableShardStrategy implements ITableShardStrategy {

    private static final String DATE_PATTERN = "yyyyMMdd";

    @Override
    public String tableShard(String tableName) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        return tableName + "_" + sdf.format(new Date());
    }

}
