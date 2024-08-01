package com.finabil;
import com.finabil.model.Computer;
import com.finabil.model.User;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemoApplication {

    @Bean
    public Computer computer() {
        return new Computer("DCL", 2000);
    }

    public static void main(String[] args) {

        // ApplicationContext stores the object that bean returns
        ApplicationContext app = SpringApplication.run(SpringBootDemoApplication.class, args);
	    /*
     		we don't need to explicitly make the object of Computer class, that's why it's a loose coupling
            */
        Computer pc1 = app.getBean(Computer.class);
        System.out.println(pc1);
        Computer pc2 = app.getBean(Computer.class);
        pc2.setPcmodel("XYZ");
        System.out.println(pc1);
		/*
		Output of Bean's singleton property
		Computer{pcmodel='DCL', price=2000}
		Computer{pcmodel='XYZ', price=2000}

		 */

    }
}

------------------------------

package com.finabil.model;

public class Computer {
    private String pcmodel;
    private Integer price;

    public Computer(String pcmodel, Integer price){
        this.pcmodel = pcmodel;
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPcmodel() {
        return pcmodel;
    }

    public void setPcmodel(String pcmodel) {
        this.pcmodel = pcmodel;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "pcmodel='" + pcmodel + '\'' +
                ", price=" + price +
                '}';
    }
}

