package mx.edu.j2se.GarciaSantamaria.evaluation;

public class Circle {

    private double radius;

    public Circle() {
        this.radius = 1;
    }

    //Método para ingresar el radio del circulo.
    public void setRadius (double radius){
        if(radius <= 0){
            throw new IllegalArgumentException();
        }else{
            this.radius = radius;
        }
    }

    //Método para obtener el radio del circulo.
    public double getRadius(){
        return this.radius;
    }

    //Método para obtener el area del circulo.
    public double getArea(){
        double area = Math.PI * Math.pow(this.radius, 2);
        return area;
    }

}
