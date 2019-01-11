package com.manisharana.bootstrap;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootstrapApplicationTests {

    @Test
    public void when_user_does_not_exist_should_get_404() throws IOException {

        String userName = RandomStringUtils.randomAlphanumeric(5);
        HttpGet request = new HttpGet("https://api.github.com/users/" + userName);
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
    }

    @Test
    public void api_should_return_json_data_type() throws IOException {
        String jsonMimeType = "application/json";
        HttpGet request = new HttpGet("https://api.github.com/users/manishaRana1195");
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertThat(ContentType.getOrDefault(response.getEntity()).getMimeType(), equalTo(jsonMimeType));
    }

}

