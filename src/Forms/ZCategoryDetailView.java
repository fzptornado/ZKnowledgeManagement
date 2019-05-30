package Forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Common.ZCategory;
import Components.IZCategoryDetailView;
import Manager.ZCategoryManager;

public class ZCategoryDetailView extends JPanel implements IZCategoryDetailView {
	private int width = 500;
	private int height = 400;

	//
	private CategoryMngForm catManagerFrm;

	// labels

	private JLabel lblCId;
	private JLabel lblCTitle;
	private JLabel lblCChilds;

	// textbox

	private JTextField txtCId;
	private JTextField txtCTitle;

	// Button

	private JButton btnInsertCategory;
	private JButton btnUpdateCategory;
	private JButton btnDeleteCategory;
	private JButton btnClearForm;

	// Constructors
	public ZCategoryDetailView(int width, int height,CategoryMngForm catManagerfrm) {
		super();
		this.catManagerFrm = catManagerfrm;
		this.width = width;
		this.height = height;
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.white);
		this.setVisible(true);
		setFormComponent();
	}

	public ZCategoryDetailView(CategoryMngForm catManagerfrm) {
		super();
		this.catManagerFrm = catManagerfrm;
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.white);
		this.setVisible(true);
		setFormComponent();

	}

	public void setFormComponent() {
		lblCId = new JLabel("کد دسته");
		lblCId.setPreferredSize(new Dimension(200, 50));
		lblCTitle = new JLabel("عنوان دسته");
		lblCTitle.setPreferredSize(new Dimension(200, 50));
		lblCChilds = new JLabel("زیر دسته ها");
		lblCChilds.setPreferredSize(new Dimension(200, 50));

		txtCId = new JTextField();
		txtCId.setPreferredSize(new Dimension(200, 50));
		txtCTitle = new JTextField();
		txtCTitle.setPreferredSize(new Dimension(200, 50));

		btnInsertCategory = new JButton("درج");
		btnInsertCategory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					int cid = 0;
					String cTitle = "";
					if( txtCId.getText().isEmpty() == false)
					{
						cid = Integer.parseInt(txtCId.getText());
						if( txtCTitle.getText().isEmpty() == false)
						{
							cTitle = txtCTitle.getText();
						}
						else
							return;
						
						ZCategory tempCategory = new ZCategory();
						tempCategory.setCatId(cid);
						tempCategory.setCatName(cTitle);
						tempCategory.setCatChild(null);
						catManagerFrm.insertNewCategory(tempCategory);
					}
					else
					return;
				}catch (Exception e) {
					
				}
				
			}
		});
		btnInsertCategory.setPreferredSize(new Dimension(98, 40));
		btnUpdateCategory = new JButton("بروز رسانی");
		btnUpdateCategory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					int cid = 0;
					String cTitle = "";
					if( txtCId.getText().isEmpty() == false)
					{
						cid = Integer.parseInt(txtCId.getText());
						if( txtCTitle.getText().isEmpty() == false)
						{
							cTitle = txtCTitle.getText();
						}
						else
							return;
						
						ZCategory tempCategory = new ZCategory();
						tempCategory.setCatId(cid);
						tempCategory.setCatName(cTitle);
						tempCategory.setCatChild(null);
						catManagerFrm.updateCategory(tempCategory);
					}
					else
					return;
				}catch (Exception e) {
					
				}
				
			}
		});
		btnUpdateCategory.setPreferredSize(new Dimension(98, 40));
		btnDeleteCategory = new JButton("حذف");
		btnDeleteCategory.setPreferredSize(new Dimension(98, 40));
		btnDeleteCategory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					int cid = 0;
					String cTitle = "";
					if( txtCId.getText().isEmpty() == false)
					{
						cid = Integer.parseInt(txtCId.getText());
						if( txtCTitle.getText().isEmpty() == false)
						{
							cTitle = txtCTitle.getText();
						}
						else
							return;
						
						ZCategory tempCategory = new ZCategory();
						tempCategory.setCatId(cid);
						tempCategory.setCatName(cTitle);
						tempCategory.setCatChild(null);
						catManagerFrm.deleteCategory(tempCategory);
					}
					else
					return;
				}catch (Exception e) {
					
				}
				
			}
		});
		btnClearForm = new JButton("پاک کردن فرم");
		btnDeleteCategory.setPreferredSize(new Dimension(98, 40));
		this.add(lblCId);
		this.add(txtCId);

		this.add(lblCTitle);
		this.add(txtCTitle);

		this.add(btnInsertCategory);
		this.add(btnUpdateCategory);
		this.add(btnDeleteCategory);
		this.add(btnClearForm);

	}

	@Override
	public void HandleItemDoubleClick(ZCategory category) {
		this.txtCId.setText(String.valueOf(category.getCatId()));
		this.txtCTitle.setText(category.getCatName());
	}

	@Override
	public void HandleItemSingleClick(ZCategory category) {
		this.txtCId.setText(String.valueOf(category.getCatId()));
		this.txtCTitle.setText(category.getCatName());

	}

}
