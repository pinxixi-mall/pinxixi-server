package com.pinxixi.config;

import com.pinxixi.common.Constants;
import com.pinxixi.config.handler.AdminUserArgumentResolver;
import com.pinxixi.config.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * mvc配置
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private AdminUserArgumentResolver adminUserArgumentResolver;

    @Bean
    public TokenInterceptor tokenInterceptor() {
        return new TokenInterceptor();
    }

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(JWTConfig.excludePaths);
    }

    /**
     * 参数拦截处理
     * @param resolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        //管理员信息注解
        resolvers.add(adminUserArgumentResolver);
    }

    /**
     * 资源路径映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //swagger接口文档路径
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
        //上传文件路径
        String path = System.getProperty("user.dir") + "/src/main/resources/" + Constants.UPLOAD_DIR + "/";
        registry.addResourceHandler("/upload/**")
                //class路径，需重启服务才能访问
                //.addResourceLocations("classpath:/" + Constants.UPLOAD_DIR + "/")
                //项目路径
                .addResourceLocations("file:" + path);
    }

}
