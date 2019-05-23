package Components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.nio.file.Files;
import java.util.Enumeration;

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

public class JTreeExample extends JPanel
{
    private JTree tree;
    private JLabel selectedLabel;
     
    public JTreeExample()
    {
    	
        //create the root node
    	DefaultClass dt = new DefaultClass();
    	dt.id = 1;
    	dt.text = "Root";
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(dt);
        //create the child nodes
        dt = new DefaultClass();
    	dt.id = 2;
    	dt.text = "Vegetable00000000000s";
        DefaultMutableTreeNode vegetableNode = new DefaultMutableTreeNode(dt);
        dt = new DefaultClass();
        dt.id = 3;
    	dt.text = "Fruits";
        DefaultMutableTreeNode fruitNode = new DefaultMutableTreeNode(dt);
        fruitNode.add(new DefaultMutableTreeNode("Banana"));
        fruitNode.add(new DefaultMutableTreeNode("Mango"));
	

        fruitNode.add(new DefaultMutableTreeNode("Grapes"));
        fruitNode.add(new DefaultMutableTreeNode("Orange"));
        //add the child nodes to the root node
        root.add(vegetableNode);
        root.add(fruitNode);
         
        // create the tree by passing in the root node
        tree = new JTree(root);
        File f = new File(".//ogimg.jpg");
        if(f.exists()){
        ImageIcon imageIcon = new ImageIcon(f.getPath());
        ImageIcon imageIcon2 = new ImageIcon(imageIcon.getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH));
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
                DefaultClass x=(DefaultClass) selectedNode.getUserObject();
                selectedLabel.setText(((Integer)x.id).toString());
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
         
               
        //this.setPreferredSize(new Dimension(300, 50));
        this.setVisible(true);
    }
     
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	JFrame temp = new JFrame();
            	temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	temp.setTitle("JTree Example");
            	
            	temp.add(new JTreeExample());
            	temp.setVisible(true);
            	temp.setSize(500, 100);
            }
        });
    }       
}
