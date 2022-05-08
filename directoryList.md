|-- pom.xml                                                         // 项目依赖
|-- log                                                             // 日志输出目录
|-- src                                                             
|   |-- main
|   |   |-- java                                                    // 源码
|   |   |   |-- com
|   |   |       |-- pinxixi                                         // 包
|   |   |           |-- PinXiXiApplication.java                     // springboot启动类
|   |   |           |-- common                                      // 公共包
|   |   |           |   |-- Constants.java                          // 常量
|   |   |           |   |-- GoodsEnum.java                          // 商品枚举
|   |   |           |   |-- HttpStatus.java                         // http状态码常量
|   |   |           |   |-- HttpStatusEnum.java                     // http状态码枚举
|   |   |           |   |-- PageResult.java                         // 分页结果
|   |   |           |   |-- Result.java                             // 响应返回结果
|   |   |           |   |-- ServiceResultEnum.java                  // 响应结果枚举
|   |   |           |-- config                                      // 项目配置
|   |   |           |   |-- JWTConfig.java                          // JWT配置（token）
|   |   |           |   |-- PinXiXiException.java                   // 全局异常处理
|   |   |           |   |-- RedisConfig.java                        // Redis配置
|   |   |           |   |-- SwaggerConfig.java                      // swagger配置
|   |   |           |   |-- WebMvcConfig.java                       // 全局拦截配置
|   |   |           |   |-- annotation                              // 注解
|   |   |           |   |   |-- AdminUserArgument.java              // 管理员信息参数注解
|   |   |           |   |   |-- ClientUserArgument.java             // 客户信息参数注解
|   |   |           |   |-- handler                                 // 处理器
|   |   |           |   |   |-- AdminUserArgumentResolver.java      // 管理员注解处理器
|   |   |           |   |   |-- ClientUserArgumentResolver.java     // 客户注解处理器
|   |   |           |   |   |-- PinXiXiExceptionHandler.java        // 异常处理器
|   |   |           |   |-- interceptor                             // 拦截器
|   |   |           |       |-- TokenInterceptor.java               // token拦截器
|   |   |           |-- controller                                  // 请求控制层
|   |   |           |-- dao                                         // 数据访问对象
|   |   |           |-- entity                                      // 实体类
|   |   |           |-- service                                     // 业务处理层
|   |   |           |-- utils                                       // 工具类
|   |   |-- resources                                               // 资源
|   |       |-- application.yml                                     // 项目配置
|   |       |-- deploy.sh                                           // 部署脚本
|   |       |-- logback-spring.xml                                  // 日志配置
|   |       |-- pinxixi_mall_sql_prod.sql                           // 项目SQL
|   |       |-- mapper                                              // SQL映射
|   |-- test                                                        // 测试相关
|-- target                                                          // 编译目录
 
