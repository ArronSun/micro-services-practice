package site.sunlong.cloudStream.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.sunlong.cloudStream.CloudStreamApplication;
import site.sunlong.cloudStream.rabbitmq.SourceProvider;

/**
 * @Author: Sunlong
 * @date: 2021/12/9 16:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CloudStreamApplication.class)
public class CloudStreamTest {

    @Autowired
    private SourceProvider sourceProvider;

    @Test
    public void test(){
        sourceProvider.send("hello");
    }

}
