package mx.ydaf.proyectodemo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class PantallaMenu extends Pantalla
{
    //Referencia al juego principal
    private Juego juego;

    //Fondo de la pantalla del menu
    private Texture texturaFondo;

    //Escena
    private Stage escenaMenu;
    
    public PantallaMenu(Juego juego) {
        this.juego = juego;
    }

    /*
    Se ejecuta al inicio, antes de mostrar la pantalla
    INICIALIZAR los objetos
     */
    @Override
    public void show() {
        
        crearMenu();
    }

    private void crearMenu() {
        //Fondo
        texturaFondo = new Texture("menu/fondoMenu.jpg");
        
        //MENU, NECESITAMOS UNA ESCENA
        escenaMenu = new Stage(vista);

        //Actores.... Boton
        Button btnMario = crearBoton("menu/b_jugar_mario.png", "menu/bInverso_jugar_mario.png");
        btnMario.setPosition(ANCHO/3, 2*ALTO/3, Align.center);
        //Agregar a la escena el boton
        escenaMenu.addActor(btnMario);
        btnMario.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                juego.setScreen(new PantallaMario(juego));
            }
        });

        Button btnSpace = crearBoton("menu/b_jugar_space.png", "menu/bInverso_jugar_space.png");
        btnSpace.setPosition(2*ANCHO/3,2*ALTO/3,Align.center);
        escenaMenu.addActor(btnSpace);
        //REGISTRAR el evento de click para el boton
        btnSpace.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //Cambiar de pantalla (Space Invaders)
                juego.setScreen(new PantallaSpaceInvaders(juego));
            }
        });

        Button btnRunner = crearBoton("menu/b_jugar_runner.png", "menu/bInverso_jugar_runner.png");
        btnRunner.setPosition(ANCHO/3,ALTO/3,Align.center);
        escenaMenu.addActor(btnRunner);
        btnRunner.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                juego.setScreen(new PantallaRunner(juego));
            }
        } );

        Button btnConfiguracion = crearBoton("menu/b_configuracion.png", "menu/bInverso_configuracion.png");
        btnConfiguracion.setPosition(2*ANCHO/3,ALTO/3,Align.center);
        escenaMenu.addActor(btnConfiguracion);
        btnConfiguracion.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                juego.setScreen(new PantallaConfiguracion (juego));
            }
        });

        //La ESCENA se encarga de ATENDER LOS EVENTOS DE ENTRADA
        Gdx.input.setInputProcessor(escenaMenu);
    }

    private Button crearBoton(String archivo, String archivoInverso) {
        Texture texturaBoton = new Texture(archivo);
        TextureRegionDrawable trdBtnMario = new TextureRegionDrawable(texturaBoton);
        //Inverso
        Texture texturaInverso = new Texture(archivoInverso);
        TextureRegionDrawable trdBtnInverso = new TextureRegionDrawable(texturaInverso);

        return new Button(trdBtnMario, trdBtnInverso);
    }

    // Se ejecuta automaticamente (60 veces/seg)
    //delta es el tiempo que ha transcurrido entre frames
    @Override
    public void render(float delta) {
        borrarPantalla(0,1,1);

        batch.setProjectionMatrix(camara.combined);

        batch.begin();
        batch.draw(texturaFondo, 0,0);
        batch.end();

        //Dibujar la escena DESPUES DEL FONDO
        escenaMenu.draw();
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
