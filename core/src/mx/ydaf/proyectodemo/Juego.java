package mx.ydaf.proyectodemo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/*
Representa la APLICACION que corre, el objeto esta vivo durante toda la ejecucion
Autor: Yised Denisse Apolonio Flores
 */
public class Juego extends Game
{
	@Override
	public void create () {
		// Muestre la primera pantalla
		setScreen(new PantallaMenu(this));     //Esta es la primera pantalla visible

	}

}
