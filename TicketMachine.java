/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // ATRIBUTO PARA CREAR MAQUINA REGALO
    private int premio;
    //CREO UN PARAMETRO DE LOS ASIENTOS DISPONIBLES
    private int asientos;
    //Creo una varaiable global que me guarda los billetes vendidos  
    private int numeroBilletesVendidos;


    /**
     * Máquina normal un 0, maquina con premio un 1.
     */
    public TicketMachine(int cost,int numeroBilletes, int tombola)
    {
        price = cost;
        asientos = numeroBilletes;
        premio = tombola;
        balance = 0;
        total = 0;
        numeroBilletesVendidos = 0;
    }
   

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
    if( numeroBilletesVendidos<asientos ){
        
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +amount);
    
        }
    }
     else{
     System.out.println("ERROR NO HAY ASIENTOS DISPONIBLES." );  
    }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
  
      if( numeroBilletesVendidos<asientos ){
        
            if(premio<=0 && balance >= price ) {
                // Simulate the printing of a ticket.
                System.out.println("##################");
                System.out.println("# The BlueJ Line");
                System.out.println("# Ticket");
                System.out.println("# " + price + " cents.");
                System.out.println("##################");
                System.out.println();
    
                // Update the total collected with the price.
                total = total + price;
                // Reduce the balance by the prince.
                balance = balance - price;
                
              
                numeroBilletesVendidos = numeroBilletesVendidos + 1;
                
                System.out.println("Numero de billetes Vendidos" +numeroBilletesVendidos );
            }
            else {
                int amointLeftToPay = price -balance;
                System.out.println("You must insert at least: " +
                                   (amointLeftToPay) + " more cents.");
                        
            }
        
            if (premio>=1 && balance >= price){
                 // Simulate the printing of a ticket.
                System.out.println();
                System.out.println("##################");
                System.out.println("# The BlueJ Line");
                System.out.println("# Ticket");
                System.out.println("# " + price + " cents.");
                System.out.println("##################");
                System.out.println();
    
                // Update the total collected with the price.
                total = total + price;
                // Reduce the balance by the prince.
                balance = balance - price;
                
                System.out.println();
                System.out.println("##################");
                System.out.println();
                System.out.println("# Ticket de REGALO");
                System.out.println("# " + 0 + " cents.");
                
                
            
                numeroBilletesVendidos = numeroBilletesVendidos + 1; //Aunque sea una máquina que regala un asiento nos indican QUE NO LO CONTEMOS
                
                System.out.println("Numero de billetes Vendidos" +numeroBilletesVendidos );
            }
             else {
                int amointLeftToPay = price -balance;
                System.out.println("You must insert at least: " +
                                   (amointLeftToPay) + " more cents.");
                        
            }
        
    }
    else{
     System.out.println("Se han impreso todos los billetes posibles "+ asientos+ " ALSA siente las molestias" );  
    }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
    
    public int vaciarMaquina ()
    {
        int dineroGuardadoMaquina;
        
        if(balance>0){          // Si un usuario ha metido dinero no se vacia la máquina sino si.
            return -1;  
        }
        else{  
            dineroGuardadoMaquina = total;
            total = 0;
            return dineroGuardadoMaquina;
            
        }
    }
}
