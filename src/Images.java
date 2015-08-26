import com.sun.javafx.iio.png.PNGDescriptor;
import sun.awt.image.PNGImageDecoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Andrew on 26.08.2015.
 */
public class Images{

    public static void main(String args[]){

        File image1 = new File("D:\\java\\ImageCompare\\src\\resources\\image1.png");
        File image2 = new File("D:\\java\\ImageCompare\\src\\resources\\image2.png");
        //I show where my images

        try/* this needed because it may be IOException*/ {
            BufferedImage bufferedImage1 = ImageIO.read(image1);
            BufferedImage bufferedImage2 = ImageIO.read(image2);
            //reading images

            int height = bufferedImage1.getHeight();
            int width = bufferedImage1.getWidth();
            //i need this variables to solve how much times the loop must do
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB );
            

            for (int i = 0; i < height; i++){
                for (int j = 0; i < width; j++){
                    int pixel1 = bufferedImage1.getRGB( j, i );
                    int pixel2 = bufferedImage2.getRGB( j, i );

                    if ((pixel1 < ((pixel2/10)*9)) || (pixel2 <((pixel1/10)*9))){

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
