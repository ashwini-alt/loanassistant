import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
public class loan extends JFrame
{
	JLabel balance=new JLabel();
	JTextField balance_textfield=new JTextField();
	JLabel interest=new JLabel();
	JTextField interest_textfield=new JTextField();
	JLabel months=new JLabel();
	JTextField months_textfield=new JTextField();
	JLabel payment=new JLabel();
	JTextField payment_textfield=new JTextField();
	JButton compute_button = new JButton();
	JButton newloan_button = new JButton();
	JButton months_button=new JButton();
	JButton payment_button=new JButton();
	JLabel analysis=new JLabel();
	JTextArea analysis_textfield=new JTextArea();
	JButton exit_button=new JButton();
	Font myfont=new Font("Times New Roman",Font.PLAIN,18);
	Color c=new Color(255,255,128);
	boolean compute_payment;
	
public static void main(String args[])
{
// create frame
new loan().show();
}
public loan()
{
// frame constructor
setTitle("Loan Assistant");
setResizable(true);
addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent evt)
{

	System.exit(0);
}
});
//pack();
//Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
//setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height- getHeight())), getWidth(), getHeight());
setLayout(new FlowLayout());
setSize(800,800);
getContentPane().setLayout(new GridBagLayout());
GridBagConstraints gc;

balance.setText("Loan Balance:");
balance.setFont(myfont);
gc=new GridBagConstraints();
gc.gridx=0;
gc.gridy=0;
gc.anchor=GridBagConstraints.WEST;
gc.insets=new Insets(10,10,0,0);
getContentPane().add(balance,gc);

balance_textfield.setPreferredSize(new Dimension(150,25));
balance_textfield.setHorizontalAlignment(SwingConstants.RIGHT);
balance_textfield.setFont(myfont);
gc=new GridBagConstraints();
gc.gridx=1;
gc.gridy=0;
gc.insets=new Insets(10,10,0,10);
getContentPane().add(balance_textfield,gc);
balance_textfield.addActionListener(new ActionListener ()
{
public void actionPerformed(ActionEvent e)
{
balance_textfieldActionPerformed(e);
}

private void balance_textfieldActionPerformed(ActionEvent e) {
	balance_textfield.transferFocus();
	
}
});

interest.setText("Interest Rate:");
interest.setFont(myfont);
gc=new GridBagConstraints();
gc.gridx=0;
gc.gridy=1;
gc.anchor=GridBagConstraints.WEST;
gc.insets=new Insets(10,10,0,0);
getContentPane().add(interest,gc);

interest_textfield.setPreferredSize(new Dimension(150,25));
interest_textfield.setHorizontalAlignment(SwingConstants.RIGHT);
interest_textfield.setFont(myfont);
gc=new GridBagConstraints();
gc.gridx=1;
gc.gridy=1;
gc.insets=new Insets(10,10,0,10);
getContentPane().add(interest_textfield,gc);
interest_textfield.addActionListener(new ActionListener ()
{
public void actionPerformed(ActionEvent e)
{
interest_textfieldActionPerformed(e);
}

private void interest_textfieldActionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	interest_textfield.transferFocus();
}
});

months.setText("Number of Payments:");
months.setFont(myfont);
gc=new GridBagConstraints();
gc.gridx=0;
gc.gridy=2;
gc.anchor=GridBagConstraints.WEST;
gc.insets=new Insets(10,10,0,0);
getContentPane().add(months,gc);

months_textfield.setPreferredSize(new Dimension(150,25));
months_textfield.setHorizontalAlignment(SwingConstants.RIGHT);
months_textfield.setFont(myfont);
gc=new GridBagConstraints();
gc.gridx=1;
gc.gridy=2;
gc.insets=new Insets(10,10,0,10);
getContentPane().add(months_textfield,gc);
months_textfield.addActionListener(new ActionListener ()
{
public void actionPerformed(ActionEvent e)
{
months_textfieldActionPerformed(e);
}
private void  months_textfieldActionPerformed(ActionEvent ae) {
	months_textfield.transferFocus();
}

});

payment.setText("Monthly Payment:");
payment.setFont(myfont);
gc=new GridBagConstraints();
gc.gridx=0;
gc.gridy=3;
gc.anchor=GridBagConstraints.WEST;
gc.insets=new Insets(10,10,0,0);
getContentPane().add(payment,gc);

payment_textfield.setPreferredSize(new Dimension(150,25));
payment_textfield.setHorizontalAlignment(SwingConstants.RIGHT);
payment_textfield.setFont(myfont);
gc=new GridBagConstraints();
gc.gridx=1;
gc.gridy=3;
gc.insets=new Insets(10,10,0,10);
getContentPane().add(payment_textfield,gc);
payment_textfield.addActionListener(new ActionListener ()
{
public void actionPerformed(ActionEvent e)
{
payment_texfieldActionPerformed(e);
}
private void  payment_texfieldActionPerformed(ActionEvent ae) {
	payment_textfield.transferFocus();
}
});


compute_button.setText("Compute monthly payment");
compute_button.setFocusable(false);
gc=new GridBagConstraints();
gc.gridx=0;
gc.gridy=4;
gc.gridwidth=2;
gc.insets=new Insets(30,0,0,0);
getContentPane().add(compute_button,gc);
compute_button.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent ae) {
		compute_action_performed(ae);
	}

	private void compute_action_performed(ActionEvent ae) {
		double balance1, interest1, payment1;
		int months1;
		double monthlyInterest, multiplier;
		double loanBalance, finalPayment;
		if(validatedecimal(balance_textfield)) {
		balance1 =Double.valueOf(balance_textfield.getText()).doubleValue();
		}
		else {
JOptionPane.showConfirmDialog(null, "Invalid or Empty LoanBalance.\n please correct.", "Balance Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
			return;}
		if(validatedecimal(interest_textfield)) {
		interest1 =Double.valueOf(interest_textfield.getText()).doubleValue();
		}
		else {
JOptionPane.showConfirmDialog(null, "Invalid or Empty Interest.\n please correct.", "Inyerest Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
			return;}
		monthlyInterest = interest1 / 1200;
		// Compute loan payment
		if(compute_payment) {
			if(validatedecimal(months_textfield)) {
		months1 =Integer.valueOf(months_textfield.getText()).intValue();}
			else {
JOptionPane.showConfirmDialog(null, "Invalid or Empty Number of payments.\n please correct.", " number of payment Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				return;}
		if (interest1 == 0)
		{
		payment1 = balance1 / months1;
		}
		else
		{

		multiplier = Math.pow(1 + monthlyInterest, months1);
		payment1 = balance1 * monthlyInterest * multiplier / (multiplier - 1);
		}
		payment_textfield.setText(new DecimalFormat("0.00").format(payment1));	
		}
		else
		{
		// Compute number of payments
			if(validatedecimal(payment_textfield)) {
		payment1 =Double.valueOf(payment_textfield.getText()).doubleValue();
		if (payment1 <= (balance1 * monthlyInterest + 1.0))
		{
		if (JOptionPane.showConfirmDialog(null, "Minimum payment must be $" +new DecimalFormat("0.00").format((int)(balance1 * monthlyInterest + 1.0)) + "\n" + "Do you want to use the minimum payment?", "Input Error", JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
		{
		payment_textfield.setText(new DecimalFormat("0.00").format((int)
		(balance1 * monthlyInterest + 1.0)));
		payment1 =Double.valueOf(payment_textfield.getText()).doubleValue();
		}
		else
		{
		payment_textfield.requestFocus();
		return;
		}
		}

		}
			else {
				JOptionPane.showConfirmDialog(null, "Invalid or Empty monthly payment.\n please correct.", "monthly payment Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);				
				return;}
		if (interest1 == 0)
		{
		months1 = (int)(balance1 / payment1);
		}
		else
		{
		months1 = (int)((Math.log(payment1) - Math.log(payment1 - balance1 * monthlyInterest))
		/ Math.log(1 + monthlyInterest));}
		months_textfield.setText(String.valueOf(months1));
		}
		if(validatedecimal(payment_textfield)) {
		payment1 =Double.valueOf(payment_textfield.getText()).doubleValue();}
		else {return;}
				// show analysis
				analysis_textfield.append("Loan Balance: " + new DecimalFormat("0.00").format(balance1));
				analysis_textfield.append("\n" + "Interest Rate: " + new DecimalFormat("0.00").format(interest1) + "%");
				// process all but last payment
				loanBalance = balance1;
				for (int paymentNumber = 1; paymentNumber <= months1 - 1; paymentNumber++)
				{
				loanBalance += loanBalance * monthlyInterest - payment1;
				}
				// find final payment
				finalPayment = loanBalance;
				if (finalPayment > payment1)
				{
				// apply one more payment
				loanBalance += loanBalance * monthlyInterest - payment1;
				finalPayment = loanBalance;
				months1++;
				
				months_textfield.setText(String.valueOf(months1));
				}
				analysis_textfield.append("\n\n" + String.valueOf(months1 - 1) + " Payments of " + new DecimalFormat("0.00").format(payment1));
				analysis_textfield.append("\n" + "Final Payment of: " + new DecimalFormat("0.00").format(finalPayment));
				analysis_textfield.append("\n" + "Total Payments: " + new DecimalFormat("0.00").format((months1 - 1) * payment1 + finalPayment));
				analysis_textfield.append("\n" + "Interest Paid " + new DecimalFormat("0.00").format((months1 - 1) * payment1 + finalPayment - balance1));
				compute_button.setEnabled(false);
				newloan_button.setEnabled(true);
				newloan_button.requestFocus();
	}

	private boolean validatedecimal(JTextField tf) {
		String s=tf.getText().trim();
		boolean hasdecimal=false;
		boolean valid=true;
		if(s.length()==0) {
			valid=false;
		}
		else {
			for(int i=0;i<s.length();i++) {
				char c1=s.charAt(i);
				if(c1>='0' && c1<='9') {
					continue;
				}
				else if(c1=='.' && !hasdecimal) {
					hasdecimal=true;
				}
				else {
					valid=false;
				}
			}
		}
		tf.setText(s);
		if(!valid) { 
			tf.requestFocus();
		}
		return(valid);
	
		
	}
});

newloan_button.setText("New Loan Analysis");
newloan_button.setFocusable(false);
gc=new GridBagConstraints();
gc.gridx=0;
gc.gridy=5;
gc.gridwidth=2;
gc.insets=new Insets(20,0,0,0);
getContentPane().add(newloan_button,gc);
newloan_button.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent ae) {
		newloan_action_performed(ae);
	}

	private void newloan_action_performed(ActionEvent ae) {
		if (compute_payment)
		{
		payment_textfield.setText("");
		}
		else
		{
		months_textfield.setText("");
		}
		analysis_textfield.setText("");
		compute_button.setEnabled(true);
		newloan_button.setEnabled(false);
		balance_textfield.requestFocus();
		
	}
});

months_button.setText("X");
months_button.setFocusable(false);
gc=new GridBagConstraints();
gc.gridx=2;
gc.gridy=2;
gc.gridwidth=1;
gc.insets=new Insets(10,10,0,0);
getContentPane().add(months_button,gc);
months_button.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent ae) {
		months_action_performed(ae);
	}

	private void months_action_performed(ActionEvent ae) {
		compute_payment=false;
		payment_button.setVisible(true);
		months_button.setVisible(false);
		months_textfield.setEditable(false);
		months_textfield.setFocusable(false);
		payment_textfield.setEditable(true);
		months_textfield.setBackground(c);
		months_textfield.setText("");
		payment_textfield.setBackground(Color.WHITE);
		payment_textfield.setFocusable(true);
		compute_button.setText("Compute Num of payments");
		balance_textfield.requestFocus();
	}
});

payment_button.setText("X");
payment_button.setFocusable(false);
gc=new GridBagConstraints();
gc.gridx=2;
gc.gridy=3;
gc.gridwidth=1;
gc.insets=new Insets(10,10,0,0);
getContentPane().add(payment_button,gc);
payment_button.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent ae) {
		payment_action_performed(ae);
	}

	private void payment_action_performed(ActionEvent ae) {
	compute_payment=true;
	payment_button.setVisible(false);
	months_button.setVisible(true);
	months_textfield.setEditable(true);
	months_textfield.setFocusable(true);
	payment_textfield.setEditable(false);
	months_textfield.setBackground(Color.WHITE);
	payment_textfield.setText("");
	payment_textfield.setFocusable(false);
	payment_textfield.setBackground(c);
	compute_button.setText("Compute Monthly payment");
	balance_textfield.requestFocus();
	}
});

analysis.setText("Loan Analysis:");
analysis.setFont(myfont);
gc=new GridBagConstraints();
gc.gridx=3;
gc.gridy=0;
gc.anchor=GridBagConstraints.WEST;
gc.insets=new Insets(0,10,0,0);
getContentPane().add(analysis,gc);

analysis_textfield.setPreferredSize(new Dimension(250,150));
analysis_textfield.setFocusable(false);
analysis_textfield.setBorder(BorderFactory.createLineBorder(Color.BLACK));
analysis_textfield.setFont(new Font("Courier New",Font.PLAIN,14));
analysis_textfield.setEditable(false);
analysis_textfield.setBackground(Color.WHITE);

gc=new GridBagConstraints();
gc.gridx=3;
gc.gridy=1;
gc.gridheight=4;
gc.insets=new Insets(0,10,0,10);
getContentPane().add(analysis_textfield,gc);

exit_button.setText("Exit");
exit_button.setFocusable(false);
gc=new GridBagConstraints();
gc.gridx=3;
gc.gridy=5;
gc.insets=new Insets(20,0,0,0);
getContentPane().add(exit_button,gc);
exit_button.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent ae) {
		exit_action_performed(ae);
	}

	private void exit_action_performed(ActionEvent ae) {
		System.exit(0);
		
	}
});



}
}
