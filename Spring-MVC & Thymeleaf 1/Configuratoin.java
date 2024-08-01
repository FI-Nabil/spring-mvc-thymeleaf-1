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


    public static void main(String[] args) {

        ApplicationContext app = SpringApplication.run(SpringBootDemoApplication.class, args);
      /*
         it typically returns an object of type Object. The Object class is the root class of all Java classes, so any object can be implicitly upcasted to an Object, 
         Without the typecast, you would get a compile-time error because the compiler cannot guarantee that the object returned by getBean is indeed an instance of Computer.
         By performing the typecast, you're telling the compiler that you are confident that the object returned by getBean is indeed a Computer, allowing you to work with it as such
      */
        Computer computer1 = (Computer) app.getBean("DCL");
        User user1 = new User("Fahim",25,computer1);
        User user2 = new User("Istiak", 26, (Computer) app.getBean("ABC"));
        System.out.println(user1);
        System.out.println(user2);

    }
}

//---------------

package com.finabil;

import com.finabil.model.Computer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// The configuration annotation starts after the line of ApplicationContext of the main class and it configures all the beans
@Configuration
public  class BinConfiguration{

    @Bean
    public Computer DCL(){
        return  new Computer("DCL",2000);
    }
    @Bean
    public Computer ABC(){
        return  new Computer("ABC",2001);
    }

    @Bean
    public Computer DEF(){
        return  new Computer("DEF",2002);
    }

}

//--------------
package com.finabil.model;

public class User {
    private String username;
    private Integer age;
    Computer computer;

    public User(String username, Integer age, Computer computer) {
        this.username = username;
        this.age = age;
        this.computer = computer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPrice() {
        return age;
    }

    public void setPrice(Integer age) {
        this.age = age;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", computer=" + computer +
                '}';
    }
}
//-----------------

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
