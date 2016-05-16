package pClases;

public class ArregloBiNumeros {
    
    private int filas;
    private int columnas;
    private int m[][];

    public ArregloBiNumeros(int f,int c){
        
        this.columnas=c;
        this.filas=f;
        m=new int[f][c];
        Generar();  
    }
    
    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
 
    public int Obtener(int posF,int posC){
        return m[posF][posC];
          
    }
    public void Generar(){
        for (int i = 0; i < filas; i++) 
            for (int j = 0; j < columnas; j++) 
                m[i][j]=(int)((99-10+1)*Math.random()+10);              
    }
    public int SumaFila(int f){
        int s=0;
        int i=f-1;
        for (int j = 0; j < columnas; j++) 
            s+=m[i][j];
   return s;
    }
    public int SumaColumna(int c){
        int s=0;
        int j=c-1;
        for (int i = 0; i <filas; i++) 
            s+=m[i][j];
    return s;    
    }
//editado desde github
}

