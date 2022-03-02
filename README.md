### 问题记录
#### 1. 集成swagger启动报错
报错信息：  
>Failed to start bean 'documentationPluginsBootstrapper'; nested exception is java.lang.NullPointerException

原因： 
>Springfox使用的路径匹配是基于AntPathMatcher的，而Spring Boot 2.6.X使用的是PathPatternMatcher。  

解决：  
application.yml
```
  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher
```

### 2. Interceptor里通过@Value读取不到application.yml的值

原因： 
>Interceptor默认没有被spring容器管理。

解决：
```
    @Bean
    public TokenInterceptor tokenInterceptor() {
        return new TokenInterceptor();
    }
```

### 3. 404异常拦截不到，NoHandlerFoundException不生效

y原因：
>exceptionHandler只接收一个参数....@@

解决：

```java
public Result exceptionHandler(NoHandlerFoundException e) {}
```

### 4. **Mappr could be null

