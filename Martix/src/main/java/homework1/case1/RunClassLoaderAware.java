package homework1.case1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunClassLoaderAware {
    public static void main(String[] args) {
        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("app-conf.xml");
        abstractApplicationContext.registerShutdownHook();
    }
}
