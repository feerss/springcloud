package com.atguigu.springcloud.contoller;

import com.atguigu.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
//        private static final String REST_URL_PREFIX="http://localhost:8001";
    /**
     * 注册再EurekaServer中的微服务名称
     */
    private static final String REST_URL_PREFIX="http://springcloud-dept";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add( Dept Dept){
        //三个参数：url,requestMap ResponseBean.class
        return  restTemplate.postForObject(
                REST_URL_PREFIX+"/dept/add",
                Dept,
                Boolean.class);
    }

    @RequestMapping("/consumer/dept/findById/{deptNo}")
    public Dept findById(@PathVariable("deptNo") Long deptNo){
        //三个参数：url,requestMap ResponseBean.class
        return  restTemplate.getForObject(
                REST_URL_PREFIX+"/dept/findById/"+deptNo,
                Dept.class);
    }

    @RequestMapping("/consumer/dept/findAll")
    public List<Dept> findAll(){
        //三个参数：url,requestMap ResponseBean.class
        return  restTemplate.getForObject(
                REST_URL_PREFIX+"/dept/findAll",
                List.class);
    }

    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery(){
        return  restTemplate.getForObject(
                REST_URL_PREFIX+"/dept/discovery",
                Object.class);
    }
}
