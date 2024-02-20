package model;

public class ComplexNum {
    private final double realNum;
    private final double imaginaryNum;

    public ComplexNum(double realNum, double imaginaryNum) {
        this.realNum = realNum;
        this.imaginaryNum = imaginaryNum;
    }

    public String toString() {
        String formattedRealNum = String.format("%.2f", realNum);
        String formattedImaginaryNum = String.format("%.2f", imaginaryNum);
        if (imaginaryNum >= 0)
            return formattedRealNum + "+" + formattedImaginaryNum + "i";
        else
            return formattedRealNum + "" + formattedImaginaryNum + "i";
    }

    public double getRealNum() {
        return realNum;
    }

    public double getImaginaryNum() {
        return imaginaryNum;
    }

}
