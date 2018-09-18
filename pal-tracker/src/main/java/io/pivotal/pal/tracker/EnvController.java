package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class EnvController {


   private  String port;
    private  String mlimit;
    private String cfindex;
    private String cfinstance;

    public EnvController(@Value("${PORT:NOT SET}") String port,
                  @Value("${MEMORY_LIMIT:NOT SET}") String mlimit,
                  @Value("${CF_INSTANCE_INDEX:NOT SET}") String cfindex,
                  @Value("${CF_INSTANCE_ADDR:NOT SET}") String cfinstance){
        this.port=port;
        this.mlimit=mlimit;
        this.cfindex=cfindex;
        this.cfinstance=cfinstance;

    }


    @GetMapping("/env")
    public  Map<String,String> getEnv() {
            System.out.print("from env " +System.getenv("WELCOME_MESSAGE"));
         Map<String,String> map = new HashMap<String,String>();
        map.put("PORT",port);
        map.put("MEMORY_LIMIT",mlimit);
        map.put("CF_INSTANCE_INDEX",cfindex);
        map.put("CF_INSTANCE_ADDR",cfinstance);

            return  map;

    }
}
