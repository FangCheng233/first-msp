package com.fc.msp.db.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fc.msp.db.dto.NodeStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @ClassName NodeStatusMapper
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/20 10:40 下午
 * @Version 1.0
 */
@Mapper
@Component
public interface NodeStatusMapper extends BaseMapper<NodeStatus> {
    @Select("select * from user where name = ?")
    void insert(NodeStatus nodeStatus, String tableName);
    void selectByIp(String tableName,String nodeIp);
}
