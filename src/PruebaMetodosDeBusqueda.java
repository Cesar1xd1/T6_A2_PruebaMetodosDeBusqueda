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

public class PruebaMetodosDeBusqueda {

	public static void main(String[] args) {
		

	}

}
