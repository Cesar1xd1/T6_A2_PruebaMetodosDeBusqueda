import java.util.Arrays;
import java.util.Scanner;

class BusquedaBinaria{
	int pasadas;
	int comparaciones;
	long tInicio;
	long tFin;
	// vector,0,vector.len-1
	static public int[] quicksort(int[] numeros,int izq,int der) {
		int pivote = numeros[izq];
		int i = izq, j = der;
		int aux;
		while(i<j) {
			while(numeros[i]<=pivote && i<j) i++;
			while(numeros[j]>pivote)j--;
			if(i<j) {
				aux = numeros[i];
				numeros[i]=numeros[j];
				numeros[j] = aux;
			}
		}
		numeros[izq]=numeros[j];
		numeros[j]=pivote;
		if(izq<j-1)
			quicksort(numeros,izq,j-1);
		if(j+1<der)
			quicksort(numeros, j+1, der);
		return numeros;
	}
	

	public int binario(int[]matriz, int valorBuscado) {
		if(matriz.length==0) {
			return -1;
		}
		int mitad,inferior =0;
		int superior = matriz.length-1;
		do {
			pasadas++;
			mitad = (int)(inferior + superior) / 2;
			comparaciones++;
			if (valorBuscado > matriz[mitad]) {
			inferior = mitad + 1;
			} else {
			superior = mitad-1;
			}
			} while (matriz[mitad] != valorBuscado && inferior <= superior);
				comparaciones ++;
			if (matriz[mitad] == valorBuscado) {
				System.out.println("El valor "+ valorBuscado+" SI fue encontrado");
				return mitad;
			
			} else {
				System.out.println("El valor "+ valorBuscado+" NO fue encontro");
			return -1;
			}		
		}
	

	public void resultadosBinarios(int[] vector,int valorB) {
		tInicio = System.nanoTime();
		vector = quicksort(vector, 0, vector.length-1);
		binario(vector , valorB);
		tFin = System.nanoTime();
		System.out.println("Tiempo de ejecucion:"+(tFin-tInicio));
		System.out.println("Numeor de Comparaciones = " + comparaciones);
		System.out.println("Numero de Pasadas = " + pasadas);
		
	}

	}
class FuncionHASH{
	long tInicio;
	long tFin;
	int pasadas;
	int comparaciones;
	String[] arreglo;
	int tamaño;
	
	public FuncionHASH(int tam) {
		tamaño = tam;
		arreglo = new String[tam];
		Arrays.fill(arreglo, "-1");
	}
	public void funcionHash(String[] cadArreglo, String[] arreglo) {
		int i;
		// Ciclo para asiganar a la varible elemento el valor de la cadena
		for (i = 0; i < cadArreglo.length; i++) {
			pasadas++;
			String elemento = cadArreglo[i];
			int indiceArreglo = Integer.parseInt(elemento) % 20;
			System.out.println("Indice: " + indiceArreglo + " para " + elemento);
			// Mpetodo para solucionar una colision
			while (arreglo[indiceArreglo] != "-1") {
				comparaciones++;
				pasadas++;
				indiceArreglo++;
				System.out.println("Colisión en el indice: " + (indiceArreglo - 1) + " cambiando por " + indiceArreglo);
				indiceArreglo %= tamaño; 
			}
			arreglo[indiceArreglo] = elemento;
		}
	
	}

	// Metodo para mostrar la funcion hash
	public void mostrar() {
		int incremento = 0;
		int j;

		for (int i = 0; i < 1; i++) {
			incremento += 100;
			System.out.println("");
			System.out.println("------------------------------------------------------------------");
			for (j = incremento - 100; j < incremento; j++) {
				System.out.format(" | %3s " + " ", j);
			}
			System.out.println(" | ");
			System.out.println();
			for (j = incremento - 100; j < incremento; j++) {
				if (arreglo[j].equals("-1")) {
					System.out.println(" | ");
				} else {
					System.out.print(String.format(" | %3s" + " ", arreglo[j]));
				}
			}

			System.out.println("|");
			System.out.println("------------------------------------------------------------------");
			System.out.println("");
		}
	}

	// Metodo para buscar una clave de los elementos
	public String buscarClave(String elemento) {
		
		int indiceArrglo = Integer.parseInt(elemento) % 99;
		int contador = 0;
	
		while (arreglo[indiceArrglo] != "-1") {
			pasadas++;
			comparaciones++;
			if (arreglo[indiceArrglo].equals(elemento)) {
				System.out.println("Elemento " + elemento + " se encontro en el indice " + indiceArrglo);
				return arreglo[indiceArrglo];
			}
			indiceArrglo++;
			indiceArrglo %= tamaño;
			contador++;
			comparaciones++;
			if (contador > 100) {
				System.out.println("No fue encontrado");
				break;
			}
		}
		return null;
	}
	public void mostrarHash(String elemento) {
		tInicio = System.nanoTime();
		buscarClave(elemento);
		tInicio = System.nanoTime();
		System.out.println("Tiempo de ejecucion:"+(tFin-tInicio));
		System.out.println("Numeor de Comparaciones = " + comparaciones);
		System.out.println("Numero de Pasadas = " + pasadas);
		
	}
	
}
interface Correcion{
	Scanner input = new Scanner(System.in);
	
	public static int validacion() {
		int r = 0;
		boolean e = false;
		do {
			try {
				r = input.nextInt();
			} catch (java.util.InputMismatchException h) {
				System.out.println("Ups... Solo numeros porfavor, intenta de nuevo:");
				input.nextLine();
				e=true;
			}
			if (r>0) {
				e=false;
			}else {
				System.out.println("Solo numeros mayores a 0 por favor, intenta de nuevo:");
				e=true;
			}
		}while(e);
		return r;
	}
}
class Clase {
	Scanner entrada = new Scanner (System.in);
	public void trabajo(int x) {
		String vectorHash[]=new String[100];
		int vectorMaestro[] = new int [100];
		for(int i=0;i<vectorMaestro.length;i++) {
			vectorMaestro[i]=(int) (Math.random() * 100);
			vectorHash[i]=String.valueOf(vectorMaestro[i]);
		}
		BusquedaBinaria b = new BusquedaBinaria();
		vectorMaestro = b.quicksort(vectorMaestro, 0, vectorMaestro.length-1);
		for(int i=0;i<vectorMaestro.length;i++) {
			vectorHash[i]=String.valueOf(vectorMaestro[i]);
		}
		
		int vectorBin[] = vectorMaestro;
		if(x==1) {
			
			System.out.println("Vector: " + Arrays.toString(vectorBin));
			System.out.println("========== Metodo de Busqueda Binaria ==========");
			System.out.println("Ingresa el elemento a buscar:");
			int elemento = entrada.nextInt();
			b.resultadosBinarios(vectorBin, elemento);
		}
		else if(x==2) {
			System.out.println("Vector: " + Arrays.toString(vectorHash));
			System.out.println("========== Metodo de Funcion Hash ==========");
			FuncionHASH fh = new FuncionHASH(vectorHash.length);
			fh.tInicio = System.nanoTime();
			fh.funcionHash(vectorHash, fh.arreglo);
			fh.mostrar();
			System.out.println("Ingresa el elemento a buscar");
			int elemento = entrada.nextInt();
			fh.buscarClave(String.valueOf(elemento));
			fh.tFin = System.nanoTime();
			System.out.println("Tiempo de ejecucion:"+(fh.tFin-fh.tInicio));
			System.out.println("Numeor de Comparaciones = " + fh.comparaciones);
			System.out.println("Numero de Pasadas = " + fh.pasadas);
		}
	}
}

public class PruebaMetodosDeBusqueda {

	public static void main(String[] args) {
		Clase x = new Clase();
		int opcion =0;
		do {
			System.out.println("========== MENU ==========");
			System.out.println("Digite 1 para La busqueda Binaria");
			System.out.println("Digite 2 para la busqueda por Funcion Hash");
			System.out.println("Digite 3 para ***SALIR***");
			opcion = Correcion.validacion();
			x.trabajo(opcion);	
		}while(opcion!=3);
		
		
		

	}

}
