public class Complex {
    private double real;
    private double imaginary;

    public Complex() {
        this(0.0, 0.0);
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imaginary;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImag(double imaginary) {
        this.imaginary = imaginary;
    }

    @Override
    public String toString() {
        if (imaginary >= 0.0) {
            return "(" + real + "+" + imaginary+ "i)";
        } else {
            return "(" + real + "" + imaginary+ "i)";
        }
    }
}