package arbol;

public class arbol {
    Nodo raiz = null;

    public arbol() {
    }
    //1 = red, 0 = black
    public Nodo push (Nodo tree, int value){
        if (tree == null){
            return new Nodo(value);             
        } 
 
        if (value < tree.value) {
            tree.left = push(tree.left, value);
        }
         
        else if (value > tree.value) {
            tree.right = push(tree.right, value);            
        }
         
        else{
            return tree;            
        }
        
        tree = balancear(tree);
        
        return tree;
    }    
    //imprimir forma del arbol-----------------------------------------------------
    public int getAltura(Nodo node){
        if (node == null) {
            return 0;
        }
        int leftlevel = getAltura(node.left);
        int rightlevel = getAltura(node.right);
        if (leftlevel>rightlevel) {
            return leftlevel+1;
        }else{
            return rightlevel+1;
        }
    }
    
    public void imprimirArbol(Nodo node){
        int altura = getAltura(node);
        String[] levels = new String[altura];
        imprimirArbol(node, 0, levels);
        for (int i = 0; i <levels.length; i++) {
            System.out.println(levels[i]+" NIVEL:"+i);
        }
    }
    public void imprimirArbol(Nodo node, int level, String[] levels){
        if(node != null){
            levels[level] = node.getValue()+ "  " +((levels[level]!= null) ? levels[level] :"");
            imprimirArbol(node.right, level + 1, levels);
            imprimirArbol(node.left, level + 1, levels);
        }

    }
    //imprimir ordenes--------------------------------------------------------------
    public void preorder(Nodo node){
        if(node != null){
            System.out.println(node.getValue());
            preorder(node.left);
            preorder(node.right);
        }

    }
    public void postorder(Nodo node){
        if(node != null){
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.getValue());
        }
    }
    public void inorder(Nodo node){
        if(node != null){
            inorder(node.left);
            System.out.println(node.getValue());
            inorder(node.right);
        }
    }
    
    //Balancear--------------------------------------------------------------------
    public boolean isRed(Nodo nodo){
        if (nodo == null) {
            return false;
        }
        return nodo.color == 1;
    }
    
    public Nodo rotateLeft(Nodo nodo){
        Nodo child = nodo.right;
        Nodo childLeft = child.left;
        child.left = nodo;
        nodo.right = childLeft;
        
        return child;
        
    }
    public Nodo rotateRight(Nodo nodo){
        Nodo child = nodo.left;
        Nodo childRight = child.right;
        child.right = nodo;
        nodo.left = childRight;
        
        return child;
    }
    public Nodo swithcColor(Nodo nodo){
        nodo.color = nodo.color == 0 ? 1 : 0;
        nodo.left.color = 0;
        nodo.right.color = 0;
        return nodo;
    }
    public void intercambioColor (Nodo nodo, Nodo nodo2){
        int aux = nodo.color;
        nodo.color = nodo2.color;
        nodo.color = aux;
    }
    
    public Nodo balancear(Nodo nodo){
        if (isRed(nodo.right) && !isRed(nodo.left)) {
            nodo = rotateLeft(nodo);
            intercambioColor(nodo, nodo.left);
        }
        if (isRed(nodo.left) && isRed(nodo.left.left)) {
            nodo = rotateRight(nodo);
            intercambioColor(nodo, nodo.right);
        }
        if (isRed(nodo.left)&& isRed(nodo.right)) {
            nodo = swithcColor(nodo);
        }
        return nodo;
    }
    
}
