import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {



    static ExecutorService executorService=Executors.newFixedThreadPool(50);

    public static void main(String[] args) {

        for (int i=200;i<400;i++){

            final int fi=i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    String ip1="http://localhost:8080";
                    String ip2="http://localhost:8081";

                    int mod=(int)(1+Math.random()*(2));
                    //可以先手动加载一下商品详情,模拟轮询
                    String url = (mod==1?ip1:ip2)+"/buy?gid=10003&uid="+fi;
                    String result=SendUtil.loadURL(url);
                    System.out.println(result);
                }
            });

        }


    }



}
