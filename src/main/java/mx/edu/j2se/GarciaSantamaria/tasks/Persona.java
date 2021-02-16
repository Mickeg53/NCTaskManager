package mx.edu.j2se.GarciaSantamaria.tasks;

public class Persona {
    String nombre;
    int edad;
    String sexo;
    double altura;
    String nacionalidad;

    /**
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String loDejanEntrarAlBar (){
        if(this.edad >= 18){
            return "Bienveido al bar";
        }else{
            return "Sigue participando";
        }
    }

    public boolean condicionalAlturaNacionalidad (){
        if(this.altura >= 1.7 && this.nacionalidad == "Mexicana"){
            return true;
        }else{
            return false;
        }
    }
}
