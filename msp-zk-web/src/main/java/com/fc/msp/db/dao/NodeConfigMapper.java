package com.fc.msp.db.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fc.msp.db.dto.NodeConfig;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName NodeConfigMapper
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/20 10:40 下午
 * @Version 1.0
 */
@Mapper
@Component
public interface NodeConfigMapper extends BaseMapper<NodeConfig> {
    void insert(NodeConfig nodeConfig, String tableName);
    List<NodeConfig> selectByEnv(String env);
}
