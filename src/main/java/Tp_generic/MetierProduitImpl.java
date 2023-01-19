package Tp_generic;

import java.io.*;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit>{
    List<Produit> produits;
    private String nomFichier;

    public MetierProduitImpl(List<Produit> produits, String nomFichier) {
        this.produits = produits;
        this.nomFichier = nomFichier;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    @Override
    public void add(Produit o) {
        produits.add(o);
    }
    @Override
    public List<Produit> getAll(){
       if (produits==null){
           return null;
       }
        File f1 = new File(this.nomFichier);
        FileInputStream fss;
        ObjectInputStream objectInputStream;
        List<Produit> produitList;

        {
            try {
                //lecture des donnees
                fss = new FileInputStream(f1);
                objectInputStream = new ObjectInputStream(fss);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return produits;
    }

    @Override
    public Produit findById(long id) {
        for (Produit p : produits)
            if (p.getId() == id)
                return p;
        return null;
    }

    @Override
    public void delete(long id) {
        Produit p = findById(id);
        produits.remove(p);
    }

    @Override
    public String toString() {
        return "MetierProduitImpl [produits=" + produits + "]";
    }

    @Override
    public void saveAll() {
        try {
            File file = new File(this.nomFichier);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
