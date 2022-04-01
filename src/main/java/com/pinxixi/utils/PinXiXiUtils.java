package com.pinxixi.utils;

import com.pinxixi.common.ServiceResultEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

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
