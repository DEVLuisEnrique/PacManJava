
package Juegos;

import java.awt.Color;
import static java.awt.Frame.NORMAL;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import Juegos.FotosEstudiantes;
import java.util.Locale;

public class Juego {
    
     //Atributos
    static JFrame ventana;

    
    JPanel PanelPresentacion,PanelPresentacion1; 
    JButton  iniciar,fotosE,volver;
    JLabel fondopresentacion;
    ImageIcon ImagenFondoPrese;
    
    //variable de menu
    JPanel PanelMenu; 
    JButton  botones[];
    JLabel fondoMenu;
    ImageIcon ImagenFondoMenu;
    
    //Juego 
    static JPanel Paneljuego;
    JLabel fondojuego;
    ImageIcon ImagenFondojuego;
    static int mat[][];
    int nivel;
    static JLabel matrix[][];
    int px,py;
    //int fanx,fany;
    String jugador;
    JLabel nombre;
    JLabel records;
    int puntos;
    int abajo,arriba,izq,der;
    Timer timer;
    
    //fantasmas
    Fantasmas fantasma1;
    Fantasmas fantasma2;
    Fantasmas fantasma3;
    static int matAux[][];
      
 //////////////////////////////////////////
    public void jugar()//FUNCION JUGAR
      {
         
         //PANEL
         PanelMenu.setVisible(false);
         Paneljuego = new JPanel();
         Paneljuego.setLayout(null);
         Paneljuego.setBounds(0, 0,ventana.getWidth() , ventana.getHeight());
         Paneljuego.setVisible(true);
         
                
        //FONDO
         fondojuego = new JLabel();
         fondojuego.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
         ImagenFondojuego = new ImageIcon(getClass().getResource("/Imagenes/fondojuego.png"));
         //ImagenFondojuego = new ImageIcon("src/Imagenes/fondojuego.png");
         ImagenFondojuego = new ImageIcon(ImagenFondoMenu.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
         fondojuego.setIcon(ImagenFondojuego);
         fondojuego.setVisible(true);
         
         Paneljuego.add(fondojuego);
          
          for (int i = 0; i < mat.length; i++) {
              
              for (int j = 0; j < mat.length; j++) {
                    matrix[i][j].setIcon(new ImageIcon(getClass().getResource("/Imagenes/"+mat[i][j]+".png")));
                 // matrix[i][j].setIcon(new ImageIcon("src/Imagenes/"+mat[i][j]+".png"));
                  matrix[i][j].setBounds(100+(i*30), 100+(j*30), 30, 30);
                  matrix[i][j].setVisible(true);
                  
                  Paneljuego.add(matrix[i][j],0);
                  
                  
              }
              
          }
          //nombre de jugador
          nombre = new JLabel("Jugador: "+jugador);
          nombre.setBounds(20, 20, 150, 30);
          nombre.setVisible(true);
          nombre.setForeground(Color.white);
          Paneljuego.add(nombre,0);
          
          //puntuacion de jugador
          records = new JLabel("Puntos: "+puntos);
          records.setBounds(ventana.getWidth()-(150+20), 20, 150, 30);
          records.setForeground(Color.white);
          Paneljuego.add(records,0);
          records.setVisible(true);
          /////
          MoverPacman();
         fantasma1 = new Fantasmas(8,6);
         fantasma2 = new Fantasmas(8,6);
         //fantasma3 = new Fantasmas(8,6);
          
          
         
         
         ventana.add(Paneljuego);
      }
    
    public static void pintarMatriz(){//PINTAR MATRIZ
    
        for (int i = 0; i < mat.length; i++) {

                  for (int j = 0; j < mat.length; j++) {
                      //matrix[i][j].setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/"+mat[i][j]+".png")));
                      matrix[i][j].setIcon(new ImageIcon(""+mat[i][j]+".png"));
                      matrix[i][j].setBounds(100+(i*30), 100+(j*30), 30, 30);
                      matrix[i][j].setVisible(true);

                      Paneljuego.add(matrix[i][j],0);

                  }

              }
    
    }
    //TABLEROS NIVELES DEL JUEGO
    public int[][] tablero(int opcion)
     {
         int aux1[][]= new int[15][15];
         
         if(opcion == 1)
            {
                int aux[][] ={//15*15
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,1,1,1,1,1,1,2,1,1,1,1,1,1,2},
                    {2,1,2,2,1,2,1,2,1,2,2,1,2,1,2},
                    {2,1,2,1,1,2,1,2,1,1,2,1,2,1,2},
                    {2,1,2,1,1,1,1,1,1,1,1,1,1,1,2},
                    {2,1,2,1,1,2,1,2,2,1,1,1,2,2,2},
                    {2,1,2,2,1,2,1,1,2,1,1,2,2,1,2},
                    {2,1,1,1,1,2,1,1,1,1,1,1,2,1,2},
                    {2,1,2,2,1,2,1,1,1,1,2,1,1,1,2},//d
                    {2,1,2,1,1,2,1,1,2,1,2,1,1,1,2},
                    {2,1,2,1,1,2,1,2,2,1,2,1,1,1,2},
                    {2,1,2,1,1,1,1,1,1,1,1,1,2,1,2},
                    {2,1,2,2,1,2,1,2,2,1,1,2,2,1,2},
                    {2,1,1,1,1,2,1,1,1,1,1,1,1,1,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    };
                return aux; 
                }
                
               
            
          if(opcion == 2)
            {   
                int aux[][] ={//20*15
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,1,1,1,1,1,1,2,1,1,1,1,1,1,2},
                    {2,1,2,2,1,2,1,2,1,2,2,1,2,1,2},
                    {2,1,2,1,1,2,1,1,1,1,2,1,2,1,2},
                    {2,1,1,1,2,2,2,1,2,1,1,1,1,1,2},
                    {2,1,2,1,1,1,1,1,2,2,2,1,2,2,2},
                    {2,1,2,2,1,2,2,1,1,2,2,1,1,1,2},
                    {2,1,1,1,1,1,2,2,1,1,1,1,2,1,2},
                    {2,2,2,1,2,1,2,2,2,1,2,1,2,1,2},
                    {2,1,1,1,2,1,1,1,1,1,1,1,1,1,2},
                    {2,1,2,1,1,1,2,2,2,1,2,1,2,1,2},
                    {2,1,1,1,2,1,2,1,1,1,1,1,2,1,2},
                    {2,1,2,1,2,1,2,1,2,1,2,1,2,1,2},
                    {2,1,1,1,2,1,1,1,1,1,1,1,1,1,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    };
                
              return aux;  
            }
           if(opcion == 3)
            {
                int aux[][] ={
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
                    {2,1,2,2,2,2,2,2,1,1,1,2,1,1,2},
                    {2,1,2,2,2,2,2,2,1,1,1,1,1,1,2},
                    {2,1,2,2,2,2,2,2,1,1,1,1,1,1,2},
                    {2,1,2,2,2,2,2,2,1,1,1,1,1,1,2},
                    {2,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
                    {2,1,1,1,1,1,2,1,1,1,1,1,1,1,2},
                    {2,1,1,1,1,1,2,1,1,1,1,1,2,1,2},
                    {2,2,1,1,2,2,2,2,2,1,1,1,2,1,2},
                    {2,2,1,1,1,1,2,1,1,1,1,1,2,1,2},
                    {2,2,1,1,1,1,2,1,1,1,1,1,2,1,2},
                    {2,2,1,1,1,1,1,1,1,1,1,1,2,1,2},
                    {2,2,2,2,2,2,1,1,1,1,1,1,1,1,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},};
                
              return aux;  
            }
           
           return aux1;
     }
    
////////////////////////////////////////////////
    public Juego()//COSNTRUCTOR
        {
        //VENTANA
         
         ventana  = new JFrame("PacMan");
         ventana.setSize(700, 700);
         ventana.setLayout(null);
         ventana.setLocationRelativeTo(null);
         ventana.setResizable(false);
         ventana.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.png")).getImage());
         ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         //ventana.setIconImage(new ImageIcon(getClass().getResource("Imagenes/icono.png")).getImage());
         
         //PANEL
         PanelPresentacion = new JPanel();
         PanelPresentacion.setLayout(null);
         PanelPresentacion.setBounds(0, 0,ventana.getWidth() , ventana.getHeight());
         PanelPresentacion.setVisible(true);
         PanelPresentacion.setBackground(Color.red);
         
         //BOTONES
         iniciar = new JButton("Iniciar");
         iniciar.setVisible(true);
         iniciar.setBounds(ventana.getWidth()-120, 20, 100, 30);
         iniciar.setBackground(Color.WHITE);
         PanelPresentacion.add(iniciar);
         
         fotosE = new JButton("Estudiantes");
         fotosE.setVisible(true);
         fotosE.setBounds(ventana.getWidth()-680,20 ,150, 30);
         fotosE.setBackground(Color.white);
         PanelPresentacion.add(fotosE);
         
        //FONDO
         fondopresentacion = new JLabel();
         fondopresentacion.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
         ImagenFondoPrese = new ImageIcon(getClass().getResource("/Imagenes/fondo1.png"));
         //ImagenFondoPrese = new ImageIcon("src/Imagenes/fondo1.png");
         ImagenFondoPrese = new ImageIcon(ImagenFondoPrese.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
         fondopresentacion.setIcon(ImagenFondoPrese);
         fondopresentacion.setVisible(true);
         PanelPresentacion.add(fondopresentacion);
         
         //Evento boton iniciar
         //menu
            botones = new JButton[5];
            for (int i = 0; i < botones.length; i++) {
              botones[i] = new JButton();
            }
             
         iniciar.addMouseListener(new MouseAdapter() {
         
            public void mousePressed(MouseEvent e){
                          menu();
                          eventoMenu();
                       }  
         });
         
         //BOTON FOTOS DE ESTUDIANTES////////
          fotosE.addMouseListener(new MouseAdapter() {
         
            public void mousePressed(MouseEvent e){
                         FotosEs();
                       }
   
         });
          
        ////
        //juego
        
        mat = new int[15][15];
        mat = tablero(1);
        ///matAux = tablero(1);
        matrix = new JLabel[15][15];
        matAux = new int[15][15];
        for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    matrix[i][j] = new JLabel();
                    matAux[i][j] =mat[i][j];
                }
            }
        
        
            //mat = tablero(1);//llama el nivel del tablero
            //Posicion de PacMan en el tablero
            px=1;
            py=1;
            mat[px][py]=3;
        
            
            abajo=0;
            arriba=0;
            izq=0;
            der=0;
            
            
         /****************/
         ventana.add(PanelPresentacion);
         ventana.setVisible(true);
        }
    
    public void nivel_1(){
    mat = new int[15][15];
        mat = tablero(1);
        ///matAux = tablero(1);
        matrix = new JLabel[15][15];
        matAux = new int[15][15];
        for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    matrix[i][j] = new JLabel();
                    matAux[i][j] =mat[i][j];
                }
            }
        
        
            //mat = tablero(1);//llama el nivel del tablero
            //Posicion de PacMan en el tablero
            px=1;
            py=1;
            mat[px][py]=3;
        
            
            abajo=0;
            arriba=0;
            izq=0;
            der=0;
    }
    
     public void nivel_2(){
        //fantasma2 = new Fantasmas(8,6);
        mat = new int[15][15];
        mat = tablero(2);
        ///matAux = tablero(1);
        matrix = new JLabel[15][15];
        matAux = new int[15][15];
        for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    matrix[i][j] = new JLabel();
                    matAux[i][j] =mat[i][j];
                }
            }
        
        
            //mat = tablero(1);//llama el nivel del tablero
            //Posicion de PacMan en el tablero
            px=1;
            py=1;
            mat[px][py]=3;
        
            
            abajo=0;
            arriba=0;
            izq=0;
            der=0;
            
    }
    
     public void nivel_3(){
        //fantasma2 = new Fantasmas(8,6);
        //fantasma3 = new Fantasmas(8,6);
        mat = new int[15][15];
        mat = tablero(3);
        ///matAux = tablero(1);
        matrix = new JLabel[15][15];
        matAux = new int[15][15];
        for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    matrix[i][j] = new JLabel();
                    matAux[i][j] =mat[i][j];
                }
            }
        
        
            //mat = tablero(1);//llama el nivel del tablero
            //Posicion de PacMan en el tablero
            px=1;
            py=1;
            mat[px][py]=3;
        
            
            abajo=0;
            arriba=0;
            izq=0;
            der=0;
            
    }
    
    
    public void MoverPacman(){//FUNCION PARA ANIMAR EL PACMAN
        
        
        
        timer = new Timer (100, new ActionListener()//TIMER UTILIZADO PARA AJUSTAR LA VELOCIDAD DE MOVIMIENTO
        {
            public void actionPerformed(ActionEvent e)
            {  
               if(arriba==1 && ( mat[px][py-1]==1 || mat[px][py-1]==0 ))//MOVER Y COMER PUNTOS HACIA ARRIBA
                {
                        if(mat[px][py-1]==1)
                            {
                                puntos=puntos+10;
                                records.setText("Puntos: "+puntos);
                            }
                        mat[px][py]=0;
                        matAux[px][py]=mat[px][py];//esto es nuevo 
                        py=py-1;
                        mat[px][py]=5;
                        pintarMatriz();
                        
                } 
               
               if(abajo==1 && (mat[px][py+1]==1 || mat[px][py+1]==0 ))//MOVER Y COMER PUNTOS HACIA ABAJO
                {
                        if(mat[px][py+1]==1)
                            {
                                puntos=puntos+10;
                                records.setText("Puntos: "+puntos);
                            }
                        mat[px][py]=0;
                        matAux[px][py]=mat[px][py];//esto es nuevo
                        py=py+1;
                        mat[px][py]=4;
                        pintarMatriz();
                        
                       
                        
                } 
               
               if(izq==1 && (mat[px-1][py]==1 || mat[px-1][py]==0 ))//MOVER Y COMER PUNTOS A LA IZQUIERDA
                {
                        if(mat[px-1][py]==1)//GENERACION DE LOS PUNTOS
                            {
                                puntos=puntos+10;
                                records.setText("Puntos: "+puntos);
                            }
                        mat[px][py]=0;
                        matAux[px][py]=mat[px][py];//esto es nuevo
                        px=px-1;
                        mat[px][py]=6;
                        pintarMatriz();
                        
                } 
               if(der==1 && (mat[px+1][py]==1 || mat[px+1][py]==0 ))//MOVER Y COMER PUNTOS A LA DERECHA
                {
                       if(mat[px+1][py]==1)//Generacion de los puntos
                            {
                                puntos=puntos+10;
                                records.setText("Puntos: "+puntos);
                            }

                        mat[px][py]=0;
                        matAux[px][py]=mat[px][py];//esto es nuevo
                        px=px+1;
                        mat[px][py]=3;
                        pintarMatriz();
                        
                } 
               
             //CONDICIONES PARA GANAR
            int enc=0;
                for (int i = 0; i < mat.length && enc==0; i++) {
                    for (int j = 0; j < mat.length && enc==0; j++) {
                        if(mat[i][j]==1)
                            {
                                enc=1;
                            }
                    }
                }
                if(enc==0)
                    {
                     fantasma1.timer.stop();
                     fantasma2.timer.stop();
                     //fantasma3.timer.stop();
                     JOptionPane.showMessageDialog(ventana, "Felicidades "+jugador+" Ganaste!!"+"\nPuntos: "+puntos);
                     Paneljuego.setVisible(false);
                     PanelMenu.setVisible(true);
                     timer.stop();
                     puntos=0;
                     nivel_1();
                    }
                
                 //matar pacman
                if(mat[px][py+1] ==7 || mat[px][py-1] ==7 || mat[px-1][py] ==7 ||mat[px+1][py] ==7)
                    {
                       fantasma1.timer.stop();
                       fantasma2.timer.stop();
                      // fantasma3.timer.stop();
                      // fantasma3.timer.stop();
                       JOptionPane.showMessageDialog(ventana, "Estas muerto "+jugador+"\nPuntos obtenidos: "+puntos);
                       Paneljuego.setVisible(false);
                       PanelMenu.setVisible(true);
                       timer.stop();
                       puntos=0;
                       nivel_1();
                       
                    }
                
                
            }});     
        
        
        timer.start();
        ventana.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {//PRESIONAR TECLA Y SE MANTIENE PRESIONADA
                
                if(e.getKeyCode() == KeyEvent.VK_UP)//MOVER TECLA ARRIBA
                    {
                       // System.out.println("Tecla hacia arriba");
                       if(mat[px][py-1]==1 || mat[px][py-1]==0 ){  
                            arriba =1;
                            abajo=0;
                            izq=0;
                            der=0;
                       }
                    }
                
                if(e.getKeyCode() == KeyEvent.VK_DOWN)//MOVER TECLA ABAJO
                    {
                       // System.out.println("Tecla hacia abajo");
                       if(mat[px][py+1]==1 || mat[px][py+1]==0 ){ 
                            arriba =0;
                            abajo=1;
                            izq=0;
                            der=0;
                       }
                    }
                
                if(e.getKeyCode() == KeyEvent.VK_LEFT)//MOVER TECLA IZQUIERDA
                    {
                        //System.out.println("Tecla hacia izquierda");
                       if(mat[px-1][py]==1 || mat[px-1][py]==0 ){ 
                            arriba =0;
                            abajo=0;
                            izq=1;
                            der=0; 
                        }
                    }
                
                if(e.getKeyCode() == KeyEvent.VK_RIGHT)//MOVER TECLA DERECHA
                    {
                       // System.out.println("Tecla hacia derecha");
                       
                      if(mat[px+1][py]==1 || mat[px+1][py]==0 ){ 
                        arriba =0;
                        abajo=0;
                        izq=0;
                        der=1;
                      }
                    }
                
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
            @Override
            public void keyReleased(KeyEvent e) {//PRESIONAR TECLA Y LA SUELTA
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    
    
    }
    
    public void menu(){
     
    
        //PANEL
         PanelPresentacion.setVisible(false);
         PanelMenu = new JPanel();
         PanelMenu.setLayout(null);
         PanelMenu.setBounds(0, 0,ventana.getWidth() , ventana.getHeight());
         PanelMenu.setVisible(true);
         
                
        //FONDO
         fondoMenu = new JLabel();
         fondoMenu.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
         ImagenFondoMenu = new ImageIcon(getClass().getResource("/Imagenes/fondojuego.png"));
         //ImagenFondoMenu = new ImageIcon("src/Imagenes/fondojuego.png");
         ImagenFondoMenu = new ImageIcon(ImagenFondoMenu.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
         fondoMenu.setIcon(ImagenFondoMenu);
         fondoMenu.setVisible(true);
         PanelMenu.add(fondoMenu);
            
         botones[0].setText("Jugar Nivel 1");
         botones[1].setText("Jugar Nivel 2");
         botones[2].setText("Jugar Nivel 3");
         botones[3].setText("Ayuda");
         botones[4].setText("Salir");
         
         for (int i = 0; i < botones.length; i++) {
             
            botones[i].setBounds(ventana.getWidth()-(200+50), (i+1)*50, 200, 40);
            botones[i].setVisible(true);
            botones[i].setBackground(Color.white);
            PanelMenu.add(botones[i],0);
            
        }
         ventana.add(PanelMenu);
         
    
    }
   

    //FOTOS ESTUDIANTES    
    public void FotosEs(){
      FotosEstudiantes f = new FotosEstudiantes();
      f.setLocationRelativeTo(null);
      f.setTitle("Integrantes del grupo");
      f.setVisible(true);
      
      ventana.setVisible(false);
        
    }
       
    public void eventoMenu()
        {
         //boton jugar
         botones[0].addMouseListener(new MouseAdapter() {
         
            public void mousePressed(MouseEvent e)
                       {
                          jugador = JOptionPane.showInputDialog(ventana,"Nombre del jugador","Escribe aqui");
                          while(jugador==null || jugador.compareTo("Escribe aqui")==0 || jugador.compareTo("")==0)
                            {
                                jugador = JOptionPane.showInputDialog(ventana,"Debes ingresar usuarios","Escribe aqui");
                            }
                          //nivel_1();
                          jugar();
                          
                          
                          
                          
                       }
       
         });
         //boton load,nivel 2
         botones[1].addMouseListener(new MouseAdapter() {
         
            public void mousePressed(MouseEvent e)
                       {
                          jugador = JOptionPane.showInputDialog(ventana,"Nombre del jugador","Escribe aqui");
                          while(jugador==null || jugador.compareTo("Escribe aqui")==0 || jugador.compareTo("")==0)
                            {
                                jugador = JOptionPane.showInputDialog(ventana,"Debes ingresar usuarios","Escribe aqui");
                            }
                          nivel_2();
                          jugar();
                          //fantasma2 = new Fantasmas(8,6);
                       }
         });
         
         //boton Score, nivel 3
         botones[2].addMouseListener(new MouseAdapter() {
         
            public void mousePressed(MouseEvent e)
                       {
                          jugador = JOptionPane.showInputDialog(ventana,"Nombre del jugador","Escribe aqui");
                          while(jugador==null || jugador.compareTo("Escribe aqui")==0 || jugador.compareTo("")==0)
                            {
                                jugador = JOptionPane.showInputDialog(ventana,"Debes ingresar usuarios","Escribe aqui");
                               
                            }
                            nivel_3();
                            jugar();
                            //fantasma3 = new Fantasmas(8,6);
                       }
         });
         //BOTON ESTUDIANTES
         botones[3].addMouseListener(new MouseAdapter() {
         
            public void mousePressed(MouseEvent e)
                       {
                         
                         
                       }
         });
         //boton exit
         botones[4].addMouseListener(new MouseAdapter() {
         
            public void mousePressed(MouseEvent e)
             {
                  String Option[] ={"Salir","Cancelar"};
                  int eleccion;
                  eleccion = JOptionPane.showOptionDialog(null, "Quieres SALIR de PACMAN? ","PACMAN", WIDTH, HEIGHT, null, Option, NORMAL);
                       
                  if(eleccion==JOptionPane.YES_OPTION)
                    {
                       System.exit(0); 
                    }
                  else
                    {   
                        menu();
                        
                    }
                  
                           
                      
              }
         });
         
         
      
        }
    
}
