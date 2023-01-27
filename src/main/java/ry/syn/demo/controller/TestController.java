package ry.syn.demo.controller;

import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/test")
public class TestController {
    String appleName = "Apple";

    @GetMapping()
    public Boolean getRootTest() {
        return false;
    }

    @GetMapping("/getApple/{count}")
    public List<String> getApple(@PathVariable("count") int count) {
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0; i < count; ++i)
            ret.add(appleName + "#" + i);
        return ret;
    }

    @PostMapping("/setApple")
    public boolean setAppleName(@RequestBody() Map<String, Object> body) {
        try {
            if (body.containsKey("name")) {
                appleName = ((String) body.get("name"));
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
