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

2. 