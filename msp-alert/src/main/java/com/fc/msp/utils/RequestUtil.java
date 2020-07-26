package com.fc.msp.utils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName RequestUtil
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/7/26 5:27 下午
 * @Version 1.0
 */
public class RequestUtil {
    // 二进制读取
    public static String readAsBytes(HttpServletRequest request)
    {

        int len = request.getContentLength();
        byte[] buffer = new byte[len];
        ServletInputStream in = null;

        try
        {
            in = request.getInputStream();
            in.read(buffer, 0, len);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != in)
            {
                try
                {
                    in.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return new String(buffer);
    }

}
