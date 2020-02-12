import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class NewMandlebrot extends JPanel {
    private static int x = 0;
    private static int y = 0;
    private static int width = 300;
    private static int height = 200;
    private static int MAX_ITERATIONS = 500;

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        //g2d.fillOval(0, 0, 30, 30);
        //g2d.fillRect(50, 0, 30, 30);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                double curC = calcC(i, j);
                double curN = calcN(curC);
                System.out.println(curN);
                if (curN >= MAX_ITERATIONS || curN == MAX_ITERATIONS - 1) {
                    g2d.fillRect(i, j, 5, 5);
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.add(new NewMandlebrot());
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static double calcC(double x, double y) {
        return Math.pow(x, 2) + Math.pow(y, 2);
    }

    public static int calcN(double C) {
        double Z = 0;
        int n = 0;

        while (n < MAX_ITERATIONS && Math.abs(Z) <= 2) {
            Z = Math.pow(Z, 2) + C;
            n++;
        }
        return n;
   }
}
