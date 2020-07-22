import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;


public class Ahorcado  extends JFrame implements ActionListener{
	
	private JPanel componentes;
	private JButton reiniciar, inicio, validar, salir;
	private JLabel etiqueta, et2;
	private JTextField letra, palabra, intentos;
	private Pintar grafico;
	private Palabras p;
	private int vidas, cont;
	
	public Ahorcado() {
		super("Juego del Ahorcado");
		setLayout(new BorderLayout(1,1));
		setSize(600,600);
		agregarElementos();
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vidas=0;
	}
	
	public void agregarElementos() {
		grafico = new Pintar();
		grafico.setBackground(Color.WHITE);
        add(grafico,BorderLayout.CENTER);
        
        //Panel donde estaran los elementos
        componentes = new JPanel();
        componentes.setBackground(Color.cyan);
        componentes.setLayout(null);
        
        reiniciar = new JButton("Reinicar Juego");
        inicio = new JButton("Inicar Juego");
        validar = new JButton("Validar Letra");
        salir = new JButton("SALIR");
        
        etiqueta = new JLabel("Palabra");
        et2 = new JLabel("Intentos");
        palabra = new JTextField("");
        intentos = new JTextField(""+cont);
        letra = new JTextField("");
        
        //Colocando elementos en el panel
        reiniciar.setBounds(30,400,150,30);
        etiqueta.setBounds(250,400,100,30);
        palabra.setBounds(300,400,150,30);
        et2.setBounds(250,460,100,30);       
        intentos.setBounds(300,460,150,30);
        inicio.setBounds(30,450,150,30);
        validar.setBounds(30,500,150,30);
        letra.setBounds(200,500,50,30);
        salir.setBounds(430,500,150,30);
        
        reiniciar.addActionListener(this);
        inicio.addActionListener(this);
        validar.addActionListener(this);
        salir.addActionListener(this);
        
        componentes.add(reiniciar);
        componentes.add(inicio);
        componentes.add(validar);
        componentes.add(salir);
        componentes.add(letra);
        componentes.add(etiqueta);
        componentes.add(et2);
        componentes.add(palabra);
        componentes.add(intentos);
        add(componentes,BorderLayout.CENTER);
        
	}
	 public void actionPerformed(ActionEvent evento) 
	    {
	        if(evento.getSource() == reiniciar)
	        {
	            grafico.error(0);
	            palabra.setText("");
	            intentos.setText("");
	            letra.setText("");
	            vidas = 0;
	        }
	        else if(evento.getSource() == inicio)
	        {
	            grafico.error(0);
	            p = new Palabras();
	            String aux="";
	            int contador =0, c=p.getElegida().length();
	            //intentos.setText("numero de intentos: "+c);
	            while(contador < p.getElegida().length())
	            {		            
	                aux+="*";
	                contador++;
	               
	                 
	            }
	            
	            palabra.setText(aux);

	        }
	        else if(evento.getSource() == validar)
	        {
	            String l="";
	           
	            l = letra.getText();
	            char c = l.charAt(0);
	            if(p.comparar(c).equals(p.getElegida()))
	            { 
	                palabra.setText(p.comparar(c));
	                
	                
	                JOptionPane.showMessageDialog(null,"Ganaste");
	            }
	            else if(vidas == 6)
	            {
	                JOptionPane.showMessageDialog(null,"Has perdido");
	            }
	            else if(p.getBandera() == 1)
	            {
	                palabra.setText(p.comparar(c));
	            }
	            else if(p.getBandera() == 0)
	            {
	                vidas = vidas + 1;
	                cont++;
	              intentos.setText(""+cont);
	                grafico.error(vidas);
	            }
	        }
	        else if(evento.getSource() == salir)
	        {
	            System.exit(0);
	        }
	    }
}
