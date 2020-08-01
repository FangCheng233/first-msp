package com.fc.msp.mspalert.mapper;

import com.fc.msp.mspalert.entity.AlertMsgInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AlertMsgInfoMapper {
    int insert(AlertMsgInfo alertMsgInfo);
}
