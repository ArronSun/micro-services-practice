package site.sunlong.cloudgateway.test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: Sunlong
 * @date: 2021/12/27 10:26
 */
public class Tests {
    public static void main(String[] args) {

        final String utcFormat = ZonedDateTime.now().minusHours(1).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
        System.out.println(utcFormat);

    }
}
