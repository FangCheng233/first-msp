package com.fc.msp.mspalert.mapper;

import com.fc.msp.datasource.DataSource;
import com.fc.msp.datasource.DataSourceConfig;
import com.fc.msp.mspalert.entity.AlertMsgInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
@DataSource(DataSourceConfig.SLAVE_DATASOURCE)
public interface AlertMsgInfoMapper {
    int insert(AlertMsgInfo alertMsgInfo);
}
