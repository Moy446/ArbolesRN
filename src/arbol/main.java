
package arbol;

public class main {
        public static void main(String[] args) {
        arbol tree = new arbol();
        tree.raiz =tree.push(tree.raiz, 47);
        tree.raiz.color = 0;
        tree.raiz =tree.push(tree.raiz, 16);
        tree.raiz.color = 0;
        tree.raiz =tree.push(tree.raiz,87);
        tree.raiz.color = 0;
        tree.raiz =tree.push(tree.raiz,45);
        tree.raiz.color = 0;
        tree.raiz =tree.push(tree.raiz,9);
        tree.raiz.color = 0;
        tree.raiz =tree.push(tree.raiz,35);
        tree.raiz.color = 0;
        tree.raiz =tree.push(tree.raiz,25);
        tree.raiz.color = 0;
        tree.raiz =tree.push(tree.raiz,46);
        tree.raiz.color = 0;
        tree.raiz =tree.push(tree.raiz,34);
        tree.raiz.color = 0;
        tree.raiz =tree.push(tree.raiz,12);
        tree.raiz.color = 0;
        System.out.println("Forma del arbol");
        tree.imprimirArbol(tree.raiz);
        System.out.println("Preorder----------------------------");
        tree.preorder(tree.raiz);
        System.out.println("PostOrder----------------------------");
        tree.postorder(tree.raiz);
        System.out.println("Inorder----------------------------");
        tree.inorder(tree.raiz);
    }
}
