package Forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.JList;



public class CategoryMngForm extends JFrame {
	
	public static final int width = 800;
	public static final int height = 800;
	
	//Jtree
	
	private JTree Tree;
	//labels
	private JLabel lblBNo;
	private JLabel lblTitle;
	private JLabel lblSubject;
	private JLabel lblAuthor;
	private JLabel lblPages;

	//textBox
	private JTextField  txtBNo;
	private JTextField txtTitle;
	private JTextField txtSubject;
	private JTextField txtAuthor;
	private JTextField txtPages; 
	
	//Button
	
	private JButton btnInsertBook;
	
	//Panels
	private JPanel InsertPanel;
	
	
	//TextArea
	private JTextArea txtaAllBooks;
	
	
	public CategoryMngForm(){
		super("Books Manager ");
		this.setBounds(500, 100, width, width);
		this.setLayout(new FlowLayout());
		setFormComponent();
		
	}
	
	private void setFormComponent()
	{
		  lblBNo = new JLabel("شماره کتاب");
		  lblBNo.setPreferredSize(new Dimension(150,20));
		  lblTitle= new JLabel("عنوان کتاب");
		  lblTitle.setPreferredSize(new Dimension(150,20));
		  lblSubject= new JLabel("موضوع");
		  lblSubject.setPreferredSize(new Dimension(150,20));
		  lblAuthor= new JLabel("نویسنده");
		  lblAuthor.setPreferredSize(new Dimension(150,20));
		  lblPages= new JLabel("تعداد صفحات");
		  lblPages.setPreferredSize(new Dimension(150,20));

		  txtBNo = new JTextField();
		  txtBNo.setPreferredSize(new Dimension(130,20));
		  txtTitle = new JTextField();
		  txtTitle.setPreferredSize(new Dimension(130,20));
		  txtSubject = new JTextField();
		  txtSubject.setPreferredSize(new Dimension(130,20));
		  txtAuthor = new JTextField();
		  txtAuthor.setPreferredSize(new Dimension(130,20));
		  txtPages = new JTextField();
		  txtPages.setPreferredSize(new Dimension(130,20));
		  
		  btnInsertBook = new JButton("ثبت کتاب");
		  
		  InsertPanel = new JPanel();
		  InsertPanel.setPreferredSize(new Dimension(300, 300));
		  InsertPanel.setBackground(Color.LIGHT_GRAY);
		  
		  InsertPanel.add(lblBNo);
		  InsertPanel.add(txtBNo);
		  InsertPanel.add(lblTitle);
		  InsertPanel.add(txtTitle);
		  InsertPanel.add(lblSubject);
		  InsertPanel.add(txtSubject);
		  InsertPanel.add(lblAuthor);
		  InsertPanel.add(txtAuthor);
		  InsertPanel.add(lblPages);
		  InsertPanel.add(txtPages);
		  
		  
		  InsertPanel.add(btnInsertBook);
		  this.add(InsertPanel);

		  txtaAllBooks = new JTextArea();
		  txtaAllBooks.setPreferredSize(new Dimension(600,200));
		  txtaAllBooks.setAutoscrolls(true);
		  this.add(txtaAllBooks);
		  
		  btnInsertBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				InsertNewBook();
				
			}
		});
	}
	
	private void InsertNewBook(){

	}
	

}
