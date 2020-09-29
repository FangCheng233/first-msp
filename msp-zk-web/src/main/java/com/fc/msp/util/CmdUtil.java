package com.fc.msp.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName CmdUtil
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/20 4:46 下午
 * @Version 1.0
 */
@Slf4j
public enum CmdUtil {
    /**
     * @Description
     */
    INSTANCE;

    public String executeCmd(String cmd, String zkServer, String zkPort) throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            Socket s = new Socket(zkServer, Integer.parseInt(zkPort));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out.println(cmd);
            String line = reader.readLine();
            sb = new StringBuilder();
            while (line != null) {
                sb.append(line);
                sb.append("<br/>");
                line = reader.readLine();
            }
        }catch (Exception e){
            log.warn("");
        }
        return sb.toString();
    }
    public String executeCmd2(String cmd,String rep, String url) {
        StringBuilder sb = new StringBuilder();
        String[] ZKServer = url.split(":");
        Socket sock = null;
        OutputStream outstream = null;
        BufferedReader reader = null;
        try {
            sock = new Socket(ZKServer[0], Integer.parseInt(ZKServer[1]));
            outstream = sock.getOutputStream();
            // 通过Zookeeper的四字命令获取服务器的状态
            outstream.write(cmd.getBytes());
            outstream.flush();
            sock.shutdownOutput();

            reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.indexOf(rep) != -1) {
                    return line.replaceAll(rep, "").trim();
                }
            }
        }catch (IOException e){
            log.warn("连接异常{}",e.getMessage());
        }finally {
            try {
                if(reader!= null){
                    reader.close();
                }
                if(outstream!= null){
                    outstream.close();
                }
                if(sock!= null){
                    sock.close();
                }
            }catch (IOException e){
                log.warn("连接关闭");
            }
        }
        return sb.toString();
    }
}
