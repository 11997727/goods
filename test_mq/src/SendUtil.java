import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendUtil {


    public static String loadURL(String urlStr){

        URL url=null;
        String responseStr=null;

        try{
            url=new URL(urlStr);
            HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream=urlConnection.getInputStream();

            responseStr=convert(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        return responseStr;


    }

    private static String convert(InputStream inputStream){
        InputStreamReader reader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(reader);
        StringBuilder builder=new StringBuilder();
        String line=null;
        try{
            while ((line=bufferedReader.readLine())!=null){
                builder.append(line+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
                inputStream.close();
                bufferedReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
        return builder.toString();

    }

}
