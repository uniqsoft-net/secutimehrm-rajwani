
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class ProgressBar {

final int MAX = 100;
final JFrame frame = new JFrame("JProgress ");
final JProgressBar pbOne = new JProgressBar();
final JProgressBar pbTwo = new JProgressBar();
final JProgressBar pbThree = new JProgressBar();

   public ProgressBar(){ 

        pbOne.setMinimum(0);
        pbOne.setMaximum(MAX);
        pbOne.setStringPainted(true);

        pbTwo.setMinimum(0);
        pbTwo.setMaximum(MAX);
        pbTwo.setStringPainted(true);

        pbThree.setMinimum(0);
        pbThree.setMaximum(MAX);
        pbThree.setStringPainted(true);

        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(pbOne);
        frame.getContentPane().add(pbTwo);
        frame.getContentPane().add(pbThree);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }


    public  void  setProgress(int progress){
        try {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    pbOne.setValue(progress); //HERE IS where I get lost. How do I differentiate     between PBs and Threads
                }
            });
            java.lang.Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}