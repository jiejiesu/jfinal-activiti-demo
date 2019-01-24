package com.fuge.jfinal.demo.activiti;

import com.fuge.jfinal.demo.activiti.controller.HelloController;
import com.fuge.jfinal.demo.activiti.controller.IndexController;
import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

/**
 * TODO.
 * <p>
 * User: sujie
 * Date: 2019/1/3
 * Time: 2:50 PM
 */
public class AppConfig extends JFinalConfig
{
    @Override
    public void configConstant(Constants constants)
    {
        loadPropertyFile("conf/demo.properties");
        PropKit.use("conf/demo.properties");
        constants.setDevMode(PropKit.getBoolean("devMode", true));
        constants.setViewType(ViewType.JFINAL_TEMPLATE);

        constants.setBaseUploadPath(System.getProperty("user.dir") + getProperty("upload.path"));

    }

    @Override
    public void configRoute(Routes routes)
    {
        routes.add("/", IndexController.class, "/index");
        routes.add("/hello", HelloController.class, "/hello");
    }

    @Override
    public void configEngine(Engine engine)
    {

    }

    @Override
    public void configPlugin(Plugins plugins)
    {
        DruidPlugin druidPlugin = new DruidPlugin(getProperty("db.default.url"),
                getProperty("db.default.user"),
                getProperty("db.default.password"),
                getProperty("db.default.driver"));

        druidPlugin.setInitialSize(getPropertyToInt("db.default.poolInitialSize"));
        druidPlugin.setMaxPoolPreparedStatementPerConnectionSize(getPropertyToInt("db.default.poolMaxSize"));
        druidPlugin.setTimeBetweenConnectErrorMillis(getPropertyToInt("db.default.connectionTimeoutMillis"));
        plugins.add(druidPlugin);
//        DbKit.addConfig(new Config(DbKit.MAIN_CONFIG_NAME, druidPlugin.getDataSource()));

        // 配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
        arp.setDialect(new MysqlDialect());
        plugins.add(arp);

        //配置Activiti插件
        ActivitiPlugin ap = new ActivitiPlugin();
        plugins.add(ap);

        //        _MappingKit.mapping(arp);//注册所有model-bean
    }

    @Override
    public void configInterceptor(Interceptors interceptors)
    {

    }

    @Override
    public void configHandler(Handlers handlers)
    {
    }

    public static void main(String[] args)
    {
        UndertowServer.start(AppConfig.class, 8090, true);
        //        JFinal.start("src/main/webapp", 8090, "/");
    }
}
