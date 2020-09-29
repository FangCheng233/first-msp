package com.fc.msp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.net.Socket;

@SpringBootTest
class MspZkWebApplicationTests {

	@Test
	void contextLoads() {

	}

	public static void main(String[] args) {
				String host = "192.168.1.103";
				int port = 32181;
				String cmd = "stat";
				Socket sock = null;
				BufferedReader reader = null;
				try {
					sock = new Socket(host, port);
					OutputStream outstream = sock.getOutputStream();
					// 通过Zookeeper的四字命令获取服务器的状态
					outstream.write(cmd.getBytes());
					outstream.flush();
					sock.shutdownOutput();

					reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
					String line;
					while ((line = reader.readLine()) != null) {
						if (line.indexOf("Mode: ") != -1) {
							System.out.println(line.replaceAll("Mode: ", "").trim());
						}
					}
				}catch (IOException e){
					System.out.println(e.getMessage());
				}finally {
					try {
						sock.close();
						if (reader != null) {
							reader.close();
						}
					}catch (IOException e){

					}

				}
			}

}
