### 模块分布

一共分为四个模块，分别为

monitor-common: 所有的公共方法、公共API、注解均需要放在该模块下。

monitor-entity: 数据库相关的实体类和mapper放在这里。

monitor-service: 业务处理逻辑在该模块中。

monitor-center: 对外展示和Controller层放在该模块中。

引用关系为：monitor-center->monitor-service->monitor-entity->monitor-common



### Monitor-center 内包详细说明

- com.qs.monitor.vo 包内是对外展示的模型对象。

- com.qs.monitor.interceptor 是所有的拦截器

- com.qs.monitor.config 是配置类

- com.qs.monitor.controller 是所有的控制类

- application.yml 是配置文件

- resources 目录下的static和template是放在静态文件的包

### 拦截器

​    添加拦截器需要在该包com.qs.monitor.interceptor 中添加，继承 HandlerInterceptor接口。

​    preHandle 处理servlet方法之前调用，只有返回true才会往后调用，false表示跳出请求，拦截掉当前请求。

​    postHandle   请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）

​    afterCompletion    在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）



-  RedisSessionInterceptor 是拦截判断Redis是是否存在Session信息。

-  ResultDataInterceptor 是拦截判断本次请求是否需要进行返回数据的封装。

-  AuthInterceptor 是进行判断本次请求，该用户是否有权限进行操作。

   

  拦截器的添加

  生成拦截器后，需要在com.qs.monitor.config.MyBaseMVCConfig 中添加

  ```java
  /**
   * 添加拦截器
   *
   * @param registry
   */
  @Override
  protected void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**");
      registry.addInterceptor(new ResultDataInterceptor()).addPathPatterns("/**");
  
      registry.addInterceptor(getSessionInterceptor()).addPathPatterns("/api/**").excludePathPatterns("/api" +
              "/user/login");
  
      super.addInterceptors(registry);
  }
  ```

   

拦截器执行的顺序按照添加的顺序，

- .addPathPatterns("/**")  表示需要拦截的路径

- excludePathPatterns("/api/user/login") 表示本次拦截需要排除的方法。

### ControllerAdvice 说明

本次添加了com.qs.monitor.config.ResponseResultHandler，该注解是对controller进行增强，本次是对返回的对象进行统一的封装处理。各Controller请求返回真实的对象，由该增强类将其包装到ResultData对象中，前端界面拿到的是ResultData对象，通过先判断该对象，获取本次请求是否异常。



### 剩余配置类说明

-  RedisConfig 是对Redis信息的配置，当前配置文件中使用了Redis集群，后期计划修改为单点的配置。

-  MyBatisConfig 是对MyBatis配置，主要是@MapperScan({"com.qs.monitor.mapper"}) 表示需要扫描的mapper

   

### 注解类说明

​    本次先定义了两个注解类，后期可以自己再扩展，放在common模块中

-  Authorization 添加到类和方法上，表示该Controller和方法需要进行权限校验。

-  ResponseResult 可以添加到类和方法上，表示需要对该请求结果进行封装。

   

### Controller类说明

​    先定义了几个基本的Controller。

-  HelloController 该类中添加ResponseResult 注解，对该注解进行演示说明。并且该类中添加了@RestController，表示该类下的所有请求都是REST，返回都是JSON数据。

-  HtmlController 该类就是普通的Controller，可以直接返回到界面中

-  LoginController 是测试RedisSession 登录。

-  MyBatisController 是对数据库进行CRUD

-  RedisController 是测试Redis数据存储和读取的Controller

   

### 系统后期优化添加

1.  尽快在entity包中需要添加mybatis generator，反向生成实体类和mapper
2.  添加log配置文件
3. 再详细测试验证RedisSession
4. 添加其他HandlerInterceptor
