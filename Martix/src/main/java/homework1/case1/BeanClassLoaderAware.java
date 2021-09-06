package homework1.case1;

public class BeanClassLoaderAware implements org.springframework.beans.factory.BeanClassLoaderAware {

    public BeanClassLoaderAware() {
        System.out.println("Bean Loader is use");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("parent class aloder"+classLoader.getParent());
    }
}

