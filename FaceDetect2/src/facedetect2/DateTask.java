/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facedetect2;

import java.util.Date;
import java.util.TimerTask;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author jieni
 */
public class DateTask extends TimerTask {
    
    public Mat finalFrame;
    public Rect rectCrop;
    
    public void run() {
        Mat imageRoi = new Mat(finalFrame, rectCrop);

        Mat resizeimage = new Mat();
        Size sz = new Size(200, 200);
        Imgproc.resize(imageRoi, resizeimage, sz);
        System.out.println("任務時間：" + new Date());
    }
    public void setMat(){
        
        
    }
}
