package mx.ydaf.proyectodemo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/*
Representa objetos en el juego (Nave, Bala, Alien, Marcador, Enemigo...)
Autor: Yised Denisse Apolonio Flores
 */
public class Objeto
{
    //Protected para que las clases que heredan puedan acceder a la variable
    protected Sprite sprite;  //Imagen, posicion

    //Constructor, Inicializa el objeto con la imagen y la posicion
    public Objeto(Texture textura, float x, float y) {
        sprite = new Sprite(textura);
        sprite.setPosition(x, y);
    }

    //Constructor por default
    public Objeto() {
    }

    // Dibujar el objeto  -> begin  end <-
    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }
}
