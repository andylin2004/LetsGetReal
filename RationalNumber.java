public class RationalNumber extends Number
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    if (deno == 0 || nume == 0){
      numerator = 0;
      denominator = 1;
    }else{
      numerator = nume;
      denominator = deno;
      reduce();
    }
  }

  public double getValue(){
    // double inital = Math.round(numerator*10000/(double)denominator);
    // return inital/10000;
    return numerator/(double)denominator;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    RationalNumber a = new RationalNumber(numerator,denominator);
    a.reduce();
    a = new RationalNumber(denominator,numerator);
    return a;
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    this.reduce();
    other.reduce();
    return (this.getNumerator() == other.getNumerator()) && (this.getDenominator() == other.getDenominator());
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    if (denominator == 1){
      return numerator+"";
    }
    return numerator+"/"+denominator;
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    int temp = 0;
    if(a<b){
      temp = a;
      a = b;
      b = temp;
    }
    if (b == 0){
      return 1;
    }
    temp = a%b;
    while (temp != 0){
      a = b;
      b = temp;
      temp = a%b;
    }
    return b;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int gcd = gcd(numerator,denominator);
    numerator = numerator/gcd;
    denominator = denominator/gcd;
    if (denominator < 1){
      numerator *= -1;
      denominator *= -1;
    }
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    return new RationalNumber(this.getNumerator()*other.getNumerator(), this.getDenominator()*other.getDenominator());
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return new RationalNumber(this.getNumerator()*other.getDenominator(), this.getDenominator()*other.getNumerator());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    return new RationalNumber(this.getNumerator()*other.getDenominator()+other.getNumerator()*this.getDenominator(), this.getDenominator()*other.getDenominator());
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    return new RationalNumber(this.getNumerator()*other.getDenominator()-other.getNumerator()*this.getDenominator(), this.getDenominator()*other.getDenominator());
  }
}
