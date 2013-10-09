Spring and JSF
==============

There are several ways to connect Spring DI with JSF views. In this
example we use Spring's SpringBeanFacesELResolver in
WEB-INF/faces-config.xml so that we can use JSF EL expressions to
look up Spring Beans defined in WEB-INF/applicationContext.xml.

Builds with Eclipse (due to imbedded Spring Jars) and with Maven.

To run it just to "maven package" and drop into an EE6+ container
such as JBoss WildFly (nee JBoss AS).

Credit: some of the configuation information was taken from
http://www.mkyong.com/jsf2/.
