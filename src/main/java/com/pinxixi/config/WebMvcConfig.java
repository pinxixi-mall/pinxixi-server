package com.pinxixi.config;

import com.pinxixi.common.Constants;
import com.pinxixi.config.handler.AdminUserArgumentResolver;
import com.pinxixi.config.handler.ClientUserArgumentResolver;
import com.pinxixi.config.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    private ClientUserArgumentResolver clientUserArgumentResolver;

    @Value("${spring.profiles.active}")
    private String env;

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
        //管理员参数注解
        resolvers.add(adminUserArgumentResolver);
        //客户参数注解
        resolvers.add(clientUserArgumentResolver);
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
        String path = env.equals("dev") ? "classpath:/" + Constants.UPLOAD_DIR : "file:./" + Constants.UPLOAD_DIR;
         registry.addResourceHandler("/upload/**").addResourceLocations(path);

    }

}
