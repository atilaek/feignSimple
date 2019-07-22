package aek.feign.feignDemo;

import aek.feign.feignDemo.client.PostClient;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FeignDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FeignDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PostClient bookClient = Feign.builder()
				.client(new OkHttpClient())
				.encoder(new GsonEncoder())
				.decoder(new GsonDecoder())
				.logger(new Slf4jLogger(PostClient.class))
				.logLevel(Logger.Level.FULL)
				.target(PostClient.class, "https://jsonplaceholder.typicode.com");
		System.out.println(bookClient.findAll().toString());


	}
}
