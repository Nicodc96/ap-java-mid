package vehiculos;

public class Vehiculo {
	 
    private String matricula;
    private Marca marca;
    private int kilometros;
 
    public Vehiculo(String matricula, Marca marca, int kilometros) {
        this.matricula = matricula;
        this.marca = marca;
        this.kilometros = kilometros;
    }
 
    public String getMatricula() {
        return matricula;
    }
 
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
 
    public Marca getMarca() {
        return marca;
    }
 
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
 
    public int getKilometros() {
        return kilometros;
    }
 
    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }
 
    @Override
    public String toString() {
        return "[ " + matricula + ", " + marca.toString() + ", " + kilometros + " ]";
    }
}
