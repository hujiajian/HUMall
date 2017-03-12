package cn.hucode.codegen;

import cn.org.rapid_framework.generator.GeneratorConstants;
import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;
import cn.org.rapid_framework.generator.provider.db.DataSourceProvider;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * @author jiajian
 * @date 2016/10/29
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        GeneratorFacade g = new GeneratorFacade();

        g.getGenerator().setTemplateRootDir("code-gen/src/main/resources/template");

        DataSource dataSource = new RapidDataSource(GeneratorProperties.getRequiredProperty(GeneratorConstants.JDBC_URL),
                GeneratorProperties.getRequiredProperty(GeneratorConstants.JDBC_USERNAME),
                GeneratorProperties.getProperty(GeneratorConstants.JDBC_PASSWORD),
                GeneratorProperties.getRequiredProperty(GeneratorConstants.JDBC_DRIVER));

        DataSourceProvider.setDataSource(dataSource);

        g.generateByTable("account");
    }

    public static class RapidDataSource implements DataSource {

        private String url;
        private String username;
        private String password;
        private String driverClass;

        public RapidDataSource(String url, String username, String password, String driverClass) {
            this.url = url;
            this.username = username;
            this.password = password;
            this.driverClass = driverClass;
        }


        public PrintWriter getLogWriter() throws SQLException {
            return null;
        }

        public void setLogWriter(PrintWriter out) throws SQLException {

        }

        public void setLoginTimeout(int seconds) throws SQLException {

        }

        public int getLoginTimeout() throws SQLException {
            return 0;
        }

        public Logger getParentLogger() throws SQLFeatureNotSupportedException {
            return null;
        }

        public Connection getConnection() throws SQLException {
            java.util.Properties props = new java.util.Properties();
            props.setProperty("user", username);
            props.setProperty("password", password);
            props.setProperty("remarks", "true"); //设置可以获取remarks信息
            props.setProperty("useInformationSchema", "true");//设置可以获取tables remarks信息
            return DriverManager.getConnection(url, props);
        }

        public Connection getConnection(String username, String password) throws SQLException {
            java.util.Properties props = new java.util.Properties();
            props.setProperty("user", username);
            props.setProperty("password", password);
            props.setProperty("remarks", "true"); //设置可以获取remarks信息
            props.setProperty("useInformationSchema", "true");//设置可以获取tables remarks信息
            return DriverManager.getConnection(url, props);
        }

        public <T> T unwrap(Class<T> iface) throws SQLException {
            return null;
        }

        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            return false;
        }
    }
}
