package mx.ydaf.proyectodemo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

/*
Representa un clon del juego Space invaders
Autor: Yised Denisse Apolonio Flores
 */
public class PantallaSpaceInvaders extends Pantalla
{
    private Juego juego;

    //Enemigos
    //private Alien alien;  //se borrara mas adelante
    private Array<Alien> arrAliens;  //Aqui guarda TODOS los aliens

    //Personaje (Nave)
    private Nave nave;

    public PantallaSpaceInvaders(Juego juego) {
        this.juego = juego;
    }

    // Aqui se inicializan todos los objetos
    @Override
    public void show() {
        crearEnemigos();
        crearNave();
    }

    private void crearNave() {
        Texture texturaNave = new Texture("space/nave.png");
        nave = new Nave(texturaNave, ANCHO/2, 0.07f*ALTO);
    }

    private void crearEnemigos() {
        Texture texturaAlien = new Texture("space/enemigoArriba.png");
        //alien = new Alien(texturaAlien, ANCHO/2, ALTO/2);
        // CREAR 55 aliens (11 columnas x 5 filas)
        arrAliens = new Array<>(11*5);
        for (int renglon=0; renglon<5; renglon++) {
            for (int columna=0; columna<11; columna++) {
                Alien alien = new Alien(texturaAlien, 310 + columna*60, ALTO/2 + renglon*60);
                arrAliens.add(alien);  //Lo guarda en el arreglo
            }
        }
    }

    @Override
    public void render(float delta) {
        borrarPantalla(0,0,0);  //Borrar con color negro

        batch.setProjectionMatrix(camara.combined);

        batch.begin();
        //alien.render(batch);
        // Dibujar los 55 aliens que estan en el arreglo
        for (Alien alien : arrAliens) {   //Automaticamente visita cada objeto del arreglo
            alien.render(batch);
        }
        //Dibujar nave
        nave.render(batch);
        batch.end();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
