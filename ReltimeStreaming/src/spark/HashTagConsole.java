package spark;

import java.awt.GridBagLayout;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

@SuppressWarnings("serial")
public class HashTagConsole extends JFrame
{

	JTextArea console;
	JScrollPane sp_console;

	HashTagConsole()
	{

		setSize(800,550);
		setTitle("Popular Hash Tags");
		setLocationRelativeTo(null);
		setForeground(new java.awt.Color(255, 12, 26));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridBagLayout());

		console = new javax.swing.JTextArea();
		console.setColumns(70);
		console.setRows(25);

		console.setText("Console Output...");
		System.out.println("\n");

		sp_console = new javax.swing.JScrollPane(console);

		add(sp_console);

		System.setOut(new PrintStream(new JTextAreaOutputStream(console)));
		System.setErr(new PrintStream(new JTextAreaOutputStream(console)));

		new Thread(new Runnable() {
			public void run() {
				try {
					writeLog();
				} catch (Exception ie) { }
			}
		}).start();
	}

	//inner class
	public class JTextAreaOutputStream extends OutputStream
	{
		JTextArea ta;
		//caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		public JTextAreaOutputStream(JTextArea t) {
			super();
			ta = t;
			ta.setCaretPosition(ta.getDocument().getLength());
			DefaultCaret caret = (DefaultCaret)ta.getCaret();
			caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		}

		public void write(int i) {
			ta.append(Character.toString((char)i));
		}

		public void write(char[] buf, int off, int len) {
			String s = new String(buf, off, len);
			ta.append(s);
		}

	}
	//function to write console log
	public void writeLog() {

		TopHashTags.main(new String[] {});       
		console.setCaretPosition(console.getDocument().getLength());
		//UI.authentication();
		// Tweets.main();
		//Tweets.main(null); Tweets.main(new String[] {}); 
		//just taking pause of 50ms
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}


	public static void main(String[] args) {
		JFrame obj = new HashTagConsole();
		obj.setVisible(true);

	}
}