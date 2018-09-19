package spark;

import java.awt.GridBagLayout;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

@SuppressWarnings("serial")
public class TweetsConsole extends JFrame
{

	JTextArea console;
	JScrollPane sp_console;

	/**
	 * Default Constructor to set 
	 * the size,title,Location of Frame
	 * Background Color, Foreground Color
	 * DefaultCloseOperation, Layout
	 * scroll pane,TextArea
	 * Representation of Entire 
	 * Output Redirection 
	 * whenever you click any event 
	 * occurs in a Java UI
	 */
	TweetsConsole()
	{
		setSize(800,550);
		setTitle("Retreiving Tweets");
		setLocationRelativeTo(null);
		setBackground(new java.awt.Color(255, 165, 0));
		setForeground(new java.awt.Color(255, 12, 26));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridBagLayout());

		console = new javax.swing.JTextArea();
		console.setColumns(70);
		console.setRows(25);

		console.setText("Console Output... \n");
		sp_console = new javax.swing.JScrollPane(console);
		add(sp_console);

		/*
		 * Setting the Output Stream 
		 * 
		 * */
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

	public class JTextAreaOutputStream extends OutputStream
	{
		JTextArea ta;
		
		/*
		 * Parameterized Constructor 
		 * where we pass JTextArea Object
		 */
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
	/*
	 * function to write console log to 
	 * JTextArea or We can simply term
	 * this as an Output Redirection 
	 */
	public void writeLog() {

		Tweets.main(new String[] {});       
		console.setCaretPosition(console.getDocument().getLength()); 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame obj = new TweetsConsole();
		obj.setVisible(true);

	}
}
