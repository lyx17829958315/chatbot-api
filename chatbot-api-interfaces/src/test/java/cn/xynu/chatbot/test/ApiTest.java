package cn.xynu.chatbot.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient=HttpClientBuilder.create().build();
        HttpGet get=new HttpGet("https://api.zsxq.com/v2/groups/48888582122148/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie","zsxq_access_token=DC5E2E41-23A5-9E08-21E9-8B644D494E6A_2F7BC172B52B37E8; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218fe19acb43f5d-0e1cb9b252742a8-4c657b58-1327104-18fe19acb448%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThmZTE5YWNiNDNmNWQtMGUxY2I5YjI1Mjc0MmE4LTRjNjU3YjU4LTEzMjcxMDQtMThmZTE5YWNiNDQ4In0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218fe19acb43f5d-0e1cb9b252742a8-4c657b58-1327104-18fe19acb448%22%7D; abtest_env=product; zsxqsessionid=fe43fa37d91ea9567015c8d0ef3686b8");
        get.addHeader("Content-Type","application/json; charset=UTF-8");
        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient=HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/48888582122148/answer");
        post.addHeader("cookie","zsxq_access_token=DC5E2E41-23A5-9E08-21E9-8B644D494E6A_2F7BC172B52B37E8; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218fe19acb43f5d-0e1cb9b252742a8-4c657b58-1327104-18fe19acb448%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThmZTE5YWNiNDNmNWQtMGUxY2I5YjI1Mjc0MmE4LTRjNjU3YjU4LTEzMjcxMDQtMThmZTE5YWNiNDQ4In0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218fe19acb43f5d-0e1cb9b252742a8-4c657b58-1327104-18fe19acb448%22%7D; abtest_env=product; zsxqsessionid=fe43fa37d91ea9567015c8d0ef3686b8");
        post.addHeader("Content-Type","application/json; charset=UTF-8");
        String paramJson="";
        StringEntity stringEntity=new StringEntity(paramJson, ContentType.create("type/json","UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

}

