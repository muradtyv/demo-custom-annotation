package az.annotation.customannotation.service;

import az.annotation.customannotation.annotation.TrackExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @TrackExecutionTime
    public String doSomething() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Done!";
    }
}
