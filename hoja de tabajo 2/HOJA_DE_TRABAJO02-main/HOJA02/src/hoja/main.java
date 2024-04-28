/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba1;
import javax.swing.*;
import java.awt.*;

public class ExpressionTreeVisualizer extends JPanel {
    private Node root; // La raíz del árbol de expresiones

    public ExpressionTreeVisualizer(Node root) {
        this.root = root;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawNode(g, getWidth() / 2, 30, root, getWidth() / 4);
    }

    private void drawNode(Graphics g, int x, int y, Node node, int xOffset) {
        if (node != null) {
            g.drawString(node.getData(), x, y);
            if (node.getLeft() != null) {
                // Dibujar la rama izquierda
                int nextX = x - xOffset;
                int nextY = y + 50;
                g.drawLine(x, y, nextX, nextY);
                drawNode(g, nextX, nextY, node.getLeft(), xOffset / 2);
            }
            if (node.getRight() != null) {
                // Dibujar la rama derecha
                int nextX = x + xOffset;
                int nextY = y + 50;
                g.drawLine(x, y, nextX, nextY);
                drawNode(g, nextX, nextY, node.getRight(), xOffset / 2);
            }
        }
    }

    public static void main(String[] args) {
        // Ejemplo de creación de un árbol de expresiones
        Node root = new Node("*");
        root.setLeft(new Node("3"));
        
        Node rightSubtree = new Node("-");
        rightSubtree.setLeft(new Node("9"));
        
        Node rightRightSubtree = new Node("*");
        rightRightSubtree.setLeft(new Node("3"));
        rightRightSubtree.setRight(new Node("4"));
        
        rightSubtree.setRight(rightRightSubtree);
        
        root.setRight(rightSubtree);

        // Crear un JFrame y agregar el visualizador del árbol de expresiones
        JFrame frame = new JFrame("Expression Tree Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ExpressionTreeVisualizer visualizer = new ExpressionTreeVisualizer(root);
        frame.add(visualizer);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}

class Node {
    private String data;
    private Node left;
    private Node right;

    public Node(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public String getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}