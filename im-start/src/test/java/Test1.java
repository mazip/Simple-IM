/**
 * Created by mazip on 2016/8/25.
 */
public class Test1 {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("com.sun.tools.attach.VirtualMachine");
            System.out.println(c.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
