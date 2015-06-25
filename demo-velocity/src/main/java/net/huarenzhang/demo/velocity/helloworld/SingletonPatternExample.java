package net.huarenzhang.demo.velocity.helloworld;

import java.io.StringWriter;

import net.huarenzhang.demo.velocity.Globals;

import org.apache.logging.log4j.LogManager;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

/**
 * This is the legacy pattern, where there is only one instance of the Velocity
 * engine in the JVM (or web application, depending) that is shared by all. This
 * is very convenient as it allows localized configuration and sharing of
 * resources. For example, this is a very appropriate model for use in a Servlet
 * 2.2+ compliant web application as each web application can have its own
 * instance of Velocity, allowing that web application's servlet to share
 * resources like templates, a logger, etc.
 * 
 * @author zhanghuaren
 * @version Jun 25, 2015
 * @see {@code http://velocity.apache.org/engine/devel/developer-guide.html#Introduction}
 */
public class SingletonPatternExample {

    static {
        try {
            /* Configure the engine - as an example, we are using NullLogChute as the logger - see logging examples */
            Velocity.setProperty(Velocity.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.NullLogChute");
            /* Initialize Velocity */
            Velocity.init();
        } catch (Exception e) {
            LogManager.getLogger(SingletonPatternExample.class).error("Init velocity error!", e);
        }
    }

    public static String hello() {

        /* Create a Context object */
        VelocityContext context = new VelocityContext();
        /* Add data objects to the Context*/
        context.put("name", "huarenzhang");
        context.put("site", "http://www.cnblogs.com/hrzhang09/");

        /* Choose a template */
        Template t = Velocity.getTemplate(Globals.VIEW_BASE_PATH + "helloworld/foo.vm");
        /* 'Merge' the template and data to produce the ouput. */
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        return writer.toString();
    }

}
