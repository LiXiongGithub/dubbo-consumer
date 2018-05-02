package com.lx.consumer;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lx.service.ProviderService;

public class Consumer {

	/**
	 * @author lx
	 * @since 2017年1月11日
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"spring.xml"});
		context.start();
		ProviderService providerService = (ProviderService) context.getBean("providerService");;
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(2000);
				System.out.println(providerService.sayHello("李雄"));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Press any key to exit.");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
