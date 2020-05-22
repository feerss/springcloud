package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//Feign的面向接口编程
//@FeignClient(value = "springcloud-dept")

/**
 * 修改api工程模块，根据已有的DeptClientService接口新建一个实现了FallbackFactory接口的
 *      类DeptClientServiceFallBackFactory
 * fallbackFactory：集成Hystrix服务降级，还要记得在depte-feign模块 yml开启hystrix（因为fallbackFactory是在注解@FeignClient使用的）
 */
@FeignClient(value = "springcloud-dept",fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService {
    @RequestMapping(value = "/dept/add",method = RequestMethod.GET)
    public boolean add(Dept deptEntity);

    @RequestMapping(value = "/dept/findById/{deptNo}",method = RequestMethod.GET)
    public Dept findById(@PathVariable("deptNo") Long deptNo);

    @RequestMapping(value = "/dept/findAll",method = RequestMethod.GET)
    public List findAll();
}