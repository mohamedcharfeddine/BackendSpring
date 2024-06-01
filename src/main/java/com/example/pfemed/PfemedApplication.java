package com.example.pfemed;


import com.example.pfemed.models.User;
import com.example.pfemed.repository.UserRepository;
import com.example.pfemed.utils.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // tactivi la persistance des donnees ll les entites jpa
@SpringBootApplication  //tmarqui li  classe hethi rahi lmain
// implementina  CommandLineRunner hiya li taaml demarrage  mtaa lapplication
public class PfemedApplication  implements CommandLineRunner {
    private final StorageService storage;
    private final UserRepository iUser;
    public PfemedApplication(StorageService storage, UserRepository iUser) {
        this.storage = storage;
        this.iUser = iUser;
    }
    public static void main(String[] args) {
        SpringApplication.run(PfemedApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //hetha lcode li mch tsirlou lexecution fi awel demarrage
        //nruniwh awl ma fil app baed decomentiwh
//        storage.init();
//		User admin = new User();
//		admin.setUsername("admin2024");
//		admin.setRole("Admin");
//		admin.setPassword("admin");
//		admin.setEnable(true);
//		iUser.save(admin);
    }
}


