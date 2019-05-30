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

import Common.ZCategory;
import Components.ZListTreeView;
import Manager.ZCategoryManager;

import javax.swing.JList;

public class CategoryMngForm extends JFrame {

	public static final int width = 800;
	public static final int height = 600;

	private ZCategoryManager categoryMng; // Manage Category Storage

	private ZListTreeView treeView;

	private ZCategoryDetailView categoryViewPanel;

	public CategoryMngForm() {
		super("Books Manager ");
		this.setBounds(500, 100, width, width);
		this.setLayout(new FlowLayout());
		categoryMng = new ZCategoryManager();
		categoryViewPanel = new ZCategoryDetailView(this);
		setFormComponent();

	}

	private void setFormComponent() {
		this.categoryViewPanel = new ZCategoryDetailView(this);
		this.treeView = new ZListTreeView(this.categoryMng.SelectAll(), this.categoryViewPanel);

		this.add(treeView);
		this.add(categoryViewPanel);
	}

	public void insertNewCategory(ZCategory category) {
		categoryMng.insert(category);
		this.refreshForm();
	}

	public void updateCategory(ZCategory category) {
		categoryMng.update(category);
		this.refreshForm();
	}

	public void deleteCategory(ZCategory category) {
		categoryMng.delete(category);
		this.refreshForm();
	}

	public void refreshForm() {
		this.treeView.setCategories(this.categoryMng.SelectAll());
		this.treeView.resetListMember(1);
	}

}
