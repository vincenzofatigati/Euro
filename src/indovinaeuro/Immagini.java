package indovinaeuro;

/**
 * indovinare le Banconote degli Euro
 * @author vincenzo F
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Immagini extends JFrame implements ActionListener
 {
 static String arrEuro[] = new String[5];
 private JPanel pan = new JPanel();
 private JPanel panNomi = new JPanel();
 private JRadioButton rbEuro[] = new JRadioButton[5];
 private ButtonGroup bg = new ButtonGroup();
 private JLabel imgEuro = new JLabel();
 private JPanel panPulsanti = new JPanel();
 private JButton btnUscita = new JButton("Uscita");
  public Immagini()
 {
 arrEuro[0] = "Cinquanta Euro";
 arrEuro[1] = "Cinque Euro";
 arrEuro[2] = "Dieci Euro";
 arrEuro[3] = "Cento Euro";
 arrEuro[4] = "Venti Euro";
 pan.setLayout(new BorderLayout());
 panNomi.setLayout(new GridLayout(5,1));
 // crea i pulsanti di opzione, li aggiunge al gruppo
 // e imposta la stringa di comando per l'evento sul pulsante
 for (int i=0; i<5; i++)
 {
rbEuro[i] = new JRadioButton(arrEuro[i]);
bg.add(rbEuro[i]);
rbEuro[i].setActionCommand(arrEuro[i]);
 }
 // imposta la prima opzione come preselezionata
 rbEuro[0].setSelected(true);
 imgEuro.setIcon(new ImageIcon("\"C:\\Users\\vince\\OneDrive\\Documenti\\NetBeansProjects\\IndovinaEuro\\images\"" + arrEuro[0] + ".jpg\""));
 // imposta la stringa di comando per l'evento sul pulsante di uscita
 btnUscita.setActionCommand("uscita");
 // registra gli ascoltatori per i pulsanti
 for (int i=0; i<5; i++) rbEuro[i].addActionListener(this);
 btnUscita.addActionListener(this);
 // inserisce le componenti nei pannelli
 for (int i=0; i<5; i++) panNomi.add(rbEuro[i]);
 panPulsanti.add(btnUscita);
 pan.add(panNomi, "West");
 pan.add(imgEuro, "Center");
 pan.add(panPulsanti,"South");
 // aggiunge il pannello al frame
 this.getContentPane().add(pan, BorderLayout.CENTER);
 // controlla l'uscita dal programma quando la finestra viene chiusa
 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
 // gestione degli eventi
 public void actionPerformed(ActionEvent e)
 {
 if ("uscita".equals(e.getActionCommand()))
 {int n = JOptionPane.showConfirmDialog(null,
 "Sei sicuro di voler uscire dal programma?",
 "Uscita dal programma",
 JOptionPane.YES_NO_OPTION);
 if (n == JOptionPane.YES_OPTION)
 {
System.exit(0);
 }
 }
 else
 {
imgEuro.setIcon(new ImageIcon("images/" + e.getActionCommand() + ".jpg"));
String messaggio = "Banconota: " + e.getActionCommand();
JOptionPane.showMessageDialog(null,
 messaggio,
 "Conferma",
 JOptionPane.INFORMATION_MESSAGE);
 }
 }
}
