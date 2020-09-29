package com.fc.msp.mspalert.mapper;

import com.fc.msp.mspalert.entity.AlertInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AlertInfoMapper {
    @Insert("insert into")
    int insert(AlertInfo alertInfo);
}
