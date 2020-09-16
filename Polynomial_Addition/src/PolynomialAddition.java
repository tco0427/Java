
public class PolynomialAddition {
    public static void main(String[] args) {
        System.out.println("Enter the first polynomial");
        Polynomial polynomialA=new Polynomial(UserInput.getString());
        System.out.println("Enter the second polynomial");
        Polynomial polynomialB=new Polynomial(UserInput.getString());

        Polynomial polynomialC=Polynomial.add(polynomialA,polynomialB);
        System.out.println();
        polynomialC.printPolynomial();
    }
}
