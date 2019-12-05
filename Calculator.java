import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener, KeyListener{
	private static final char VK_PLUS = 0;
	private static final char VK_MULTIPLY = 0;
	private JPanel p1,p2,p3,p4,p5,p6;
	private String[] labels = {"C","7","8","9","/","4","5","6","*","1","2","3","-","0","        =         ","+"};
	private JButton[] buttons = new JButton[16]; 
	private JTextField t1;
	private String ss;
	private int etc,sum;
	private double sum2;
	private char nl;
	
	public Calculator() {	// 생성자
		setSize(250,250);	
		setTitle("계산기");	
		p1 = new JPanel();
		setLayout(new GridLayout(6,4,0,0));
		addKeyListener(this);
		
		//버튼에 레이블값을 차례대로 저장한다.
		for(int num = 0; num <16; num++) {
			buttons[num] = new JButton(labels[num]);
		}
		
		//텍스트 칸을 만들어 준다.
		t1 = new JTextField(20);
		t1.setHorizontalAlignment(JTextField.RIGHT);
		
		//각각의 버튼마다 액션과 키가 작동할 수 있게 해준다.
		for(int num = 0; num < 16; num++) {
			buttons[num].addActionListener(this);
			buttons[num].addKeyListener(this);
		}
		
		//버튼들의 위치를 지정해준다.
		p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT, 21,0));
		
		p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER, 10,0));
		
		p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.CENTER, 10,0));
		
		p5 = new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.CENTER, 10,0));
		
		p6 = new JPanel();
		p6.setLayout(new FlowLayout(FlowLayout.CENTER, 10,0));
		
		//버튼들을 창에 띄워준다.
		p1.add(t1);
		add(p1);
		p2.add(buttons[0]);
		add(p2);
		p3.add(buttons[1]);
		p3.add(buttons[2]);
		p3.add(buttons[3]);
		p3.add(buttons[4]);
		add(p3);
		
		p4.add(buttons[5]);
		p4.add(buttons[6]);
		p4.add(buttons[7]);
		p4.add(buttons[8]);
		add(p4);
		
		p5.add(buttons[9]);
		p5.add(buttons[10]);
		p5.add(buttons[11]);
		p5.add(buttons[12]);
		add(p5);
		
		p6.add(buttons[13]);
		p6.add(buttons[14]);
		p6.add(buttons[15]);
		add(p6);
		setVisible(true);
		
		
	}
	
	//마우스로 각각의 버튼을 누를때마다 이벤트를 발생하게 한다.
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == buttons[0])
			 t1.setText("");
		 else if (e.getSource() == buttons[1]) 
			 t1.setText(t1.getText()+7);
		 else if (e.getSource() == buttons[2]) 
			 t1.setText(t1.getText()+8);
		 else if (e.getSource() == buttons[3]) 
			 t1.setText(t1.getText()+9);
		 else if (e.getSource() == buttons[5]) 
			 t1.setText(t1.getText()+4);
		 else if (e.getSource() == buttons[6]) 
			 t1.setText(t1.getText()+5);
		 else if (e.getSource() == buttons[7]) 
			 t1.setText(t1.getText()+6);
		 else if (e.getSource() == buttons[9]) 
			 t1.setText(t1.getText()+1);
		 else if (e.getSource() == buttons[10]) 
			 t1.setText(t1.getText()+2);
		 else if (e.getSource() == buttons[11]) 
			 t1.setText(t1.getText()+3);
		 else if (e.getSource() == buttons[13]) 
			 t1.setText(t1.getText()+0);
		 
		 //부호를 눌렀을때 그값을 저장하고 변수에 부호를 저장한다.
		 else if (e.getSource() == buttons[4]) {
			 etc = Integer.parseInt(t1.getText());
			 t1.setText("");
			 ss = "/";
		 }
		 else if (e.getSource() == buttons[8]) {
			 etc = Integer.parseInt(t1.getText());
			 t1.setText("");
			 ss = "*";
		 }
		 else if (e.getSource() == buttons[12]) {
			 etc = Integer.parseInt(t1.getText());
			 t1.setText("");
			 ss = "-";
		 }
		 else if (e.getSource() == buttons[15]) {
			 etc = Integer.parseInt(t1.getText());
			 t1.setText("");
			 ss = "+";
		 }
		 
		 //"="버튼을 눌렀을때 전에 사용했던 부호들의 계산을 할 수 있게해준다.
		 else if (e.getSource() == buttons[14]) {// "="을 눌렀을때
			
			 if(ss.equals("/")) {
				 sum2 = Double.valueOf(t1.getText());
				 t1.setText(Double.toString((double)etc/sum2));
				 
			 }
			 else if(ss.equals("*")) {
				 sum = Integer.parseInt(t1.getText())*etc;
				 t1.setText(Integer.toString(sum));
			 }
			 else if(ss.equals("-")) {
				 sum = etc-Integer.parseInt(t1.getText());
				 t1.setText(Integer.toString(sum));
			 }
			 else if(ss.equals("+")) {
				 sum = Integer.parseInt(t1.getText())+etc;
				 t1.setText(Integer.toString(sum));
			 }
		 }
		 
	}
	//위에 마우스를 누를때와 같이 키를 누를때 같은 이벤트를 발생시킨다.
	@Override
	public void keyPressed(KeyEvent e) {
		nl = e.getKeyChar();
		if(nl == '0') {
			 t1.setText(t1.getText()+0);
		}
		else if (nl == '1') {
			t1.setText(t1.getText()+1);
		}
		else if (nl == '2') {
			t1.setText(t1.getText()+2);
		}
		else if (nl == '3') {
			t1.setText(t1.getText()+3);
		}
		
		else if (nl == '4') {
			t1.setText(t1.getText()+4);
		}
		else if (nl == '5') {
			t1.setText(t1.getText()+5);
		}
		else if (nl == '6') {
			t1.setText(t1.getText()+6);
		}
		else if (nl == '7') {
			t1.setText(t1.getText()+7);
		}
		else if (nl == '8') {
			t1.setText(t1.getText()+8);
		}
		else if (nl == '9') {
			t1.setText(t1.getText()+9);
		}
		
		//부호를 눌렀을때 그값을 저장하고 변수에 부호를 저장한다.
		else if (nl == '+') {
			 etc = Integer.parseInt(t1.getText());
			 t1.setText("");
			 ss = "+";
		}
		else if (nl == '-') {
			 etc = Integer.parseInt(t1.getText());
			 t1.setText("");
			 ss = "-";
		}
		else if (nl == '/') {
			 etc = Integer.parseInt(t1.getText());
			 t1.setText("");
			 ss = "/";
		}
		else if (nl == '*') {
			 etc = Integer.parseInt(t1.getText());
			 t1.setText("");
			 ss = "*";
		}
		
		//엔터 키를 눌렀을때 전에 사용했던 부호들의 계산을 할 수 있게해준다.
		else if (nl == KeyEvent.VK_ENTER) {
			if(ss.equals("/")) {
				 sum2 = Double.valueOf(t1.getText());
				 t1.setText(Double.toString((double)etc/sum2));
				 
			 }
			 else if(ss.equals("*")) {
				 sum = Integer.parseInt(t1.getText())*etc;
				 t1.setText(Integer.toString(sum));
			 }
			 else if(ss.equals("-")) {
				 sum = etc-Integer.parseInt(t1.getText());
				 t1.setText(Integer.toString(sum));
			 }
			 else if(ss.equals("+")) {
				 sum = Integer.parseInt(t1.getText())+etc;
				 t1.setText(Integer.toString(sum));
			 }
		}
		else if(nl == KeyEvent.VK_ESCAPE) {
			t1.setText("");
		}
	}

	//메인함수, 계산기함수를 실행 시킨다.
	public static void main(String[] args) {
		Calculator c = new Calculator();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
