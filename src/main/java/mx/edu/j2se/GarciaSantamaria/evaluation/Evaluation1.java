package mx.edu.j2se.GarciaSantamaria.evaluation;

public class Evaluation1 {

    public static void main(String[] args) {

        double circleRadious = 0;

        Circle circle1 = new Circle();
        Circle circle2 = new Circle();
        Circle circle3 = new Circle();
        Circle circle4 = new Circle();

        try{
               System.out.println("El valor de radio del círculo es: "+circleRadious);
               circle1.setRadius(circleRadious);
        }catch(IllegalArgumentException d){
            System.out.println("*** Estimado usuario, usted a ingresado un valor inválido de radio, por favor vuelva a intentarlo ***");
        }

        circle2.setRadius(2);
        circle3.setRadius(5);
        circle4.setRadius(3);

        Circle[] arrayOfCircles = new Circle[]{circle2, circle3, circle4};


        double maxRadious = biggestCircle(arrayOfCircles);
        int maxIndex = biggestCircle(arrayOfCircles, maxRadious);

        System.out.println("El radio mayor es: "+maxRadious);
        System.out.println("El indice del radio mayor es: "+maxIndex);


    }
    public static double biggestCircle(Circle[] array){
        double x = 0;
        for(Circle temp : array){
            if(temp.getRadius() > x){
                x = temp.getRadius();
            }
        }
        return x;
    }

    public static int biggestCircle(Circle[] array, double maxradious){
        int index = -1;
        int indexFinal = 0;
        for(Circle temp : array){
            index++;
            if(temp.getRadius() == maxradious){
                indexFinal = index;
            }
        }
        return indexFinal;
    }
}
