package com.shaojie.jfinaldemo.config;

import com.jfinal.config.*;
import com.jfinal.json.MixedJsonFactory;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.shaojie.jfinaldemo.controller.HelloController;

/**
 * @author： ShaoJie
 * @data： 2020年03月05日 12:28
 * @Description： Jfinal 配置
 */
public class JfinalConfig extends JFinalConfig {

    /**
     * 注意：用于启动的 main 方法可以在任意 java 类中创建，在此仅为方便演示
     *      才将 main 方法放在了 DemoConfig 中
     *
     *      开发项目时，建议新建一个 App.java 或者 Start.java 这样的专用
     *      启动入口类放置用于启动的 main 方法
     */
    /**
     * 配置常量
     */
    @Override
    public void configConstant(Constants constants) {
        // 配置开发模式，true 值为开发模式
        constants.setDevMode(true);

        // 配置上传下载的 baseDownlodePath
        // 最终下载文件为：src/resources/uplode/file.zip
        // renderFile("file.zip");
        // 最终下载文件为：src/resources/uplode/abc/def/file.zip
        // renderFile("abc/deb/file.zip");
        constants.setBaseDownloadPath("src/resources/uplode");

        // 配置依赖注入 开启改依赖注入    使用 @Inject 注解可以向 Controller 以及 Interceptor 中注入依赖对象
        // 例如： @Inject
        //       AccountService service;    // 此处会注入依赖对象
        constants.setInjectDependency(true);

        // 配置 aop 代理使用 cglib，否则将使用 jfinal 默认的动态编译代理方案
//        constants.setToCglibProxyFactory();

        // 配置依赖注入时，是否对被注入类的超类进行注入
        constants.setInjectSuperClass(false);

        // 配置为 slf4j 日志系统，否则默认将使用 log4j
        // 还可以通过 constants.setLogFactory(...) 配置为自行扩展的日志系统实现类
        constants.setToSlf4jLogFactory();

        // 设置 Json 转换工厂实现类，更多说明见第 12 章
        constants.setJsonFactory(new MixedJsonFactory());

        // 配置视图类型，默认使用 jfinal enjoy 模板引擎
        constants.setViewType(ViewType.JFINAL_TEMPLATE);

        // 配置基础下载路径，默认为 webapp 下的 download
//        constants.setBaseDownloadPath();

        // 配置基础上传路径，默认为 webapp 下的 upload
//        constants.setBaseUploadPath();

        // 配置 404、500 页面
        constants.setError404View("/common/404.html");
        constants.setError500View("/common/500.html");

        // 配置 encoding，默认为 UTF8
        constants.setEncoding("UTF8");

        // 配置 json 转换 Date 类型时使用的 data parttern
        constants.setJsonDatePattern("yyyy-MM-dd HH:mm:ss");

        // 配置是否拒绝访问 JSP，是指直接访问 .jsp 文件，与 renderJsp(xxx.jsp) 无关
        constants.setDenyAccessJsp(true);

        // 配置上传文件最大数据量，默认 10M
//        constants.setMaxPostSize(10 * 1024 * 1024);

        // 配置验证码缓存 cache，配置成集中共享缓存可以支持分布式与集群
//        constants.setCaptchaCache(...);

        // 配置 urlPara 参数分隔字符，默认为 "-"
//        constants.setUrlParaSeparator("-");


    }

    /**
     * 配置路由
     */
    @Override
    public void configRoute(Routes routes) {
        /*
         * 这里配置的是访问路由是 /say 约定访问的是 HelloController 中的 index（）方法
         * 那如果我们想访问在 HelloController 中的其他方法 直接在后面追加该方法名称 作为 restful 的请求
         * 例如:
         *<p>
         *  public void hello() {
         *   renderText("say Hello JFinal World.");
         *  }
         *</p>
         * 那当前的访问路径应该是 /say/hello 其余方法接口也是如此
         *
         * 第一个参数 controllerKey 是指访问某个 Controller 所需要的一个字符串，该字符串
         *          唯一对应一个 Controller，controllerKey仅能定位到Controller。
         * 第二个参数 controllerClass 是该 controllerKey 所对应到的 Controller 。
         * 第三个参数 viewPath是指该Controller返回的视图的相对路径(该参数具体细节将在Controller相关章节中给出)。
         *          当viewPath未指定时默认值为controllerKey。
         */
        routes.add("/say", HelloController.class);

        // 如果要将控制器超类中的 public 方法映射为 action 配置成 true，一般不用配置
//        routes.setMappingSuperClass(false);

        // 配置 baseViewPath，可以让 render(...) 参数省去 baseViewPath 这部分前缀
//        routes.setBaseViewPath("/view");

        // 配置作用于该 Routes 对象内配置的所有 Controller 的拦截器
//        routes.addInterceptor(new FrontInterceptor());
    }

    @Override
    public void configEngine(Engine engine) {

    }

    /**
     * 配置处理器
     */
    @Override
    public void configPlugin(Plugins plugins) {

    }

    /**
     * 配置全局拦截器
     */
    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    /**
     * 配置插件
     */
    @Override
    public void configHandler(Handlers handlers) {

    }
}
