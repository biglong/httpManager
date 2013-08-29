package com.ule.main;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.*;

/**
 * <p>Description:  </p>
 *
 * @author: huangshaolong
 * Date: 8/29/13
 * Time: 10:44 AM
 * CopyRight com.tom.ule
 */
public class AutoLoginHelper {

    public static void main(String[] args) {
          String url = "http://www.jiayuan.com";
          AutoLoginHelper helper = new AutoLoginHelper();
        try {
            helper.excute(url);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void excute(String url) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if(entity != null){
            try {
                InputStream inputStream = entity.getContent();
                String web = readStream(inputStream);
                System.out.println(web);
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (IllegalStateException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } finally {
            }

        }

    }

    /**
     * @功能 读取流
     * @param inStream
     * @return 字节数组
     * @throws Exception
     */
    public static String readStream(InputStream inStream) throws IOException {
        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(inStream,"UTF-8"));
            String line;
            while((line = reader.readLine())!=null){
                sb.append(line).append("\n");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            inStream.close();
        }

        return sb.toString();
    }
}
