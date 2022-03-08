package com.pinxixi.utils;

import com.pinxixi.common.ServiceResultEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class PinXiXiUtils {

    public static Integer port;

    @Value("${server.port}")
    private void setPort(int port){
        PinXiXiUtils.port = port;
    };

    /**
     * 获取当前IP+端口
     * @return
     */
    public static String getHostPort() {
        InetAddress localHost = null;
        try {
            localHost = Inet4Address.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        PinXiXiUtils pinXiXiUtils = new PinXiXiUtils();
        return "http://" + localHost.getHostAddress() + ":" + port;
    }

    /**
     * 根据sql结果返回默认成功/失败信息
     * @param rows
     * @return
     */
    public static String genSqlResultByRows(Integer rows) {
        return rows > 0 ? ServiceResultEnum.SUCCESS.getResult() : null;
    }

}
