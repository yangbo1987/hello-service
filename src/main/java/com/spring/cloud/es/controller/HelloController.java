package com.spring.cloud.es.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//
//import com.ylifegroup.protobuf.Phonebook.PhoneType;



import com.spring.cloud.es.bean.User;

@RestController
public class HelloController {
	
	@Autowired
	private DiscoveryClient client;
	
//	@Autowired
//    private GrpcClientService grpcClientService;

	@RequestMapping("/hello")
	public String hello() throws InterruptedException{
//	      List<ServiceInstance> instances = client.getInstances("hello-service");
//	        for (int i = 0; i < instances.size(); i++) {
//	            System.out.println("/hello,host:" + instances.get(i).getHost() +",port:"+ instances.get(i).getPort()+ ",service_id:" + instances.get(i).getServiceId());
//	        }
		ServiceInstance instance=client.getLocalServiceInstance();
		int sleepTime=new Random().nextInt(3000);
		System.out.println("sleepTime:"+sleepTime);
		Thread.sleep(sleepTime);
		System.out.println("/hello,host="+instance.getHost()+",port="+instance.getPort()+",serviceId="+instance.getServiceId());
		return "hello";
	}
//	
//	@RequestMapping("/grpcTest")
//	public String grpcTest(){
//		grpcClientService.addPhoneToUser(1, PhoneType.WORK, "1388888888");
//		return null;
//	}
	
	@RequestMapping(value="/hello1",method=RequestMethod.GET)
	public String hello1(@RequestParam String name){
		return "name ="+name;
	}
	
	@RequestMapping(value="/hello2",method=RequestMethod.GET)
	public User hello2(@RequestHeader String name,@RequestHeader Integer age){
		return new User(name,age);
	}
	
	@RequestMapping(value="/hello3",method=RequestMethod.POST)
	public String hello3(@RequestBody User user){
		return "name ="+user.getName()+",age ="+user.getAge();
	}
}
