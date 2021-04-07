/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Xan-T
 */
public class Suma {
    
    int Base = 0;
    int Altura = 0; 
    int Area = 0;
    int Perimetro = 0;
    
    public Suma(String n1, String n2){
        this.Base = Integer.parseInt(n1);
        this.Altura = Integer.parseInt(n2);
    }
    
    public void hacerSuma(){
        this.Area = (this.Base * this.Altura)/ 2;
        this.Perimetro = Base * 3;
    }
    
    public int getNum1(){
        return Base;
    }
    
    public int getNum2(){
        return Altura;
    }
    
    public int getResultado(){
        return Area;
    }
    
    public int getPerimetro(){
        return Perimetro;
    }
    
    
    
}
