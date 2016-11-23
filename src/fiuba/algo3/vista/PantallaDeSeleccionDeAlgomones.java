package vista;

import Algomones.Algomon;
import Algomones.Bulbasaur;
import Algomones.Chansey;
import Algomones.Charmander;
import Algomones.Jigglypuff;
import Algomones.Rattata;
import Algomones.Squirtle;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.*;

public class PantallaDeSeleccionDeAlgomones {

	Jugador jugador1,jugador2;
	Stage stage;
	BorderPane seleccionDeAlgomon;
	VBox jugador1Algomones,jugador2Algomones,comenzarBatalla;
	VBox vistaCharmander,vistaSquirtle,vistaBulbasaur,vistaJigglypuff,vistaRattata,vistaChansey;
	int contador = 0;
	
	
	public PantallaDeSeleccionDeAlgomones(Stage stagePrincipal, Jugador j1,Jugador j2){
		jugador1 = j1;
		jugador2 = j2;
		stage = stagePrincipal;
	}
	
	public ImageView crearImagen(String url, int height, int width){
		Image img = new Image(url);
		ImageView imgView = new ImageView(img);	
		imgView.setFitHeight(height);
		imgView.setFitWidth(width);
		return imgView;
	}
	
	public Button crearBotonDeAlgomon(String url){
		Button boton = new Button();
		boton.setPrefSize(75, 75);
		boton.setStyle(url
				+"-fx-background-color: #38acff;"
				+"-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );"
				+"-fx-opacity: 0.95;");
		return boton;
	}
	
	public Label crearLabelDeAlgomon(String nombre, String url){
		
		Label label = new Label(nombre);
		label.setStyle(url + "-fx-font: 32 arial;" );
		return label;
	}
	
	public Button crearBotonDeEleccion(){
		Button boton = new Button("Elegir");
		boton.setStyle("-fx-font: 18 arial; -fx-base: #ff0000;"
					+  "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
		return boton;
	}

	public void cambiarVista(){
		
		//CUARTA PANTALLA
		seleccionDeAlgomon = new BorderPane();
		HBox contenedorDeAlgomon = new HBox(40);
		contenedorDeAlgomon.setPrefHeight(150);
		contenedorDeAlgomon.setAlignment(Pos.CENTER);
		jugador1Algomones = new VBox(10);
		jugador1Algomones.setAlignment(Pos.TOP_CENTER);
		jugador2Algomones = new VBox(10);
		jugador2Algomones.setAlignment(Pos.TOP_CENTER);
		jugador1Algomones.setPrefWidth(130);
		jugador2Algomones.setPrefWidth(130);
		
		
		Label nombrejugador1 = new Label(jugador1.getNombre());
		nombrejugador1.setStyle("-fx-font: 24 arial; -fx-text-fill: #00ffff;");
		jugador1Algomones.getChildren().add(nombrejugador1);
		
		Label nombrejugador2 = new Label(jugador2.getNombre());
		nombrejugador2.setStyle("-fx-font: 24 arial; -fx-text-fill: #ff0000;");
		jugador2Algomones.getChildren().add(nombrejugador2);
		
		Label nombreCharmander = crearLabelDeAlgomon("Charmander","-fx-text-fill: #ff0000;");
		Label nombreSquirtle = crearLabelDeAlgomon("Squirtle","-fx-text-fill: #00ffdd;");
		Label nombreBulbasaur = crearLabelDeAlgomon("Bulbasaur","-fx-text-fill: #00ff00;");
		Label nombreJigglypuff = crearLabelDeAlgomon("Jigglypuff","-fx-text-fill: #ffffff;");
		Label nombreRattata = crearLabelDeAlgomon("Rattata","-fx-text-fill: #ffffff;");
		Label nombreChansey = crearLabelDeAlgomon("Chansey","-fx-text-fill: #ffffff;");
		
		Button botonCharmander = crearBotonDeAlgomon("-fx-background-image: url('file:src/imagenes/charmander.png');-fx-background-size: cover;");
		Button botonSquirtle = crearBotonDeAlgomon("-fx-background-image: url('file:src/imagenes/squirtle.png');-fx-background-size: cover;");
		Button botonBulbasaur = crearBotonDeAlgomon("-fx-background-image: url('file:src/imagenes/bulbasaur.png');-fx-background-size: cover;");
		Button botonJigglypuff = crearBotonDeAlgomon("-fx-background-image: url('file:src/imagenes/jigglypuff.png');-fx-background-size: cover;");
		Button botonRattata = crearBotonDeAlgomon("-fx-background-image: url('file:src/imagenes/rattata.png');-fx-background-size: cover;");
		Button botonChansey = crearBotonDeAlgomon("-fx-background-image: url('file:src/imagenes/chansey.png');-fx-background-size: cover;");
		
		Button comenzar = new Button("COMENZAR BATALLA");
		comenzar.setPrefSize(300, 75);
		comenzar.setStyle("-fx-base: #ff0000;"
						+ "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );"
						+ "-fx-font: 22 arial;");
		comenzar.setOnAction(e->{
			PantallaDeLucha pantallaLucha = new PantallaDeLucha(stage, jugador1, jugador2);
			pantallaLucha.cambiarVista();
		});
		comenzarBatalla = new VBox();
		comenzarBatalla.setAlignment(Pos.CENTER);
		comenzarBatalla.getChildren().addAll(comenzar);
		
		Button botonElegirCharmander = crearBotonDeEleccion();
		botonElegirCharmander.setOnAction(e->this.agregarImagenDeAlgomonAJugador(new Charmander(), "file:src/imagenes/charmander.png"));		
		
		Button botonElegirSquirtle = crearBotonDeEleccion();
		botonElegirSquirtle.setOnAction(e->this.agregarImagenDeAlgomonAJugador(new Squirtle(), "file:src/imagenes/squirtle.png"));
		
		Button botonElegirBulbasaur = crearBotonDeEleccion();
		botonElegirBulbasaur.setOnAction(e->this.agregarImagenDeAlgomonAJugador(new Bulbasaur(), "file:src/imagenes/bulbasaur.png"));
		
		Button botonElegirJigglypuff = crearBotonDeEleccion();
		botonElegirJigglypuff.setOnAction(e->this.agregarImagenDeAlgomonAJugador(new Jigglypuff(), "file:src/imagenes/jigglypuff.png"));
		
		Button botonElegirRattata = crearBotonDeEleccion();
		botonElegirRattata.setOnAction(e->this.agregarImagenDeAlgomonAJugador(new Rattata(), "file:src/imagenes/rattata.png"));
		
		Button botonElegirChansey = crearBotonDeEleccion();
		botonElegirChansey.setOnAction(e->this.agregarImagenDeAlgomonAJugador(new Chansey(), "file:src/imagenes/chansey.png"));

		contenedorDeAlgomon.getChildren().addAll(botonCharmander,botonSquirtle,botonBulbasaur,botonJigglypuff,botonRattata,botonChansey);
		
		vistaCharmander = new VBox(20);
		vistaCharmander.setAlignment(Pos.CENTER);
		vistaCharmander.getChildren().addAll(nombreCharmander,crearImagen("file:src/imagenes/charmander.png", 200, 200),crearImagen("file:src/imagenes/caraccharmander.png", 120, 480),botonElegirCharmander);
		
		vistaSquirtle = new VBox(20);
		vistaSquirtle.setAlignment(Pos.CENTER);
		vistaSquirtle.getChildren().addAll(nombreSquirtle,crearImagen("file:src/imagenes/squirtle.png",200,200),crearImagen("file:src/imagenes/caracsquirtle.png", 120, 480),botonElegirSquirtle);
		
		vistaBulbasaur = new VBox(20);
		vistaBulbasaur.setAlignment(Pos.CENTER);
		vistaBulbasaur.getChildren().addAll(nombreBulbasaur,crearImagen("file:src/imagenes/bulbasaur.png",200,200),crearImagen("file:src/imagenes/caracbulbasaur.png", 120, 480),botonElegirBulbasaur);
		
		vistaJigglypuff = new VBox(20);
		vistaJigglypuff.setAlignment(Pos.CENTER);
		vistaJigglypuff.getChildren().addAll(nombreJigglypuff,crearImagen("file:src/imagenes/jigglypuff.png",200,200),crearImagen("file:src/imagenes/caracjigglypuff.png", 120, 480),botonElegirJigglypuff);
		
		vistaRattata = new VBox(20);
		vistaRattata.setAlignment(Pos.CENTER);
		vistaRattata.getChildren().addAll(nombreRattata,crearImagen("file:src/imagenes/rattata.png",200,200),crearImagen("file:src/imagenes/caracrattata.png", 120, 480),botonElegirRattata);
		
		vistaChansey = new VBox(20);
		vistaChansey.setAlignment(Pos.CENTER);
		vistaChansey.getChildren().addAll(nombreChansey,crearImagen("file:src/imagenes/chansey.png",200,200),crearImagen("file:src/imagenes/caracchansey.png", 120, 480),botonElegirChansey);
	
		
		seleccionDeAlgomon.setRight(jugador2Algomones);		
		seleccionDeAlgomon.setLeft(jugador1Algomones);
		seleccionDeAlgomon.setBottom(contenedorDeAlgomon);
		
		seleccionDeAlgomon.setStyle("-fx-background-image: url('file:src/imagenes/fondo3.jpg');"
								   +"-fx-background-size: cover;");
		Scene cuartaPantalla = new Scene(seleccionDeAlgomon,1100,600);
		
		stage.setScene(cuartaPantalla);
		stage.setMaximized(false);
		stage.setMaximized(true);

		botonCharmander.setOnMouseEntered(e->this.mostrarVistaDeAlgomonEnElCentro(vistaCharmander));
		botonSquirtle.setOnMouseEntered(e->this.mostrarVistaDeAlgomonEnElCentro(vistaSquirtle));
		botonBulbasaur.setOnMouseEntered(e->this.mostrarVistaDeAlgomonEnElCentro(vistaBulbasaur));
		botonJigglypuff.setOnMouseEntered(e->this.mostrarVistaDeAlgomonEnElCentro(vistaJigglypuff));
		botonRattata.setOnMouseEntered(e->this.mostrarVistaDeAlgomonEnElCentro(vistaRattata));
		botonChansey.setOnMouseEntered(e->this.mostrarVistaDeAlgomonEnElCentro(vistaChansey));
	}
	
	public void agregarImagenDeAlgomonAJugador(Algomon algomon, String url){
		if (contador%2 == 0){
		jugador1Algomones.getChildren().add(crearImagen(url, 125, 125));
		jugador1.setAlgomon(algomon);
		contador++;
		}
		else{
			jugador2Algomones.getChildren().add(crearImagen(url, 125, 125));
			jugador2.setAlgomon(algomon);
			contador++;
		}
		if (contador > 5){
			seleccionDeAlgomon.setCenter(comenzarBatalla);
		}
	}
	
	public void mostrarVistaDeAlgomonEnElCentro(VBox vistaAlgomon){
		if (contador > 5){
			seleccionDeAlgomon.setCenter(comenzarBatalla);
		}
		else{
			seleccionDeAlgomon.setCenter(vistaAlgomon);
		}
	}
}
