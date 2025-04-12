package arreglo;

import java.util.ArrayList;

import clase.Estudiante;

public class ArregloEstudiante {
	
	private ArrayList<Estudiante>estu;
	
	public ArregloEstudiante() {
		estu = new ArrayList<Estudiante>();
		//                  'Codigo','Nombre','nota1','nota2'
		Agregar(new Estudiante(1020, "Anita", 12.5, 13.5));
		Agregar(new Estudiante(3040, "Luis", 14, 13));
		Agregar(new Estudiante(5060, "Rosita", 10, 8));
	}
	
public void Agregar(Estudiante x) {
	estu.add(x);
}

public int Tamaño() {
	return estu.size();
}

public Estudiante Obtener(int x) {
	return estu.get(x);
}

public double PromedioGeneral() {
	double suma = 0.0;
	for(int i = 0; i < Tamaño(); i++) {
		suma += Obtener(i).Promedio();
	}
	return suma/Tamaño();
	
}

public Estudiante Buscar(int cod) {
	for(int i = 0; i < Tamaño(); i++) {
		if(Obtener(i).getCod() == cod) return Obtener(i);	
	}
	return null;
}

public void Eliminar(Estudiante x) {
	estu.remove(x);
}

}
