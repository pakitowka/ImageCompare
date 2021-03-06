import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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
            BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB );
            //I have created the third image that'll include the differences
            List<Integer> differencesX = new ArrayList<>();
            List<Integer> differencesY = new ArrayList<>();

            for (int i = 0; i < height; i++){
                for (int j = 0; j < width; j++){
                    int pixel1 = bufferedImage1.getRGB( j, i );
                    int pixel2 = bufferedImage2.getRGB( j, i );
                    result.setRGB(j, i, pixel1);

                    if (pixel1 != pixel2){
                        differencesX.add(j);
                        differencesY.add(i);
                    }
                }
            }

            for(int i = 0; i < (differencesX.size()-1); i++){
                /*int pixel3 = result.getRGB(differencesX.get(i), differencesY.get(i));
                if(differencesY.get(i) == differencesY.get(i+1)){
                    pixel3 = BufferedImage.TYPE_INT_BGR;
                }*/
                result.setRGB(differencesX.get(i),differencesY.get(i),BufferedImage.TYPE_INT_RGB);
            }

            ImageIO.write(result, "png", new File("D:\\java\\ImageCompare\\src\\resources\\result.png"));

            System.out.println(differencesX.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
