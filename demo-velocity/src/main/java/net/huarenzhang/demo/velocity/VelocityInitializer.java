package net.huarenzhang.demo.velocity;

import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.velocity.app.Velocity;

/**
 * Init Velocity
 * 
 * @author zhanghuaren
 * @version Jun 25, 2015
 */
public class VelocityInitializer {

    private static final AtomicBoolean INIT_SUCCEDD = new AtomicBoolean(false);

    private static final boolean initVelocity() {
        /* Configure the engine - as an example, we are using NullLogChute as the logger - see logging examples */
        Velocity.setProperty(Velocity.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.NullLogChute");
        /* Initialize Velocity */
        Velocity.init();
        return true;
    }

    public static void init() {
        INIT_SUCCEDD.compareAndSet(false, initVelocity());
    }
}
