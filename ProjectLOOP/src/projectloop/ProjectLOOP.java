
package projectloop;

import model.Acesso;

/**
 *
 * @author leonardo
 */
public class ProjectLOOP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Acesso login = new Acesso("leo", "123", 1);
        
        System.out.println(login.getMessage());
    }
    
}
