import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame {

    public int[] arr = new int[30];
    public boolean [] arr1 = new boolean[30];

    public int min = 50;
    public int max = 400;
    JButton bubbleSort  = new JButton();
    JButton insertionSort = new JButton();
    JButton resetSort = new JButton();

    boolean entered = false;
    Panel newPanel;
    BubbleSort bs;
    InsertionSort insertion;
    MergeSort merger;
    public MainFrame() throws InterruptedException {

        generateRand();
        bubbleSort.setBounds(300,10,150,30);
        bubbleSort.setText("Bubble Sort");
        bubbleSort.setFocusable(false);
        bubbleSort.addActionListener(e ->{

            this.remove(newPanel);
            bs = new BubbleSort(arr,arr1);
            this.add(bs);
            entered = true;
            SwingUtilities.updateComponentTreeUI(this);
            //this.remove(bs);
        });

        insertionSort.setBounds(150,10,150,30);
        insertionSort.setText("Insertion Sort");
        insertionSort.setFocusable(false);
        insertionSort.addActionListener(e ->{

            this.remove(newPanel);
            insertion = new InsertionSort(arr,arr1);
            this.add(insertion);
            entered = true;
            SwingUtilities.updateComponentTreeUI(this);
            //this.remove(bs);
            for (int m:
                    arr) {
                System.out.print(m + "  ");
            }
        });

        resetSort.setFocusable(false);
        resetSort.setBounds(450, 10, 100,30);
        resetSort.setText("Reset");
        this.getContentPane().setBackground(Color.BLACK);

        merger = new MergeSort(arr,arr1);

        this.setSize(605,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.add(merger);
        this.add(bubbleSort);
        this.add(insertionSort);
        this.add(resetSort);
        newPanel = new Panel(arr,arr1);

        this.add(newPanel);



        resetSort.addActionListener(e -> {

            this.dispose();
            try {
                new MainFrame();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

        });

        //bubbleSort.addActionListener(e -> Bubbles());
        //Bubbles();

    }

    public void generateRand(){
        Random r = new Random();
        //int fourDigit = 1000 + r.nextInt(10000);
        for(int j = 0; j < arr.length; j++){
            arr[j] = r.nextInt((max-min) + 1) + min;
        }

    }


    public void newSorter() {
        SwingWorker<Void, String> Worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {


                int i = 0;
                int j = 1;
                int count = arr.length - 1;
                int swap_count = 0;

                while (count > 0) {
                    while (i < arr.length - 1 && j < arr.length) {

                        if (arr[i] > arr[j]) {
                            arr1[i] = true;
                            arr1[j] = true;
                            int temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                            swap_count++;
                        }
                        //this.remove(newPanel);
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        revalidate();
                        repaint();


                        i++;
                        j++;
                    }
                    i = 0;
                    j = 1;
                    if (swap_count == 0) {
                        break;
                    }
                    count--;
                }
                return null;
            }
        };

        Worker.execute();
    }



    public static void main(String[] args) {
        try {
            MainFrame newMain = new MainFrame();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
