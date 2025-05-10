package parcial.ej2;

import tp2.ejercicio1.BinaryTree;
//import java.util.*;

public class Test {
    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<>(2);

        // Rama izquierda
        arbol.addLeftChild(new BinaryTree<>(7));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(23));
        arbol.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(-3));

        arbol.getLeftChild().addRightChild(new BinaryTree<>(6));
        arbol.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(55));
        arbol.getLeftChild().getRightChild().getLeftChild().addLeftChild(new BinaryTree<>(9));
        arbol.getLeftChild().getRightChild().getLeftChild().addRightChild(new BinaryTree<>(16));

        // Rama derecha
        arbol.addRightChild(new BinaryTree<>(-5));
        arbol.getRightChild().addLeftChild(new BinaryTree<>(19));

        arbol.getRightChild().addRightChild(new BinaryTree<>(4));
        arbol.getRightChild().getRightChild().addLeftChild(new BinaryTree<>(18));
        arbol.getRightChild().getRightChild().getLeftChild().addLeftChild(new BinaryTree<>(8));
        arbol.getRightChild().getRightChild().getLeftChild().addRightChild(new BinaryTree<>(24));
        
        ParcialArboles pa = new ParcialArboles(arbol);
        System.out.println(pa.isTwoTree(9));
    }
}
