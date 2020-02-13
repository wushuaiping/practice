package io.wooo.practice.studyplan.test;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.URL;

/**
 * @author wushuaiping
 * @date 2019/9/12 16:06
 */
public class TestTianyan {

    private final static String TOKEN = "854b93fe-ac2b-411b-b1ae-814f949c60f4";

    public static void main(String[] args) throws IOException {
        final URL url = new URL("http://open.api.tianyancha.com/services/v4/open/riskInfo?name=杭州匠人网络科技有限公司");
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().get().url(url).header("Authorization", TOKEN).build();
        final Call call = client.newCall(request);
        final Response response = call.execute();
        final int code = response.code();
        final String result = response.body().string();
        System.out.println(result);
    }

}
