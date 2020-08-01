package com.fc.msp.mspalert.mapper;

import com.fc.msp.mspalert.entity.AlertInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AlertInfoMapper {

    int insert(AlertInfo alertInfo);
}
