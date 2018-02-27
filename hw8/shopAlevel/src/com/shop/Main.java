package com.shop;

import com.shop.bag.ATBPacket;
import com.shop.bag.Bag;
import com.shop.bag.BagImpl;
import com.shop.buyer.Buyer;
import com.shop.buyer.BuyerImpl;
import com.shop.manager.ShopManager;
import com.shop.position.Position;
import com.shop.position.impl.Apple;
import com.shop.position.impl.Pen;
import com.shop.position.impl.abst.AbstractPosition;
import com.shop.shelf.AppleShelf;
import com.shop.shelf.PenShelf;
import com.shop.shelf.Shelf;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;
import java.util.Scanner;

import static com.shop.shelf.AppleShelf.appleShelf;
import static com.shop.shelf.PenShelf.penShelf;

/**
 * Created by Ivan Isaev on 21.02.2018.
 */
public class Main {

    static Shelf shelfPen = new PenShelf(penShelf);
    static Shelf shelfApple = new AppleShelf(appleShelf);
    static Buyer buyer = new BuyerImpl("Uncle Vasya", 100);
    static Pen currentPen = new Pen(30, "karandash");
    static Apple currentApple = new Apple(25, "Iablochko");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        zavozPen(currentPen);
        zavozApple(currentApple);
        Bag bag;
        System.out.println("V NASHEM SUPER-PUPER MAGAZINE DEYSTVUET AKTSIYA: KAZHDIY TRETIY TOVAR BESPLATNIY***");
        System.out.println("S chem poidem vasia?");
        System.out.println("1: ATB power");
        System.out.println("2: Standart edition, Galia");
        switch (scanner.nextInt()) {
            case 1:
                bag = new ATBPacket();
                break;
            case 2:
                bag = new BagImpl();
                break;
            default:
                System.out.println("sho zirkaesh? pognali s rukzackom");
                bag = new BagImpl();

        }
        while (true) {
            System.out.println("Shito delaem desy?");
            System.out.println("1: go za pokupkami person-san");
            System.out.println("2: go na cassu");
            switch (scanner.nextInt()) {
                case 1:
                    doPokupki(bag);
                    break;
                case 2:
                    discounts(bag);
                    goNaCassu(bag);
                    break;
                default:
                    System.out.println("dich. ti vtiraech mne dich");
            }
        }
    }

    private static void doPokupki(Bag bag) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(buyer.lookProfileBueyer());
        while (bag.getNotUsedSize() != 0) {
            System.out.println("1:Pen");
            System.out.println("2:Aple");
            System.out.println("3:Dumay");
            System.out.println("4:Polozhyt' tovar - Pen na polku");
            System.out.println("5:Polozhyt' tovar - Apple na polku");
            switch (scanner.nextInt()) {
                case 1:
                    if(shelfPen.checkAvailable()){
                        shelfPen.get();
                        bag.add(currentPen);
                        break;
                    } else {
                        System.out.println("Ruchek bol'she net na polke");
                        break;
                    }
                case 2:
                    if(shelfApple.checkAvailable()){
                        shelfApple.get();
                        bag.add(currentApple);
                        break;
                    } else {
                        System.out.println("Yablok bol'she net na polke");
                        break;
                    }
                case 3: return;
                case 4:
                    if(shelfPen.getCurrIndex() == 5){
                        System.out.println("Polka ruchek zapolnena");
                        break;
                    } else{
                        shelfPen.put(currentPen);
                        break;
                    }
                case 5:
                    if(shelfApple.getCurrIndex() == 5){
                        System.out.println("Polka yablok zapolnena");
                        break;
                    } else {
                        shelfApple.put(currentApple);
                        break;
                    }
                case 6: discounts(bag);
                default:
                    System.out.println("dich. ti vtiraech mne dich");
            }
        }
        System.out.println("Galia, I te sho grushick");
    }

    private static void goNaCassu(Bag bag) {
        ShopManager babaGala = new ShopManager();
        try {
            if(buyer.orderPay(babaGala.sum(bag))){
                System.out.println("VSE OPLACHENO:");
                System.out.println("PROFILE POKUPATELYA: " + buyer.lookProfileBueyer());
            } else{
                System.out.println("DENEG NET U TEBYA, NO TY DERZHYS'");
                System.out.println("PROFILE POKUPATELYA: " + buyer.lookProfileBueyer());
            }
            System.out.println("oi mama, hera tac dorogo");
            System.exit(0);
        } catch (InterruptedException e) {
            System.out.println("SCORUYY!!BABA GALA!");
        }
    }

    public static void zavozApple(AbstractPosition position) {
        int currIndex = 0;
        for (int i = 0; i < appleShelf.length; i++) {
            appleShelf[currIndex++] = (Apple) position;
        }
    }

    public static void zavozPen(AbstractPosition position) {
        int currIndex = 0;
        for (int i = 0; i < appleShelf.length; i++) {
            penShelf[currIndex++] = (Pen) position;
        }
    }

    public static void discounts(Bag bag){
        int temp = 0;
        for(int i =0; i < bag.getPositions().length; i++){
            if(bag.getPositions()[i] == null){
                temp = i;
                break;
            }
        }
        bag.setPositions(Arrays.copyOf(bag.getPositions(), temp));
        bag.sort();
        for (int j = 0; j < bag.getPositions().length/3; j++){
            bag.getPositions()[j] = null;
        }

        for (int i = 0; i < bag.getPositions().length / 2; i++) {
            Position tmp = bag.getPositions()[i];
            bag.getPositions()[i] = bag.getPositions()[bag.getPositions().length - i - 1];
            bag.getPositions()[bag.getPositions().length - i - 1] = tmp;
        }
        for(int i =0; i < bag.getPositions().length; i++){
            if(bag.getPositions()[i] == null){
                temp = i;
                break;
            }
        }
        bag.setPositions(Arrays.copyOf(bag.getPositions(), temp));
        bag.setRealIndex(bag.getPositions().length);
    }
}
