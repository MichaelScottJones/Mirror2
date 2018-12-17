package com.michaelscottjones.mirror2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {
    CameraUtils cameraUtils = new CameraUtils();

    @GetMapping("/user")
    @ResponseBody
    public UserData userAPI() {
        return getUserData();
    }

    public UserData getUserData() {
        return new UserData("Michael", cameraUtils.takePhoto());
    }
}
