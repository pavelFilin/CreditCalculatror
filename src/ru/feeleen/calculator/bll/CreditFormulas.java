package ru.feeleen.calculator.bll;

public class CreditFormulas {
    public static double annuityPayment(double amount, int months, double rate){
        return amount*annuityCoefficientCalc(months, rate);
//        S - сумма кредита, n - количество месяцев, в течении которых выплачивается кредит, i - ставка по кредиту.
//        Формула аннуитетного платежа: A=K*S, где К - коэффициент аннуитета.
//        К = i*(1+i)^(n)/((1+i)^n-1). (^ - возведение в степень).
    }

    private static double annuityCoefficientCalc(int months, double rate) {
        double e = (rate*Math.pow((1+rate),(months)))/(Math.pow((1+rate), months)-1);
       return e;
    }


}
