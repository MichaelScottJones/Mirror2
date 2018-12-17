package com.michaelscottjones.mirror2;

import com.hopding.jrpicam.*;
import com.hopding.jrpicam.exceptions.FailedToRunRaspistillException;

public class CameraUtils {
    private RPiCamera piCamera;
    private final String imgPath = "/home/pi/Documents/Mirror2/src/main/resources/static/img";
    private final String img = "face.jpg";

    public CameraUtils() {
        try {
            piCamera = new RPiCamera(imgPath).turnOffPreview();
        } catch (FailedToRunRaspistillException e) {
            System.out.println("ERROR: Failed to run raspistill");
        }
    }

    public RPiCamera getPiCamera() {
        return piCamera;
    }

    public String takePhoto() {
        try {
            piCamera.takeStill("img");
        } catch (Exception e) {
            System.out.println("ERROR: Couldn't take a picture");
            return "";
        }
        return img;
    }


}
