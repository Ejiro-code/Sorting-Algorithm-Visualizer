import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    int [] arr;
    boolean [] arr1;
    Panel(int [] arr, boolean [] arr1){
        this.arr = arr;
        this.arr1 = arr1;
//        for(int j: arr){
//            System.out.println(j);
//        }

        //this.setBackground(Color.black);
        this.setBounds(0,50,605,600);

    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0,0,605,520);



        for(int i = 0; i < arr.length; i++){
            if(arr1[i] == false){
                g.setColor(Color.ORANGE);
            }
            else {
                g.setColor(Color.MAGENTA);
            }
            g.fillRect(i*20,500-arr[i],20 - 2*5,arr[i]);
        }
        for(int k = 0; k < arr1.length; k++){
            arr1[k] = false;
        }


    }
}
