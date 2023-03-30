import Modell.Operatii;
import Modell.Polynomial;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatiiTest {
    @ParameterizedTest
    @MethodSource("provideInput")
    public void addTest(Polynomial firstPol,Polynomial secPol, Polynomial expPol)
    {
       assertEquals(Operatii.polynomialToString(Operatii.adunare(firstPol,secPol)),Operatii.polynomialToString(expPol));
    }

    @ParameterizedTest
    @MethodSource("provideInput2")
    public void subTest(Polynomial firstPol,Polynomial secPol, Polynomial expPol)
    {
        assertEquals(Operatii.polynomialToString(Operatii.scadere(firstPol,secPol)),Operatii.polynomialToString(expPol));
    }
    @ParameterizedTest
    @MethodSource("provideInput3")
    public void mulTest(Polynomial firstPol,Polynomial secPol, Polynomial expPol)
    {
        assertEquals(Operatii.polynomialToString(Operatii.inmultire(firstPol,secPol)),Operatii.polynomialToString(expPol));
    }
    @ParameterizedTest
    @MethodSource("provideInput4")
    public void derivTest(Polynomial firstPol, Polynomial expPol)
    {
        assertEquals(Operatii.polynomialToString(Operatii.derivare(firstPol)),Operatii.polynomialToString(expPol));
    }
    @ParameterizedTest
    @MethodSource("provideInput5")
    public void integTest(Polynomial firstPol,Polynomial expPol)
    {
        assertEquals(Operatii.polynomialToString(Operatii.integrare(firstPol)),Operatii.polynomialToString(expPol));
    }
    private static List<Arguments> provideInput(){
        List<Arguments> arguments = new ArrayList<>();
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();
        Polynomial p3=new Polynomial();
        //p1=Operatii.stringToPolynomial("x^2+3x+5");
       // p2=Operatii.stringToPolynomial("x+1");
       // p3=Operatii.stringToPolynomial("x^2+4x+6");
        p1=Operatii.stringToPolynomial("x^7+x+1");
        p2=Operatii.stringToPolynomial("x^9+10");
        p3=Operatii.stringToPolynomial("x^9+x^7+x+11");
        arguments.add(Arguments.of(p1, p2, p3));

        p1=Operatii.stringToPolynomial("x+5");
        p2=Operatii.stringToPolynomial("x+1");
        p3=Operatii.stringToPolynomial("2x+6");
        arguments.add(Arguments.of(p1, p2, p3));

        p1=Operatii.stringToPolynomial("7");
        p2=Operatii.stringToPolynomial("x^5+8x+4");
        p3=Operatii.stringToPolynomial("x^5+8x+11");
        arguments.add(Arguments.of(p1, p2, p3));
        return arguments;
    }

    private static List<Arguments> provideInput2(){
        List<Arguments> arguments = new ArrayList<>();
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();
        Polynomial p3=new Polynomial();
        p1=Operatii.stringToPolynomial("x^2+3x+5");
        p2=Operatii.stringToPolynomial("x+1");
        p3=Operatii.stringToPolynomial("x^2+2x+4");
        arguments.add(Arguments.of(p1, p2, p3));

        p1=Operatii.stringToPolynomial("x+5");
        p2=Operatii.stringToPolynomial("x+1");
        p3=Operatii.stringToPolynomial("4");
        arguments.add(Arguments.of(p1, p2, p3));

        p1=Operatii.stringToPolynomial("7");
        p2=Operatii.stringToPolynomial("x^5+8x+4");
        p3=Operatii.stringToPolynomial("-x^5-8x+3");
        arguments.add(Arguments.of(p1, p2, p3));
        return arguments;
    }

    private static List<Arguments> provideInput3(){
        List<Arguments> arguments = new ArrayList<>();
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();
        Polynomial p3=new Polynomial();
        p1=Operatii.stringToPolynomial("x^2+3x+5");
        p2=Operatii.stringToPolynomial("x+1");
        p3=Operatii.stringToPolynomial("x^3+4x^2+8x+5");
        arguments.add(Arguments.of(p1, p2, p3));

        p1=Operatii.stringToPolynomial("x+5");
        p2=Operatii.stringToPolynomial("x+1");
        p3=Operatii.stringToPolynomial("x^2+6x+5");
        arguments.add(Arguments.of(p1, p2, p3));

        p1=Operatii.stringToPolynomial("7");
        p2=Operatii.stringToPolynomial("x^5+8x+4");
        p3=Operatii.stringToPolynomial("7x^5+56x+28");
        arguments.add(Arguments.of(p1, p2, p3));
        return arguments;
    }

    private static List<Arguments> provideInput4(){
        List<Arguments> arguments = new ArrayList<>();
        Polynomial p1=new Polynomial();
        Polynomial p3=new Polynomial();
        p1=Operatii.stringToPolynomial("x^2+3x+5");
        p3=Operatii.stringToPolynomial("2x+3");
        arguments.add(Arguments.of(p1,p3));

        p1=Operatii.stringToPolynomial("x+5");
        p3=Operatii.stringToPolynomial("1");
        arguments.add(Arguments.of(p1,p3));

        p1=Operatii.stringToPolynomial("7");
        p3=Operatii.stringToPolynomial("0");
        arguments.add(Arguments.of(p1,p3));
        return arguments;
    }

    private static List<Arguments> provideInput5(){
        List<Arguments> arguments = new ArrayList<>();
        Polynomial p1=new Polynomial();
        Polynomial p3=new Polynomial();
        p1=Operatii.stringToPolynomial("4x^3+3x^2+5");
        p3=Operatii.stringToPolynomial("x^4+x^3+5x");
        arguments.add(Arguments.of(p1,p3));

        p1=Operatii.stringToPolynomial("2x+5");
        p3=Operatii.stringToPolynomial("x^2+5x");
        arguments.add(Arguments.of(p1,p3));

        p1=Operatii.stringToPolynomial("7");
        p3=Operatii.stringToPolynomial("7x");
        arguments.add(Arguments.of(p1,p3));
        return arguments;
    }
}
