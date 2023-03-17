package org.example;

import java.util.List;

public class SaleManager {
        private List<Sale> sales;

    public SaleManager(List<Sale> sales) {
        this.sales = sales;
    }

    public SaleManager() {
    }

    public void add(Sale sale) {
            sales.add(sale);
        }

        public void delete(Sale sale) {
            sales.remove(sale);
            System.out.println("Satış silindi!");
        }

        public void update(Sale sale) {
        for (Sale s:sales){
            if (s.getId()== sale.getId()){
                s.setOrder(sale.getOrder());
            }
        }
            System.out.println("Satış başarı ile güncellendi!");
        }

        public Sale read(int id){
            for (Sale sale:sales
            ) {
                if(sale.getId()==id){
                    return sale;
                }
            }
            return null;
        }
        public List<Sale> getAll() {
            return sales;
        }
        public void sell(Cart order)
        {
            for (Game game : order.getGames()){
                System.out.println(game.getName() + " oyunu, " + order.getGamer().getUserName() + " adlı kullanıcıya satıldı.");
            }
        }

}
