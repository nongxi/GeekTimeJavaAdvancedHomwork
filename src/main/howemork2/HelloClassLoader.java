import java.io.File;
import java.util.Base64;

public class HelloClassLoader extends ClassLoader{
    public static void main(String[] args) {
        try{
            new HelloClassLoader().findClass("HelloHomework").newInstance();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }catch(InstantiationException e){
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException{
        String helloBase64="yv66vgAAADQAHAoABgAOCQAPABAIABEKABIAEwcAFAcAFQEABjxpbml0PgEAAygpVgEABENvZGUB" +
                "AA9MaW5lTnVtYmVyVGFibGUBAAg8Y2xpbml0PgEAClNvdXJjZUZpbGUBABJIZWxsb0hvbWV3b3Jr" +
                "LmphdmEMAAcACAcAFgwAFwAYAQAfSGVsbG9Ib21ld29yayBDbGFzcyBJbml0aWFsaXplZAcAGQwA" +
                "GgAbAQANSGVsbG9Ib21ld29yawEAEGphdmEvbGFuZy9PYmplY3QBABBqYXZhL2xhbmcvU3lzdGVt" +
                "AQADb3V0AQAVTGphdmEvaW8vUHJpbnRTdHJlYW07AQATamF2YS9pby9QcmludFN0cmVhbQEAB3By" +
                "aW50bG4BABUoTGphdmEvbGFuZy9TdHJpbmc7KVYAIQAFAAYAAAAAAAIAAQAHAAgAAQAJAAAAHQAB" +
                "AAEAAAAFKrcAAbEAAAABAAoAAAAGAAEAAAABAAgACwAIAAEACQAAACUAAgAAAAAACbIAAhIDtgAE" +
                "sQAAAAEACgAAAAoAAgAAAAMACAAEAAEADAAAAAIADQ==";
        //byte[] bytes=decode(helloBase64);
        byte[] bytes=decode(helloBase64);
        return defineClass(name,bytes,0,bytes.length);
    }

    public byte[] decode(String base64){
            return Base64.getDecoder().decode(base64);
    }
}
