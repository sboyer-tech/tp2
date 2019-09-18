package ticketmachine;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicketMachineTest {
	private static final int PRICE = 50; // Une constante

	private TicketMachine machine; // l'objet à tester

	@Before
	public void setUp() {
		machine = new TicketMachine(PRICE); // On initialise l'objet à tester
	}

	@Test
	// On vérifie que le prix affiché correspond au paramètre passé lors de l'initialisation
	// S1 : le prix affiché correspond à l’initialisation
	public void priceIsCorrectlyInitialized() {
		// Paramètres : message si erreur, valeur attendue, valeur réelle
		assertEquals("Initialisation incorrecte du prix", PRICE, machine.getPrice());
	}

	@Test
	// S2 : la balance change quand on insère de l’argent
	public void insertMoneyChangesBalance() {
		machine.insertMoney(10);
		machine.insertMoney(20);
		assertEquals("La balance n'est pas correctement mise à jour", 10 + 20, machine.getBalance()); // Les montants ont été correctement additionnés               
	}
        @Test
        //S3: Pas de ticket si le montant inséré n'est pas suffisant  
        public void MoneyInsuffisant(){
            machine.insertMoney(10);
            machine.insertMoney(20);
            assertFalse("Balance Insuffisante Impossible d'imprimer le ticket",machine.getTotal()>=machine.getPrice());
            
        }
        //S4  on imprime le ticket si l'argent est suffisant
        @Test
        public void MoneySuffisant(){
            machine.insertMoney(60);
            machine.insertMoney(40);
            assertFalse("Balance Insuffisante Impossible d'imprimer le ticket",machine.getTotal()<=machine.getPrice());
        }
        
        @Test
        //S5 Quand on imprime le ticket on decremente
        public void BalanceDecremente(){
            machine.insertMoney(30);
            machine.insertMoney(30);
            machine.printTicket();
            assertEquals("On decremente", machine.getBalance(),0);
            
        }
        
        @Test
        //S6 Le montant collecté est mis à jour quand on imprime un ticket( pas avant)
        public void total(){
            machine.insertMoney(30);
            machine.insertMoney(30);
            assertFalse("total mal modifié",machine.getTotal()>0);
            machine.printTicket();
            assertEquals("machine Incremente total", machine.getTotal(),50);
            
        }
        @Test
        //S7 Rend la monnaie
        public void RendMonnaie(){
            machine.insertMoney(30);
            machine.insertMoney(30);
            machine.printTicket();
            
        }
}
