import java.io.IOException;

public class Mandelbrot {
    private static int minX = -2, maxX = 2, minY = -1, maxY = 1;
    private static int width = 500;
    private static int height = 400;
    private static final int MAX_ITERS = 500;
    private static ImageCreator imag = new ImageCreator(width, height);

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Complex curC = new Complex();
                double[] complexVals = pixelToComplex(i, j);
                curC.setReal(complexVals[0]);
                curC.setImag(complexVals[1]);

                int iters = calcIterations(curC);
                if (iters == (int) MAX_ITERS) {
                    // System.out.println(curC + " " + iters);
                    imag.fillCoord(i, j, iters, MAX_ITERS);
                }
            }
        }
        imag.createImage();
    }

    public static int calcIterations(Complex c) {
        Complex z = new Complex();
        z.setReal(0.0);
        z.setImag(0.0);
        int n = 0;
        while (n < MAX_ITERS && Math.abs(z.getReal()) <= 2) {
            z.setReal(z.getReal() * z.getReal() + c.getReal());
            z.setImag(z.getImag() * z.getImag() + c.getImag());
            n++;
        }
        return n;
    }

    public static double[] pixelToComplex(double x, double y) {
        double realC = minX + (x / width) * (maxX - minX);
        double imagC = minY + (y / height) * (maxY - minY);

        double[] complex = {realC, imagC};

        return complex;
    }
}