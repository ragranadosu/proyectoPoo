package com.company;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Carro {
    private int x,y;
    private int nColor;
    private boolean bVisible;
    private int dx,dy;
    private boolean bObstaculo;
    private Random r;
    private JLabel imagen = new JLabel() ;


    public Carro (boolean obstaculo, Random r){
        if(!this.bObstaculo){
            imagen.setIcon(new ImageIcon(getClass().getResource("carrocaro.png")));
            imagen.setBounds(45,70,9,15);
        }
        this.bObstaculo=obstaculo;
        this.r=r;
    }

    public JLabel getImagen() {
        return imagen;
    }
    
    

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getColor() {
        return nColor;
    }

    public boolean getVisible() {
        return bVisible;
    }

    public void mostrarCarro(int color){
        bVisible=true;
        nColor=color;
        y=-20;
        x=6+((r.nextInt(3)+1)*20);
    }

    public void ocultarCarro(){
        bVisible=false;
    }

    public void moverComputador(){
        if(bVisible){
            mover(dx,1);
            if(y>100){
                ocultarCarro();
                

            }
        }
    }

    public void setXY(int x,int y){
        this.x=x;
        this.y=y;
    }

    public void mover(int dx, float dy) {
        
        
       
        if (!bObstaculo) {
            y += dy;
            x += dx;
            //LIMITACION DE MOVIMIENTO DEL VEHICULO PROPIO
            if (y < 10) {
                y = 10;
            }
            if (y > 70) {
                y = 70;
            }
            
            if (x < 20) {
                x = 20;
            }

            if (x > 70) {
                x = 70;
            }
        } else {
            x += dx;
            if (x < 20) {
                x = 20;
                this.dx = -this.dx;
            }

            if (x > 70) {
                x = 70;
                this.dx = -this.dx;
            }

            y += this.dy;
        }
    }

    public boolean hayChoque(int x2, int y2){
        if (x+1>x2+10) return false;
        if (x2+1>x+10) return false;
        if (y+1>y2+16) return false;
        if (y2+1>y+16) return false;
        return true;
    }
    
    
    
    /*public void moverAutoPropio(){
        if(!bObstaculo){
            //LIMITACION DE MOVIMIENTO DEL VEHICULO PROPIO
            if(y<10){
                y=10;
            }
            if(y>70){
                y=70;
            }
        }
    }*/

    public void setDy(int dy) {
        this.dy = dy;
    }

}
