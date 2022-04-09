## 开发
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


<br/>

## 部署
>使用Jenkins实现自动化部署。
### 1. 服务器配置
+ 安装jdk
+ 安装MySQL
+ 安装Redis
+ 安装maven（修改maven镜像为阿里云）

### 2. Jenkins配置
+ 2.1 安装Jenkins
+ 2.2 下载安装插件(Manage Plugins)
  - Git
  - Publish Over SSH
+ 2.3 添加maven配置(Global Tool Configuration)
+ 2.4 设置maven环境变量(Configure System -> Global properties)
+ 2.5 配置SSH连接服务器(Configure System -> Publish Over SSH)
  - Passphrase：服务器密码
  - SSH Server
    * name：服务器名称（自定义）
    * Hostname：服务器IP
    * Username：用户名（一般是root）
    * Remote Directory：/

  <br/>

  >配置完成后点击Test configuration测试是否连接成功。

+ 2.6 新建任务
  * 配置项目源码地址
  * 配置构建命令
  ```bash
    # Build -> Execute shell
    mvn clean package -Dmaven.test.skip=true
  ```
  * 添加构建步骤（Add build step）
    >将打包好的jar包传到服务器项目目录。(如果Jenkins运行在服务器上，直接通过命令拷贝过去就行，不需要通过SSH)
    + 选择Send build artifacts over SSH
      - SSH Server：选择前面设置的服务器名称
      - Source files
      >源文件路径是相对Jenkins的工作空间（workspace）下的项目目录。
      ```bash
      target/*.jar
      ```
      - Remove prefix
      >删除Source files的jar包路径前缀，不在服务器上创建这个路径，只保存jar。
      ```bash
      target
      ```
      - Remote directory
      >Jenkins打包后将jar包上传到服务器的该路径下。
      ```bash
      # 本次项目路径为/www/wwwroot/pinxixi_server，
      /www/wwwroot/pinxixi_server/build
      ```
      - Exec command
      >在项目服务器上执行的脚本。（先将执行脚本上传到服务器）
      ```bash
      cd /www/wwwroot/pinxixi_server && ./deploy.sh
      ```
+ 2.7 构建任务
  - Build Now