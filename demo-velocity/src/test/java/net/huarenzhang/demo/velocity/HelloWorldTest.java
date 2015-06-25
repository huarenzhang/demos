package net.huarenzhang.demo.velocity;

import net.huarenzhang.demo.velocity.helloworld.SeparateInstanceExample;
import net.huarenzhang.demo.velocity.helloworld.SingletonPatternExample;

import org.junit.Assert;
import org.junit.Test;

public class HelloWorldTest {
    @Test
    public void test() {
        Assert.assertNotNull(SeparateInstanceExample.hello());
        Assert.assertNotNull(SingletonPatternExample.hello());
    }
}
