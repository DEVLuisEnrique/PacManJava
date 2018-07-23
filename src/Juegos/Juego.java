
package Juegos;

import java.awt.Color;
import static java.awt.Frame.NORMAL;
import java.awt.Image;
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


public class Juego {
    
     //Atributos
    JFrame ventana;
    JPanel PanelPresentacion; 
    JButton  iniciar;
    JLabel fondopresentacion;
    ImageIcon ImagenFondoPrese;
    
    //variable de menu
    JPanel PanelMenu; 
    JButton  botones[];
    JLabel fondoMenu;
    ImageIcon ImagenFondoMenu;
    
    public Juego()//COSNTRUCTOR
        {
        //VENTANA
         ventana  = new JFrame("PacMan");
         ventana.setSize(700, 700);
         ventana.setLayout(null);
         ventana.setLocationRelativeTo(null);
         ventana.setResizable(false);
         ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         //PANEL
         PanelPresentacion = new JPanel();
         PanelPresentacion.setLayout(null);
         PanelPresentacion.setBounds(0, 0,ventana.getWidth() , ventana.getHeight());
         PanelPresentacion.setVisible(true);
         PanelPresentacion.setBackground(Color.red);
         
         //BOTON
         iniciar = new JButton("Iniciar");
         iniciar.setVisible(true);
         iniciar.setBounds(ventana.getWidth()-120, 20, 100, 30);
         iniciar.setBackground(Color.WHITE);
         PanelPresentacion.add(iniciar);
         
        //FONDO
         fondopresentacion = new JLabel();
         fondopresentacion.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
         ImagenFondoPrese = new ImageIcon(getClass().getResource("/Imagenes/fondo1.png"));
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
         
            public void mousePressed(MouseEvent e)
                       {
                          menu();
                          eventoMenu();
                       }
         
         
         
         });
                
        
         /****************/
         ventana.add(PanelPresentacion);
         ventana.setVisible(true);
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
         ImagenFondoMenu = new ImageIcon(getClass().getResource("/Imagenes/fondo1.png"));
         ImagenFondoMenu = new ImageIcon(ImagenFondoMenu.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
         fondoMenu.setIcon(ImagenFondoMenu);
         fondoMenu.setVisible(true);
         PanelMenu.add(fondoMenu);
            
         botones[0].setText("Play");
         botones[1].setText("Load");
         botones[2].setText("Score");
         botones[3].setText("Ladenboar");
         botones[4].setText("Exit");
         
         for (int i = 0; i < botones.length; i++) {
            botones[i].setBounds(ventana.getWidth()-(200+50), (i+1)*50, 200, 40);
            botones[i].setVisible(true);
            botones[i].setBackground(Color.white);
            PanelMenu.add(botones[i]);
            
        }
         ventana.add(PanelMenu);
         
    
    }
   
    
    
    public void eventoMenu()
        {
         //boton jugar
         botones[0].addMouseListener(new MouseAdapter() {
         
            public void mousePressed(MouseEvent e)
                       {
                          
                       }
       
         });
         //boton load
         botones[1].addMouseListener(new MouseAdapter() {
         
            public void mousePressed(MouseEvent e)
                       {
                          
                       }
         });
         
         //boton Score
         botones[2].addMouseListener(new MouseAdapter() {
         
            public void mousePressed(MouseEvent e)
                       {
                          
                       }
         });
         //boton laderboar
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
