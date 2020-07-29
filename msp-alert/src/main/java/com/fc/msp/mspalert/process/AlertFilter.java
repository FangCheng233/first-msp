package com.fc.msp.mspalert.process;

import com.fc.msp.mspalert.entity.Alert;
import com.fc.msp.mspalert.entity.Alerts;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName AlertFilter
 * @Description 根据业务实际情况对告警信息进行部分屏蔽，临时上线或停机时手动关闭告警
 * @Author fangcheng
 * @Date 2020/7/29 9:00 上午
 * @Version 1.0
 */
@Component
public class AlertFilter {
    /**
     *
     * @Description 查询数据库配置信息，对部分告警信息进行过滤处理
     * @Author fangcheng
     * @param alert :
     * @return boolean
     * @throws
     * @Date 2020/7/29 10:33 上午
     */
    public boolean pushFilter(Alert alert){


        return false;
    }
}
