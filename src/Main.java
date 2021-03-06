
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	
	
	public static void main(String[] args) {
		
		ArrayList<boisson> ListeBoissons;
		HashMap<boisson, Integer> stock;
		
		ListeBoissons= new ArrayList<boisson>();
		
		ListeBoissons.add(new boisson(1,"Coca-Cola",100));
		ListeBoissons.add(new boisson(2,"Fanta",80));
		ListeBoissons.add(new boisson(3,"Hamoud",60));
		ListeBoissons.add(new boisson(4,"Pepsi",70));
		ListeBoissons.add(new boisson(5,"Miranda",50));
		ListeBoissons.add(new boisson(6,"Ramy",100));
		
		stock = new HashMap<boisson,Integer>();
		
		stock.put(ListeBoissons.get(0), 10);
		stock.put(ListeBoissons.get(1), 8);
		stock.put(ListeBoissons.get(2), 11);
		stock.put(ListeBoissons.get(3), 5);
		stock.put(ListeBoissons.get(4), 12);
		stock.put(ListeBoissons.get(5), 7);
		
		
		stockBissons _stockBoissons= new stockBissons(stock, ListeBoissons);
		
		Caisse caisse = new Caisse(new ArrayList<Integer>(Arrays.asList(10, 20, 50)));
		
		
		int choix;
		int menu;
		
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		while(true)
		{
			System.out.println("{1}- Acheter une boisson");
			System.out.println("{2}- Alimenter de distributeur en boisson");
			System.out.println("{3}- Vider la caisse");
			System.out.println("{4}- Alimenter la caisse");
			System.out.println("{5}- Quitter");

			
			System.out.println("\n¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤\n");
			System.out.println("Entrez votre choix: ");
			
			menu = Integer.parseInt(sc.nextLine());	
			
			
			switch(menu){
				case 1:
					System.out.println("Liste des Boissons Disponibles:\n");
					for(boisson b:ListeBoissons){
						if(_stockBoissons.getStock().get(b)>0)
							System.out.println(String.format("{%s}- %s [%s Jetons]", b.getId(),b.getNom(),b.getPrix()));
						
					}
					
					System.out.println("\n¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤\n");
					System.out.println("Entrez votre choix: ");
					choix = Integer.parseInt(sc.nextLine());
					
					
					caisse.encaisser(ListeBoissons.get(choix-1).getPrix());
					_stockBoissons.distribuerBoisson(ListeBoissons.get(choix-1));
					break;
					
				case 2:
					
					System.out.println("Liste des Boissons Disponibles:\n");
					for(boisson b:ListeBoissons){
							System.out.println(String.format("{%s}- %s", b.getId(),b.getNom()));
						
					}
					
					System.out.println("\n¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤\n");
					System.out.println("Entrez votre choix: ");
					choix = Integer.parseInt(sc.nextLine());
					
					System.out.println("Entrez le nombre : ");
					
					int nbr = Integer.parseInt(sc.nextLine());
					
					
					_stockBoissons.alimenterStock(ListeBoissons.get(choix-1),nbr);
					
					break;
					
				case 3:
					
					caisse.setCaisse(0);
					
					break;
					
				case 4:
					
					System.out.println("Entrez le montant : ");
				    int  montant = Integer.parseInt(sc.nextLine());				    
				    caisse.encaisser(montant);			    
					
					break;
					
				case 5:
					System.exit(0);
					break;
			}
			
		
			System.out.println("\n¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤\n");
			System.out.println("Etat du stock: ");
			
			for(boisson b:ListeBoissons){
			     System.out.println(String.format("{%s}- %s [%s]", b.getId(),b.getNom(),_stockBoissons.getStock().get(b)));
			}
			
			System.out.println("\n¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤\n");
			System.out.println("Etat de la caisse: "+caisse.getCaisse()+" Jetons");		
			
			
		}		
		
		
	}

}
