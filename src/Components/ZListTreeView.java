package Components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.nio.file.Files;
import java.util.Enumeration;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import Common.ZCategory;

public class ZListTreeView extends JPanel {
	private JTree tree;
	private JLabel selectedLabel;
	private List<ZCategory> categories;
	private IZCategoryDetailView categoryDetailView;

	public List<ZCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<ZCategory> categories) {
		this.categories = categories;
		resetListMember();
	}

	public ZListTreeView(List<ZCategory> categories,IZCategoryDetailView categoryDetailView) {
		this.categories = categories;
		this.categoryDetailView = categoryDetailView;
		// create the root node
				ZCategory cat = new ZCategory();
				DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
				for (ZCategory zCategory : categories) {
					setTreeItem(root, zCategory); // add category to root
				}

				// create the tree by passing in the root node		
				tree = new JTree(root);

				File f = new File(".//ogimg.jpg");
				if (f.exists()) {
					ImageIcon imageIcon = new ImageIcon(f.getPath());
					ImageIcon imageIcon2 = new ImageIcon(
							imageIcon.getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH));
					DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
					renderer.setLeafIcon(imageIcon2);
					renderer.setIcon(imageIcon2);
					tree.setCellRenderer(renderer);
				}
				tree.setShowsRootHandles(true);
				tree.setRootVisible(false);
				add(new JScrollPane(tree));

				selectedLabel = new JLabel();
				add(selectedLabel, BorderLayout.SOUTH);

				tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
					@Override
					public void valueChanged(TreeSelectionEvent e) {
						DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
						ZCategory category = (ZCategory) selectedNode.getUserObject();
						categoryDetailView.HandleItemSingleClick(category);
					}

				});
				tree.addMouseMotionListener(new MouseMotionListener() {

					@Override
					public void mouseMoved(MouseEvent arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseDragged(MouseEvent arg0) {
						// TODO Auto-generated method stub

					}
				});
				tree.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent arg0) {
						if (arg0.getClickCount() == 3) {
							System.out.println("double clicked");
						}
					}
				});

				// this.setPreferredSize(new Dimension(300, 50));
				this.setVisible(true);

		resetListMember();

		
	}

	public void resetListMember(int i ) {
		ZCategory cat = new ZCategory();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode)this.tree.getModel().getRoot();
		root.removeAllChildren();
		for (ZCategory zCategory : categories) {
			setTreeItem(root, zCategory); // add category to root
		}
		
	}
	public void resetListMember( ) {

		resetListMember(0);
	}

	private void setTreeItem(DefaultMutableTreeNode root, ZCategory zCategory) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(zCategory);
		for (ZCategory tempCategory : zCategory.getCatChild()) {
			setTreeItem(node, tempCategory);
		}
		root.add(node);
	}
}
