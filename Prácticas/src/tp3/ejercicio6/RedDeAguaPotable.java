package tp3.ejercicio6;
import tp3.ejercicio5.GeneralTree;
public class RedDeAguaPotable {
	GeneralTree<Integer> tree;
	
	public RedDeAguaPotable(GeneralTree<Integer> tree) {
		this.tree = tree;
	}
	
	public double minimoCaudal(double caudal) {
		if(this.tree == null || this.tree.isEmpty())
			return 0;
		return minimoCaudalRecursivo(this.tree, caudal);
		
	}
	
	private double minimoCaudalRecursivo(GeneralTree<Integer> tree, double caudal) {
		double min = caudal;
		if (tree.isLeaf()) 
			return caudal;
	
		for (GeneralTree<Integer> child : tree.getChildren()) {
			min = Math.min(min, minimoCaudalRecursivo(child, caudal / tree.getChildren().size()));
		}
		
		return min;
	}

}
