import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    enum Week{Sun,Mon,Tue,Wed,Thu,Fri,Sat}
    public static void main(String[] args) {
        //调用接口的实现
       // B.s.doSomething();

        Week[] workDays = {Week.Mon, Week.Tue, Week.Wed, Week.Thu,Week.Fri};
        List<Week> list = Arrays.asList(workDays);
        list.add(Week.Sat);
    }
}

/*
interface B {
    public static final S s = new S(){
        public void doSomething(){
            System.out.println("我在接口中实现");
        }
    };
}

interface S{
    public void doSomething();
}*/
