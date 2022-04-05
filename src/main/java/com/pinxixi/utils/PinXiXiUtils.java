package com.pinxixi.utils;

import com.pinxixi.common.ServiceResultEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Component
public class PinXiXiUtils {

    public static Integer port;

    @Value("${server.port}")
    private void setPort(int port){
        PinXiXiUtils.port = port;
    };

    /**
     * 本地IP+端口
     * @return
     */
    public static String getHostPort() {
        InetAddress localHost = null;
        try {
            localHost = Inet4Address.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "http://" + localHost.getHostAddress() + ":" + port;
    }

    /**
     * 项目IP+端口
     * @return
     */
    public static String getServerAddress(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String serverIp = request.getServerName();
        int serverPort = request.getServerPort();
        return "http://" + serverIp + ":" + serverPort;
    }

    /**
     * 根据sql结果返回默认成功/失败信息
     * @param rows
     * @return
     */
    public static String genSqlResultByRows(Integer rows) {
        return rows > 0 ? ServiceResultEnum.SUCCESS.getResult() : null;
    }

    /**
     * 复制List到目标List
     * @param sources List源
     * @param clazz 目标实体
     * @param <T>
     * @return
     */
    public static <T> List<T> copyList(List sources, Class<T> clazz) {
        List<T> targetList = new ArrayList<>();
        for (Object source : sources) {
            try {
                T target = clazz.getDeclaredConstructor().newInstance();
                BeanUtils.copyProperties(source, target);
                targetList.add(target);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return targetList;
    }

}
