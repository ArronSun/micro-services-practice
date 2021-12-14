import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.sunlong.cloudStream.CloudStreamProviderApplication;
import site.sunlong.cloudStream.rabbitmq.ProcessorProvider;
import site.sunlong.cloudStream.rabbitmq.SourceProvider;

/**
 * @Author: Sunlong
 * @date: 2021/12/13 18:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CloudStreamProviderApplication.class)
public class CloudStreamProviderTest {

    @Autowired
    private SourceProvider sourceProvider;
    @Autowired
    private ProcessorProvider processorProvider;

    @Test
    public void test(){
        sourceProvider.send("hello,this is first message");
    }

    @Test
    public void testProcessor(){
        processorProvider.send("hello,this is testProcessor message2");
    }

}
