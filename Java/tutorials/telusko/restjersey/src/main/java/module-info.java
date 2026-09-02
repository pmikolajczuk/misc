module pl.mikolaj.restjersey.module {
    requires jakarta.ws.rs;

    requires org.glassfish.jersey.container.servlet;
    requires org.glassfish.jersey.inject.hk2;
    requires jakarta.xml.bind;
    requires java.sql;
    requires mysql.connector.j;

    exports pl.mikolaj.restjersey;
}