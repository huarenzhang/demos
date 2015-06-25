package net.huarenzhang.demo.velocity.helloworld;

import java.io.StringWriter;

import net.huarenzhang.demo.velocity.Globals;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

/**
 * The separate instance allows you to create, configure and use as many
 * instances of Velocity as you wish in the same JVM (or web application.) This
 * is useful when you wish to support separate configurations, such as template
 * directories, loggers, etc in the same application.
 * 
 * @author zhanghuaren
 * @version Jun 25, 2015
 * @see {@code http://velocity.apache.org/engine/devel/developer-guide.html#Introduction}
 */
public class SeparateInstanceExample {

    public static String hello() {

        /* Create a new instance of the engine */
        VelocityEngine ve = new VelocityEngine();
        /* Configure the engine - as an example, we are using NullLogChute as the logger - see logging examples */
        ve.setProperty(Velocity.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.NullLogChute");
        /* Initialize the engine */
        ve.init();

        /* Create a Context object */
        VelocityContext context = new VelocityContext();
        /* Add data objects to the Context*/
        context.put("name", "huarenzhang");
        context.put("site", "http://www.cnblogs.com/hrzhang09/");

        /* Choose a template */
        Template t = ve.getTemplate(Globals.VIEW_BASE_PATH + "helloworld/foo.vm");
        /* 'Merge' the template and data to produce the ouput. */
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        return writer.toString();

    }


}
