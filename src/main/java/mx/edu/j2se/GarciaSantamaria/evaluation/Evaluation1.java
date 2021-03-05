package mx.edu.j2se.GarciaSantamaria.evaluation;

public class Evaluation1 {

    public static void main(String[] args) {

        double circleRadious = 0;

        Circle circle1 = new Circle();

        try{
               System.out.println("El valor de radio del círculo es: "+circleRadious);
               circle1.setRadius(circleRadious);
        }catch(IllegalArgumentException d){
            System.out.println("*** Estimado usuario, usted a ingresado un valor inválido de radio, por favor vuelva a intentarlo ***");
        }

        Circle[] arrayOfCircles = new Circle[3];

        arrayOfCircles[0].setRadius(2);
        arrayOfCircles[1].setRadius(5);
        arrayOfCircles[2].setRadius(3);

        double maxRadious = biggestCircle(arrayOfCircles);
        double maxIndex = biggestCircle(arrayOfCircles, maxRadious);

        System.out.println("El radio mayor es: "+maxRadious);
        System.out.println("El indice del radio mayor es: "+maxIndex);


    }
    public static double biggestCircle(Circle[] array){
        double x = 0;
        int index = -1;
        int indexFinal = 0;
        for(Circle temp : array){
            index++;
            if(temp.getRadius() > x){
                x = temp.getRadius();
                indexFinal = index;
            }
        }
        return x;
    }

    public static double biggestCircle(Circle[] array, double maxradious){
        double x = 0;
        int index = -1;
        int indexFinal = 0;
        for(Circle temp : array){
            index++;
            if(temp.getRadius() > x){
                x = temp.getRadius();
                indexFinal = index;
            }
        }
        return indexFinal;
    }
}
