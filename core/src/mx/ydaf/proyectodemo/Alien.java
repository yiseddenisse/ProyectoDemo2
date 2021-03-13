package mx.ydaf.proyectodemo;

import com.badlogic.gdx.graphics.Texture;

/*
Representa los Aliens o enemigos en el juego
Autor: Yised Denisse Apolonio Flores
 */
public class Alien extends Objeto
{
    public Alien(Texture textura, float x, float y) {
        super(textura, x, y);  //El constructor de la superclase inicialice el sprite
    }

    //Mever al alien. Se mueve dx pixeles
    public void moverHorizontal(float dx) {
        sprite.setX( sprite.getX() + dx );
    }

    //Dibujar (ya lo heredó de objeto)


    // ´Disparan´
}
