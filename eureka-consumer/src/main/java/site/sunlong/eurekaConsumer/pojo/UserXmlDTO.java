package site.sunlong.eurekaConsumer.pojo;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author: Sunlong
 * @date: 2021/12/31 10:42
 */
@Data
@XmlRootElement(name = "userList")
public class UserXmlDTO {

    private Long userId;

    private String userName;

}
