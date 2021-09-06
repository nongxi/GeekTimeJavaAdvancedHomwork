package homework1.case1;

import java.time.LocalDate;

public class Date implements  org.springframework.beans.factory.BeanClassLoaderAware{


    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        LocalDate date= LocalDate.now();

        System.out.println("now the date is :"+date);
    }
}
